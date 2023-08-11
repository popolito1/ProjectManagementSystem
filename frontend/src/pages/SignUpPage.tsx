import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';
import SignupForm from '../components/SignUpForm';

const SignupPage: React.FC = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
  const [mail, setMail] = useState('');
  const [password, setPassword] = useState('');

  const handleSignup = async (e: React.FormEvent) => {
    e.preventDefault();

    try {
      await AuthService.signup(username, mail, password);
      navigate('/login'); // Redirect to login page on successful signup
    } catch (error) {
      console.error('Signup error:', error);
    }
  };

  return (
    <div>
      <h1>Signup</h1>
      <SignupForm
        username={username}
        setUsername={setUsername}
        mail={mail}
        setMail={setMail}
        password={password}
        setPassword={setPassword}
        handleSignup={handleSignup}
      />
       <Link to="/login">I already have an account</Link>
    </div>
  );
};

export default SignupPage;
