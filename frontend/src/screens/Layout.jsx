import { Outlet } from "react-router-dom";
import Navbar from "../components/Navbar";

const Layout = () => {
  return (
    <div className="h-screen bg-orange-50 flex flex-col">
      <Navbar />
      <main className="flex-1 h-full">
        <Outlet />
      </main>
    </div>
  );
};

export default Layout;
