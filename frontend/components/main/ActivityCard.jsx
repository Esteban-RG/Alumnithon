const ActivityCard = ({ activity, showJoinButton, showDeleteButton, creationDate }) => {
  return (
    <div className="bg-white border border-black rounded-lg p-4">
      <p className="text-sm text-black">{activity.organizer}</p>
      <p className="text-sm text-black font-semibold">{activity.event}</p>
      {activity.tags && (
        <div className="flex flex-wrap gap-2 mt-2">
          {activity.tags.map((tag, index) => (
            <span key={index}
              className={`text-xs font-medium px-3 py-1 rounded-full ${tag === 'Deportes' ? 'bg-emerald-100 text-green-900' : tag === 'Tecnología' ? 'bg-blue-100 text-cyan-900' : 'bg-orange-100 text-black'}`}>
              {tag}
            </span>
          ))}
        </div>
      )}
      <p className="text-sm text-black mt-3">{activity.date}</p>
      <p className="text-black mt-2">
        {activity.description}
      </p>
      {creationDate && <p className="text-xs text-gray-500 mt-3">Fecha de creación: {creationDate}</p>}
      <div className="flex justify-end mt-4">
        {showJoinButton && (
          <button className="bg-orange-200 text-black border border-black font-semibold rounded-lg px-8 py-2 text-sm">
            Unirme
          </button>
        )}
        {showDeleteButton && (
          <button className="bg-rose-300 text-black border border-black font-semibold rounded-lg px-8 py-2 text-sm">
            Borrar
          </button>
        )}
      </div>
    </div>
  );
};

export default ActivityCard;