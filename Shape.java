
import java.util.Random;
import java.util.Scanner;

public class Shape {
    public static int[] starLocation = new int[16];
    public static String[][] mat;

    public Shape() {
    }

    //this methode make my shape by random numbers and rotate the shape for the first time
    public void shape(String[][] boardshape, int[] starLocation) {
        Random rand = new Random();
        int x = rand.nextInt(7) + 1;

        String[][] mat = new String[x][x];
        int n = 0;
        int i = rand.nextInt(x);
        int j = rand.nextInt(x);
        mat[i][j] = "*";
        starLocation[n++] = i;
        starLocation[n++] = j;
        for (int l = 0; l < x - 1; l++) {


            if (i + 1 != x && mat[i + 1][j] != "*") {
                mat[i + 1][j] = "*";
                starLocation[n++] = i + 1;
                starLocation[n++] = j;
            } else if (i - 1 != -1 && mat[i - 1][j] != "*") {
                mat[i - 1][j] = "*";
                starLocation[n++] = i - 1;
                starLocation[n++] = j;
            } else if (j + 1 != x && mat[i][j + 1] != "*") {
                mat[i][j + 1] = "*";
                starLocation[n++] = i;
                starLocation[n++] = j + 1;

            } else if (j - 1 != -1 && mat[i][j - 1] != "*") {
                mat[i][j - 1] = "*";
                starLocation[n++] = i;
                starLocation[n++] = j - 1;
            } else if (j - 2 != -1 && j - 2 != -2 && mat[i][j - 2] != "*") {
                mat[i][j - 2] = "*";
                starLocation[n++] = i;
                starLocation[n++] = j - 2;
            } else if (j + 2 != x && j + 2 != x + 1 && mat[i][j + 2] != "*") {
                mat[i][j + 2] = "*";
                starLocation[n++] = i;
                starLocation[n++] = j + 2;
            } else if (i - 2 != -1 && i + -2 != -2 && mat[i - 2][j] != "*") {
                mat[i - 2][j] = "*";
                starLocation[n++] = i - 2;
                starLocation[n++] = j;
            } else if (i + 2 != x && i + 2 != x + 1 && mat[i + 2][j] != "*") {
                mat[i + 2][j] = "*";
                starLocation[n++] = i + 2;
                starLocation[n++] = j;
            }
        }
        starLocation[n++] = 18;

        for (int k = 0; k < x; k++) {
            for (int l = 0; l < x; l++) {
                if (mat[k][l] != "*")
                    mat[k][l] = " ";
                System.out.print(mat[k][l]);
            }
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        int numOfRotations = 0;
        String st = scanner.next();
        for (int l = 0; l < st.length(); l++) {
            if (st.charAt(l) == 'w' || st.charAt(l) == 'W')
                numOfRotations++;

        }
        numOfRotations = numOfRotations + 3;
        for (int g = 0; g < numOfRotations; g++) {
            mat = rotateLeft(mat, n);
            for (int k = 0; k < n - 1; k = k + 2) {
                int s = starLocation[k + 1];
                starLocation[k + 1] = starLocation[k];
                starLocation[k] = mat.length - s - 1;
            }
        }

        for (int k = 1; k < x + 1; k++) {
            for (int l = 1; l < x + 1; l++) {
                boardshape[k][l] = mat[k - 1][l - 1];
            }

        }
        for (int k = 0; k < 2 * x; k++) {
            starLocation[k] = starLocation[k];

        }

        this.mat = mat;
    }


    //this methode rotate my shape for the first time
    public static String[][] rotateLeft(String[][] shape, int n) {
        String[][] rotatedShape = new String[shape[0].length][shape.length];
        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[0].length; ++j) {
                rotatedShape[shape[0].length - j - 1][i] = shape[i][j];
            }
        }

        return rotatedShape;
    }

}
