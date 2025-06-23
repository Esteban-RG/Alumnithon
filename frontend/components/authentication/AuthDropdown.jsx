const AuthDropdown = ({ label, dataType, objectsList }) => {

  const classesLabel = `text-white font-semibold`

  const classesSelect = `
    w-full
    p-3
    bg-gray-700
    rounded-lg
    text-white
    placeholder-gray-400
  `;

  return (
    <>
      <label className={classesLabel}>{label}</label>
      <select className={classesSelect} name={dataType} id={dataType}>
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