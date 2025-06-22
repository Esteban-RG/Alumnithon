const Header = () => {
  return (
    <header className="text-center
                        py-12 
                        px-4">
      <h1 className="text-3xl 
                      font-bold 
                      text-black">
        ¡Bienvenido, Usuario!
      </h1>
      <button className="mt-6 
                        bg-black 
                        text-white 
                        font-semibold 
                        rounded-full 
                        px-8 
                        py-3">
        Empezar a explorar
      </button>
    </header>
  );
};

export default Header;