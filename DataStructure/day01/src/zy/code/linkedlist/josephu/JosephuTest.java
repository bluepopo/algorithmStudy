package zy.code.linkedlist.josephu;

/**
 * 约瑟夫环问题，丢手帕问题
 * 测测试
 */
public class JosephuTest {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(5);
        circleSingleLinkedList.show();
        System.out.println("游戏开始");
        circleSingleLinkedList.playjosephu(5,1,2);//2--4--1--5--3
    }
}
