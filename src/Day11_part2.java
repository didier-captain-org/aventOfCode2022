import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11_part2 {

    static  Monkey2[] Monkey2s = new Monkey2[8];
    static Long modulo=1L;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day11_input.txt");
        Scanner sc = new Scanner(file);


        while (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            String line3 = sc.nextLine();
            String line4 = sc.nextLine();
            String line5 = sc.nextLine();
            String line6 = sc.nextLine();
            if(sc.hasNextLine()) {
                String blankLine = sc.nextLine();
            }
            Monkey2 m = new Monkey2();
            m.number = Integer.parseInt(regex(Pattern.compile("^Monkey ([0-9]*):$"),line1).group(1));
            Monkey2s[m.number] = m;

            String listItem = regex(Pattern.compile("^  Starting items:(.*)$"),line2).group(1);
            String[] listItem2 = listItem.replace(" ","").split(",");
            for(String i : listItem2){
                m.items.add(Long.parseLong(i));
            }

            Matcher operationMatcher = regex(Pattern.compile("^  Operation: new = (.*) ([*+]) (.*)$"),line3);
            m.operation = operation(operationMatcher);

            m.divideBy = Long.parseLong(regex(Pattern.compile("^  Test: divisible by ([0-9]*)$"),line4).group(1));
            modulo = modulo* m.divideBy;
            m.trueMonkey = Integer.parseInt(regex(Pattern.compile("^    If true: throw to monkey ([0-9]*)$"),line5).group(1));
            m.falseMonkey = Integer.parseInt(regex(Pattern.compile("^    If false: throw to monkey ([0-9]*)$"),line6).group(1));



        }


        for(int turn=1;turn <=10000 ;turn++){
            //System.out.println("turn "+turn);
            for(Monkey2 m : Monkey2s){
                //System.out.println(" Monkey2 "+m.number);
                while(!m.items.isEmpty()){
                    long worryLevel =m.items.poll();
                    //System.out.println("  Monkey2 inspects an item with a worry level of "+worryLevel);
                    long resOperation = m.operation.apply(worryLevel)%modulo;
                    //System.out.println("    Worry level is compute to "+resOperation);
                    //resOperation = resOperation/3;
                    //System.out.println("    Monkey2 gets bored with item. Worry level is divided by 3 to "+resOperation);
                    if(resOperation%m.divideBy==0){
                        //System.out.println("    Current worry level is divisible by "+m.divideBy);
                        //System.out.println("    Item with worry level "+resOperation+" is thrown to Monkey2 ."+m.trueMonkey2);
                        Monkey2s[m.trueMonkey].items.add(resOperation);
                    }else{
                        //System.out.println("    Current worry level is not divisible by "+m.divideBy);
                        //System.out.println("    Item with worry level "+resOperation+" is thrown to Monkey2 3."+m.falseMonkey2);
                        Monkey2s[m.falseMonkey].items.add(resOperation);
                    }
                    m.itemProcessCount = m.itemProcessCount+1;

                }


            }
        }

        long score = Arrays.stream(Monkey2s).map(m->(long)m.itemProcessCount).sorted(Comparator.reverseOrder()).limit(2).reduce(1L, (subtotal, element) -> subtotal * element);

        System.out.println(score);
    }


    static Function<Long,Long> operation(Matcher operationMatcher){

        return x->{

            long second = operationMatcher.group(3).equals("old")?x:Long.parseLong(operationMatcher.group(3));

            if(operationMatcher.group(2).equals("*")){
                return x*second;
            }else{
                return x+second;
            }

        };

    }

    static Matcher regex(Pattern p,String line){
        Matcher m = p.matcher(line);
        if(!m.matches()){
            throw new RuntimeException("Bad regex");
        }
        return m;
    }


}class Monkey2{

    int number;
    Queue<Long> items = new ArrayDeque<>();
    Function<Long,Long> operation;
    long divideBy;
    int trueMonkey;
    int falseMonkey;
    int itemProcessCount=0;


}