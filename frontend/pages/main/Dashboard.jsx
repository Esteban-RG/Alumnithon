import Header from "../../components/main/Header";
import ActivityCard from "../../components/main/ActivityCard";
import BottomNav from "../../components/main/BottomNav";
import LogoutButton from "../../components/main/LogoutButton";

const Dashboard = ({ setIsAuthenticated }) => {
  return (
    <div className="bg-gray-50 min-h-screen flex flex-col">

      <main className="flex-1 pb-20">
        <Header />
        <div className="px-4">
          <h3 className="text-lg font-semibold text-black mb-4">Actividades cerca de ti</h3>
          <ActivityCard />
          <LogoutButton setIsAuthenticated={setIsAuthenticated} />
        </div>
      </main>
      <BottomNav />
    </div>
  );
};

export default Dashboard;