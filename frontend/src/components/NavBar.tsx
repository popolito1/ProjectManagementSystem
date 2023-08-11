import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser,faSignOutAlt,faPenToSquare,faFolder } from '@fortawesome/free-solid-svg-icons';


const Navbar: React.FC = () => {
    const navigate = useNavigate();
  const handleLogout = () => {
    AuthService.logout(); // Implement your logout method
    navigate('/');
  };

  return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark ">
            <ul className="navbar-nav mx-4">
                <li className="nav-item ">
                    <Link className="nav-link active" to="/myprojects">
                        <FontAwesomeIcon icon={faFolder} className="nav-icon" /> My Projects
                    </Link>
                </li>
                <li className="nav-item ">
                    <Link className="nav-link active" to="/createproject">
                        <FontAwesomeIcon icon={faPenToSquare} className="nav-icon" /> Create Project
                    </Link>
                </li>
                <li className="nav-item ">
                    <Link className="nav-link active" to="/profile">
                        <FontAwesomeIcon icon={faUser} className="nav-icon" /> Profile
                    </Link>
                </li>
                <li className="nav-item active ">
                <button className="nav-link btn " onClick={handleLogout}>
                    <FontAwesomeIcon icon={faSignOutAlt} className="nav-icon" /> Logout
                </button>
                </li>
            </ul>

        </nav>
  );
};

export default Navbar;
