import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import UserService from "../Services/UserService";

const User = () => {
  const navigate = useNavigate();

  useEffect(() => {
    let user = localStorage.getItem("user");
    if(user && user !== null) {
      navigate("/user/homepage");
    }
  }, []);

  const [user, setUser] = useState({
    username: "",
    firstname: "",
    lastname: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({...user, [e.target.name]: value});
    console.log(user);
  };

  const saveUser = (e) => {
    e.preventDefault();
    console.log(user);
    UserService.saveUser(user)
    .then(
        (response) => {
            console.log(response);
            navigate("/user/login");
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
    setUser({
        username: "",
        firstname: "",
        lastname: "",
        email: "",
        password: "",
    });
    console.log(user);
  };

  return (
    <div>
      <input type="text" name="firstname" placeholder="First Name" onChange={(e)=>handleChange(e)}></input>
      <input type="text" name="lastname" placeholder="Last Name" onChange={(e)=>handleChange(e)}></input>
      <input type="email" name="email" placeholder="Email Address" onChange={(e)=>handleChange(e)}></input>
      <input type="text" name="username" placeholder="Username" onChange={(e)=>handleChange(e)}></input>
      <input type="password" name="password" placeholder="Password" onChange={(e)=>handleChange(e)}></input>
      <button onClick={saveUser}>Register</button>
      <button onClick={reset}>Clear</button>
    </div>
  );
};

export default User;
