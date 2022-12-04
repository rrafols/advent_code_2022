import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        try {
            sc = new Scanner(new File("i.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }


        int count1 = 0;
        int count2 = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] pair = line.split(",");
            int min0 = Integer.parseInt(pair[0].split("-")[0]);
            int max0 = Integer.parseInt(pair[0].split("-")[1]);
            int min1 = Integer.parseInt(pair[1].split("-")[0]);
            int max1 = Integer.parseInt(pair[1].split("-")[1]);

            if ((min1 >= min0 && max1 <= max0) || (min0 >= min1 && max0 <= max1)) {
                count1++;
            }

            if ((min1 >= min0 && min1 <= max0) || (min0 >= min1 && min0 <= max1)) {
                System.out.println(line);
                count2++;
            }
        }

        
        System.out.println(count1);
        System.out.println(count2);
    }
}