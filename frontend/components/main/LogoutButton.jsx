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
    <button className="block
                        text-center
                        text-gray-700
                        text-sm
                        font-semibold
                        hover:underline
                        mx-auto
                        cursor-pointer"
      onClick={handleLogout}>
      Cerrar Sesión
    </button>
  );
};

export default LogoutButton;