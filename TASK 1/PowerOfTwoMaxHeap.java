import java.util.ArrayList;
public class PowerOfTwoMaxHeap<T extends Comparable<T>>


     {
        private final int childCount;
        private final ArrayList<T> data;

        public PowerOfTwoMaxHeap(int x) {
            if (x < 0) {
                throw new IllegalArgumentException("x must be non-negative");
            }
            this.childCount = (int) Math.pow(2, x);
            this.data = new ArrayList<>();
        }

        public void insert(T item) {
            data.add(item);
            int itemIndex = data.size() - 1;
            while (itemIndex > 0) {
                int parentIndex = (itemIndex - 1) / childCount;
                if (data.get(itemIndex).compareTo(data.get(parentIndex)) > 0) {
                    swap(itemIndex, parentIndex);
                    itemIndex = parentIndex;
                } else {
                    break;
                }
            }
        }

        public T popMax() {
            if (data.isEmpty()) {
                return null;
            }

            T maxItem = data.get(0);
            if (data.size() > 1) {
                T lastItem = data.remove(data.size() - 1);
                data.set(0, lastItem);
                int itemIndex = 0;
                while (true) {
                    int largestChildIndex = getLargestChildIndex(itemIndex);
                    if (largestChildIndex == -1 || data.get(itemIndex).compareTo(data.get(largestChildIndex)) >= 0) {
                        break;
                    }
                    swap(itemIndex, largestChildIndex);
                    itemIndex = largestChildIndex;
                }
            } else {
                data.remove(0);
            }

            return maxItem;
        }

        private int getLargestChildIndex(int parentIndex) {
            int largestChildIndex = -1;
            T largestChildValue = null;
            for (int i = 1; i <= childCount; i++) {
                int childIndex = childCount * parentIndex + i;
                if (childIndex < data.size()) {
                    T childValue = data.get(childIndex);
                    if (largestChildValue == null || childValue.compareTo(largestChildValue) > 0) {
                        largestChildValue = childValue;
                        largestChildIndex = childIndex;
                    }
                }
            }
            return largestChildIndex;
        }

        private void swap(int i, int j) {
            T temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        public static void main(String[] args) {
            PowerOfTwoMaxHeap<Integer> heap = new PowerOfTwoMaxHeap<>(2);
            heap.insert(10);
            heap.insert(20);
            heap.insert(5);
            heap.insert(7);
            heap.insert(15);

            System.out.println(heap.popMax()); // 20
            System.out.println(heap.popMax()); // 15
            System.out.println(heap.popMax()); // 10
        }
    }


