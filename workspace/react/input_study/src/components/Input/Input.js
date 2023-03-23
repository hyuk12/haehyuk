/** @jsxImportSource @emotion/react*/
import React from "react";
import * as S from "./style";

function Input({ value, type, placeholder,inputRef }) {

    return (
        <input
            css={S.style}
            type={type}
            placeholder={placeholder}
            value={value}
            ref={inputRef}
        />
    );
}

export default Input;