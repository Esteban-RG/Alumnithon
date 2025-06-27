import { Link, useLocation } from "react-router-dom";

const classesLink = `flex flex-col items-center justify-center h-full cursor-pointer flex-1`;
const classesIcon = `w-6 h-6 mx-auto my-2`;
const classesSpan = `text-xs font-medium mb-1`;

const navItems = [
  {
    to: "/dashboard",
    icon: "/home-light.svg",
    iconActive: "/home.svg",
    label: "INICIO",
  },
  {
    to: "/myactivities",
    icon: "/learn-light.svg",
    iconActive: "/learn.svg",
    label: "MIS ACTIVIDADES",
  },
  {
    to: "/search",
    icon: "/search-light.svg",
    iconActive: "/search.svg",
    label: "BUSCAR",
  },
  {
    to: "/profile",
    icon: "/user-light.svg",
    iconActive: "/user.svg",
    label: "PERFIL",
  },
];

const BottomNav = () => {
  const location = useLocation();

  return (
    <footer className="fixed bottom-0 left-0 w-full h-16 bg-primary flex md:hidden">
      {navItems.map((item) => {
        const isActive = location.pathname === item.to;
        const linkClasses = `${classesLink} ${
          isActive ? "bg-background text-primary" : "text-white"
        }`;
        const iconSrc = isActive ? item.iconActive : item.icon;

        return (
          <Link key={item.to} to={item.to} className={linkClasses}>
            <img src={iconSrc} alt={item.label} className={classesIcon} />
            <span className={classesSpan}>{item.label}</span>
          </Link>
        );
      })}
    </footer>
  );
};

export default BottomNav;
