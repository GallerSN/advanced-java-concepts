package comparableInterface;

public class ComparableMain {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Student[] arr = new Student[5];
		arr[4] = new Student("Sam", 3.61);
		arr[2] = new Student("Ashley", 3.82);
		arr[0] = new Student("John", 2.52);
		arr[3] = new Student("Jane", 4.0);
		arr[1] = new Student("Tyler", 3.24);
		
		System.out.println("Before sort:");
		for (int i = 0; i < 5; i++)
			System.out.println(arr[i]);
		
		System.out.println('\n' + "Sorting" + '\n');
		MySelectionSort.selectionSort(arr);
		
		System.out.println("After sort:");
		for (int i = 0; i < 5; i++)
			System.out.println(arr[i]);
	}
}
