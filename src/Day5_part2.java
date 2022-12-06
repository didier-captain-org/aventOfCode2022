import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5_part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day5_input.txt");
        Scanner sc = new Scanner(file);

        int skipLine=10;
        Stack<String>[] cargo = new Stack[9];

/*
        cargo[0] = new Stack<String> () ;
        cargo[0].addAll(Arrays.asList("Z","N"));
        cargo[1] = new Stack<String> () ;
        cargo[1].addAll(Arrays.asList("M","C","D"));
        cargo[2] = new Stack<String> () ;
        cargo[2].addAll(Arrays.asList("P"));
*/

        cargo[0] = new Stack<String> () ;
        cargo[0].addAll(Arrays.asList("R","N","F","V","L","J","S","M"));
        cargo[1] = new Stack<String> () ;
        cargo[1].addAll(Arrays.asList("P","N","D","Z","F","J","W","H"));
        cargo[2] = new Stack<String> () ;
        cargo[2].addAll(Arrays.asList("W","R","C","D","G"));
        cargo[3] = new Stack<String> () ;
        cargo[3].addAll(Arrays.asList("N","B","S"));
        cargo[4] = new Stack<String> () ;
        cargo[4].addAll(Arrays.asList("M","Z","W","P","C","B","F","N"));
        cargo[5] = new Stack<String> () ;
        cargo[5].addAll(Arrays.asList("P","R","M","W"));
        cargo[6] = new Stack<String> () ;
        cargo[6].addAll(Arrays.asList("R","T","N","G","L","S","W"));
        cargo[7] = new Stack<String> () ;
        cargo[7].addAll(Arrays.asList("Q","T","H","F","N","B","V"));
        cargo[8] = new Stack<String> () ;
        cargo[8].addAll(Arrays.asList("L","M","H","Z","N","F"));

        print(cargo);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(skipLine!=0){
                skipLine--;
                continue;
            }else{
                Pattern p = Pattern.compile("move (.*) from (.*) to (.*)");
                Matcher m = p.matcher(line);
                boolean b = m.matches();
                //System.out.println(m.group(1));
                //System.out.println(m.group(2));
                //System.out.println(m.group(2));

                int nbCreate = Integer.parseInt(m.group(1));
                int columnStart = Integer.parseInt(m.group(2));
                int columnTarget = Integer.parseInt(m.group(3));

                Stack<String> tmp = new Stack<>();
                for(int i=0;i<nbCreate;i++){
                    tmp.push(cargo[columnStart-1].pop());
                }
                for(int i=0;i<nbCreate;i++){
                    cargo[columnTarget-1].push(tmp.pop());
                }

            }
            System.out.println("-----------------------------------------------------");
            System.out.println(line);
            print(cargo);
        }

        System.out.println("---------------------res--------------------------------");
        for (int i = 0; i < cargo.length; i++) {
            System.out.print(cargo[i].pop());

        }

    }

    public static void print(Stack<String>[] cargo){

        String[][] array = new String[cargo.length][100];

        for (int i = 0; i < cargo.length; i++) {
            List<String> pile = new ArrayList<>(cargo[i]);
            array[i][0] = ""+(i+1);
            for( int j=0;j<pile.size();j++){
                array[i][j+1] = pile.get(j);
            }
        }

        for( int j=array[0].length-1;j>-1;j--){
            List<String> values = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                String test = array[i][j]==null?" ":array[i][j];
                values.add(test);
            }
            String finalView = String.join(" ", values);
            if(!finalView.replace(" ","").isEmpty()){
                System.out.println(finalView);
            }

        }

    }


}
