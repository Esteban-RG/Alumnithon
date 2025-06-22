const AuthButton = ({ value }) => {
  const Classes = `
    w-full
		bg-white 
		text-black 
		font-bold 
		py-3 
		rounded-lg
  `;

  return <button className={Classes}>{value}</button>;
};

export default AuthButton;
