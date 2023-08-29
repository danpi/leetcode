package thinking_ch4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestIterator implements Iterator<Integer> {
    private Iterator<Integer> it;

    public NestIterator(List<NestedInteger> nestList) {
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestList) {
            scanList(node, result);
        }
        this.it = result.iterator();
    }

    void scanList(NestedInteger root, List<Integer> result) {
        if (root.isInteger()) {
            result.add(root.getInteger());
            return;
        }
        for (NestedInteger node : root.getList()) {
            scanList(node, result);
        }
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }
}
