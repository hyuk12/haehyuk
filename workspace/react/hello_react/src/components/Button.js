import React from "react";
import UserInfo from "./UserInfo";

function handlerClick() {
    console.log('이름전달 버튼 클릭');
}

function Button(props) {
    return (
        <button onClick={props.handlerClick}>이름전달</button>
    );
}

export default Button;