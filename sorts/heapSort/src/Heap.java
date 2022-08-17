import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Heap {
    int heapSize;
    int capacity;
    ArrayList<Integer> data;

    public Heap() {
        heapSize = 0;
        data =  new ArrayList<>();
    }

    public Heap(String mod) {
        if (mod.equals("test")) {
            heapSize = 10;
            capacity = 100;
            data = new ArrayList<>(Arrays.asList(4,1,3,2,16,9,10,14,8,7));
        }
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void maxHeapify(int rootIndex) {
        int leftChildIndex = left(rootIndex);
        int rightChildIndex = right(rootIndex);

        int largestValueIndex = rootIndex;
        if (leftChildIndex < heapSize && data.get(leftChildIndex) > data.get(largestValueIndex)) {
            largestValueIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && data.get(rightChildIndex) > data.get(largestValueIndex)) {
            largestValueIndex = rightChildIndex;
        }

        if (largestValueIndex != rootIndex) {
            Collections.swap(data, largestValueIndex, rootIndex);
            maxHeapify(largestValueIndex);
        }
    }

    public void buildMaxHeap() {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void sort() {
        int realSize = heapSize;
        buildMaxHeap();

        for (int i = heapSize - 1; i > 1; i--) {
            Collections.swap(data, 0, i);
            heapSize--;
            maxHeapify(0);
        }

        heapSize = realSize;
    }

    public void addElement(int element) {
        data.add(heapSize, element);
        int curIndex = heapSize;
        heapSize++;

        int curParent = parent(curIndex);
        while (curIndex > 0 && data.get(curParent) < element) {
            Collections.swap(data, curParent, curIndex);
            curIndex = curParent;
            curParent = parent(curIndex);}
    }
}
