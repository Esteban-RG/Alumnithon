import { NavLink, useLocation } from "react-router-dom";

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
];

const Sidebar = () => {
  const location = useLocation();

  return (
    <aside className="hidden md:sticky md:top-0 md:flex flex-col justify-between bg-primary text-white text-lg h-screen w-24 hover:w-100 transition-all duration-300 group z-20 rounded-br-xl">
      {/* Sección de navegación */}
      <div className="flex flex-col gap-4 px-2">
        {navItems.map((item) => {
          const isActive = location.pathname === item.to;
          return (
            <NavLink
              key={item.to}
              to={item.to}
              className={`flex items-center gap-4 p-2 transition-colors ${
                isActive
                  ? "bg-background text-primary"
                  : "hover:bg-secondary text-white"
              }`}
            >
              <img
                src={isActive ? item.iconActive : item.icon}
                alt={item.label}
                className="w-9 h-9 lg:w-10 lg:h-10"
              />
              <span className="whitespace-nowrap opacity-0 group-hover:opacity-100 transition-opacity duration-300">
                {item.label}
              </span>
            </NavLink>
          );
        })}
      </div>

      {/* Ícono de perfil abajo */}
      <div className="p-2">
        <NavLink
          to="/profile"
          className={({ isActive }) =>
            `flex items-center gap-4 p-2 rounded transition-colors ${
              isActive
                ? "bg-background text-primary rounded-bl-xl"
                : "hover:bg-white/10 text-white"
            }`
          }
        >
          <img
            src={
              location.pathname === "/profile"
                ? "/user.svg"
                : "/user-light.svg"
            }
            alt="PERFIL"
            className="w-9 h-9 lg:w-10 lg:h-10"
          />
          <span className="whitespace-nowrap opacity-0 group-hover:opacity-100 transition-opacity duration-300">
            PERFIL
          </span>
        </NavLink>
      </div>
    </aside>
  );
};

export default Sidebar;