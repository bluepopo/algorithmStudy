package zy.code.linkedlist;

/*
双向链表的数据结构
 */
public class DoubleLinkedList {

    DoubleHeroNode head = new DoubleHeroNode(0,"","");

    DoubleHeroNode getHead(){
        return head;
    }




    /**
     * 顺序遍历双向链表
     */
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空....");
            return;
        }
        // 使用辅助节点来遍历
      DoubleHeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     * 追加新的节点
     * 1. 不考虑排名问题时，只在单链表尾端进行追加
     * 2. 遍历单链表，让最后一个节点的next指向新节点
     */
    public void add(DoubleHeroNode heroNode){
        // 由于head头节点是固定的，不能指向其他节点，所以这里创建一个临时指针进行遍历
        DoubleHeroNode temp = this.head;
        while (temp.next != null){
            temp = temp.next;
        }
        // 遍历到结尾,追加
        temp.next = heroNode;
        heroNode.pre = temp;

    }
    /**
     * 更新结点
     */
    public void update(DoubleHeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空，不能更新....");
            return;
        }
        DoubleHeroNode temp = head.next;
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
     * 删除一个节点
     * 1. 遍历节点找到要删除的节点编号
     * 2. 待删除结点的 next、pre指针修改
     */
    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空，不能更新....");
            return;
        }
        DoubleHeroNode temp = head.next;

        boolean flag = false; //是否找到要删除的结点的标志
        while (temp != null){
            if(temp.no == no){
                flag = true;
                break;
            }
            // 指针后移
            temp = temp.next;
        }

        if (flag){
            // 找到匹配节点temp，执行删除操作
            if (temp.next == null){
                // 要删除的结点是最后一个
                temp.pre.next = temp.next;
            }else{
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.printf("删除失败，没有匹配  %d 号的节点\n",no);
        }

    }


    /**
     * 插入新节点
     * 1. 考虑节点排名顺序，默认从小到大排序，
     * 2. 插入的新节点依次与遍历节点比较，如果遍历节点比新节点大，在之前插入
     */
    public void addByOrder(DoubleHeroNode heroNode){
        DoubleHeroNode temp = head;
        boolean flag = false;//判断节点排名是否相等的标志
        while (temp.next != null && temp.next.no <= heroNode.no){
            if (temp.next.no == heroNode.no){
                flag = true;//已存在相同结点，不需要插入
                break;
            }
            //指针后移
            temp = temp.next;
        }

        if (!flag){
           //第一步：先连键
          heroNode.next = temp.next;
          heroNode.pre = temp;

          //第二步：断掉原来的键
         if (temp.next == null){
             //若temp是最后一个元素，在temp之后结尾插入
             temp.next = heroNode;
         }else{
             // 在中间插入的话，是在temp、temp.next 之间插入
             temp.next.pre = heroNode;
             temp.next = heroNode;
         }


        }else{
            System.out.println("链表种已存在相同结点，请不要重复插入");
        }

    }

}
