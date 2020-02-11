import java.util.*;
public class LinkedList {
  
    Node head;
    
    class Node
    {
      int data;
      Node next;
    }
    
    public void insert(int data)
    {
      Node node=new Node();
      node.data=data;
      node.next=null;
      
      if(head==null)
          head=node;
      else
      {
          Node n=head;
          while(n.next!=null)
          {
            n=n.next;
          }
          
          n.next=node;
      }  
    }
    
    public void insertAtStart(int data)
    {
        Node node= new Node();
        node.data=data;
        node.next=null;
        node.next=head;
        head=node;
    }
    
    public void insertAt(int index,int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index==0)
		{
			insertAtStart(data);
		}
		else{
		Node n = head;
		for(int i=0;i<index-1;i++)
		{
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
		}
	}
	
    public void show()
    {
      Node node=head;
      while(node!=null)
      {
        System.out.print(node.data+" ");
        node=node.next;
      }
      System.out.println();
    }
    
    public void showMid()
    {
        Node sp=head;
        Node fp=head;
        
        if(head!=null)
        {
            while(fp!=null && fp.next!=null)
            {
                fp=fp.next.next;
                sp=sp.next;
            }
            System.out.println(sp.data);
        }
    }
    
    public void showNthLast(int index) //nth From Last
    {
        Node node=head;
        int length=0;
        while(node!=null)
        {
            node=node.next;
            length++;
        }
        if(length<index)
            return;
        
        node=head;
        
        for(int i=0;i<length-index;i++)
            node=node.next;
            
        System.out.println(node.data);
    }
    
    
    public void showNth(int index) //nth 
    {
        Node node=head;
       
        for(int i=1;i<index;i++)
            node=node.next;
            
        System.out.println(node.data);
    }
    int detectLoop() 
	{ 
		Node sp=head;
		Node fp=head;
		
		for(;sp!=null && fp!=null && fp.next.next!=null;)
		{
		    sp=sp.next;
		    fp=fp.next.next;
		    if(sp==fp)
		    {
		        System.out.println("Loop Hai");
		        return 1;
		    }
		}
		return 0;
	} 
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.insert(5);
        l.insert(10);
        l.insert(15);
        l.insert(20);
        l.insert(25);
        
        l.insertAtStart(30);
        l.show();
        
        l.insertAt(1,35);
        l.show();
        
        l.showMid();
        l.show();
        l.showNthLast(3);
        
        l.showNth(5);
        
        LinkedList l1=new LinkedList();
        l1.insertAtStart(100);
        l1.insertAtStart(200);
        l1.insertAtStart(300);
        l1.insertAtStart(400);
        l1.insertAtStart(500);
        
        l1.head.next.next.next.next = l1.head; 
        l1.detectLoop();
    }
}
