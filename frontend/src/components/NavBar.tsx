import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser,faSignOutAlt,faPenToSquare,faFolder } from '@fortawesome/free-solid-svg-icons';
import '../css/navbar.css'


const Navbar: React.FC = () => {
    const navigate = useNavigate();
  const handleLogout = () => {
    AuthService.logout(); // Implement your logout method
    navigate('/');
  };

  return (
    <div className='df'>
        <nav className="navbar navbar-expand-lg navbar-light ">
            <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                    <Link className="nav-link" to="/myprojects">
                        <FontAwesomeIcon icon={faFolder} className="nav-icon" /> My Projects
                    </Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/createproject">
                        <FontAwesomeIcon icon={faPenToSquare} className="nav-icon" /> Create Project
                    </Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/profile">
                        <FontAwesomeIcon icon={faUser} className="nav-icon" /> Profile
                    </Link>
                </li>
                <li className="nav-item">
                <button className="nav-link btn" onClick={handleLogout}>
                    <FontAwesomeIcon icon={faSignOutAlt} className="nav-icon" /> Logout
                </button>
                </li>
            </ul>
        </nav>
    </div>
  );
};

export default Navbar;
