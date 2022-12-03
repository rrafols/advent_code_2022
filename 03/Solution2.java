import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        try {
            sc = new Scanner(new File("i.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }


        ArrayList<String> lines = new ArrayList<>();
        while(sc.hasNextLine()) lines.add(sc.nextLine());

        int priority = 0;
        for (int i = 0; i < lines.size(); i += 3) {
            char common = 0;
            boolean found = false;
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < 3 && !found; j++) {
                HashSet<Character> lc = new HashSet<>();
                for (char ch : lines.get(i + j).toCharArray()) lc.add(ch);

                for (char ch : lc) {
                    if (map.containsKey(ch)) {
                        int current = map.get(ch);
                        if (current == 2) {
                            found = true;
                            common = ch;
                        }
                        map.put(ch, current + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
            }

            if (common >= 'a' && common <= 'z') priority += common - 'a' + 1;
            if (common >= 'A' && common <= 'Z') priority += common - 'A' + 27;
        }
        
        System.out.println(priority);
    }
}