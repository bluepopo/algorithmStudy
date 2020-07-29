package zy.code.stack;



/**
 * 基于数组栈的计算器
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "10*10-1";
        ArrayStack numStack = new ArrayStack(30);
        ArrayStack oprStack = new ArrayStack(30);
        //定义相关变量
        int index = 0;//用于扫描字符串表达式
        char ch =' ';//保存每次扫描的元素
        int num1 = 0;
        int num2 = 0;
        int opr = 0;
        int result = 0;
        String keepNum = "";
        //循环遍历表达式字符串
        for (index = 0; index < expression.length(); index++){
             ch = expression.charAt(index);
             if (oprStack.isOpr(ch)){
                 //是操作符
                 if (!oprStack.isEmpty()){
                     //符号栈不为空

                     // 一直比较优先级，直到当前符号大于栈顶
                     //43+  42* 45-

                     while (!oprStack.isEmpty() && oprStack.priority(ch) <= oprStack.priority(oprStack.peekTop()) ){
                         //弹出当前栈顶符号一个
                          opr = oprStack.pop();
                         //弹出数字站两个
                          num1 = numStack.pop();
                          num2 = numStack.pop();
                          //计算
                         result = oprStack.calculate(num1, num2, opr);
                         //结果压入数字栈
                         numStack.push(result);

                     }
                         //直到当前符号优先级大时，将当前符号压栈
                         oprStack.push(ch);




                 }else{
                     //符号栈为空，直接压栈
                     oprStack.push(ch);

                 }

             }else{
                 //不是操作符，是数字(注意：ch是char 类型)

                // numStack.push(ch - 48);// 0的ASCII码是48
                 //多位数问题
                keepNum += ch;

                if (index == expression.length() - 1){
                    numStack.push(ch - 48);// 0的ASCII码是48

                }else{
                    if (!oprStack.isOpr(expression.charAt(index+1))){
                        // 如果下一位还是数字
                        keepNum += expression.charAt(index+1);
                        int i = Integer.parseInt(keepNum);
                        //多位数入栈
                        numStack.push(i);
                        //清空keepNum
                        keepNum = "";
                        //多位数压栈后，扫描索引必须移位
                        index++;

                    }else{
                        //如果下一位是操作符
                        int j = Integer.parseInt(keepNum);
                        numStack.push(j);
                        keepNum = "";
                    }

                }




             }

        }

        //表达式扫描完毕，对两个栈中的元素进行操作
        while (!oprStack.isEmpty()){
            opr = oprStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();
            result = oprStack.calculate(num1, num2, opr);
            numStack.push(result);

        }
        // 数字栈最后只剩一个最终结果
        System.out.printf("表达式：%s = %d\n",expression,numStack.pop());



    }



}
