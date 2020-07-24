package zy.code.stack;

/**
 * 数组模拟栈
 */
public class ArrayStack {
    int maxSize;    //最大容量
    int[] stack;    //栈数组存放数据
    int top = -1;   //栈顶的索引

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 判断栈满
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }
    /**
     * 判断栈空
     */
        public boolean isEmpty(){
        return top == - 1;
    }

    /**
     * 入栈
     */
    public void push(int val){
        if (isFull()){
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = val;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (isEmpty()){
           throw new RuntimeException("栈空，没有数据");
        }
        int val = stack[top];
        top--;
        return val;

    }

    /**
     * 遍历(从栈顶到栈底)
     */
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }


    /**
     * 查看栈顶元素
     */
    public int peekTop(){
        return stack[top];
    }

    /**
     * 返回优先级
     * @param opr
     * @return
     */
    public int priority(int opr){
        if (opr == '*' || opr == '/'){
            return 1;
        }else if(opr == '+' || opr == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是否为操作符
     */
    public boolean isOpr(char opr){
        if (opr == '*' || opr == '/' || opr == '+' || opr == '-' ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 计算
     */
    public int calculate(int num1,int num2,int opr){
        //num1 表示第一个出栈数字， num2 表示第二个出栈数字
        int result = 0;
      switch (opr){
          case '*':
              result  = num1 * num2;
              break;
          case '/':
              result  = num2 / num1;
              break;
          case '+':
              result  = num1 + num2;
              break;
          case '-':
              result  = num2 - num1;
              break;

      }
        return result;
    }
}
