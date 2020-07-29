package zy.code.hashtable;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * 使用链表，模拟哈希表结构
 */
public class EmpLinkedList {
    private Emp head;

    public Emp getHead() {
        return head;
    }

    /**
     * 添加员工
     * 1。假定 id是自增长的，添加时默认在链表尾部追加
     *
     * @param emp
     */
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }

        //遍历到链表尾部
        Emp temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = emp;

    }

    /**
     * 遍历链表
     */
    public void list(){
        if (head == null){
            System.out.println("当前链表为空");
            return;
        }

        System.out.println("当前链表的信息如下：");
        Emp temp = head;
        while (temp != null){
            System.out.printf("emp[id=%d,name=%s] \t",temp.id,temp.name);
            temp = temp.next;
        }
    }

    /**
     * 查找
     */
    public Emp findById(int id){
        if (head == null){
            System.out.println("无法查找，因为当前链表为空");
            return null;
        }
        Emp temp = head;
        while (temp != null && temp.id != id){
            temp = temp.next;
        }
        if (temp == null){
            return null;
        }else{
            return temp;
        }


    }


}
