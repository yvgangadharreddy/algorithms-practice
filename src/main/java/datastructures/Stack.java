package datastructures;

public class Stack {
    int capacity;
    int[] arr;
    int top;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("StackOverFlow error: Stack is full");
            System.exit(1);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty");
            System.exit(1);
        }
        return arr[top--];
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    boolean isEmpty() {
        return top == - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStack();
    }
}

// A Dynamic Programming based java program to
// find minimum possible sum of elements of array
// such that an element out of every three
// consecutive is picked.


// This code is contributed by vt_m
