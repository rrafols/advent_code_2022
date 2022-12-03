import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        try {
            sc = new Scanner(new File("i.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }


        int priority = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();

            HashSet<Character> map = new HashSet<>();
            for(int i = 0; i < line.length() / 2; i++) map.add(line.charAt(i));
            boolean found = false;
            for(int i = 0; i < line.length() / 2 && !found; i++) {
                char ch = line.charAt(i + line.length()/2);
                if (map.contains(ch)) {
                    found = true;
                    if (ch >= 'a' && ch <= 'z') priority += ch - 'a' + 1;
                    if (ch >= 'A' && ch <= 'Z') priority += ch - 'A' + 27;
                    // System.out.println(line +" :: " + ch);
                }
            }
        }
        System.out.println(priority);
    }
}