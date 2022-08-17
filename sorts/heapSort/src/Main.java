public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap("test");

        heap.buildMaxHeap();
        heap.addElement(8);
        heap.addElement(11);
    }
}