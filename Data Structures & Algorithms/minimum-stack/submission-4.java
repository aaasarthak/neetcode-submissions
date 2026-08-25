class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    Integer minValue;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if(val < minValue) {
            minStack.push(val);
            minValue = val;
        } else {
            minStack.push(minValue);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if(!minStack.isEmpty()) {
            minValue = minStack.peek();
        } else {
            minValue = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValue;
    }
}
