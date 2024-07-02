public class DoublyLinkedList {
    private Node head;
    private Node tail;
    static int size=0;

    public DoublyLinkedList(){
        this.size=0;
    }

    static class Node{
      private int value;
      private Node next;
      private Node prev;

      public Node(int value) {  //constructor of the node class fires everytime a new node (object of node) is create
        this.value = value;
        next = null;
        prev=null;
       }
    }

    //insert at begining 
    public static DoublyLinkedList insert(DoublyLinkedList list, int value) {
        Node new_node = new Node(value); //create new node
        if(list.head == null){
            list.head = new_node;
            list.tail = new_node;
        }
        else{
            list.head.prev= new_node;
            new_node.next= list.head;
            new_node.prev= null;
            list.head= new_node;
        }
        size++;
        return list;
    }

    //print linked list
    public static void printLinkedList(DoublyLinkedList list){
        Node currNode = list.head; 
    
        System.out.print("LinkedList: "); 
    
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.value + " "); 
    
            // Go to next node 
            currNode = currNode.next; 
        } 
        System.out.println("Size of the list is : "+size);
     }

     //display in reverse
     public static void printReverseList(DoublyLinkedList list){
        Node last = list.head;
        while(list.tail !=null){
            last=last.next;
        }
     }
     public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        list.insert(list, 2);
        list.printLinkedList(list);
        list.insert(list, 1);
        list.printLinkedList(list);
     }
}
