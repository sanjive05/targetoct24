import {useState} from 'react';
function Greeting({name,message}){
    const [messageState,setMessage] = useState(message);
    return(
        <div>
    <h1>Hello {name} </h1>
    <p>{messageState}</p>
    <button onClick={()=>{
        if(message != null){
         setMessage('Good bye')}
        }
         }>change message</button>
    </div>);
}
export default Greeting;  