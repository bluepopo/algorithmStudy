package zy.code.hashtable;

import java.util.Scanner;

/**
 * 哈希表结构
 * 1. 可以方便的管理多条链表
 * 2. 根据 hash散列函数，计算添加对象应该加到哪一条链表当中去
 */
public class HashTableDemo {
    public static void main(String[] args) {
        EmpHashTable empHashTable = new EmpHashTable(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("================");
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    empHashTable.add(emp);
                    break;
                case "list":
                    empHashTable.list();
                    break;
            case "find":
                System.out.println("请输入要查找的id");
                id = scanner.nextInt();
                empHashTable.findById(id);
                break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
