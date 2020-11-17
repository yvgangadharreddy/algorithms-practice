package datastructures;

public class Queue {
    int front, rear, size=5;
    int[] arr = new int[size];

    Queue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return rear == size-1 && front == 0;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) front = 0;
            arr[++rear] = x;
        }
    }

    int dequeue() {
        int element = arr[front];
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
        }
        System.out.println("removed element" + element);
        return element;
    }

    void display() {
        for (int i= front; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();

        q.enqueue(6);

        q.display();

        q.dequeue();
        q.dequeue();

        q.display();


    }

}
