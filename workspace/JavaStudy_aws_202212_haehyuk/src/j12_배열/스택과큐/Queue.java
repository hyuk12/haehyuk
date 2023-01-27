package j12_배열.스택과큐;

import java.util.LinkedList;

// 연결 리스트를 이용한 큐 선입선출

public class Queue {

    java.util.Queue<Integer> queue = new LinkedList<>();

    void enQueue(int value) {
        queue.add(value);
    }

    int deQueue() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        System.out.printf("%d, %d, %d", queue.deQueue(), queue.deQueue(), queue.deQueue());
    }
}
