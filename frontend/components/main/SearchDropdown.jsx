const SearchDropdown = ({ label, option }) => {
	return (
		<div>
			<label className="text-sm font-semibold text-black">{label}</label>
			<select className="mt-1 block w-full bg-white border border-black rounded-md py-2 px-3 text-black">
				<option>{option}</option>
			</select>
		</div>
	)
};

export default SearchDropdown;