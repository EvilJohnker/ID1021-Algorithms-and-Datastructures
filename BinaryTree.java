public class BinaryTree {

    private class Node {

        private Integer value;
        private Node left, right;

        private Node(Integer value) {
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(value);
            if(right != null)
                right.print();
        }

    }


    private Node root;

    public BinaryTree() {
        root = null;
    }


    void add(Integer value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node c = root;

        //addrcs(c, value);

        while(true) {
            if (c.value == value) return;
            if (c.value > value && c.left != null) {
                c = c.left;
                continue;
            }
            if (c.value < value && c.right != null) {
                c = c.right;
                continue;
            }
            if (c.value > value) {
                c.left = new Node(value);
                return;
            }
            c.right = new Node(value);
            return;
        }
    }

    void addrcs(Node c, int value) {
        if (c.value == value) return;
        if (c.value > value && c.left != null) {
            addrcs(c.left, value);
            return;
        }
        if (c.value < value && c.right != null) {
            addrcs(c.left, value);
            return;
        }
        if (c.value > value) {
            c.left = new Node(value);
            return;
        }
        c.right = new Node(value);
    }

    boolean lookup(Integer key) {
        Node c = root;
        while (c != null){
            if (c.value == key) return true;
            if (c.value > key) {
                c = c.left;
                continue;
            }
            c = c.right;
        }
        return false;
    }

    public void print() {
        DynamicStack<Node> stk = new DynamicStack<>();
        Node cur = this.root;
        while(cur != null || !stk.isEmpty()) {
            if(cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.pop();
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }



}
