import Header from "../../components/main/Header";
import MainTitle from "../../components/main/MainTitle";
import ActivityCard from "../../components/main/ActivityCard";
import BottomNav from "../../components/main/BottomNav";

const Dashboard = () => {
  const activities = [
    {
      organizer: "Sergio Z.",
      event: "Inglés - Intermedio",
      title: "A tour of Ensenada and its most emblematic sites...",
      tags: ["Historia", "Gastronomía", "Tradiciones"],
      date: "México. Junio 26, 2025",
      description: "A tour of Ensenada and its most emblematic sites throughout time. The tour is highly recommended for people with an intermediate to native English level."
    },
    {
      organizer: "Paulo M.",
      event: "Inglés - Básico",
      title: "The biggest soccer community in Latin America invites you...",
      tags: ["Deportes"],
      date: "México. Junio 26, 2025",
      description: "The biggest soccer community in Latin America invites you to join our big online trivia game. Show your knowledge and win cool prizes."
    }
  ];

  return (
    <div className="bg-background min-h-screen font-sans">
      <Header className="" />
      <main className="px-6 pb-24">
        <MainTitle
          title="¡Bienvenido, Usuario!"
          buttonText="Empezar a explorar"
        />
        <h2 className="text-2xl font-bold text-black mb-4">Actividades cerca de ti</h2>
        <div className="space-y-4">
          {activities.map((activity, index) => (
            <ActivityCard key={index} activity={activity} showJoinButton={true} />

          ))}
        </div>
      </main>
      <BottomNav />
    </div>
  );
};

export default Dashboard;