import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\adventOfCode2022\\src\\Day1_input.txt");
        int firstValue = Integer.MIN_VALUE;
        int secondValue = Integer.MIN_VALUE;
        int thirdValue = Integer.MIN_VALUE;
        int elfValue = 0;


        try(Scanner sc = new Scanner(file)){

            while(sc.hasNextLine()){

                String value = sc.nextLine();
                if(value.length()==0){
                    // new elf
                    if(elfValue>firstValue){
                        thirdValue=secondValue;
                        secondValue=firstValue;
                        firstValue=elfValue;
                    }else
                    if(elfValue>secondValue){
                        thirdValue=secondValue;
                        secondValue=elfValue;
                    }else
                    if(elfValue>thirdValue){
                        thirdValue=elfValue;
                    }
                    elfValue = 0;

                }else{
                    elfValue = elfValue + Integer.parseInt(value);
                }


            }
            System.out.println(firstValue+" "+secondValue+" "+thirdValue);
            System.out.println(firstValue+secondValue+thirdValue);
        }

    }

}
