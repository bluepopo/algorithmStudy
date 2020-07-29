package zy.code.hashtable;

/**
 * 链表结点
 * emp代表员工信息
 */
public class Emp {
    public int id;
    public  String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
