package exercise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import thinking_ch4.NestedInteger;

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.getFirst().isInteger()) {
            List<NestedInteger> first = list.getFirst().getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}

