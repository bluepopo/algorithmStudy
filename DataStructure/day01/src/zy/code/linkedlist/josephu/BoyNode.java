package zy.code.linkedlist.josephu;

/**
 * 以丢手帕问题为例
 * 一个小朋友就是一个结点
 */
public class BoyNode {

    public int no;// 编号
    public BoyNode next; // 指向下一个节点,默认null

    public BoyNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BoyNode[" +
                "no=" + no +
                ']';
    }
}
