深度优先DFS(depth first search)  
广度优先BFS(breadth first search)

实战题目  
• ([102]二叉树的层序遍历)https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description  
• ()https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description    
• ()https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description  
课后作业  
• ()https://leetcode-cn.com/problems/word-ladder/description/  
• ()https://leetcode-cn.com/problems/word-ladder-ii/description/  
• https://leetcode-cn.com/problems/number-of-islands/  
• https://leetcode-cn.com/problems/minesweeper/description/  

DFS递归写法  
二叉树

    public void dfs(node,res){
        if(node==null){
            return;
        }
        res.add(node.val);
        
        dfs(node.left,res);
        dfs(node.right,res);
    }
n叉树
    
    public void dfs(node,res){
        if(node==null){
           return;
        }
        res.add(node.val);
        
        for(Node childNode:node.children()){
            dfs(childNode,res);
        }
    }

BFS递归写法  

    public void levelOrder(Node root) {
            List<Integer> res;
            Deque<Node> deque = new ArrayDeque<>();
            deque.offerLast(root);
            while (!deque.isEmpty()) {
                node=deque.pollFirst();
                res.add(node.val);
                deque.offerLast(node.left);
                deque.offerLast(node.right);
            }
        }