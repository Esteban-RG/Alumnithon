import { Link } from "react-router-dom";
import AuthInput from "../../components/authentication/AuthInput";
import AuthButton from "../../components/authentication/AuthButton";
import AuthLogo from "../../components/authentication/AuthLogo";

const Login = () => {
  return (
    <div
      className="flex
										flex-col
										items-center
										justify-center
										min-h-screen 
										bg-black
										p-4"
    >
      <div
        className="w-full 
											max-w-sm 
											text-center"
      >
        <AuthLogo />
        <div
          className="space-y-4 
													mb-6"
        >
          <AuthInput
            type="text"
            placeholder="Usuario"
            label="Ingresa tu usuario:"
          />
          <AuthInput
            type="password"
            placeholder="Contraseña"
            label="Ingresa tu contraseña:"
          />
        </div>
        <AuthButton value="Acceder" />
        <p
          className="mt-6
										text-sm 
										text-gray-400"
        >
          ¿No tienes cuenta?{" "}
          <Link
            to="/signup"
            className="text-white 
												font-semibold"
          >
            Regístrate aquí
          </Link>
          .
        </p>
      </div>
    </div>
  );
};

export default Login;
