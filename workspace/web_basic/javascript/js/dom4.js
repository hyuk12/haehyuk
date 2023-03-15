/**
 *  추가 버튼 클릭시 input에 들어있는 value를 받아서 리스트에 뿌려준다.
 *  리스트의 확인버튼을 누르면 글자색이 빨간색과 동시에 throw 중간줄이 표시되어야한다.
 *  확인버튼을 다시 클릭하면 todo-content의 색상을 black으로 변경하고 취소선 미적용한다.
 */

const addButton = document.getElementsByClassName('add-button');

addButton[0].onclick = () => {
    const todoList = document.getElementsByClassName('todo-list');
    const todoText = document.getElementsByClassName('todo-text');
    const li = document.createElement("li");
    li.innerHTML = `<input type="checkbox" class="ok-check"> <span class="todo-content">${todoText[0].value}</span>`;

    todoList[0].appendChild(li);
    colorChangeEvent();

    
}

function colorChangeEvent() {
    const okCheck = document.getElementsByClassName('ok-check');
    const todoContent = document.getElementsByClassName('todo-content');
    for (let i = 0; i < okCheck.length; i++) {
        okCheck[i].onclick = () => {
            if(okCheck[i].checked) {
                todoContent[i].style.textDecoration = 'line-through';
                todoContent[i].style.color = 'red';
            }else {
                todoContent[i].style.textDecoration = 'none';
                todoContent[i].style.color = 'black';
            }
        }
    }
}
