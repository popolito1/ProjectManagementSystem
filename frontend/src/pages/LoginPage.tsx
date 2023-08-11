import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';
import LoginForm from '../components/LoginForm';

const SignupPage: React.FC = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();

    try {
      await AuthService.login(username, password);
      navigate('/home'); // Redirect to login page on successful signup
    } catch (error) {
      console.error('Signup error:', error);
    }
  };

  return (
    <div>
      <h1>Login</h1>
      <LoginForm
        username={username}
        setUsername={setUsername}
        password={password}
        setPassword={setPassword}
        handleLogin={handleLogin}
      />
    </div>
  );
};

export default SignupPage;
