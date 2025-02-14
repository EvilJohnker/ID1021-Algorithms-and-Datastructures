
public class queue{
    int[] queue;
    int i = 0;
    int k = 0;
    int size;

    public queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    void push(int val) {
        if (k == i) extend();
        queue[k++] = val;
        k %= size;
    }

    int pop() {
        if (Math.abs(k - i) < size / 4) shorten();
        int val = queue[i++];
        i %= size;
        return val;
    }

    private void extend() {
        int[] queueExt = new int[size * 2];
        for (int j = 0; j < size; j++) {
            queueExt[j] = queue[i++];
            i %= size;
        }
        i = 0;
        k = size;
        size *= 2;
        queue = queueExt;
    }

    private void shorten() {
        int[] QueueShort = new int[size / 2];
        int indx = 0;
        for (int j = i; j != k; j = (j + 1) % size) {
            QueueShort[indx] = queue[j];
            indx++;
        }
        queue = QueueShort;
        i = 0;
        k = indx;
        size /= 2;
    }

}
