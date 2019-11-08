public class BinaryHeap{
private int [] arr;
private int size;

public BinaryHeap()
{
	arr = new int [10];
	size = 0;
}

public void add(int toadd) {
	if (size == arr.length){
		resize();
	}

	arr[size] = toadd;
	size++;

	int index = size - 1;
	int current = (index - 1)/2;

	while (index > 0 && arr[index] < arr[current]){
		swap(index, current, arr);
		index = current;
		current = (index - 1)/2;
	}
}

public void resize(){
	int [] temp = new int [arr.length * 2];
	for (int i = 0; i < arr.length; i++){
		temp[i] = arr[i];
	}
	arr = temp;
}


private void shift(int current){
	int child = current * 2 + 1;
	if (child >= size){
		return;
	}
	if (arr[child + 1] < arr[child]){
	    child++;
	}
	if (arr[current] > arr[child]){
		swap(child, current, arr);
		shift(child);
	}
}


public int remove(){
	int temp = arr[0];
	arr[0] = arr[size - 1];
	size--;
	shift(0);
	return temp;
	}




public void swap(int a, int b, int [] array){
	int temp = array[a];
	array[a] = array[b];
	array[b] = temp;
}
}