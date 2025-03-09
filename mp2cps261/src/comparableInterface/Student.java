package comparableInterface;

@SuppressWarnings("rawtypes")
public class Student implements Comparable{
	private int studentID;
	private String name;
	private double gpa;
	private static int maxStudentID = 0;
	
	public Student(String n, double g) {
		setName(n);
		setGpa(g);
		
		maxStudentID++;
		setStudentID(maxStudentID);
	}
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public int compareTo(Object temp) {
		Student other = (Student) temp;
		
		if(this.studentID > other.getStudentID())
			return 1;
		else if(this.studentID < other.getStudentID())
			return -1;
		else
			return 0;
	}
	
//	public int compareTo(Object temp) {
//		Student other = (Student) temp;
//		
//		return this.name.compareToIgnoreCase(other.getName());
//	}


	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
}
