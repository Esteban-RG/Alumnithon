const ActivityCard = () => {
  return (
    <div className="bg-white 
                    border 
                    border-black 
                    rounded-lg 
                    p-4">
      <h2 className="text-xl font-bold text-black">
      Ensenada's History for Tourists</h2>
      <p className="text-sm text-black mt-1">
        Organizado por: Sergio Z.</p>
      <p className="text-sm text-black">Evento: Inglés - Intermedio</p>

      <div className="flex flex-wrap gap-2 mt-4">
        <span className="bg-gray-400 
                          text-black 
                          text-xs 
                          font-medium 
                          px-3 
                          py-1 
                          rounded-full">
          Historia
        </span>
        <span className="bg-gray-400 
                          text-black 
                          text-xs 
                          font-medium 
                          px-3 
                          py-1 
                          rounded-full">
          Gastronomía
        </span>
        <span className="bg-gray-400 
                          text-black 
                          text-xs 
                          font-medium 
                          px-3 
                          py-1 
                          rounded-full">
          Tradiciones
        </span>
      </div>

      <p className="text-sm text-black mt-4">México. Junio 26, 2025</p>
      <p className="text-black mt-2">
        A tour of Ensenada and its most emblematic sites throughout time. The tour is highly recommended for people with an intermediate to native English level.
      </p>

      <div className="flex justify-end mt-4">
        <button className="bg-black
                              text-white 
                              font-semibold 
                              rounded-full 
                              px-6 
                              py-2 
                              text-sm">
          Unirme
        </button>
      </div>
    </div>
  );
};

export default ActivityCard;