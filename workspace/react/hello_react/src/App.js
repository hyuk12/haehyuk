import Hello from './components/Hello';
import Button from "./components/Button";
import UserInfo from "./components/UserInfo";
import {useState} from "react";

function App() {
    let [name, setName] = useState('');
    return (
      <>
        <div>
          {/** Jsx 주석
               1. Jsx 는 javascript 함수 return 에 HTML 태그 또는 다른 component 들을 표현할 수 있는 표현식이다.
               2. 하나의 Jsx 즉, return 에는 하나의 태그 묶음만 들어올 수 있다.
               3. <></> 비어있는 태그를 열고 닫으면 실제 랜더링 시에 무시된다.
           */}
        </div>
        <div>
          <Hello></Hello>
            <Button handlerClick={() => {
                name === '' ? setName('test') : setName('');
            }}></Button>
            <UserInfo name={name} phone={"010-0000-0000"} address={"부산 부산진구"}></UserInfo>
        </div>
      </>
  );
}
export default App;
