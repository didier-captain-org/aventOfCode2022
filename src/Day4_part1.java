import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day4_input.txt");
        Scanner sc = new Scanner(file);

        int score = 0;



        while(sc.hasNextLine()){

            String[] inputs = sc.nextLine().split("[-,]");
            int startA = Integer.parseInt(inputs[0]);
            int endA = Integer.parseInt(inputs[1]);
            int startB = Integer.parseInt(inputs[2]);
            int endB = Integer.parseInt(inputs[3]);

            if(startA <= startB && endB <= endA){
                score++;
            }else if(startA >= startB && endB >= endA){
                score++;
            }


        }
        System.out.println(score);


    }

}
