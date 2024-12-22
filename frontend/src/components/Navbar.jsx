import { Link } from "react-router-dom";

export function Navbar() {
  return <div className="bg-sky-50 h-16">
    <div className="text-2xl font-bold text-sky-950 p-4 bg-sky-100 fixed w-full"> 
      <Link to={'/'}>Unborn
        <span className="text-sky-200">.ly</span>
      </Link>
    </div>
  </div>;
}