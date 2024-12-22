import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className="bg-orange-100 h-16 w-full">
      <div className="text-2xl font-bold text-orange-950 p-4">
        <Link to={"/"}>
          Unborn
          <span className="text-white">.ly</span>
        </Link>
      </div>
    </div>
  );
};

export default Navbar;
