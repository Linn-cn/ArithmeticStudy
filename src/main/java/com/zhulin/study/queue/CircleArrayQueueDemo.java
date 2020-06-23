package com.zhulin.study.queue;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname CircleArrayQueueDemo
 * @description
 * @create 2020-02-23 11:23
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 说明设置4,其队列的有效数据最大是3
        EnhanceCircleArrayQueue<Integer> queue = new EnhanceCircleArrayQueue<>(4);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        System.out.println("取出队头数据:" + queue.getQueue());
        queue.addQueue(4);
        System.out.println("取出队头数据:" + queue.getQueue());
        queue.addQueue(5);
        System.out.println("查看队头数据:" + queue.headQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println("-----------------");
        queue.showQueue();
//        System.out.println(4/5);
    }

}

/**
 * 使用数组模拟队列-编写一个ArrayQueue的类
 */
class CircleArrayQueue<E> {
    private int maxSize;    // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;      // 队列头
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear;       // 队列尾
    private Object[] elementData;      // 该数组用于存放数据,模拟队列

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize
     */
    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.elementData = new Object[maxSize];
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列
     *
     * @param element
     */
    public void addQueue(E element) {
        // 判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        // 直接将数据加入
        elementData[rear] = element;
        // 让rear后移，这里应该考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     *
     * @return
     */
    public E getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        E o = (E) elementData[front];
        elementData[front] = null;
        front = (front + 1) % maxSize;
        return o;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        for (int i = front, size = size(); i < front + size; i++) {
            System.out.println(i % maxSize + ":" + (E) elementData[i % maxSize]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     */
    public E headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        return (E) elementData[front];
    }

    public int size() {
        // rear = 1、front = 0、maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }
}


/**
 * 使用数组模拟队列-编写一个ArrayQueue的类
 */
class EnhanceCircleArrayQueue<E> {
    private int maxSize;    // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;      // 队列头
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear;       // 队列尾
    private int useFulData; // 有效数据
    private Object[] elementData;      // 该数组用于存放数据,模拟队列

    /**
     * 创建队列的构造器
     *
     * @param arrMaxSize
     */
    public EnhanceCircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.elementData = new Object[maxSize];
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列
     *
     * @param element
     */
    public void addQueue(E element) {
        // 判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        // 直接将数据加入
        elementData[rear] = element;
        // 让rear后移，这里应该考虑取模
        rear = (rear + 1) % maxSize;
        // 有效数据 + 1
        useFulData++;
    }

    /**
     * 获取队列的数据，出队列
     *
     * @return
     */
    public E getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        E o = (E) elementData[front];
        elementData[front] = null;
        front = (front + 1) % maxSize;
        // 有效数据 - 1
        useFulData--;
        return o;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        for (int i = front; i < front + useFulData; i++) {
            System.out.println(i % maxSize + ":" + (E) elementData[i % maxSize]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     */
    public E headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        return (E) elementData[front];
    }

    public int size() {
        return useFulData;
    }
}
