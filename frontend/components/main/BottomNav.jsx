import { HiHome, HiOutlineCursorClick, HiSearch, HiUser } from "react-icons/hi";
import { Link } from "react-router-dom";

const classesLink = `flex flex-col items-center text-white`;
const classesIcon = `text-3xl mx-auto`;
const classesSpan = `text-xs font-medium`;

const navItems = [
  { to: "/dashboard", icon: HiHome, label: "INICIO" },
  { to: "/myactivities", icon: HiOutlineCursorClick, label: "MIS ACTIVIDADES" },
  { to: "/search", icon: HiSearch, label: "BUSCAR" },
  { to: "/profile", icon: HiUser, label: "PERFIL" },
];

const BottomNav = () => {
  return (
    <footer className="fixed bottom-0 left-0 w-full bg-black flex justify-around py-3">
      {navItems.map((item) => (
        <Link key={item.to} to={item.to} className={classesLink}>
          <item.icon className={classesIcon} />
          <span className={classesSpan}>{item.label}</span>
        </Link>
      ))}
    </footer>
  );
};

export default BottomNav;