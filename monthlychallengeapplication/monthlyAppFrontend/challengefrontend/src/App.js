import logo from './logo.svg';
import './App.css';
import './components/ChallengesList.js';
import ChallengesList from './components/ChallengesList';
import { useEffect, useState } from 'react';
import axios from 'axios';
import AddChallenge from './components/AddChallenge.js';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [challenges,setChallenges]=useState([ 
]);
  useEffect(()=>{
    console.log("Inside use Effect method...")
    fetchChallenges();
  },[]);
  
  const fetchChallenges = async () => {
    try{
      console.log("Inside try method...")
      // here we have to change the url based on our spring boot application url
      const response =await axios.get('http://localhost:5000/challenges');
    setChallenges(response.data);
    }
    catch(error){
      console.error("Error in job challenges .... ",error);
    }
    
  };
  const handlechallengeAdded = () => {
    console.log("This method invoked...");
    fetchChallenges()
  }
  return (
    <div className="container mt-5">
     <h1 className='text-center mb-4'>Monthly challenges</h1>   
     <AddChallenge onChallenges ={handlechallengeAdded}/>   
     <ChallengesList challenges={challenges}/>
    </div>
  );
}

export default App;
