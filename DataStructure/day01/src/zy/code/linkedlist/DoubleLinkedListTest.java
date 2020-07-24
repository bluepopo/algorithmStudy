package zy.code.linkedlist;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 双向链表的测试
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleHeroNode heroNode2_1 = new DoubleHeroNode(1,"宋江","及时雨");
        DoubleHeroNode heroNode2_2 = new DoubleHeroNode(2,"卢俊义","玉麒麟");
        DoubleHeroNode heroNode2_3 = new DoubleHeroNode(4,"林冲","豹子头");
        DoubleHeroNode heroNode2_4 = new DoubleHeroNode(3,"吴用","智多星");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(heroNode2_1);
        doubleLinkedList.addByOrder(heroNode2_2);
        doubleLinkedList.addByOrder(heroNode2_3);
        doubleLinkedList.addByOrder(heroNode2_4);

        doubleLinkedList.list();

        DoubleHeroNode heroNode2_5 = new DoubleHeroNode(5,"武松","行者");
        doubleLinkedList.add(heroNode2_5);
        DoubleHeroNode heroNode2_33 = new DoubleHeroNode(4,"冲冲","豹子头");
        doubleLinkedList.update(heroNode2_33);

        System.out.println("修改之后的链表为：");
        doubleLinkedList.list();

        doubleLinkedList.delete(2);
        System.out.println("删除之后的链表为：");
        doubleLinkedList.list();
    }
}
