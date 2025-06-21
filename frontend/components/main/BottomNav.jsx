import {HiHome, HiClipboardList, HiUser} from "react-icons/hi";

const BottomNav = () => {
  return (
    <footer className="fixed 
                        bottom-0 
                        left-0 
                        w-full 
                        bg-white 
                        border-t 
                        border-black
                        flex 
                        justify-around 
                        py-2">
      <button className="flex flex-col items-center text-black">
        <HiHome className="text-2xl" />
        <span className="text-xs">Inicio</span>
      </button>
      <button className="flex flex-col items-center text-black">
        <HiClipboardList className="text-2xl" />
        <span className="text-xs">Mis Actividades</span>
      </button>
      <button className="flex flex-col items-center text-black">
        <HiHome className="text-2xl" />
        <span className="text-xs">Perfil</span>
      </button>
    </footer>
  );
};

export default BottomNav;