import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day6_input.txt");
        Scanner sc = new Scanner(file);

        int i = 0;

        Queue<Character> fourDigit = new ArrayDeque<>();


        //while(sc.hasNextLine()){
            String input = sc.nextLine();
        //}

        while(i<input.length()){

            fourDigit.add(input.charAt(i));

            if(i>3){
                fourDigit.poll();
            }

            if(new HashSet<>(fourDigit).size()==4 ){
                System.out.println(fourDigit);
                System.out.println(i+1);
                break;
            }else{
                i++;
            }




        }

    }

}
