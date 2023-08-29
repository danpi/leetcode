package thinking_ch4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/flatten-nested-list-iterator/
public class N10_NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;

    public N10_NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}
