import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\adventOfCode2022\\src\\Day1_input.txt");
        int maxValue = Integer.MIN_VALUE;
        int elfValue = 0;


        try(Scanner sc = new Scanner(file)){

            while(sc.hasNextLine()){

                String value = sc.nextLine();
                if(value.length()==0){
                    // new elf
                    if(elfValue>maxValue){
                        maxValue=elfValue;
                    }
                    elfValue = 0;

                }else{
                    elfValue = elfValue + Integer.parseInt(value);
                }


            }
            System.out.println(maxValue);
        }

    }

}
