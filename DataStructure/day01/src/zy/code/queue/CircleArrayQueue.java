package zy.code.queue;


/**
 * 数组实现循环队列
 */
public class CircleArrayQueue {

    private int maxSize;//最大容量为数组大小
    private int front;//队首指向第一个元素，初始值为0
    private int rear;//队尾指向最后一个元素的下一个位置，初始值为0
    private int[] arr;//存储队列元素

    /**
     * 队列初始化
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     * 判断是否已满
     */
    public boolean isFull(){
        if ((rear + 1) % maxSize == front) {
            return true;
        }
        return false;
    }

    /**
     * 判空
     */
    public boolean isEmpty(){
        if (this.front == this.rear){
            return true;
        }
        return false;
    }

    /**
     * 添加数据
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能添加数据。");
            return;
        }

        arr[rear] = n;//添加元素
        rear = (rear + 1) % maxSize;//指针后移
    }

    /**
     * 取数据
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据。");
        }
        // 先把队头元素保存在一个临时变量
        // 然后对头指针后移
        // 返回临时变量
        int temp = arr[front];
        front = (front + 1 ) % maxSize;
        return temp;
    }

    /**
     * 显示队列数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，没有数据可以显示。");
        }

        //怎么遍历数组？
        int count = size();
        for (int i = front; i < front + count; i++){
            //从队头开始遍历，真正的下标可能会超出数组大小，必须转换为循环后的真正下标
            int index = i % maxSize;
            int val = arr[index];
            System.out.printf("arr[%d] = %d\n",index,val);
        }

    }


    /**
     * 取出队列有效元素的个数
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }


    /**
     * 查看第一个元素
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据。");
        }
        return arr[front];
    }

}

