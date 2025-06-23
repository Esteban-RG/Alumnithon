import Header from "../../components/main/Header";
import BottomNav from "../../components/main/BottomNav";
import LogoutButton from "../../components/main/LogoutButton";
import { HiUserCircle } from "react-icons/hi";


const Profile = ({ setIsAuthenticated }) => {
  const interests = [
    "Historia", "Naturaleza", "Música",
    "Tradiciones", "Deportes", "Literatura",
    "Gastronomía", "Tecnología", "Cine"
  ];

  return (
    <div className="bg-orange-50 min-h-screen font-sans">
      <Header />
      <main className="px-6 pb-24 -mt-8">
        <h2 className="text-3xl font-bold text-black text-center mb-4">Perfil</h2>
        <div className="flex justify-center mb-4">
          <div className="relative">
            <HiUserCircle className="w-24 h-24 text-black" />
            <button className="absolute bottom-0 right-0 bg-orange-200 text-black text-xs font-semibold 
                                rounded-md px-2 py-1 border border-black text-center">
              Cambiar Foto
            </button>
          </div>
        </div>
        <div className="space-y-4">
          <div>
            <label className="text-sm font-semibold text-black">Nombre de Usuario</label>
            <input type="text" placeholder="Tu Nombre de Usuario"
              className="mt-1 block w-full bg-white border border-black rounded-md py-2 px-3" />
          </div>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="text-sm font-semibold text-black">Edad</label>
              <input type="number" defaultValue="25"
                className="mt-1 block w-full bg-white border border-black rounded-md py-2 px-3" />
            </div>
            <div>
              <label className="text-sm font-semibold text-black">País</label>
              <select className="mt-1 block w-full bg-white border border-black rounded-md py-2 px-3">
                <option>Selecciona</option>
              </select>
            </div>
          </div>
          <div className="border border-black rounded-lg p-3">
            <label className="text-sm font-semibold text-black">Idiomas Hablados</label>
            <div className="flex items-center justify-between mt-2">
              <div>
                <p className="font-semibold">Español</p>
                <div className="flex space-x-1 mt-1">
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                </div>
              </div>
              <span className="text-sm font-semibold bg-gray-200 px-3 py-1 rounded-full">Nativo</span>
            </div>
            <div className="flex items-center justify-between mt-3">
              <div>
                <p className="font-semibold">Inglés</p>
                <div className="flex space-x-1 mt-1">
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                </div>
              </div>
              <span className="text-sm font-semibold bg-gray-200 px-3 py-1 rounded-full">Básico</span>
            </div>
            <button className="mt-4 w-full bg-orange-200 text-black 
                                font-semibold rounded-lg py-2 border border-black text-sm">
              Agregar Idioma
            </button>
          </div>

          <div className="border border-black rounded-lg p-3">
            <label className="text-sm font-semibold text-black">Idiomas Deseados</label>
            <div className="flex items-center justify-between mt-2">
              <div>
                <p className="font-semibold">Portugués</p>
                <div className="flex space-x-1 mt-1">
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-black rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                  <span className="w-3 h-3 bg-gray-300 rounded-full"></span>
                </div>
              </div>
              <span className="text-sm font-semibold bg-gray-200 px-3 py-1 rounded-full">
                Intermedio
              </span>
            </div>
            <button className="mt-4 w-full bg-orange-200 text-black 
                              font-semibold rounded-lg py-2 border border-black text-sm">
              Agregar Idioma
            </button>
          </div>

          <div>
            <label className="text-sm font-semibold text-black mb-2 block">Intereses</label>
            <div className="grid grid-cols-3 gap-x-4 gap-y-2">
              {interests.map((interest) => (
                <label key={interest} className="flex items-center">
                  <input type="checkbox" className="h-4 w-4 rounded border-gray-400" />
                  <span className="ml-2 text-black">{interest}</span>
                </label>
              ))}
            </div>
          </div>
          <div className="pt-4 text-center">
            <button className="w-full bg-orange-200 text-black font-bold rounded-lg py-3 
                                border border-black">
              Guardar Perfil
            </button>
            <div className="mt-4">
              <LogoutButton setIsAuthenticated={setIsAuthenticated} />
            </div>
          </div>
        </div>
      </main>
      <BottomNav />
    </div>
  );
};

export default Profile;