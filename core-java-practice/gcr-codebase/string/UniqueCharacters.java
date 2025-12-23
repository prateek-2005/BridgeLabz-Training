import java.util.*;
public class UniqueCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Str = sc.nextLine();

		int length = find(Str);
		char[] ch = new char[length];
		int index = 0;

		for (int i = 0; i < length; i++) {
			char currchar = Str.charAt(i);
			boolean check = true;

			for (int j = 0; j < index; j++) {
				if (ch[j] == currchar) {
					check = false;
					break;
				}
			}
			if (check) {
				ch[index] = currchar;
				index++;
			}
		}

		System.out.println("Unique Characters in a String are: ");
		for (int i = 0; i < index; i++) {  
			System.out.print(ch[i] + " ");
		}

		sc.close();
	}

	public static int find(String Str) {
		int count = 0;
		try {
			while (true) {
				Str.charAt(count);
				count++;
			}
		} catch (Exception e) {
		}
		return count;
	}
}
