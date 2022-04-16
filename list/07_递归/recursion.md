实战题目  
• https://leetcode-cn.com/problems/climbing-stairs/  
• ([22]括号生成)https://leetcode-cn.com/problems/generate-parentheses/  
• ([226]翻转二叉树)https://leetcode-cn.com/problems/invert-binary-tree/description/  
• ([98]验证二叉搜索树)https://leetcode-cn.com/problems/validate-binary-search-tree  
• ([104]二叉树的最大深度)https://leetcode-cn.com/problems/maximum-depth-of-binary-tree  
• ([111]二叉树的最小深度)https://leetcode-cn.com/problems/minimum-depth-of-binary-tree  
• ([297]二叉树的序列化与反序列化)https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/  
每日一课  
• 如何优雅地计算斐波那契数列  
课后作业  
• https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/  
• https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal  
• https://leetcode-cn.com/problems/combinations/  
• https://leetcode-cn.com/problems/permutations/  
• https://leetcode-cn.com/problems/permutations-ii/


### 递归模板

    public void recursion(int level,int param){
        //#recursion terminator
        if(level>MAX_LEVEL){
            //process result
            return;
        }
        
        //process current logic
        process(level,param);
        
        //drill down
        recursion(level:level+1,newParam);
        
        //restore current statusß
    }
        