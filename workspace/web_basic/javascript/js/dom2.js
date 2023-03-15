const container = document.getElementsByClassName('container');
const box = document.getElementsByClassName('box');
const redButton = document.getElementsByClassName('red-button');
const blueButton = document.getElementsByClassName('blue-button');
const addButton = document.getElementsByClassName('add-button');

box[0].style.backgroundColor = 'black';
addEvent();

function addEvent () {
    for(let i = 0; i < box.length; i++) {
    
        redButton[i].onclick= () => {
            box[i].style.backgroundColor = 'red';
        }
        
        blueButton[i].onclick = () => {
            box[i].style.backgroundColor = 'blue';
        }
    }
}
    


addButton[0].onclick = () => {
   container[0].innerHTML += 
    `<div class="box"></div>
    <button class="red-button">빨간색</button>
    <button class="blue-button">파란색</button>`;

    box[box.length - 1].style.backgroundColor = 'black';
    addEvent();
}

    


