//main class of linkedlist
public class LinkedList {

    private Node head;  //head pointing to first element of the list
    private Node tail;  //tail pointing to the last element
    static int size;  //size of the linked list

    public LinkedList() {
        this.size=0;;
    }

       private class Node {  //Node structure static to allow Linked list to access it.
        private int value;
        private Node next;

        public Node(int value) {  //constructor of the node class fires everytime a new node (object of node) is create
            this.value = value;
            next = null;
            size++;
        }
    }
    //insert operation on the linked list
    public void insert(int value) {
        Node new_node = new Node(value); //create new node
        if(head ==null){
           head= new_node;
           tail= new_node;
        }
        else{
            Node last=head; 
            while(last.next !=null){  //Traverse to the last node
                last= last.next;
            }
            //Insert the new node at the last node 
            last.next = new_node;
            tail= new_node; //maintaining the tail pointer
        }
    }

    //insert at first position
    public void  insertFirst( int value){
        Node new_node= new Node(value);
        if(head != null){
            new_node.next=head;
            head=new_node;
        }
        else{
            head= new_node;
            tail= new_node;
        }
        
    }

    //insert at nth pos
    public void insertAt( int value, int pos){
        if(pos==0){
            insertFirst( value);
        }
        else if(pos == size){
            insertLast( value);
        }
        else{
            int i=1;
            Node new_node= new Node(value);
            Node before=head;
            Node after=before.next;
            while(i<=pos && before.next != null)
            {
                before=before.next;
                after= after.next;
                i++;
            }
            before.next=new_node;
            new_node.next=after;
        }
      
    }

    //insert at last position
    public void insertLast(int value){
        Node new_node= new Node(value);
        Node temp;
        if(tail != head){
            temp=tail;
            temp.next=new_node;
            new_node.next=null;
        }
        else{
            head= new_node;
           tail= new_node;
        }
        
    }

    //deleting first element
    public  int deleteFirst(LinkedList list){
        int val;
        val= list.head.value;
        if(list.head.next !=null){
            list.head= list.head.next;
        }
        else{
            list.head= null;
        }
        return val;
    }

    //delete lastElement
     public  int deleteLast(LinkedList list){
        int val;
        Node temp=list.head;
        while(temp != list.tail){
            temp=temp.next;
        }
        val=temp.next.value;
        temp.next=null;
        return val;
     }
     
     //delete at nth pos
     void deleteAt(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
             temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;
     }

    //print linked list
    public  void printLinkedList(){
        Node currNode = head; 
    
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
    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(10);
        list.insert(12);
        list.printLinkedList();
        list.insertFirst(90);
        list.printLinkedList();
        list.insertLast( 100);
        list.printLinkedList();
        list.insertAt(45, 2);
        list.printLinkedList();
        System.out.println(list.deleteFirst(list));
        list.printLinkedList();
        System.out.println(list.deleteLast(list));
        list.printLinkedList();
        list.deleteAt(3);
        list.printLinkedList();
}
}
