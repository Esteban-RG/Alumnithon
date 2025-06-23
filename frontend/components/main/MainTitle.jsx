import MainButton from "./MainButton";

const Main = ({ title, buttonText }) => {
  return (
    <div className="text-center py-10">
      <h2 className="text-3xl font-bold text-black">{title}</h2>
      {buttonText && (
        <MainButton>{buttonText}</MainButton>
      )}
    </div>
  );
}

export default Main;