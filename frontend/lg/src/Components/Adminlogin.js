import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import AdminService from "../Services/AdminService";


const Adminlogin=()=>{
    const [admin,setAdmin]=useState({
        username: "",
        password: "",
    });
    
const navigate = useNavigate();

const handleChange = (e) => {
    const value = e.target.value;
    setAdmin({...admin, [e.target.name]: value});
  };

    const validateLoginDetails = (e) => {
        e.preventDefault();
        AdminService.validateLogin(admin)
        .then(
          (response) => {
            console.log(response);
            if(response.data === "") {
              navigate("/admin/login");
            } else {
              localStorage.setItem("admin", response);
              navigate("/admin/homepage");
            }
          }
        )
        .catch(
          (error) => {
            console.log(error);
          }
        );
      };


    return(

        <div>
            <input type="text" name="username" placeholder="Enter Username" onChange={(e)=>handleChange(e)}></input>
            <input type="password" name="password" placeholder="Enter the password" onChange={(e)=>handleChange(e)}></input>
            <button onClick={validateLoginDetails}>Login</button>
        </div>


    );


}
export default Adminlogin;