import logo from './logo.svg';
import './App.css';
import './components/ChallengesList.js';
import ChallengesList from './components/ChallengesList';
import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [challenges,setChallenges]=useState([
]);
  useEffect(()=>{
    const fetchChallenges = async () => {
      const response =await axios.get('http://localhost:8080/challenges');
      setChallenges(response.data);
    };
    fetchChallenges();
  },[])
  return (
    <div className="App">
     <h1>Monthly challenges</h1>
     <ChallengesList challenges={challenges}/>
    </div>
  );
}

export default App;
