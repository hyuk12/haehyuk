let numbers1 = [1,2,3,4,5];
let numbers2 = [6,7,8,9,10];
let numbers3 = new Array();

let numbers4 = numbers1.concat(numbers2);

console.log(typeof numbers1);
console.log(typeof numbers2);
console.log(typeof numbers3);
console.log(typeof numbers4);

console.log(numbers4);



let numbers5 = numbers4.filter((num) => {
    return num % 2 != 0;
});

console.log(numbers5)

numbers4.forEach(n => {
    if(n % 2 != 0) {
        console.log(`forEach: ${n}`);
    }
});

console.log(numbers5.indexOf(5));
console.log(numbers5.lastIndexOf(2)); // 못찾으면 -1 반환
console.log(numbers5.join(''));
console.log(numbers5.push(11)); // 길이(lengh)를 반환 
console.log(numbers5);
console.log(numbers5.unshift(13));
console.log(numbers5);
console.log(numbers5.pop(1));
numbers5.splice(3, 2, 15, 17);
console.log(numbers5.slice(3, 6));
console.log(numbers5.sort((a, b) => a - b));
console.log(numbers5.reverse());
console.log(numbers5.toString());

const backButton = document.getElementsByTagName('button');

backButton[0].onclick = () => {
    location.replace('/javascript/window.html');
}