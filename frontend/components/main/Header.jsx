import { Link } from "react-router-dom";
import HeaderBuscar from "./HeaderBuscar";


const Header = () => {
  return (
    <header className="bg-black py-4 md:px-8 flex flex-col items-center md:py-5 md:flex-row md:justify-between lg:py-6">
      <h1 className="text-3xl font-inter font-extrabold italic text-white text-center md:text-4xl md:text-left">
        <Link to="/" className="no-underline hover:no-underline focus:no-underline">
          BabeLink
        </Link>
      </h1>

      <div className="hidden md:flex items-center gap-6">
        <HeaderBuscar />
        <Link
          to="/profile"
          className="cursor-pointer"
        >
          <img src="/user-light.svg" alt="Perfil de usuario" className="w-10 h-10 lg:w-12 lg:h-12" />
        </Link>
      </div>
    </header>
  );
};

export default Header;