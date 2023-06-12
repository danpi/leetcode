package structrue_ch3;

import common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class N5_codec {
    private final String SEP = ",";
    private final String NULL = "null";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        sb.insert(0, '[');
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    //前序
    private void preSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        preSerialize(root.left, sb);
        preSerialize(root.right, sb);
    }

    //后序
    private void postSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        postSerialize(root.left, sb);
        postSerialize(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : sb.toString().split(SEP)) {
            nodes.addLast(s);
        }
        return preDeserialize(nodes);
    }

    public String levelSerialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode levelDeserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < nodes.length; ) {
            TreeNode cur = q.poll();
            String left = nodes[i++];
            if (left.equals(NULL)) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            }
            String right = nodes[i++];
            if (right.equals(NULL)) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            }
        }
        return root;
    }

    private TreeNode preDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = preDeserialize(nodes);
        root.right = preDeserialize(nodes);
        return root;
    }

    private TreeNode postDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String last = nodes.removeLast();
        if (last.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = postDeserialize(nodes);
        root.left = preDeserialize(nodes);
        return root;
    }
}
