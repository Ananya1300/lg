import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import ContributorService from "../Services/ContributorService";

const ContributorLogin = () => {

    const navigate = useNavigate();

    useEffect(() => {
        let contributor = localStorage.getItem("contributor");
        if(contributor && contributor !== null) {
            navigate("/contributor/dashboard");
        }
    }, []);

    const [contributor, setContributor] = useState({
        username: "",
        password: "",
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setContributor({...contributor, [e.target.name]: value});
    };

    const validateLoginDetails = () => {
        ContributorService.validateLogin(contributor)
        .then(
            (response) => {
                if(response.data === "") {
                    alert("Login Failed");
                    navigate("/contributor/login");
                } else {
                    console.log(response);
                    localStorage.setItem("contributor", response);
                    navigate("/contributor/homepage");
                }
            }
        )
        .catch(
            (error) => {
                console.log(error);
            }
        );
    };

    return (
        <div>
            <input type="text" name="username" placeholder="Username" onChange={(e)=>handleChange(e)}></input>
            <input type="text" name="password" placeholder="Password" onChange={(e)=>handleChange(e)}></input>
            <button onClick={validateLoginDetails}>Login</button>
            <button onClick={() => navigate("/contributor/signup")}>Signup As Contributor</button>
        </div>
    );
};

export default ContributorLogin;