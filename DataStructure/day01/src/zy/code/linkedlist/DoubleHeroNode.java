package zy.code.linkedlist;

/**
 * 双向链表的结点结构
 */
public class DoubleHeroNode {
    public   int no;//英雄排名
    public String name;//姓名
    public String nickname;//昵称
    public DoubleHeroNode next;//指向下一个节点的指针
    public DoubleHeroNode pre;//指向上一个结点的指针

    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        // 不打印 next，只打印该节点的data信息
        return  "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }


}
