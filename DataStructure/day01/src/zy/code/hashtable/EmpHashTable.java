package zy.code.hashtable;

import com.sun.glass.ui.Size;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * 哈希表结构
 */
public class EmpHashTable {
    private EmpLinkedList[] empLinkedListArray;//存放多条链表的数组结构
    private int size;

    public EmpHashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];//初始化哈希表的大小，即管理多少条链表
        for (int i = 0; i < size; i++){
            EmpLinkedList empLinkedList = new EmpLinkedList();
            empLinkedListArray[i] = empLinkedList;
        }
    }

    /**
     * 散列函数
     */
    public int hashFun(int id){
        return id % size;
    }
    /**
     * 添加员工
     */
    public void add(Emp emp){
        int linkedListIndex = hashFun(emp.id);
        empLinkedListArray[linkedListIndex].add(emp);

    }

    /**
     * 遍历哈希表
     */
    public void list(){
        for (int i = 0; i < empLinkedListArray.length;i++){
            System.out.print(i + "号：");
            empLinkedListArray[i].list();
            System.out.println();
        }
    }

    /**
     * 根据id查找
     */
    public void findById(int id){
        int index = hashFun(id);
        Emp emp = empLinkedListArray[index].findById(id);
        if (emp != null){
            System.out.printf("在 %d 号链表找到\t",index);
            System.out.printf("emp[id=%d,name=%s] \n",emp.id,emp.name);
        }else{
            System.out.println("没有找到该员工");
        }
    }


}
