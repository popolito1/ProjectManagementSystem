import React from 'react';

interface SignupFormProps {
  username: string;
  setUsername: React.Dispatch<React.SetStateAction<string>>;
  mail: string;
  setMail: React.Dispatch<React.SetStateAction<string>>;
  password: string;
  setPassword: React.Dispatch<React.SetStateAction<string>>;
  handleSignup: (e: React.FormEvent) => Promise<void>;
}

const SignupForm: React.FC<SignupFormProps> = ({ username, setUsername, mail, setMail, password, setPassword, handleSignup }) => {
  return (
    <form onSubmit={handleSignup}>
      <label>
        Username:
        <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
      </label>
      <label>
        Email:
        <input type="email" value={mail} onChange={(e) => setMail(e.target.value)} />
      </label>
      <label>
        Password:
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
      </label>
      <button type="submit">Signup</button>
    </form>
  );
};

export default SignupForm;
