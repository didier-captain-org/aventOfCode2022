import java.io.*;
import java.util.Scanner;

public class Day10_part2 {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day10_input.txt");
        Scanner sc = new Scanner(file);

        int cycle = 1;
        int xValue = 1;
        StringBuilder crt = new StringBuilder();


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String instructionName = split[0];
            int instructionValue = split.length == 1 ? 0 : Integer.parseInt(split[1]);

            if (instructionName.equals("noop")) {
                cycle++;
                draw(crt, xValue);
            } else {
                cycle += 2;
                draw(crt, xValue);
                draw(crt, xValue);
                xValue += instructionValue;
            }


        }
    }


    static void draw(StringBuilder crt, int xValue){

        int size = crt.length();

        if(xValue-1 == size || xValue == size || xValue+1 == size){
            crt.append("#");
        }else{
            crt.append(" ");
        }


        if(crt.length()%40==0){

            String crtS = crt.toString();
            System.out.println(crtS);
            crt.delete(0,crt.length());
        }


    }


}