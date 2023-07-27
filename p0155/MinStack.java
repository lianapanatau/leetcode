package p0155;

class Node {
    int value;
    Node nextNode;
    int min;

    public Node(int value, Node nextNode, int min) {
        this.value = value;
        this.nextNode = nextNode;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}

class MinStack {
    private Node first;

    public MinStack() {
    }

    public void push(int val) {
        if (first == null) {
            first = new Node(val, null, val);
        } else {
            first = new Node(val, first, Math.min(val, first.min));
        }
    }

    public void pop() {
        first = first.nextNode;
    }

    public int top() {
        return first.value;
    }

    public int getMin() {
        return first.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }
}
