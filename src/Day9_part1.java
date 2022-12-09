import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9_part1 {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\programmes\\workspace\\aventOfCode2022\\src\\Day9_input.txt");
        Scanner sc = new Scanner(file);

        boolean[][] board = new boolean[1002][1002];

        int[] head = new int[]{501,501};
        int[] tail = new int[]{501, 501};
        board[501][501] = true;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String direction = split[0];
            int nbCase = Integer.parseInt(split[1]);

            for (int i = 0; i < nbCase; i++) {
                if (direction.equals("U")) {
                    head[0] = head[0] - 1;
                }
                if (direction.equals("D")) {
                    head[0] = head[0] + 1;
                }
                if (direction.equals("L")) {
                    head[1] = head[1] - 1;
                }
                if (direction.equals("R")) {
                    head[1] = head[1] + 1;
                }
                tailFollow(head, tail);
                board[tail[0]][tail[1]] = true;
                //print(board, head, tail);
            }
        }
        int score = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    score++;
                }
            }
        }
        System.out.println(score);
    }

    private static void print(boolean[][] board, int[] head, int[] tail) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == head[0] && j == head[1]) {
                    System.out.print("H ");
                } else if (i == tail[0] && j == tail[1]) {
                    System.out.print("T ");
                } else if (board[i][j]) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
        System.out.println("---------------------------------------");
    }

    private static void tailFollow(int[] head, int[] tail) {
        int diffh = head[0] - tail[0];
        int diffv = head[1] - tail[1];


        if (diffh > 1 && diffv > 0) {
            tail[0] = tail[0] + 1;
            tail[1] = tail[1] + 1;
        } else if (diffh > 1 && diffv < 0) {
            tail[0] = tail[0] + 1;
            tail[1] = tail[1] - 1;
        } else if (diffh < -1 && diffv > 0) {
            tail[0] = tail[0] - 1;
            tail[1] = tail[1] + 1;
        } else if (diffh < -1 && diffv < 0) {
            tail[0] = tail[0] - 1;
            tail[1] = tail[1] - 1;
        } else if (diffv > 1 && diffh > 0) {
            tail[0] = tail[0] + 1;
            tail[1] = tail[1] + 1;
        } else if (diffv > 1 && diffh < 0) {
            tail[0] = tail[0] - 1;
            tail[1] = tail[1] + 1;
        } else if (diffv < -1 && diffh > 0) {
            tail[0] = tail[0] + 1;
            tail[1] = tail[1] - 1;
        } else if (diffv < -1 && diffh < 0) {
            tail[0] = tail[0] - 1;
            tail[1] = tail[1] - 1;
        } else if (diffh > 1) {
            tail[0] = tail[0] + 1;
        } else if (diffh < -1) {
            tail[0] = tail[0] - 1;
        } else if (diffv > 1) {
            tail[1] = tail[1] + 1;
        } else if (diffv < -1) {
            tail[1] = tail[1] - 1;
        }

    }


}