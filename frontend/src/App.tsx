import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import AuthService from './services/AuthService';
import SignUpPage from './pages/SignUpPage';
import LoginPage from './pages/LoginPage';
import Home from './pages/HomePage';
import ProfilePage from './pages/ProfilePage';
import MyProjectsPage from './pages/MyProjectsPage';
import CreateProjectPage from './pages/CreateProjectPage';

const App: React.FC = () => {
  const isAuthenticated = AuthService.isAuthenticated();

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<SignUpPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route
            path="/home"
            element={isAuthenticated ? <Home /> : <Navigate to="/login" />}
          />
          <Route
            path="/profile"
            element={isAuthenticated ? <ProfilePage /> : <Navigate to="/login" />}
          />
          <Route
            path="/myprojects"
            element={isAuthenticated ? <MyProjectsPage /> : <Navigate to="/login" />}
          />
          <Route
            path="/createproject"
            element={isAuthenticated ? <CreateProjectPage /> : <Navigate to="/login" />}
          />
          <Route
            path="/logout"
            element={<Navigate to="/" />} // You can navigate to any other page after logout
          />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
