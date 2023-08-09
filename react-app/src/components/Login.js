import { useRef, useState, useEffect } from "react";
import useAuth from "../hooks/useAuth";
import { Link, useNavigate, useLocation } from "react-router-dom";
import Cookies from 'js-cookie';
import bgImage from "../images/bg_image.jpg"

import axios from "../api/axios";
const LOGIN_URL = "https://bondtracker.up.railway.app/api/auth/signin";

const Login = () => {
  const { setAuth } = useAuth();

  const navigate = useNavigate();
  const location = useLocation();
  const from = location.state?.from?.pathname || "/";

  const userRef = useRef();
  const errRef = useRef();

  const [user, setUser] = useState("");
  const [pwd, setPwd] = useState("");
  const [errMsg, setErrMsg] = useState("");

  useEffect(() => {
    userRef.current.focus();
  }, []);

  useEffect(() => {
    setErrMsg("");
  }, [user, pwd]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        LOGIN_URL,
        JSON.stringify({ username: user, password: pwd }),
        {
          headers: { "Content-Type": "application/json" },
        }
      );
      Cookies.set('id', response?.data.id, { expires: 1 }); // expiration of 1 day
      Cookies.set('username', response?.data.username, { expires: 1 }); // expiration of 1 day
      Cookies.set('email', response?.data.email, { expires: 1 });
      Cookies.set('role', response?.data.role, { expires: 1 });
      Cookies.set('accessToken', response?.data.accessToken, { expires: 1 });
      //console.log(JSON.stringify(response));
      const accessToken = response?.data?.accessToken;
      const roles = response?.data?.role;

      setAuth({ user, pwd, roles, accessToken });
      setUser("");
      setPwd("");
      navigate(from, { replace: true });
    } catch (err) {
      if (!err?.response) {
        setErrMsg("No Server Response");
      } else if (err.response?.status === 400) {
        setErrMsg("Missing Username or Password");
      } else if (err.response?.status === 401) {
        setErrMsg("Unauthorized");
      } else {
        setErrMsg("Login Failed");
      }
      errRef.current.focus();
    }
  };

  return (
    <div  style={{ border: '1px solid red', width: '100vw', height: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center', backgroundImage: `url(${bgImage})`, backgroundRepeat: 'no-repeat', 
    backgroundSize: 'cover',       
    backgroundPosition: 'center' }}>
      <section className="section-login">
      <p
        ref={errRef}
        className={errMsg ? "errmsg" : "offscreen"}
        aria-live="assertive"
      >
        {errMsg}
      </p>
      <h1 className="blue">Sign In</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="username" style={{ color: '#fff'}}>Username:</label>
        <input
          type="text"
          id="username"
          ref={userRef}
          autoComplete="off"
          onChange={(e) => setUser(e.target.value)}
          value={user}
          required
        />

        <label htmlFor="password" style={{ color: '#fff'}}>Password:</label>
        <input
          type="password"
          id="password"
          onChange={(e) => setPwd(e.target.value)}
          value={pwd}
          required
        />
        <button>Sign In</button>
      </form>
    </section>
    </div>
    
  );
};

export default Login;
