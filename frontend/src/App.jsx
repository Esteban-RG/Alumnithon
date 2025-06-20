import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div
      className="min-h-screen
                    bg-gray-900
                    text-white
                    flex
                    flex-col
                    items-center
                    justify-center p-4"
    >
      <div
        className="flex
                      space-x-8
                      mb-10"
      >
        <a href="https://vite.dev" target="_blank">
          <img
            src={viteLogo}
            className="h-24
                        w-24"
            alt="Vite logo"
          />
        </a>
        <a href="https://react.dev" target="_blank">
          <img
            src={reactLogo}
            className="h-24
                        w-24"
            alt="React logo"
          />
        </a>
      </div>
      <h1
        className="text-5xl
                      font-bold
                      mb-8"
      >
        Vite + React
      </h1>
      <div
        className="bg-gray-800
                      p-8
                      rounded-lg
                      shadow-2xl
                      text-center"
      >
        <button
          onClick={() => setCount((count) => count + 1)}
          className="bg-indigo-600
                      text-white
                      font-semibold
                      py-3
                      px-6
                      rounded-lg
                      text-lg
                      mb-6"
        >
          count is {count}
        </button>
        <p
          className="text-gray-400
                      text-lg"
        >
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p
        className="mt-10
                    text-gray-500
                    text-md"
      >
        Click on the Vite and React logos to learn more
      </p>
    </div>
  );
}

export default App;
