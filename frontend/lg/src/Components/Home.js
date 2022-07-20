import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../Services/UserService";
import "./Home.css";

const Home = () => {
  
  const navigate = useNavigate();

  useEffect(() => {
    let user = localStorage.getItem("user");
    if(user && user !== null) {
      navigate("/user/homepage");
    }
  }, []);

  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({...user, [e.target.name]: value});
  };

  const validateLoginDetails = (e) => {
    e.preventDefault();
    UserService.validateLogin(user)
    .then(
      (response) => {
        console.log(response);
        if(response.data === "") {
          navigate("/user/login");
        } else {
          localStorage.setItem("user", response);
          navigate("/user/homepage");
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
      <input type="text" name="username" placeholder="Username" required="required" onChange={(e)=>handleChange(e)}></input>
      <input type="text" name="password" placeholder="Password" required="required" onChange={(e)=>handleChange(e)}></input>
      <button onClick={validateLoginDetails}>Login</button>
      <button onClick={() => navigate("/admin/login")}>Admin</button>
      <button onClick={() => navigate("/contributor/login")}>Contributor</button>
      <button onClick={() => navigate("/user/signup")}>Creat an Account</button>
    </div>
  );
};

export default Home;