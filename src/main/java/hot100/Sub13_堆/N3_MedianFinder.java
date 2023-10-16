package hot100.Sub13_堆;

import java.util.PriorityQueue;

/**
 * hot100.Sub13_heap
 * N3_MedianFinder
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N3_MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public N3_MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a);//大顶堆
        this.right = new PriorityQueue<>((a, b) -> a - b);//小顶堆
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            if (left.isEmpty() || num < right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (num > left.peek()) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
