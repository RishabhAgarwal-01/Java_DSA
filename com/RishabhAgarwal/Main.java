package com.RishabhAgarwal;
public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(99);
//        list.insert(100, 3);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
//        list.insertRec(88, 2);
//        list.display();

//        DoublyLinkedList list = new DoublyLinkedList();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(99);
//        list.insert(8, 65);
//
//        list.display();

        LinkedListRecursion list2= new LinkedListRecursion();
        list2.insertRec(3,0);
        list2.printLinkedList();
        list2.insertRec(2,1);
        list2.insertRec(8,2);
        list2.insertRec(17,3);
        list2.insertRec(99,4);
        list2.insertRec(8, 3);
        list2.printLinkedList();

//        CLL list = new CLL();
//        list.insert(23);
//        list.insert(3);
//        list.insert(19);
//        list.insert(75);
//        list.display();
//        list.delete(19);
//        list.display();
    }
}
