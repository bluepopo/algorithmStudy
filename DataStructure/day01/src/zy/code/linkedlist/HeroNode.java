package zy.code.linkedlist;

/**
 * 单链表结点的结构定义
 */
public class HeroNode {
    public int no;//英雄排名
    public String name;//姓名
    public String nickname;//昵称
    public HeroNode next;//指向下一个节点的指针

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    @Override
    public String toString() {
        // 不打印 next，只打印该节点的data信息
        return  "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}