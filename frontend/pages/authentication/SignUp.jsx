import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import AuthInput from "../../components/authentication/AuthInput";
import AuthButton from "../../components/authentication/AuthButton";
import AuthLogo from "../../components/authentication/AuthLogo";
import { register } from "../../services/authService";

const SignUp = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: "",
    password: "",
    firstname: "",
    lastname: "",
    email: "",
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
      await register(formData);
      navigate("/login");
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center md:flex-row bg-black text-white">
      {/* Formulario de registro */}
      <div className="flex flex-col justify-center items-center w-full md:absolute md:inset-0 lg:relative md:max-w-md lg:max-w-none md:mx-auto lg:mx-0 lg:w-2/5 lg:items-center lg:justify-center px-6 py-2 z-10">
        <div className="w-full max-w-sm text-left bg-primary md:py-20 md:px-12 overflow-y-auto max-h-screen">
          <AuthLogo />
          <form onSubmit={handleSubmit} className="space-y-4 my-6">
            <AuthInput
              type="text"
              name="username"
              placeholder="Usuario"
              label="Nombre de usuario:"
              value={formData.username}
              onChange={handleChange}
            />
            <AuthInput
              type="email"
              name="email"
              placeholder="correo@ejemplo.com"
              label="Correo Electrónico:"
              value={formData.email}
              onChange={handleChange}
            />
            <AuthInput
              type="password"
              name="password"
              placeholder="Contraseña"
              label="Contraseña:"
              value={formData.password}
              onChange={handleChange}
            />
            <AuthInput
              type="text"
              name="firstname"
              placeholder="Nombre"
              label="Nombre:"
              value={formData.firstname}
              onChange={handleChange}
            />
            <AuthInput
              type="text"
              name="lastname"
              placeholder="Apellido"
              label="Apellido:"
              value={formData.lastname}
              onChange={handleChange}
            />
            <AuthButton type="submit" value="Registrarse" />
          </form>
          <p className="mt-6 text-sm">
            ¿Ya tienes una cuenta?{" "}
            <Link to="/login" className="text-white font-semibold">
              Inicia sesión aquí
            </Link>.
          </p>
        </div>
      </div>

      {/* Imagen de fondo visible desde md */}
      <div className="hidden md:block md:absolute md:inset-0 lg:relative md:w-full lg:w-3/5">
        <img
          src="/Imagen-signup.png"
          alt="Imagen SignUp"
          className="w-full h-full max-h-screen object-cover"
        />

        {/* Texto explicativo visible solo en desktop */}
        <div className="hidden lg:flex absolute inset-0 bg-black/50 flex-col justify-center px-20 text-white text-right items-end">
          <p className="text-3xl font-semibold leading-tight">
            Comparte tu conocimiento,<br /> conecta con mentores y<br /> únete a una red global.
          </p>
          <p className="mt-4 text-base text-gray-300 max-w-md">
            BabeLink es la comunidad que impulsa el aprendizaje mutuo a través del intercambio cultural y profesional.
          </p>
        </div>
      </div>

      {/* Ícono GitHub */}
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

export default SignUp;