package com.Heap;

import java.util.ArrayList;
public class HeapDS<T extends Comparable<T>>
{
    private ArrayList<T> list;

    public HeapDS(){
        list = new ArrayList<>();
    }
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return (index * 2) +1;
    }
    private int right(int index){
        return (index * 2) +2;
    }
    public void insert(T value){
        list.add(value);
        upheap(list.size()-1);
    }
    private void upheap(int index){
        if(index ==0){
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upheap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception(("Removing from an empty heap!"));
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            dowheap(0);
        }
        return temp;
    }
    private void dowheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left))>0){
            min =left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right))>0){
            min =right;
        }
        if(min != index){
            swap(min, index);
            dowheap(min);
        }
    }
    public static void main(String[] args) {
        try {
            // Create a new instance of HeapDS for Integer type
            HeapDS<Integer> minHeap = new HeapDS<>();

            // Insert elements into the heap
            System.out.println("Inserting elements into the heap:");
            int[] elementsToInsert = {10, 20, 5, 6, 1, 8};
            for (int element : elementsToInsert) {
                minHeap.insert(element);
                System.out.println("Inserted: " + element);
            }

            // Display the current state of the heap
            System.out.println("\nCurrent Heap: " + minHeap);

            // Remove elements from the heap
            System.out.println("\nRemoving elements from the heap:");
            while (true) {
                try {
                    Integer removedElement = minHeap.remove();
                    System.out.println("Removed: " + removedElement);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break; // Exit loop when heap is empty
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
