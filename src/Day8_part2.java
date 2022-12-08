import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8_part2 {

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

        int treeVisibleInInterior = treeVisibleInInterior(forest);

        System.out.println(treeVisibleInInterior);


    }

    public static int treeVisibleInInterior(int[][] forest){
        int scenicScoreMax=0;
        for(int line=1;line< forest.length-1;line++){
            for(int column=1;column< forest[0].length-1;column++){

                int a = treeVisibleFromTop(forest, line, column);
                int b = treeVisibleFromBottom(forest, line, column);
                int c = treeVisibleFromLeft(forest, line, column);
                int d = treeVisibleFromRight(forest, line, column);
                int scenicScore = a*b*c*d;

                if( scenicScore > scenicScoreMax){
                    scenicScoreMax = scenicScore;
                }
            }
        }
        return scenicScoreMax;
    }

    private static int treeVisibleFromTop(int[][] forest, int line, int column) {

        int res = 0;
        for(int i=line-1;i>-1;i--){
            // the tree forest[i][column] is it visible from forest[line][column]
            // ie all tree between them are smaller
            boolean allSmallest = true;
            for(int j = Math.min(i,line)+1; j<Math.max(i,line); j++){
                allSmallest = allSmallest
                        && forest[j][column]<forest[line][column]
                        //&& forest[j][column]<forest[i][column]
                ;
            }
            if(allSmallest){
                res++;
            }
        }
        return res;
    }

    private static int treeVisibleFromBottom(int[][] forest, int line, int column) {

        int res = 0;
        for(int i=line+1;i<forest.length;i++){
            // the tree forest[i][column] is it visible from forest[line][column]
            // ie all tree between them are smaller
            boolean allSmallest = true;
            for(int j = Math.min(i,line)+1; j<Math.max(i,line); j++){
                allSmallest = allSmallest
                        && forest[j][column]<forest[line][column]
                        //&& forest[j][column]<forest[i][column]
                ;
            }
            if(allSmallest){
                res++;
            }
        }
        return res;
    }


    private static int treeVisibleFromLeft(int[][] forest, int line, int column) {

        int res = 0;
        for(int i=column-1;i>-1;i--){
            // the tree forest[i][column] is it visible from forest[line][column]
            // ie all tree between them are smaller
            boolean allSmallest = true;
            for(int j = Math.min(i,column)+1; j<Math.max(i,column); j++){
                allSmallest = allSmallest
                        && forest[line][j]<forest[line][column]
                        //&& forest[line][j]<forest[line][i]
                ;
            }
            if(allSmallest){
                res++;
            }
        }
        return res;
    }

    private static int treeVisibleFromRight(int[][] forest, int line, int column) {

        int res = 0;
        for(int i=column+1;i<forest[0].length;i++){
            // the tree forest[i][column] is it visible from forest[line][column]
            // ie all tree between them are smaller
            boolean allSmallest = true;
            for(int j = Math.min(i,column)+1; j<Math.max(i,column); j++){
                allSmallest = allSmallest
                        && forest[line][j]<forest[line][column]
                        //&& forest[line][j]<forest[line][i]
                ;
            }
            if(allSmallest){
                res++;
            }
        }
        return res;
    }

}