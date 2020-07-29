package zy.code.tree;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树的遍历
 */
public class BinaryTree {
    public HeroNode root = new HeroNode(0,"");


    /**
     * 前序遍历
     */
    public static void preOrder(HeroNode root){
       if (root != null){
           System.out.println(root);
           preOrder(root.left);
           preOrder(root.right);
       }

    }

    /**
     * 中序遍历
     */
    public static void inOrder(HeroNode root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     */
    public static void postOrder(HeroNode root){
        if (root != null){
            postOrder(root.right);
            System.out.println(root);
            postOrder(root.left);
        }
    }

    /**
     * 前序查找
     */
    public static HeroNode preOrderSearch(HeroNode root,int no){
        HeroNode resultNode = null;

       if (root != null){
           if (root.no == no){
               return root;
           }
        //向左遍历
        resultNode = preOrderSearch(root.left, no);
         if (resultNode != null){
             return resultNode;
         }
         //向右遍历
         resultNode = preOrderSearch(root.right,no);
     }
        return resultNode;

    }


    /**
     * 中序查找
     */
    public static HeroNode inOrderSearch(HeroNode root,int no){
        HeroNode resultNode = null;
        if (root != null){
            //向左遍历
           resultNode = inOrderSearch(root.left,no);
           if (resultNode != null){
               return resultNode;
           }
           if (root.no == no){
               return root;
           }
           //向右递归
            resultNode = inOrderSearch(root.right, no);
        }

        return resultNode;
    }



    /**
     * 后序查找
     */
    public static HeroNode postOrderSearch(HeroNode root,int no){
        HeroNode resultNode = null;
        if (root != null){

            //向右递归
            resultNode = postOrderSearch(root.right, no);
            if (resultNode != null){
                return resultNode;
            }
            //向左递归
           resultNode = postOrderSearch(root.left,no);
            if (resultNode != null){
                return resultNode;
            }
            //比较自身
            if (root.no == no){
                return root;
            }

        }

        return resultNode;
    }

}
