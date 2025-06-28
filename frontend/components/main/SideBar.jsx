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
    <aside className="hidden md:sticky md:top-0 md:flex flex-col justify-between bg-primary text-white text-base h-screen w-18 hover:w-64 transition-all duration-300 group z-20 rounded-br-xl">
      {/* Sección de navegación */}
      <div className="flex flex-col">
        {navItems.map((item) => {
          const isActive = location.pathname === item.to;
          return (
            <NavLink
              key={item.to}
              to={item.to}
              className={`w-full flex items-center gap-4 p-4 lg:py-5 transition-colors ${
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
              <span className="whitespace-nowrap opacity-0 group-hover:opacity-100 transition-opacity duration-300 pr-8">
                {item.label}
              </span>
            </NavLink>
          );
        })}
      </div>

      {/* Ícono de perfil abajo */}
      <div className="pb-4">
        <NavLink
          to="/profile"
          className={({ isActive }) =>
            `w-full flex items-center gap-4 p-4 transition-colors ${
              isActive
                ? "bg-background text-primary"
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