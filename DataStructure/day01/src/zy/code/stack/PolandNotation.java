package zy.code.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式的计算器
 */
public class PolandNotation {

    public static void main(String[] args) {

     String infixExpression = "1+((2+3)*4)-11+20*300";
        List<String> infixList = infixStringToList(infixExpression);
        System.out.println("前缀表达式" + infixList);

        List<String> sufixList = infixToSuffixList(infixList);
        System.out.println("后缀表达式" + sufixList);

        int calResult = calculate(sufixList);
        System.out.println("逆波兰计算器计算结果为 ：" + calResult);//6010

    }

    /**
     * 中缀表达式转后缀表达式
     */
    public static List<String> infixToSuffixList(List<String> infixList){
        // 初始化两个栈，一个处理操作符号栈，一个中间栈
        Stack<String> stack = new Stack<String>();
        List<String> sufList = new ArrayList<>();//中间栈可以用列表代替
        // 遍历中缀表达式
        for (String str : infixList){
            //如果是数字，直接输出
            if (str.matches("\\d+")){
                sufList.add(str);
            }else{
             //如果是操作符号
                if (stack.isEmpty() || str.equals("(")){
                    //栈空或者是左括号
                    stack.push(str);
                }else{
                    //找不空，其他符号

                    if (str.equals(")")){
                        //如果是右括号
                        while ( !(stack.peek().equals("("))){
                            //遍历弹出括号之间的符号
                            String pop_str = stack.pop();
                            sufList.add(pop_str);
                        }
                        stack.pop();//弹出左括号

                    }else{
                        //不是右括号，比较优先级
                        while (!stack.isEmpty() && !(stack.peek().equals("(")) && Operation.getPriority(str) <= Operation.getPriority(stack.peek())){
                           sufList.add(stack.pop());
                        }
                        stack.push(str);

                    }
                }

            }

        }

        //遍历完表达式后，将符号栈剩余的字符出栈，并输出到中间栈
        while (!stack.isEmpty()){
           sufList.add( stack.pop());
        }


        return sufList;
    }


    /**
     * 中缀表达式字符串转换成 List
     */
    public static List<String> infixStringToList(String infixExpression){
        List<String> list = new ArrayList<String>();
        int i = 0;//遍历字符串的索引
        char ch = ' ';//获取字符串的每一个字符
        String str = "";//拼接对位数字符

        // 遍历表达式
        while ( i < infixExpression.length() ){
            ch = infixExpression.charAt(i);

            if (ch < 48 || ch > 57){
                // 是个操作符号
                list.add("" + ch);
                i++;
            }else{
                //是个数字
                while (i < infixExpression.length() && infixExpression.charAt(i) >= 48 && infixExpression.charAt(i) <= 57){
                    //多位数判断：有下一个，且下一个还是数字
                    str += infixExpression.charAt(i);
                    i++;
                }
                list.add(str);
                str = "";//清空多位数拼接字符串，以便于下次拼接使用


            }
        }

    return list;

    }


    /**
     * 以空格分割字符串转 List
     */
    public static List<String> stringToList(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String str:split){
            list.add(str);
        }
        return list;
    }
    /**
     * 后缀表达式的计算
     */
    public static  int calculate(List<String> list){
        int result = 0;
        Stack<String> stack = new Stack<String>();
        for (String str :list){
            // 正则表达式，如果该字符串匹配的是多位整数
            if (str.matches("\\d+")){
                //数字压栈
                stack.push(str);
            }else{
                // 字符串匹配操作符号
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (str){
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        break;
                }
                // 将计算结果入栈
                stack.push("" + result);
            }
        }
        // 将栈中的最后数字就是计算结果
        return Integer.parseInt(stack.pop());

    }


}
