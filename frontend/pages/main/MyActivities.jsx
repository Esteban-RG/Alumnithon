import Header from "../../components/main/Header";
import MainTitle from "../../components/main/MainTitle";
import ActivityCard from "../../components/main/ActivityCard";
import BottomNav from "../../components/main/BottomNav";

const MyActivities = () => {
  const myActivities = [
    {
      organizer: "Mentoría: Inglés - Intermedio",
      event: "English for IT Professionals",
      tags: ["Tecnología"],
      date: "México. Julio 2, 2025",
      description: "Profesionales de RR. HH. realizarán entrevistas de trabajo a través de nuestro canal de comunicación, con el objetivo de evaluar y proporcionar retroalimentación sobre tus habilidades en inglés."
    },
    {
      organizer: "Organizado por: Paulo M.",
      event: "Evento: Inglés - Básico",
      tags: ["Deportes"],
      date: "México. Junio 26, 2025",
      description: "The biggest soccer community in Latin America invites you to join our big online trivia game. Show your knowledge and win cool prizes."
    }
  ];

  return (
    <div className="bg-orange-50 min-h-screen font-inter">
      <Header />
      <main className="px-6 pb-24">
        <MainTitle
          title="Mis Actividades"
          buttonText="Crear Actividad"
        />
        <div className="space-y-4">
          <ActivityCard activity={myActivities[0]} showDeleteButton={true} creationDate="Junio 17, 2025" />
          <ActivityCard activity={myActivities[1]} showDeleteButton={true} creationDate="Junio 8, 2025" />
        </div>
      </main>
      <BottomNav />
    </div>
  );
};

export default MyActivities;