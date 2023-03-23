/** @jsxImportSource @emotion/react*/
import React from "react";
import * as S from "./style";

function Td({ children }) {

    return (
        <td css={S.style}>{children}</td>
    );
}

export default Td;