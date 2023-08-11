import axios from 'axios';

//const apiUrl = process.env.REACT_APP_API_BASE_URL;

class AuthService {
  static async login(username: string, password: string): Promise<void> {
    try {
      const response = await axios.post(`http://localhost:8080/api/auth/signin`, {
        username,
        password
      });

      if (response.status === 200) {
        const authToken = response.data.jwt;
        localStorage.setItem('authToken', authToken);
      } else {
        throw new Error('Login failed');
      }
    } catch (error) {
      throw new Error('Login failed');
    }
  }

  static async signup(username: string, mail: string, password: string): Promise<void> {
    try {
      const response = await axios.post(`http://localhost:8080/api/auth/signup`, {
        username,
        mail,
        password
      });

      // Handle the response as needed
      console.log('Signup response:', response.data);
    } catch (error) {
      // Handle error
      console.error('Signup error:', error);
      throw error;
    }
  }

  static isAuthenticated(): boolean {
    const token = localStorage.getItem('authToken');
    return !!token;
  }

  static logout(): void {
    localStorage.removeItem('authToken');
  }
}

export default AuthService;