public class es16 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("uno");
        stack.push("due");
        stack.push("tre");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

class Stack<T> {
    private java.util.ArrayList<T> elementi = new java.util.ArrayList<>();

    public void push(T item) {
        elementi.add(item);
    }

    public T pop() {
        if (elementi.isEmpty()) return null;
        return elementi.remove(elementi.size() - 1);
    }

    public T peek() {
        if (elementi.isEmpty()) return null;
        return elementi.get(elementi.size() - 1);
    }
}