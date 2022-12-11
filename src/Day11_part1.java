import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11_part1 {

    static  Monkey[] monkeys = new Monkey[8];

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
            Monkey m = new Monkey();
            m.number = Integer.parseInt(regex(Pattern.compile("^Monkey ([0-9]*):$"),line1).group(1));
            monkeys[m.number] = m;

            String listItem = regex(Pattern.compile("^  Starting items:(.*)$"),line2).group(1);
            String[] listItem2 = listItem.replace(" ","").split(",");
            for(String i : listItem2){
                m.items.add(Integer.parseInt(i));
            }

            Matcher operationMatcher = regex(Pattern.compile("^  Operation: new = (.*) ([*+]) (.*)$"),line3);
            m.operation = operation(operationMatcher);

            m.divideBy = Integer.parseInt(regex(Pattern.compile("^  Test: divisible by ([0-9]*)$"),line4).group(1));
            m.trueMonkey = Integer.parseInt(regex(Pattern.compile("^    If true: throw to monkey ([0-9]*)$"),line5).group(1));
            m.falseMonkey = Integer.parseInt(regex(Pattern.compile("^    If false: throw to monkey ([0-9]*)$"),line6).group(1));



        }


        for(int turn=1;turn <=20;turn++){
            System.out.println("turn "+turn);
            for(Monkey m : monkeys){
                System.out.println(" Monkey "+m.number);
                while(!m.items.isEmpty()){
                    int worryLevel =m.items.poll();
                    System.out.println("  Monkey inspects an item with a worry level of "+worryLevel);
                    int resOperation = m.operation.apply(worryLevel);
                    System.out.println("    Worry level is compute to "+resOperation);
                    resOperation = resOperation/3;
                    System.out.println("    Monkey gets bored with item. Worry level is divided by 3 to "+resOperation);
                    if(resOperation%m.divideBy==0){
                        System.out.println("    Current worry level is divisible by "+m.divideBy);
                        System.out.println("    Item with worry level "+resOperation+" is thrown to monkey ."+m.trueMonkey);
                        monkeys[m.trueMonkey].items.add(resOperation);
                    }else{
                        System.out.println("    Current worry level is not divisible by "+m.divideBy);
                        System.out.println("    Item with worry level "+resOperation+" is thrown to monkey 3."+m.falseMonkey);
                        monkeys[m.falseMonkey].items.add(resOperation);
                    }
                    m.itemProcessCount = m.itemProcessCount+1;

                }


            }

        }

        int score = Arrays.stream(monkeys).map(m->m.itemProcessCount).sorted(Comparator.reverseOrder()).limit(2).reduce(1, (subtotal, element) -> subtotal * element);

        System.out.println(score);
    }


    static Function<Integer,Integer> operation(Matcher operationMatcher){

        return x->{

            int second = operationMatcher.group(3).equals("old")?x:Integer.parseInt(operationMatcher.group(3));

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


}class Monkey{

    int number;
    Queue<Integer> items = new ArrayDeque<>();
    Function<Integer,Integer> operation;
    int divideBy;
    int trueMonkey;
    int falseMonkey;
    int itemProcessCount=0;


}