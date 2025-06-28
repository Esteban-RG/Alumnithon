import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
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
        localStorage.setItem("token", response.token);
        setIsAuthenticated(true);
        navigate("/dashboard");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center md:flex-row bg-black text-white">
      {/* Formulario de acceso */}
      <div className="flex flex-col justify-center items-center w-full md:absolute md:inset-0 lg:relative md:max-w-md lg:max-w-none md:mx-auto lg:mx-0 lg:w-2/5 lg:items-center lg:justify-center px-6 py-12 z-10">
        <div className="w-full max-w-sm text-left bg-primary md:py-28 md:px-12">
          <AuthLogo />
          <form onSubmit={handleSubmit} className="space-y-4 mb-6">
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
          <p className="mt-6 text-sm text-white">
            ¿No tienes cuenta?{" "}
            <Link to="/signup" className="text-white font-semibold">
              Regístrate aquí
            </Link>.
          </p>
        </div>
      </div>

      {/* Imagen de fondo visible desde md */}
      <div className="hidden md:block md:absolute md:inset-0 lg:relative md:w-full lg:w-3/5">
        <img
          src="/Imagen-login.png"
          alt="Imagen Login"
          className="w-full h-full max-h-screen object-cover"
        />

        {/* Texto visible solo en lg */}
        <div className="hidden lg:flex absolute inset-0 bg-opacity-50 flex-col justify-center px-20 text-white text-right items-end">
          <p className="text-3xl  font-semibold leading-relaxed">
            Conecta con personas, <br /> comparte conocimientos y <br /> descubre nuevas culturas.
          </p>
          <p className="mt-4 text-base text-gray-300">
            BabeLink es la comunidad donde el aprendizaje se convierte en un viaje compartido, participa en actividades, ofrece mentorías o descubre nuevas pasiones.
          </p>
        </div>
      </div>

      {/* Ícono de GitHub en todas las vistas */}
      <a
        href="https://github.com/Esteban-RG/Alumnithon.git"
        target="_blank"
        rel="noopener noreferrer"
        className="absolute bottom-4 right-4 z-20"
      >
        <img
          src="/github.svg"
          alt="GitHub"
          className="w-6 h-6 md:w-8 md:h-8 opacity-70 hover:opacity-100"
        />
      </a>
    </div>
  );
};

export default Login;