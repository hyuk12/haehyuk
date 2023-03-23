import React from "react";

function PropsTest({ username, name, email, handlerClick}) {
    const user = {
        username,
        name,
        email
    };

    // const {username, name} = user;
    let testPrint = ({ username, name, email }) => {
        console.log(`username -> ${username}`);
        console.log(`name -> ${name}`);
        console.log(`email -> ${email}`);
    };

    testPrint(user);
    return (
        <>
            <h1>비구조할당</h1>=
            <p>username - {username}</p>
            <p>name - {name}</p>
            <p>email - {email}</p>
            <button onClick={handlerClick}>클릭</button>
        </>

    );
}

export default PropsTest;