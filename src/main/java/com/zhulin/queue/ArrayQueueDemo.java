package com.zhulin.queue;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname ArrayQueueDemo
 * @description
 * @create 2020-02-21 11:56
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(4);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        System.out.println(queue.getQueue());
        System.out.println(queue.headQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.headQueue());
        System.out.println("-----------------");
        queue.showQueue();
    }
}

/**
 * 使用数组模拟队列-编写一个ArrayQueue的类
 */
class ArrayQueue<E>{
    private int maxSize;    // 表示数组的最大容量
    private int front;      // 队列头
    private int rear;       // 队列尾
    private Object[] elementData;      // 该数组用于存放数据,模拟队列

    /**
     * 创建队列的构造器
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.elementData = new Object[maxSize];
        front = -1; // 指向队列头部，指向队列头的前一个位置
        rear = -1;  // 指向队列尾部
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 添加数据到队列
     * @param element
     */
    public void addQueue(E element){
        // 判断队列是否已满
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        rear++; //让rear后移
        elementData[rear] = element;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public E getQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++;
        E o = (E) elementData[front];
        elementData[front] = null;
        return o;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        for (Object elementDatum : elementData) {
            System.out.println(elementDatum);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     */
    public E headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        return (E)elementData[front+1];
    }
}
