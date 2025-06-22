import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react(),
    tailwindcss(),
  ],
    build: {
    outDir: '../src/main/resources/static', // o ../target/classes/static si prefieres
    emptyOutDir: true,
  },
})
