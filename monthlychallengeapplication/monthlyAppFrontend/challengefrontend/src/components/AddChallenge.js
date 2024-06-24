import axios from "axios";
import { useState } from "react";

function AddChallenge({onChallenges}){
    const [month,setMonth]=useState('');
    const [description,setDescription]=useState('');
    const handlesubmit = async(e) => {
        e.preventDefault();
        try{
            await axios.post('http://challenge-application-env.eba-csaq2wrn.ap-south-1.elasticbeanstalk.com/challenges',{month,description});
            setMonth('');
            setDescription('');
            onChallenges();
        }
        catch(error){
            console.error("Error in job challenges .... ",error)
        }
        
    }
    return(
        <div className="card my-5">
            <div class="card-header">Add new Challenge</div>
          <div className="card-body">
            <form onSubmit={handlesubmit}>
        <div className="mb-3">
            <label htmlFor="month" className="form-label" >Month</label>
            <input type="text" id="month"className="form-control" placeholder="e.g.,January" value={month} onChange={(e) =>setMonth(e.target.value)} required></input>
        </div>
        <div className="mb-3">
        <label htmlFor="description" className="form-label">Description</label>
        <textarea type="text" id="description" placeholder="Describe the challenge" className="form-control" value={description} onChange={(e) =>setDescription(e.target.value)} required></textarea>
        </div>  
        <button type="submit" className="btn btn-primary" >submit</button>
    </form>
    </div>
    </div>
    );
}
export default AddChallenge;