
import Challenge from "./Challenge";
function ChallengesList({challenges}){

    return(
        <div>
            {challenges.map(challenge =>(
                <div>
                   <Challenge key ={challenge.id} challenge={challenge}/>
                </div>
            ))}
        </div>
    );
}
export default ChallengesList;