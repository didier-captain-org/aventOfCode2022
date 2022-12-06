import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class Day6_part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day6_input.txt");
        Scanner sc = new Scanner(file);

        int i = 0;

        Queue<Character> fourteenDigit = new ArrayDeque<>();


        //while(sc.hasNextLine()){
            String input = sc.nextLine();
        //}

        while(i<input.length()){

            fourteenDigit.add(input.charAt(i));

            if(i>13){
                fourteenDigit.poll();
            }

            if(new HashSet<>(fourteenDigit).size()==14 ){
                System.out.println(fourteenDigit);
                System.out.println(i+1);
                break;
            }else{
                i++;
            }




        }

    }

}
