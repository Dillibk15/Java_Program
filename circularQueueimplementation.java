import java.util.*;

class CQueue {
    int cq[], front, rear, size;

    CQueue(int n) {
        size = n;
        front = rear = -1;
        cq = new int[size];
    }

    boolean isFull() {
        if (front == 0 && rear == size - 1 || front == rear + 1)
            return true;
        else
            return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(int x) {
        if (isFull())
            System.out.println("\nCircular Queue is full");
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            cq[rear] = x;
        }
    }

    int deQueue() {
        int x;
        if (isEmpty()) {
            System.out.println("\nCircular Queue is empty");
            return -1;
        } else {
            x = cq[front];
            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % size;
            return x;
        }
    }

    void display() {
        int i;
        if (isEmpty())
            System.out.println("\nCircular Queue is Empty");
        else {
            for (i = front; i != rear; i = (i + 1) % size)
                System.out.print(cq[i] + "--->");
            System.out.println(cq[i]);

        }
    }
}

class CQueueImplementation {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("\nEnter Size of the Circular Queue");
        n = s.nextInt();
        CQueue cq = new CQueue(n);
        int x;
        int ch;
        System.out.println("\nEnter your choice");
        do {
            System.out.println("|------------------------|");
            System.out.println("|   1---> for EnQueue |");
            System.out.println("|   2---> for DeQueue |");
            System.out.println("|   3---> for Display    |");
            System.out.println("|   4---> for Exit       |");
            System.out.println("|------------------------|");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter an item to be inserted");
                    x = s.nextInt();
                    cq.enQueue(x);
                    break;
                case 2:
                    x = cq.deQueue();
                    if (x != -1)
                        System.out.println("Deleted element is:  " + x);
                    break;
                case 3:
                    System.out.println("The content of Queue is");
                    cq.display();
                    break;
            }
        } while (ch > 0 && ch < 4);

    }
}