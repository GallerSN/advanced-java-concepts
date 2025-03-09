package comparableInterface;

public class MySelectionSort {
	public static <E extends Comparable<E>> void selectionSort(E[] arr) {
		int smallest = 0;
		int i;
		int j;
		for ( i =0; i < arr.length - 1; i++) {
			smallest = i;
			for(j = i+1; j < arr.length; j++){
				int result = arr[j].compareTo(arr[smallest]);
				if(result < 0)
					smallest = j;
			}
			E temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
	}
}
