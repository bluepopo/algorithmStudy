package zy.code.linkedlist;

/**
 * 测试单链表
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        System.out.println("原来的单链表为：");
        singleLinkedList.list();


        /**
         * 反转链表测试
         */
//        HeroNode reverse = SingleLinkedListUtil.reverse(singleLinkedList.getHead());
//        HeroNode temp = reverse.next;
//
//        System.out.println("反转后的链表：");
//        while (temp != null){
//            System.out.println(temp);
//            temp = temp.next;
//        }

        /**
         * 逆序打印测试
         */
        System.out.println("测试栈的逆序打印");
        SingleLinkedListUtil.reversePrint(singleLinkedList.getHead());

    }
}
