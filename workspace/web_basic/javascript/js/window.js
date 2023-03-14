// location.href = "http://www.naver.com";
const naverBtn = document.getElementsByTagName('button');

naverBtn[0].onclick = () => {
    // location.href = 'http://www.naver.com';
    location.replace('http://www.naver.com');
}

naverBtn[1].onclick = () => {
    location.href = 'http://127.0.0.1:5500/javascript/array.html';
}