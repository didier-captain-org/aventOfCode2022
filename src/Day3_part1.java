import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\adventOfCode2022\\src\\Day3_input.txt");
        Scanner sc = new Scanner(file);

        int score = 0;



        while(sc.hasNextLine()){

            String backpack = sc.nextLine();
            String compartiment1 = backpack.substring(0,backpack.length()/2);
            String compartiment2 = backpack.substring(backpack.length()/2);

            //Set<Character> letters1 = compartiment1.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
            //Set<Character> letters2 = compartiment2.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
            Set<Integer> letters1 = compartiment1.chars().mapToObj(Day3_part1::priority).collect(Collectors.toSet());
            Set<Integer> letters2 = compartiment2.chars().mapToObj(Day3_part1::priority).collect(Collectors.toSet());

            letters1.retainAll(letters2);

            score+=letters1.toArray(new Integer[1])[0];


        }
        System.out.println(score);


    }


    public static int priority(int x){

        char c = (char) x;

        if(Character.isLowerCase(c)){
            return x-((int)'a')+1;
        }else{
            return x-((int)'A')+27;
        }

    }

}
