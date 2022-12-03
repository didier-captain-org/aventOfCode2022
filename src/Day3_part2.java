import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3_part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\adventOfCode2022\\src\\Day3_input.txt");
        Scanner sc = new Scanner(file);

        int score = 0;



        while(sc.hasNextLine()){

            String backpack1 = sc.nextLine();
            String backpack2 = sc.nextLine();
            String backpack3 = sc.nextLine();

            //Set<Character> letters1 = compartiment1.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
            //Set<Character> letters2 = compartiment2.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
            Set<Integer> letters1 = backpack1.chars().mapToObj(Day3_part2::priority).collect(Collectors.toSet());
            Set<Integer> letters2 = backpack2.chars().mapToObj(Day3_part2::priority).collect(Collectors.toSet());
            Set<Integer> letters3 = backpack3.chars().mapToObj(Day3_part2::priority).collect(Collectors.toSet());

            Set<Integer> compare12 = compare(letters1,letters2);
            Set<Integer> compare13 = compare(letters1,letters3);
            Set<Integer> compare23 = compare(letters2,letters3);

            Set<Integer> compare1213 = compare(compare12,compare13);
            Set<Integer> compareALL = compare(compare1213,compare23);

            if(compare1213.size()==1){
                score+=compareALL.toArray(new Integer[1])[0];
            }else{
                System.out.println(letters1);
                System.out.println(letters2);
                System.out.println(letters3);
                System.out.println(compare12);
                System.out.println(compare13);
                System.out.println(compare23);
                System.out.println(compare1213);
                System.out.println(compareALL);
                System.exit(666);
            }

        }
        System.out.println(score);


    }

    public static Set<Integer> compare(Set<Integer> set1,Set<Integer> set2){
        Set<Integer> compare12 = new HashSet<>(set1);
        compare12.retainAll(set2);
        return compare12;
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
