import Header from "../../components/main/Header";
import MainTitle from "../../components/main/MainTitle";
import SearchDropdown from "../../components/main/SearchDropdown";
import BottomNav from "../../components/main/BottomNav";

const Search = () => {
  const interests = [
    "Historia", "Naturaleza", "Música", "Idiomas",
    "Tradiciones", "Deportes", "Literatura", "Viajes",
    "Gastronomía", "Tecnología", "Cine", "Otros"
  ];

  return (
    <div className="bg-orange-50 min-h-screen font-inter">
      <Header />
      <main className="px-6 pb-24">
        <MainTitle
          title="Buscar Actividades"
        />
        <div className="space-y-4">
          <SearchDropdown label="País" option="Todos los países" />
          <SearchDropdown label="Idioma" option="Todos los idiomas" />
          <SearchDropdown label="Nivel" option="Todos los niveles" />
          <SearchDropdown label="Tipo de Actividad" option="Selecciona" />
          <div>
            <label className="text-sm font-semibold text-black mb-2 block">Intereses</label>
            <div className="grid grid-cols-2 gap-x-4 gap-y-2">
              {interests.map((interest) => (
                <label key={interest} className="flex items-center">
                  <input type="checkbox"
                    className="h-4 w-4 rounded border-gray-400 text-black" />
                  <span className="ml-2 text-black">{interest}</span>
                </label>
              ))}
            </div>
          </div>
          <div className="pt-4">
            <button className="w-full bg-surface text-black font-semibold rounded-lg py-3 
                                border border-black">
              Buscar
            </button>
          </div>
        </div>
      </main>
      <BottomNav />
    </div>
  );
};

export default Search;