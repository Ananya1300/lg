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
    <div class="main">
    <form>
      <h2 >Log in</h2> 
      <div class="form-group">
      <input class="form-group" type="text" name="username" placeholder="Username" required="required" onChange={(e)=>handleChange(e)}></input><br></br>
      </div>
      <div>
      <input type="text" name="password" placeholder="Password" required="required" onChange={(e)=>handleChange(e)}></input>
      </div>
      <div class="form-group">
      <button class="btn btn-primary btn-block" onClick={validateLoginDetails}>Login</button>
      </div>
      <div class="clearfix">
            <label class="float-left form-check-label"><input type="checkbox"/> Remember me</label>
            </div>
      <button onClick={() => navigate("/admin/login")}>Admin</button>
      <button onClick={() => navigate("/contributor/login")}>Contributor</button>
      <button onClick={() => navigate("/user/signup")}>Creat an Account</button>
      </form>
      </div>
    </div>
  );
};

export default Home;