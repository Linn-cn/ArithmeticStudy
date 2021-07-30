package com.zhulin.study.queue;

/**
 * 设计一个可以容纳 k 个元素的循环队列。需要实现以下接口：
 * <pre>
 *   class MyCircularQueue {
 *     // 参数k表示这个循环队列最多只能容纳k个元素
 *     public MyCircularQueue(int k);
 *     // 将value放到队列中, 成功返回true
 *     public boolean enQueue(int value);
 *     // 删除队首元素，成功返回true
 *     public boolean deQueue();
 *     // 得到队首元素，如果为空，返回-1
 *     public int Front();
 *     // 得到队尾元素，如果队列为空，返回-1
 *     public int Rear();
 *     // 看一下循环队列是否为空
 *     public boolean isEmpty();
 *     // 看一下循环队列是否已放满k个元素
 *     public boolean isFull();
 * }
 * </pre>
 *
 * @author Zhu Lin
 * @date 2021/7/29
 */
public class CircularQueue {

  // 用来已经使用的元素个数，区别空队列和满队列
  private int used = 0;

  // 头指针
  private int front = 0;

  // 尾指针，注意开闭原则[front,rear)
  private int rear = 0;

  // 队列容量
  private int capacity;

  // 存放元素的数组
  private Integer[] elementData;

  // 参数k表示这个循环队列最多只能容纳k个元素
  public CircularQueue(int k) {
    this.capacity = k;
    this.elementData = new Integer[capacity];
  }

  // 将value放到队列中, 成功返回true
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    elementData[rear] = value;
    rear = (rear + 1) % capacity;
    used++;
    return true;
  }

  // 删除队首元素，成功返回true
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    elementData[front] = null;
    front = (front + 1) % capacity;
    used--;
    return true;
  }

  // 得到队首元素，如果为空，返回-1
  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return elementData[front];
  }

  // 得到队尾元素，如果队列为空，返回-1
  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    int tail = (rear - 1 + capacity);
    return elementData[tail];
  }

  // 看一下循环队列是否为空
  public boolean isEmpty() {
    return used == 0;
  }

  // 看一下循环队列是否已放满k个元素
  public boolean isFull() {
    return used == capacity;
  }
}
