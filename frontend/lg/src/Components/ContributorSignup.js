import React, { useState } from "react";
import { useNavigate } from "react-router";
import ContributorService from "../Services/ContributorService";

const ContributorSignup = () => {

    const navigate = useNavigate();

    const [contributor, setContributor] = useState({
        username: "",
        firstname: "",
        lastname: "",
        email: "",
        password: "",
        experience: 0,
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setContributor({...contributor, [e.target.name]: value});
        console.log(contributor);
    };

    const handleChangeNumber = (e) => {
        const value = e.target.value;
        setContributor({...contributor, ["experience"]: parseInt(value)});
        console.log(contributor);
    };

    const saveContributor = (e) => {
        e.preventDefault();
        console.log(contributor);
        ContributorService.saveContributor(contributor)
        .then(
            (response) => {
                console.log(response);
                navigate("/contributor/login");
            }
        )
        .catch(
            (error) => {
                console.log(error);
            }
        )
    };

    const reset = (e) => {
        e.preventDefault();
        setContributor({
            username: "",
            firstname: "",
            lastname: "",
            email: "",
            password: "",
            experience: 0,
        });
        console.log(contributor);
      };

    return (
        <div>
            <p>Contributor Signup</p>
          <input type="text" name="firstname" placeholder="First Name" onChange={(e)=>handleChange(e)}></input>
          <input type="text" name="lastname" placeholder="Last Name" onChange={(e)=>handleChange(e)}></input>
          <input type="email" name="email" placeholder="Email Address" onChange={(e)=>handleChange(e)}></input>
          <input type="number" name="experience" placeholder="Experience in Year(s)" onChange={(e)=>handleChangeNumber(e)}></input>
          <input type="text" name="username" placeholder="Username" onChange={(e)=>handleChange(e)}></input>
          <input type="password" name="password" placeholder="Password" onChange={(e)=>handleChange(e)}></input>
          <button onClick={saveContributor}>Register</button>
          <button onClick={reset}>Clear</button>
        </div>
    );
};

export default ContributorSignup;
