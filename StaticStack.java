public class StaticStack<T> extends Stack<T> {
    T[] stack;
    int top = 0;
    public StaticStack(int size) {
        this.stack = (T[]) new Object[size];
    }
    public void push(T val) {
        stack[top] = val;
        top++;
    }
    public T pop() {
        top--;
        return stack[top];
    }
    public static void main(String[] args) {
        StaticStack s = new StaticStack(16);
        s.push(32);
        s.push(33);
        s.push(34);
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
    }
}