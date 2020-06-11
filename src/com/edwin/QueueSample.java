package com.edwin;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueSample {
    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.add(2);
        queue.offer(3);

        System.out.println("queue = " + queue);
        // peek方法返回头部元素，如果空返回null，不抛异常
        System.out.println("queue.peek() = " + queue.peek());

        // 元素出队列，从头开始删除，先进先出，记住这个就行。
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());

        // 元素入队列，添加再尾部。
        queue.offer(4);
        System.out.println("queue = " + queue);
        System.out.println("queue.remove() = " + queue.remove());

    }
}
