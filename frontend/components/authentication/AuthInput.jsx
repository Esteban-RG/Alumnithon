const AuthInput = ({ type, placeholder, label, name, value, onChange }) => {
  const classesLabel = `text-white font-semibold`;

  const classesInput = `
    w-full
    p-3
    bg-stone-400
    rounded-lg
    text-black
    placeholder-gray-400
  `;

  return (
    <>
      <label className={classesLabel}>{label}</label>
      <input
        type={type}
        name={name}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        className={classesInput}
      />
    </>
  );
};

export default AuthInput;