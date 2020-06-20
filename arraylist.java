while(it.hasNext()) {
int value = (int)it.next();
if(value == 30) {
it.remove();
}
system.out.println(value);

system.out.println('\nfor each");
for(int value : numbers) {
	system.out.println(value);
}

system.out.println("\nfor");
for(int i=0; i<numbers.size(), i++) {
	system.out.println(numbers.get(i));

}

// insert 인덱스 특정위치에 추가하는 방법
public class Main {
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1, 15);  // 인덱스 1에 15라는 값을 입력
		numbers.addFirst(5); // 첫번째 인덱스에 값 입력
		
		//elementData[4] = elementData[3]; --> 자리값을 옮기는 일차원적 방법
	}
}

// arraylist 객체 생성 방법
public class ArrayList {
	private int size = 0;  //현재값에 몇 개가 추가되어 있는지 
	private Object[] elementData = new Object[100];
	
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
				
		return true;
	}

	// array list 에 값을 하나 입력
	public boolean add(int index, Object element) {
	// 맨 뒤에 있는 인덱스를 새로운 인덱스에 값을 넣고
	//그 뒤에 있는 놈을 그 다음칸으로 이동
		for (int i = size - 1; i >= index; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	public boolean addFirst(Object element){
		return add(0, element);  
		// 첫번째 인덱스에 값을 넣음과 동시에 뒤에 있는 
		// 모든 값들을 뒤로 한 칸씩 민다.
	}
	
	//toString 메소드로 사용자가 읽기 쉽게 구현(출력)
	public String toString() {
		String str = "[";
		for(int i=0; i < size; i++) {
			str += elementData[i];
			if(i < size-1) {
				str += ",";
			}
		}
		return str + "]";
	}

	public void remove(int index) {
		Object removed = elementData[index];
		for(int i = index+1; i <= size-1; i++){
			elementData[i - 1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
	}

	//첫번째 엘레먼트만 삭제
	public Object removefirst(){
		return remove(0);
	}
	//마지막 엘레먼트 삭제
	public Object removelast(){
		return remove(size-1);
	}

	//system.out.println(numbers.get(1));
	//array list가진 장점: 빠른 시간안에 특정 데이터를 가져올 수 있음
	//elementData라는 배열을 통해 특정값을 찾음
	public Object get(int index){
		return elementData[index];
	}

	public int size() {
		return size;
	}

	public int indexOf(Object o) {
		//i = 0부터 size 까지 검색
		for(int i = 0; i < size; i++) {
			//같은 값을 찾으면 그 값을 출력
			if(o.equals(elementData[i])){
			return i;
			}
		}
		//같은 값을 찾지 못하면 null값 출력
		return -1;
	}

	/* for(int i=0; i<numbers.size(); i++) {
		system.out.println(numbers.get(i));
	}
	이거 대신 iterator 를 사용권장(반복구문에 적용)
	*/
	// ArrayList.ListIterator li = numbers.listIterator();
	//while(li.hasNext()){   //li 다음으로 오는 인덱스 값이 있을 경우= hasNext 가 true 일 경우
	//	system.out.println(li.next());
	//}
	public ListIterator listIterator(){
		return new ListIterator();
	}

	class ListIterator{
		private int nextIndex = 0;

		// 다음 엘레먼트를 출력하는 함수
		public boolean hasNext() {
			return nextIndex < size();
		}
		public Object next(){
			/*Object returnData = elementData[nextIndex];
			nextIndex++;
			return returnData; */
			//위에 있는 주석 코드랑 같은 의미
			return elementData[nextIndex++];
		}

		public Object previous(){
			return elementData[--nextIndex];
		}

		//while(li.hasPrevious()){   //li 이전으로 오는 인덱스 값이 있을 경우= hasPrevious 가 true 일 경우
		//	system.out.println(li.previous());
		//}
		public boolean hasPrevious(){
			return nextIndex > 0;
		}

		/* ArrayList.ListIterator li = numbers.listIterator();
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.add(35);
			}
			system.out.println(numbers);
		}
		*/
		public void add(Object element){
			ArrayList.this.add(nextIndex++, element);
		}

		//remove 
		public void remove();{
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
