package zy.code.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0,"","");
    //返回头节点
    public HeroNode getHead() {
        return head;
    }


    /**
     * 删除一个节点
     * 1. 遍历节点找到要删除的节点编号
     * 2. 要得到待删除节点的前一个节点，让 fore.next ---> temp.next
     */
    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空，不能更新....");
            return;
        }
        HeroNode temp = head.next;
        HeroNode fore = head;//指向temp的前一个节点
        boolean flag = false; //是否找到要删除的结点的标志
        while (temp != null){
            if(temp.no == no){
                flag = true;
                break;
            }
            // 没有找到也没有到尾部，指针后移
            fore = temp;
            temp = temp.next;
        }

        if (flag){
            // 找到匹配节点temp，删除
            fore.next = temp.next;
        }else{
            System.out.printf("删除失败，没有匹配  %d 号的节点\n",no);
        }

    }


    /**
     * 更新结点
     */
    public void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空，不能更新....");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            //指针后移
            temp = temp.next;
        }

        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;

        }else{
            System.out.println("遍历完本单链表，未发现有可修改的匹配项....");
        }


    }


    /**
     * 插入新节点
     * 1. 考虑节点排名顺序，默认从小到大排序，
     * 2. 插入的新节点依次与遍历节点比较，如果遍历节点比新节点大，在之前插入
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;//判断节点排名是否相等的标志
        while (temp.next != null && temp.next.no <= heroNode.no){
            if (temp.next.no == heroNode.no){
                flag = true;
            }
            //指针后移
            temp = temp.next;
        }

        if (!flag){
            // 在temp之后、n之前插入。先连接尾部再连接前部
             heroNode.next = temp.next;
             temp.next = heroNode;

        }

    }


    /**
     * 追加新的节点
     * 1. 不考虑排名问题时，只在单链表尾端进行追加
     * 2. 遍历单链表，让最后一个节点的next指向新节点
     */
    public void add(HeroNode heroNode){
        // 由于head头节点是固定的，不能指向其他节点，所以这里创建一个临时指针进行遍历
        HeroNode temp = this.head;
        while (temp.next != null){
            temp = temp.next;
        }
        // 遍历到结尾,追加
        temp.next = heroNode;

    }

    /**
     * 显示单链表
     * 单向遍历
     */
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空....");
            return;
        }
        // 使用辅助节点来遍历
        HeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }

    }

}
