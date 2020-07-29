package zy.code.tree;

/**
 * 二叉树的结点结构定义
 */
public class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode[no=" + no + "," + "name=" + name + "]";
    }

}
