package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        if(firstQueue.size() == 2 && secondQueue.size() == 2) {
            arrayDeque.addAll(firstQueue);
            arrayDeque.addAll(secondQueue);
        }
        else {
            arrayDeque.add(firstQueue.remove());
            arrayDeque.add(firstQueue.remove());
            arrayDeque.add(secondQueue.remove());
            arrayDeque.add(secondQueue.remove());
            while(!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
                firstQueue.add(arrayDeque.removeLast());
                arrayDeque.add(Objects.requireNonNull(firstQueue.poll()));
                arrayDeque.add(Objects.requireNonNull(firstQueue.poll()));
                secondQueue.add(arrayDeque.removeLast());
                arrayDeque.add(Objects.requireNonNull(secondQueue.poll()));
                arrayDeque.add(Objects.requireNonNull(secondQueue.poll()));
            }
        }
        return arrayDeque;
    }
}
