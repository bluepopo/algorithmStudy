package zy.code.tree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       BinaryTree tree = new BinaryTree();

        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //手动创建二叉树关系
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        tree.root = root;

        HeroNode heroNode = BinaryTree.postOrderSearch(root, 1);
        System.out.println(heroNode);


    }
}
