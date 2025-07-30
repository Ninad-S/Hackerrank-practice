class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a, StackNode h) {
        // Add your code here
        if (top == null)
        {
            top = new StackNode(a);
            return;
        }
        if (h.next == null)
        {
            h.next = new StackNode(a);
            return;
        }
        push(a,h.next);
        
    }
    void push(int a) {
        // Add your code here
        StackNode h = top;
        push(a,h);
    }

    // Function to remove an item from top of the stack.
    int pop(StackNode h) {
        // Add your code here
        if (top == null)
        {
            return -1;
        }
        if (top.next == null)
        {
            int num = top.data;
            top = null;
            return num;
        }
        if (h.next.next == null)
        {
            int num = h.next.data;
            h.next = null;
            return num;
        }
        return pop(h.next);
    }
    int pop() {
        // Add your code here
        StackNode h = top;
        return pop(h);
    }
}
