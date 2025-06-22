const AuthDropdown = ({ label, dataType, objectsList }) => {
  
  const ClassesLabel = `text-white font-semibold`
  
  const ClassesSelect = `
    w-full
    p-3
    bg-gray-700
    rounded-lg
    text-white
    placeholder-gray-400
  `;

  return (
    <>
      <label className={ClassesLabel}>{label}</label>
      <select className={ClassesSelect} name={dataType} id={dataType}>
        {objectsList.map((element) => (
          <option key={element}>
            {element}
          </option>
        ))}
      </select>
    </>
  );
};

export default AuthDropdown;
