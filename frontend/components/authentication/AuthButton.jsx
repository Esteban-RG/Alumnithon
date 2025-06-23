const AuthButton = ({ value }) => {
	const classes = `
    w-full
		bg-white 
		text-black 
		font-bold 
		py-3 
		rounded-lg
  `;

	return <button className={classes}>{value}</button>;
};

export default AuthButton;