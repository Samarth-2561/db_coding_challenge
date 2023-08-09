import Register from "./components/Register";
import Login from "./components/Login";
import Home from "./components/Home";
import Layout from "./components/Layout";
import Admin from "./components/Admin";
import Missing from "./components/Missing";
import Unauthorized from "./components/Unauthorized";
import Lounge from "./components/Lounge";
import LinkPage from "./components/LinkPage";
import RequireAuth from "./components/RequireAuth";
import { Routes, Route } from "react-router-dom";
import Manager from "./components/Manager";
import Cookies from "js-cookie";
import ProtectedRegisterRoute from "./components/ProtectedRegisterRoute";
import Dashboard from "./components/Dashboard";

const ROLES = {
  User: "user",
  Admin: "admin",
  Manager: "manager",
};

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        {/* public routes */}
        <Route path="login" element={<Login />} />
        <Route
          path="/register"
          element={
            <ProtectedRegisterRoute
              component={Register}
              isAuthenticated={Cookies.get("role") === "admin"}
            />
          }
        />
        <Route path="linkpage" element={<LinkPage />} />
        <Route path="unauthorized" element={<Unauthorized />} />

        {/* we want to protect these routes */}
        <Route
          element={<RequireAuth allowedRoles={[ROLES.Admin, ROLES.User]} />}
        >
          <Route path="/" element={<Dashboard />} />
        </Route>
        <Route
          element={<RequireAuth allowedRoles={[ROLES.Admin, ROLES.User]} />}
        >
          <Route path="/home" element={<Home />} />
        </Route>

        <Route
          element={<RequireAuth allowedRoles={[ROLES.Admin, ROLES.Manager]} />}
        >
          <Route path="manager" element={<Manager />} />
        </Route>

        <Route element={<RequireAuth allowedRoles={[ROLES.Admin]} />}>
          <Route path="admin" element={<Admin />} />
        </Route>

        <Route
          element={<RequireAuth allowedRoles={[ROLES.Manager, ROLES.Admin]} />}
        >
          <Route path="lounge" element={<Lounge />} />
        </Route>

        {/* catch all */}
        <Route path="*" element={<Missing />} />
      </Route>
    </Routes>
  );
}

export default App;
