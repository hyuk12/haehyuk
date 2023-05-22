import React, {useState} from 'react';
import {useMutation} from "react-query";
import axios from "axios";

const ForgotPassword = () => {
    const [email, setEmail] = useState('');
    const sendMail = useMutation(async () => {
        const response = await axios.post("http://localhost:8080/mail/send", {email});
        alert(response.data)
        return response;
    });

    const sendMailClickHandler = () => {
        sendMail.mutate()
    }

    const emailInputHandler = (e) => {
        setEmail(e.target.value)
    }
    return (
        <div>
            <input type="email" onChange={emailInputHandler}/>
            <button onClick={sendMailClickHandler}>메일 전송</button>
        </div>
    );
};

export default ForgotPassword;