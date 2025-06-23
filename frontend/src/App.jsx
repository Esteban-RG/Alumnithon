import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Login from "../pages/authentication/Login";
import SignUp from "../pages/authentication/SignUp";
import Dashboard from "../pages/main/Dashboard"
import MyActivities from "../pages/main/MyActivities";
import Search from "../pages/main/Search";
import Profile from "../pages/main/Profile";

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    /**
     * Checa si token existen en localStorage
     * Si existe, usuario autenticado
     */
    const token = localStorage.getItem("token");
    if (token) {
      setIsAuthenticated(true);
    } else {
      setIsAuthenticated(false);
    }
  }, []);

  return (
    <BrowserRouter>
      <Routes>
        {/* Rutas según autenticación */}
        {isAuthenticated ? (
          <>
            {/* Solo accesible si autenticado (token) */}
            <Route
              path="/dashboard"
              element={<Dashboard />}
            />
            <Route
              path="/myactivities"
              element={<MyActivities />}
            />
            <Route
              path="/search"
              element={<Search />}
            />
            <Route
              path="/profile"
              element={<Profile setIsAuthenticated={setIsAuthenticated} />}
            />
            {/* Redirigir no definidos a dashboard/inicio */}
            <Route path="*" element={<Navigate to="/dashboard" replace />} />
          </>
        ) : (
          <>
            {/* Únicas accesibles cuando usuario no autenticado */}
            <Route
              path="/login"
              element={<Login setIsAuthenticated={setIsAuthenticated} />}
            />
            <Route path="/signup" element={<SignUp />} />
            {/* Redirigir no definidos a login */}
            <Route path="*" element={<Navigate to="/login" replace />} />
          </>
        )}
      </Routes>
    </BrowserRouter>
  );
}

export default App;