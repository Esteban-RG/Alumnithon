import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import AuthInput from "../../components/authentication/AuthInput";
import AuthButton from "../../components/authentication/AuthButton";
import AuthLogo from "../../components/authentication/AuthLogo";
import { register } from "../../services/authService";

/* const countries = ["Argentina", "Brasil", "Colombia", "México"];
 */

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
      navigate('/login');
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-black p-4">
      <div className="w-full max-w-sm text-center">
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
          <AuthInput
            type="text"
            name="firstname"
            placeholder="Nombre"
            label="Ingresa tu nombre:"
            value={formData.firstname}
            onChange={handleChange}
          />
          <AuthInput
            type="text"
            name="lastname"
            placeholder="Apellido"
            label="Ingresa tu apellido:"
            value={formData.lastname}
            onChange={handleChange}
          />
          <AuthInput
            type="email"
            name="email"
            placeholder="tucorreo@ejemplo.com"
            label="Ingresa tu correo electrónico:"
            value={formData.email}
            onChange={handleChange}
          />
          {/*           <AuthDropdown
            label="Selecciona tu país:"
            dataType="countries"
            objectsList={countries}
          /> */}
          <AuthButton type="submit" value="Registrarse" />
        </form>
        <p className="mt-6 text-sm text-gray-400">
          ¿Ya tienes una cuenta?{" "}
          <Link to="/login" className="text-white font-semibold">Inicia sesión aquí</Link>.
        </p>
      </div>
    </div>
  );
};

export default SignUp;
