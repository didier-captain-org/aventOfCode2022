import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8_part1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day8_input.txt");
        Scanner sc = new Scanner(file);

        int[][] forest = new int[99][99];

        int lineIndex =0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] split = line.split("");
            for(int i=0;i< split.length;i++){
                forest[lineIndex][i] = Integer.parseInt(split[i]);
            }
            lineIndex++;
        }


        int treeVisibleOntheEdge = 4*(forest.length-1);
        int treeVisibleInInterior = treeVisibleInInterior(forest);

        System.out.println(treeVisibleOntheEdge+treeVisibleInInterior);


    }

    public static int treeVisibleInInterior(int[][] forest){
        int nbTreeVisible=0;
        for(int line=1;line< forest.length-1;line++){
            for(int column=1;column< forest[0].length-1;column++){
                if(isTreeVisibleFromTop(forest, line, column)
                || isTreeVisibleFromBottom(forest, line, column)
                || isTreeVisibleFromLeft(forest, line, column)
                ||isTreeVisibleFromRight(forest, line, column)
                ){
                    nbTreeVisible++;
                }
            }
        }
        return nbTreeVisible;
    }

    private static boolean isTreeVisibleFromTop(int[][] forest, int line, int column) {
        boolean res = true;
        for(int i=0;i<line;i++){
            res = res & forest[i][column]<forest[line][column];
        }
        return res;
    }

    private static boolean isTreeVisibleFromBottom(int[][] forest, int line, int column) {
        boolean res = true;
        for(int i=forest.length-1;i>line;i--){
            res = res & forest[i][column]<forest[line][column];
        }
        return res;
    }

    private static boolean isTreeVisibleFromLeft(int[][] forest, int line, int column) {
        boolean res = true;
        for(int i=0;i<column;i++){
            res = res & forest[line][i]<forest[line][column];
        }
        return res;
    }

    private static boolean isTreeVisibleFromRight(int[][] forest, int line, int column) {
        boolean res = true;
        for(int i=forest[0].length-1;i>column;i--){
            res = res & forest[line][i]<forest[line][column];
        }
        return res;
    }

}