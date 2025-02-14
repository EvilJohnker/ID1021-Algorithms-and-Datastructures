public class DynamicStack<T> extends Stack<T> {
    T[] stack;
    int top = 0;
    int size = 1;
    public DynamicStack() {
        stack = (T[]) new Object[size];
    }
    public void push(T val) {
        if (top == size) {
            T[] copy = (T[]) new Object[size*2];
            for (int i = 0; i < size; i++) {
                copy[i] = stack[i];
            }
            copy[top] = val;
            stack = copy;
            size *= 2;
        }
        else {
            stack[top] = val;
        }
        top++;
    }
    public T pop() {
        if (top > 4 && top < size / 4) {
            T[] copy = (T[]) new Object[size/2];
            for (int i = 0; i < size / 4; i++) {
                copy[i] = stack[i];
            }
            stack = copy;
        }
        top--;
        return stack[top];
    }


    public static void main(String[] args) {
        DynamicStack s = new DynamicStack();
        s.push(32);
        s.push(33);
        s.push(34);
        s.push(35);
        s.push(36);
        s.push(37);
        s.push(38);
        s.push(39);
        s.push(40);
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
