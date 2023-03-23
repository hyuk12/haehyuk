/** @jsxImportSource @emotion/react*/
import React, {useRef, useState} from "react";
import * as S from "./style";
import Th from "../../components/Th/Th";
import Input from "../../components/Input/Input";
import Td from "../../components/Td/Td";
function Main() {
    const [userList, setUserList] = useState([]);

    const usernameRef = useRef();
    const passwordRef = useRef();
    const nameRef = useRef();
    const emailRef = useRef();
    const handler = () => {
        const user = {
            number: userList.length === 0 ? 1: userList[userList.length - 1].number + 1,
            username: usernameRef.current.value,
            password: passwordRef.current.value,
            name: nameRef.current.value,
            email: emailRef.current.value

        }

        setUserList([...userList, user]);


        // setUserList((userList) => {
        //     userList.push(user);
        // });
        console.log(userList);
    }
    return <>
        <div css={S.containerStyle}>
            <header css={S.mainHeaderStyle}>
                <h1>사용자 정보 등록</h1>
            </header>
            <main css={S.mainContainerStyle}>
                <div css={S.userInputContainerStyle}>
                    <Input type={"text"} placeholder={"username"} inputRef={usernameRef}></Input>
                    <Input type={"password"} placeholder={"password"} inputRef={passwordRef}></Input>
                    <Input type={"text"} placeholder={"name"} inputRef={nameRef}></Input>
                    <Input type={"email"} placeholder={"email"} inputRef={emailRef}></Input>
                    <button css={S.submitButtonStyle} type={"button"} onClick={handler}>추가</button>
                </div>
                <table>
                    <thead>
                        <tr>
                            <Th children={"number"}>number</Th>
                            <Th children={"username"}>username</Th>
                            <Th children={"password"}>password</Th>
                            <Th children={"name"}>name</Th>
                            <Th children={"email"}>email</Th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            userList.map(user => {
                                return(
                                    <tr>
                                        <Td>{user.number}</Td>
                                        <Td>{user.username}</Td>
                                        <Td>{user.password}</Td>
                                        <Td>{user.name}</Td>
                                        <Td>{user.email}</Td>
                                    </tr>

                                );
                            })
                        }
                    </tbody>
                </table>
            </main>
        </div>
    </>;
}

export default Main;