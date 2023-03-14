window.onload = () => {
    console.log('온로드 테스트');
    let calc = new Calc(30);
    calc.showInfo();
    Calc.staticPrint();
    console.log(add(Calc.testNumber, Calc.testNumber2));
    TestService.getInstance().showTest();
}

function add(a, b) {
    return a + b 
}



/**
 *  Javascript 에서 class
 * 
 *  #은 private 를 의미한다.
 *  자료형은 선언하지 않는다.
 *  멤버변수 또는 멤버메소드를 참조할 때는 항상 this를 붙인다.
 *  멤버메소드를 정의할 때는 function 키워드를 사용하지 않는다.
 *  
 *  생성자는 constructor로 정의한다.
 * 
 */

class Calc {
    #PI = null;                 // # private 
    testNumber = 10;
    static testNumber2 = 20;
    name = null;
    age = null;

    constructor (name, age) {
        if(typeof name == 'string' && typeof age == 'number') {
            this.name = name;
            this.age = age;
        }else if (typeof name == 'string') {
            this.name = name;
            this.age = null;
        }else if (typeof name == 'number') {
            this.age = name;
            this.name = null;
        }else {
            this.name = null;
            this.age = null;
        }
    }

    showInfo() {
        console.log(this.#PI);
        console.log(this.testNumber);
        console.log(this.testNumber2);
        console.log(this.name);
        console.log(this.age);
    }

    static staticPrint() {
        console.log('스태틱 테스트');
    }
}

let calc2 = {
    name: '홍길동',
    age: 20,
    showInfo: function() {
        console.log(calc2.name);
        console.log(calc2.age);
    }
}

class TestService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null){
            this.#instance = new TestService();
        }
        return this.#instance;
    }

    showTest() {
        console.log('싱글톤 테스트 출력');
    }
}