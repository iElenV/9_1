import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк матрицы 1: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы 1: ");
        int columns = scanner.nextInt();
        Main main = new Main();
        int[][] matrix1 = main.CreateMatrix(rows, columns);
        main.PrintMatrix(matrix1);

        System.out.print("Введите количество строк матрицы 2: ");
        int rows2 = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы 2: ");
        int columns2 = scanner.nextInt();
        int[][] matrix2 = main.CreateMatrix(rows2, columns2);
        main.PrintMatrix(matrix2);

        System.out.println("Единичная матрица:");
        int[][] IdentityMatrix = main.CreateIdentityMatrix(4);
        main.PrintMatrix(IdentityMatrix);

        System.out.println("Нулевая матрица:");
        int[][] NullMatrix = main.CreateNullMatrix(4, 5);
        main.PrintMatrix(NullMatrix);

        System.out.println("Сумма матриц 1 и 2:");
        int[][] SumMatrix = main.SumMatrix(matrix1, matrix2);
        main.PrintMatrix(SumMatrix);

        System.out.println("Разность матриц 1 и 2:");
        int[][] Diff_Matrix = main.DiffMatrix(matrix1, matrix2);
        main.PrintMatrix(Diff_Matrix);

        System.out.println("Cкаляр:");
        int[][] Scalar_Matrix = main.CreateScalar(3,5);
        main.PrintMatrix(Scalar_Matrix);

        System.out.println("Умножение матрицы на скаляр:");
        int[][] Mult_Sc_Matrix = main.Mult_Sc_Matrix(matrix1, Scalar_Matrix);
        main.PrintMatrix(Mult_Sc_Matrix);
    }

    public int[][] CreateMatrix(int rows, int сolumns) {
        int[][] matrix = new int[rows][сolumns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < сolumns; j++) {
                matrix[i][j] = random.nextInt(1, 10);
            }
        }
        return matrix;
    }

    public void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public int[][] CreateIdentityMatrix(int number_rows_columns) {
        int[][] matrix = new int[number_rows_columns][number_rows_columns];
        for (int i = 0; i < number_rows_columns; i++) {
            for (int j = 0; j < number_rows_columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    public int[][] CreateNullMatrix(int rows, int сolumns) {
        int[][] matrix = new int[rows][сolumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < сolumns; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public int[][] SumMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] Sum_Matrix = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Размер матриц не равен. Невозможно выполнить сложение матриц");
        } else {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    Sum_Matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

        }
        return Sum_Matrix; }

    public int[][] DiffMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] Diff_Matrix = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Размер матриц не равен. Невозмжн выполнить вычитание матриц");
        } else {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    Diff_Matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

        }
        return Diff_Matrix; }


    public int[][] Mult_Sc_Matrix(int[][] matrix1, int [][] Scalar) {
        int[][] Mult_Sc_Matrix = new int[matrix1.length][matrix1[0].length];
        if (matrix1.length != Scalar[0].length) {
            System.out.println("Количество строк матрицы 1 не равно количеству строк скалярной матрицы. Умножение невозможно");
        } else {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                     Mult_Sc_Matrix[i][j] = matrix1[i][j] * Scalar[0][0];
                }
            }
        }


        return Mult_Sc_Matrix; }

    public int[][] CreateScalar(int number_rows_columns, int number) {
        int[][] Scalar_matrix = new int[number_rows_columns][number_rows_columns];
               for (int i = 0; i < number_rows_columns; i++) {
            for (int j = 0; j < number_rows_columns; j++) {
                if (i == j) {
                    Scalar_matrix[i][j] = number;
                }
            }
        }
        return Scalar_matrix;
    }



}