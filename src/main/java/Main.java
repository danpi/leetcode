import common.TreeNode;
import exercise.Solution;
import framework.bfs.OpenLock;
import java.util.LinkedList;
import java.util.List;
import structrue.N1_LRUCache;
import structrue.N5_codec;

/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    public static void main(String[] args) {
        N5_codec codec = new N5_codec();
        String data = "[1,2,null,4,null,null,3,null,null]";
        TreeNode root = codec.deserialize(data);
        System.out.println(codec.serialize(root));

    }
}
