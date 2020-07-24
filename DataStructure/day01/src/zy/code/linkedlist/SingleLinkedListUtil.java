package zy.code.linkedlist;

import java.util.Stack;

/**
 * 面试题基础练习
 */
public class SingleLinkedListUtil {

    /**
     * 【新浪面试题】获取单链表的长度（不含头结点）
     */
    public static int getSize(HeroNode head){

        if (head.next == null){
            System.out.println("该单链表为空");
           return 0;
        }
        HeroNode temp = head.next;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    /**
     * 【新浪面试题】获取倒数第 k 个节点（不包含头结点在内）
     */
    public static HeroNode getLastIndexNode(HeroNode head,int k){

        if (head.next == null){
            System.out.println("该单链表为空");
            return null;
        }
        // 获取该链表的长度
        int size = SingleLinkedListUtil.getSize(head);
        HeroNode temp = head.next;
        // 从头顺序遍历 size - k 个
        for (int i = 0; i < size - k; i++){
            temp = temp.next;
        }
        return temp;

    }

    /**
     * 【腾讯面试题】反转单链表
     * 思路:
     * 1. 先定义一个节点 reverseHead = new HeroNode();
     * 2. 从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端.（前插法）
     * 3. 原来的链表的head.next = reverseHead.next
     */
    public static HeroNode reverse(HeroNode head){
        if (head.next == null || head.next.next == null){
            System.out.println("该单链表为空或只有一个结点");
            return head;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");

        while (cur != null){
            // 先保存cur的下一个节点
            next = cur.next;

            // 改变cur，采用前插法，插入反转链表
            cur.next = reverseHead.next;
            reverseHead.next = cur;

            // 原指针后移
           cur = next;

        }
        // 最后将原来的头指针替换为反转后链表的头指针
        head.next = reverseHead.next;
        return head;

    }

    /**
     * 【百度面试题】
     * 逆序打印单链表 【百度，要求方式 1：反向遍历 。 方式2：Stack栈】
     * 注意：
     *  1. 只需要逆序打印，无需改变原链表的结构
     *  2. 可以使用栈，顺序遍历结点并压栈，然后打印栈即可
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        //遍历栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }


    }

}
