/**
 *  추가 버튼 클릭시 input에 들어있는 value를 받아서 리스트에 뿌려준다.
 *  리스트의 확인버튼을 누르면 글자색이 빨간색과 동시에 throw 중간줄이 표시되어야한다.
 *  확인버튼을 다시 클릭하면 todo-content의 색상을 black으로 변경하고 취소선 미적용한다.
 */

const addButton = document.getElementsByClassName('add-button');

addButton[0].onclick = () => {
    const todoList = document.getElementsByClassName('todo-list');
    const todoText = document.getElementsByClassName('todo-text');
    if(todoText[0].value !== null && todoText[0].value.length !== 0 && todoText[0].value !== undefined) {
        todoList[0].innerHTML += `
        <li>
        <span class="todo-content">${todoText[0].value}</span> <button class="ok-button">확인</button>
        </li>
        `    
        colorChangeButton();
    }

    
}

function colorChangeButton (){
    const okButton = document.getElementsByClassName('ok-button');
    const todoContent = document.getElementsByClassName('todo-content');
    
    for(let i = 0; i < okButton.length; i++){
        okButton[i].onclick = () => {
            
            if(todoContent[i].style.textDecoration === 'none'){
                todoContent[i].style.textDecoration = 'line-through';
                todoContent[i].style.color = 'red';
            }else {
                todoContent[i].style.textDecoration = 'none';
                todoContent[i].style.color = 'black';
            }
        }
    }
}

