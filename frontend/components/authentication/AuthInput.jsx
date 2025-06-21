const AuthInput = ({ type, placeholder, label }) => {
  const ClassesLabel = `text-white font-semibold`;

  const ClassesInput = `
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
      <input type={type} placeholder={placeholder} className={ClassesInput} />
    </>
  );
};

export default AuthInput;
