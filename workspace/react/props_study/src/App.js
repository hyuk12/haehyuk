import PropsTest from "./components/PropsTest";
import UserInfo from "./components/UserInfo";
import {useState} from "react";


function App() {

    const userList = [
        {username: 'aaa', name: 'AAA', email: 'aaa@aaa.com'},
        {username: 'bbb', name: 'BBB', email: 'bbb@bbb.com'},
        {username: 'ccc', name: 'CCC', email: 'ccc@ccc.com'},
        {username: 'ddd', name: 'DDD', email: 'ddd@ddd.com'}
    ]

    return (
      <>
        <PropsTest
            username='aaa'
            name='bbb'
            email='aaa@gmail.com'
            handlerClick={() => {
                console.log('클릭함!!!');
                let user1 = userList[0];
                console.log(user1);
            }}
        />
          {userList.map(user => (<UserInfo username={user.username} name={user.name} email={user.email}/>))}

      </>
  );
}

export default App;
