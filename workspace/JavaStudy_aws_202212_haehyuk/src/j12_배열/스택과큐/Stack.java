package j12_배열.스택과큐;

/**
 *  stack 이란 먼저 들어간 객체가 나중에 나오는 선입후출이다.
 */

public class Stack {
    int size = 500;
    int[] arr = new int[size];
    int top = 0;

    int push(int n) {
        if(top > size) {
            return -1;
        }
        arr[top++] = n;
        return 0;
    }

    int pop() {
        if (top <= 0) {
            return -1;
        }
        return arr[--top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.printf("%d %d %d", stack.pop(), stack.pop(), stack.pop());
    }
}
