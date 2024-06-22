
import Challenge from "./Challenge";
function ChallengesList({challenges}){
    console.log("Inside challenge list method...")
    return(
        
        <div className="list-group">
            {challenges.map(challenge =>(
                <div>
                    <Challenge challenge={challenge}/>
                </div>
            ))}
            </div>
           
    );
}
export default ChallengesList;