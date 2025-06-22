import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import AuthInput from "../../components/authentication/AuthInput";
import AuthButton from "../../components/authentication/AuthButton";
import AuthLogo from "../../components/authentication/AuthLogo";
import { login } from "../../services/authService";


const Login = ({ setIsAuthenticated }) => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await login(formData);
      if (response.token) {
        /**
         * Obtenido de:
         * https://developer.mozilla.org/es/docs/Web/API/Storage/setItem
         */
        localStorage.setItem("token", response.token);
        setIsAuthenticated(true);
        navigate("/dashboard");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="flex
                    flex-col
                    items-center
                    justify-center
                    min-h-screen 
                    bg-black
                    p-4">
      <div className="w-full max-w-sm text-center">
        <AuthLogo />
        <form onSubmit={handleSubmit}
          className="space-y-4 
                      mb-6">
          <AuthInput
            type="text"
            name="username"
            placeholder="Usuario"
            label="Ingresa tu usuario:"
            value={formData.username}
            onChange={handleChange}
          />
          <AuthInput
            type="password"
            name="password"
            placeholder="Contraseña"
            label="Ingresa tu contraseña:"
            value={formData.password}
            onChange={handleChange}
          />
          <AuthButton type="submit" value="Acceder" />
        </form>
        <p className="mt-6 text-sm text-gray-400">
          ¿No tienes cuenta?{" "}
          <Link to="/signup" className="text-white font-semibold">Regístrate aquí</Link>.
        </p>
      </div>
    </div>
  );
};

export default Login;
