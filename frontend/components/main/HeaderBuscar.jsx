import { useState } from "react";
import ModalBuscar from "./ModalBuscar";

const HeaderBuscar = () => {
  const [modalOpen, setModalOpen] = useState(false);

  return (
    <div>
        <button onClick={() => setModalOpen(true)} className="flex items-center cursor-pointer">
          <img
            src="/search-light.svg"
            alt="Buscar"
            className="w-9 h-9 lg:w-11 lg:h-11"
          />
        </button>

      <ModalBuscar isOpen={modalOpen} onClose={() => setModalOpen(false)} />
    </div>
  );
};

export default HeaderBuscar;
