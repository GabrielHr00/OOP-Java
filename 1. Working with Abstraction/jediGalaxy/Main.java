package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = dimentions[0];
        int y = dimentions[1];

        int[][] matrix = readMatrix(x, y);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] ivoCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilPowerCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilX = evilPowerCoordinates[0];
            int evilY = evilPowerCoordinates[1];

            checkAndRefactorMatrix(matrix, evilX, evilY);

            int ivoX = ivoCoordinates[0];
            int ivoY = ivoCoordinates[1];

            sum = getSum(matrix, sum, ivoX, ivoY);

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static void checkAndRefactorMatrix(int[][] matrix, int evilX, int evilY) {
        while (evilX >= 0 && evilY >= 0) {
            if (evilX >= 0 && evilX < matrix.length && evilY >= 0 && evilY < matrix[0].length) {
                matrix[evilX][evilY] = 0;
            }
            evilX--;
            evilY--;
        }
    }

    private static long getSum(int[][] matrix, long sum, int ivoX, int ivoY) {
        while (ivoX >= 0 && ivoY < matrix[1].length) {
            if (ivoX >= 0 && ivoX < matrix.length && ivoY >= 0 && ivoY < matrix[0].length) {
                sum += matrix[ivoX][ivoY];
            }

            ivoY++;
            ivoX--;
        }
        return sum;
    }

    private static int[][] readMatrix(int x, int y) {
        int[][] matrix = new int[x][y];
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
