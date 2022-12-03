import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\adventOfCode2022\\src\\Day2_input.txt");
        Scanner sc = new Scanner(file);

        int score = 0;



        while(sc.hasNextLine()){

            String[] values = sc.nextLine().split(" ");
            score+=score(values[0],values[1]);


        }
        System.out.println(score);


    }



    public static int score(String str1, String str2){

        int score=0;

        /* qui gagne */
        if(Arrays.asList("AX","BY","CZ").contains(str1+str2)){
            score+=3;
        }else if(Arrays.asList("AY","BZ","CX").contains(str1+str2) ){
            score+=6;
        }else{
            score+=0;
        }

        /* ce que tu as joue */
        if(str2.equals("X")){
            score+=1;
        }else if (str2.equals("Y")){
            score+=2;
        }else{
            score+=3;
        }



        return score;

    }

}
