package zy.code.linkedlist.josephu;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
     * 单向环形链表
     */
    public class CircleSingleLinkedList {

        private   BoyNode first =null;

        public  BoyNode getFirst() {
            return first;
        }


    /**
     * 出圈游戏
     * nums : 总共人数
     * startNum ： 从几号开始
     * m ： 数到几（数几个）
     */
public void  playjosephu(int nums,int startNum,int m){
    //参数校验
    if (nums < 1 || startNum <0 || m > nums){
        System.out.println("参数设定有问题");
        return;
    }
    //创建辅助指针，该指针一直指向first的后一个，first向后移动始终指向报数者
    BoyNode helper = first;
    // 遍历到环的最后一个人,并让helper指向最后一个人
    while (helper.next != first){
        helper = helper.next;
    }
    //根据第一个报数的人，移动first、helper的默认位置
    //比如，第一个报数的是3号，指针还需要再往后移动2次
    for (int i = 0; i < startNum - 1; i++){
        first = first.next;
        helper = helper.next;
    }
    while (helper != first){

        //报数
        //从1数到m,为什么是数 m-1 次？因为从1到m，还需要循环m-1个人，指针才会指向那个“出圈者”
        for (int j = 0; j < m - 1; j++){
            first = first.next;
            helper = helper.next;
        }
        //出圈
        System.out.printf("%d 号出圈\n",first.no);
        first = first.next;
        helper.next = first;
    }

    //循环游戏结束后，最终会只剩下一个人
    System.out.printf("最后剩下的一个人的编号是：%d\n",first.no);

}


    /**
     * 添加多个结点
     */
    public void addBoys(int nums){
        if (nums < 1){
            System.out.println("nums 值不正确，至少添加1个小朋友");
            return;
        }
        // cur为辅助指针，向后移动遍历
        BoyNode cur = null;
        for (int i = 1; i <= nums; i++){
            // 创建小孩并编号
            BoyNode boy = new BoyNode(i);
            if (i == 1){
                //创建第一个结点时构建环形
                first = boy;
                boy.next = first;//一个人也可以形成一个环
                cur = first;
            }else{
                //添加的结点加入这个环
                cur.next = boy;
                boy.next = first;
                cur = boy;//cur 移动到新的节点上

            }

        }

    }

    /**
     * 遍历打印环形单链表
     * 1. 先让一个辅助指针(变量) curBoy，指向first节点
     * 2. 然后通过一个while循环遍历 该环形链表即可 curBoy.next  == first 结束
     */
    public void show(){
        // 判断
        if (first == null){
            System.out.println("环形单链表为空....");
            return;
        }
        BoyNode cur = first;
        while (true){
            System.out.printf("小孩编号：%d\n",cur.no);
            if (cur.next == first){
                break;
            }
            cur = cur.next;
        }

    }

}
