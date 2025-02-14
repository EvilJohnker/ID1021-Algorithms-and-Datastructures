class LinkedLissst {

    Cell first;

    public LinkedLissst() {
        this.first = null;
    }

    public LinkedLissst(int[] arr) {
        for (int j : arr) add(j);
    }

    LinkedLissst(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }

    private class Cell {
        int head;
        Cell tail;
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    int getVal(int indx) {
        if (indx < 0) {
            System.out.println("Negative index");
            System.exit(1);
        }
        Cell c = first;
        for (int i = 0; i < indx; i++) c = c.tail;
        return c.head;
    }

    void add (int item) {
        this.first = new Cell(item, this.first);
    }
    int length() {
        int sum = 0;
        Cell c = first;
        while (c != null) {
            sum++;
            c = c.tail;
        }
        return sum;
    }
    boolean find(int item) {
        Cell c = first;
        while (c != null) {
            if (c.head == item) return true;
            c = c.tail;
        }
        return false;
    }
    void remove(int item) {
        if (first.head == item) {
            this.first = first.tail;
            return;
        }
        Cell c = first;
        while (c.tail != null) {
            if (c.tail.head == item) {
                c.tail = c.tail.tail;
                return;
            }
            c = c.tail;
        }
        System.out.println("No existing cell for value:" + item);
    }
    public void append(LinkedLissst b) {
        Cell nxt = this.first;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b.first;
        b.first = null;
    }

}
