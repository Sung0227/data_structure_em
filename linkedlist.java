package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node {
		private Object data;
		private Node next;
		public Node(Objectt input) {
			this.data = input;
			this.next = null;	
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	/*package list.linkedlist.implementation;
	
	public class Main {
		public static void main(String[] args) {
		Linkedlist numbers = new LinkedList();
		numbers.addFirst(30);
		}
	}*/
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		//head 값이 newNode 를 가르킨다
		head = newNode;
		// size 를 하나 증가(노드 한 개 생성을 했으니)
		size++;
		// head 다음 값이 존재 하지 않으면 tail 값이 head값과 같아진다.
		if (head.next == null) {
			tail = head;
		}
	}
	/*numbers.addLast(10);
	numbers.addLast(20);
	numbers.addLast(30);*/
	public void addLast(Object input) {
		Node newNode = new Node(input);
		//data 존재 하지 않을 경우 addfirst로 값을 생성
		if (size = 0) {
			addFirst(input);
		}
		//값이 생성되었기 때문에 tail 함수로 다음 노드를 지정할 수 있다. 
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	public Node node(int index) {
		Node x = head;
		//head 다음으로 몇 번째 노드를 출력하고 싶은지에 따라 출력값 달라짐
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	//numbers.add(1, 15);
	public void add(int k, Object input) {
		if (k == 0) {
			addFIrst(input);
		}
		else {
			//추가하려는 노드 이전값을 저장
			Node temp1 = node(k - 1);
			//추가노드에 이전 노드.next 지정
			Node temp2 = temp1.next;
			//새로운 노드 생성
			Node nexNode = new node(input);
			//이전 노드.next를 새로운 노드에 연결
			temp1.next = newNode;
			//새로운 노드.next를 그 다음에 있는 기존노드에 연결
			newNode.next = temp2;
			//방 크기 1 증가
			size++;
			//새로운 노드 다음에 아무것도 없으면 그 값이 마지막 값 = tail 
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}
}
