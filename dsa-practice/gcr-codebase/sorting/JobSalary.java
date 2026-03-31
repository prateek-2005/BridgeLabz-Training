import java.util.*;
public class JobSalary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Employees: ");
		int n=sc.nextInt();
		int []salary=new int[n];
		System.out.println("Enter Salary Of Each Employee: ");
		for(int i=0;i<n;i++) {
			salary[i]=sc.nextInt();
		}
		heapSort(salary,n);
		for(int i=0;i<n;i++) {
			System.out.print(salary[i]+" ");
		}
		sc.close();
	}
	public static void heapSort(int []salary,int n) {
		for(int i=n/2-1;i>=0;i--) {
			heapify(salary,n,i);
		}
		for (int i = n - 1; i > 0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;
            heapify(salary, i, 0);
        }
	}
	public static void heapify(int[] salary, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && salary[l] > salary[largest]) {
        	largest = l;
        }
        if (r < n && salary[r] > salary[largest]) {
        	largest = r;
        } 
        if (largest != i) {
            int temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;
            heapify(salary, n, largest);
        }
    }
}
