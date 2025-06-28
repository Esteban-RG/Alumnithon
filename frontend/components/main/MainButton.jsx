/**
 * Uso de Propiedad Children
 * Obtenido de:
 * https://react.dev/learn/passing-props-to-a-component#passing-jsx-as-children 
 */

const MainButton = ({ children }) => {
  return (
    <button
      className="mt-4 bg-surface text-primary font-semibold rounded-lg px-8 py-3
                 border border-black cursor-pointer"
    >
      {children}
    </button>
  );
}

export default MainButton;