/** @jsxImportSource @emotion/react*/
import Main from "./pages/Main/Main";
import {Global} from "@emotion/react";
import {reset} from "./styles/GlobalStyle";

function App() {
  return (
      <>
        <Global styles={reset}></Global>
        <Main></Main>
      </>

  );
}

export default App;
