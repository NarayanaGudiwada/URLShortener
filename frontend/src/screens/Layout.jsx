import { Outlet } from 'react-router-dom';
import { Navbar } from '../components/Navbar';

const Layout = () => {
    return (
        <div className='h-screen bg-sky-50'>
           <Navbar />  
            <main>
                <Outlet />
            </main>
        </div>
    );
};

export default Layout;