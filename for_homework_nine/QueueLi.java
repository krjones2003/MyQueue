package for_homework_nine;

import java.util.*;

public class QueueLi<AnyType> {
	
	//constructor:
	public QueueLi() {
		beginMarker = new Node<>(null, null);
		backOfLine = new Node<>(null, null);
	}
	
	//empty method
	public boolean empty(){
		return beginMarker.next == null;
	}//running time is constant because there is only one action performed
	
	public AnyType enqueue(AnyType x) {
		if(empty()){
			Node<AnyType> t = new Node(x, null);
			beginMarker.next = t;
			backOfLine.next = t;
		} else if (!empty()) {
			Node<AnyType> p = new Node(x, null);
			backOfLine.next.next = p;
			backOfLine.next = p;		
		}
		return x;
	}//running time is constant because there are no for or while loops and the method adds directly to the end
	//using the backOfLine pointer
		
	
	public AnyType getFront(){
		if(!empty()){            
		return beginMarker.next.data;	
		} else {
			return null;
		}
	}//running time is constant because retrieving the front of the line is one action
	
	public AnyType dequeue() {
		if(!empty()){
			AnyType current = beginMarker.next.data;
			beginMarker.next = beginMarker.next.next;
			return current;
		}else{
			throw new EmptyStackException();
		}
	}//running time is constant because only two steps dequeue every possible item
	
	//methods; enqueue, getFront, dequeue, empty (plus any others)
	
	private static class Node<AnyType>{
		
		public Node(AnyType x, Node<AnyType> p) {
			data = x;
			next = p;
		}
		
		public AnyType data;
		public Node<AnyType> next;
	}
	
	private Node<AnyType> beginMarker;
	private Node<AnyType> backOfLine;
	
	public static void main(String[] args) {
		QueueLi<Integer> s = new QueueLi<>();
		for (int i = 0; i < 5; i++) {
			s.enqueue(i);
		}

		System.out.println("Queueing 0 through 4.  That means the front of the list should be 0, and the back should be 4.");
		System.out.println("The front of the queue is: " + s.getFront());
		s.dequeue();
		System.out.println("After one dequeue, the front of the queue is: " + s.getFront());
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.enqueue(7);
		s.dequeue();
		System.out.println("After dequeueing three times, enqueuing 7, and dequeueing again, the front of the queue is now: " + s.getFront());
		s.dequeue();
		System.out.println("After dequeueing again, the front of the line is: " + s.getFront());
		s.enqueue(10);
		System.out.println("After enqueueing 10 once, the front of the line is: " + s.getFront());
		
	}

}
