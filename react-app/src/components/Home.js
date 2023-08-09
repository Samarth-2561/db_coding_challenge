import { useNavigate, Link } from "react-router-dom";
import { useContext } from "react";
import AuthContext from "../context/AuthProvider";
import Cookies from "js-cookie";

const Home = () => {
  const { setAuth } = useContext(AuthContext);
  const navigate = useNavigate();

  const logout = async () => {
    Cookies.remove('role');
    Cookies.remove('username');
    Cookies.remove('accessToken');
    Cookies.remove('email');
    setAuth({});
    navigate("/login");
  };

  return (
    <div>
      <h1>You are in dashboard</h1>
      <br />
      {/* <p>You are logged in!</p>
      <br />
      <Link to="/manager">Go to the Manager page</Link>
      <br />
      <Link to="/admin">Go to the Admin page</Link>
      <br />
      <Link to="/lounge">Go to the Lounge</Link>
      <br />
      <Link to="/linkpage">Go to the link page</Link> */}
      <div className="flexGrow">
        <button onClick={logout}>Sign Out</button>
      </div>
    </div>
  );
};

export default Home;
