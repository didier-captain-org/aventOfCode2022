import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10_part1 {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day10_input.txt");
        Scanner sc = new Scanner(file);

        int cycle=1;
        long xValue=1;
        long signalStrength20=0L;
        long signalStrength60=0L;
        long signalStrength100=0L;
        long signalStrength140=0L;
        long signalStrength180=0L;
        long signalStrength220=0L;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String instructionName = split[0];
            int instructionValue = split.length==1?0:Integer.parseInt(split[1]);

            if(instructionName.equals("noop")){
                cycle++;
            }else{
                cycle+=2;
                xValue+=instructionValue;
            }

            if(cycle==19 || cycle==20){
                signalStrength20=20L*xValue;
            }
            if(cycle==59 || cycle==60){
                signalStrength60=60L*xValue;
            }
            if(cycle==99 || cycle==100){
                signalStrength100=100L*xValue;
            }
            if(cycle==139 || cycle==140){
                signalStrength140=140L*xValue;
            }
            if(cycle==179 || cycle==180){
                signalStrength180=180L*xValue;
            }

            if(cycle==219 || cycle==220){
                signalStrength220=220L*xValue;
            }

        }

        System.out.println(signalStrength20+" "+signalStrength60+" "+signalStrength100+" "+signalStrength140+" "+signalStrength180+" "+signalStrength220);
        System.out.println(signalStrength20+signalStrength60+signalStrength100+signalStrength140+signalStrength180+signalStrength220);
    }





}