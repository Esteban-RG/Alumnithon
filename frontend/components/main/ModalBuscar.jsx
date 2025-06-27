import { useEffect } from "react";

const ModalBuscar = ({ isOpen, onClose }) => {
  // Con este useEffect se bloquea el scroll del body cuando el modal está abierto
  useEffect(() => {
    if (isOpen) {
      document.body.style.overflow = "hidden";
    } else {
      document.body.style.overflow = "auto";
    }

    return () => {
      document.body.style.overflow = "auto";
    };
  }, [isOpen]);

  if (!isOpen) return null;

  return (
    <div
      className="fixed inset-0 z-50 flex items-center justify-center bg-secondary/70 overflow-y-auto"
      onClick={onClose}
    >
      <div
        className="bg-background w-[90%] max-w-xl rounded-md p-6 max-h-[90vh] overflow-y-auto"
        onClick={(e) => e.stopPropagation()} // evita que se cierre al hacer clic dentro
      >
        <h2 className="text-center text-lg font-bold mb-4">Buscar Actividades</h2>

        <form className="space-y-4">
          <input
            type="text"
            placeholder="Título o palabra clave"
            className="w-full border px-4 py-2 rounded"
          />
          <select className="w-full border px-4 py-2 rounded">
            <option>Selecciona una categoría</option>
          </select>
          <div className="flex justify-end">
            <button
              type="submit"
              className="bg-primary text-white px-4 py-2 rounded"
            >
              Buscar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ModalBuscar;
