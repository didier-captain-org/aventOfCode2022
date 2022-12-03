import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2_part2 {

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
        if(str2.equals("Y")){
            score+=3;
        }else if(str2.equals("Z") ){
            score+=6;
        }else{
            score+=0;
        }

        /* ce que tu as joue */
        if(Arrays.asList("AY","CZ","BX").contains(str1+str2)){
            score+=1;
        }else if (Arrays.asList("BY","AZ","CX").contains(str1+str2)){
            score+=2;
        }else{
            score+=3;
        }



        return score;

    }

}
