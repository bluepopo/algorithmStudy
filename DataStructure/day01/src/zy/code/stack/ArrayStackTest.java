package zy.code.stack;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("========================");
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            String key = sc.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个整数：");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case "pop":
                    int num = stack.pop();
                    System.out.printf("出栈的数字是：%d\n" , num);
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }


}
