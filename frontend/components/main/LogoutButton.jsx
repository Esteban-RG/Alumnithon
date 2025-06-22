import { useNavigate } from 'react-router-dom';

const LogoutButton = ({ setIsAuthenticated }) => {
  const navigate = useNavigate();

  /**
   * Borra token de localStorage
   * Usuario pasa no autenticado (setIsAuthenticated = false)
   * Redirige a login
   */
  const handleLogout = () => {
    localStorage.removeItem("token");
    setIsAuthenticated(false);
    navigate("/login");
  };

  return (
    <button className="bg-black
												text-white 
												font-semibold 
												rounded-full
												mx-auto
												px-6 
												py-2 
												text-sm"
						onClick={handleLogout}>
      Cerrar Sesión
    </button>
  );
};

export default LogoutButton;