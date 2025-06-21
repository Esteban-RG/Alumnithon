import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "../pages/authentication/Login";
import SignUp from "../pages/authentication/SignUp";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
