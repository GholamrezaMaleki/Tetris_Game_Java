public class Screen {
    Shape shape = new Shape();
    private String star;
    private int width = 10;
    private int length = 20;
    private int score;

    private boolean bool;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private int counter;
    private int m;

    public Screen() {
        width = 10;
        length = 20;
        star = "*";
        score = 0;

        counter = 0;
        bool = true;
    }

    //this methode make the screen
    public void drawScreen() {
        if (counter == 0) {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0 || j == width - 1) {
                        boardshape[i][j] = star;
                    } else {
                        boardshape[i][j] = " ";
                    }
                }

            }
            for (int k = 0; k < width; k++) {
                boardshape[length - 1][k] = star;
            }

        }
        if (bool) {
            shape.shape(boardshape, starLocation);
            bool = false;
        }
        counter++;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {

                if ((i == 5 && j == 0) || (i == 5 && j == 9))
                    System.out.print("$");
                else
                    System.out.print(boardshape[i][j]);
            }

            System.out.println();
        }
    }

    public String[][] boardshape = new String[length][width];
    public int[] starLocation = new int[16];

    //this methode moves down the shape
    public void moveDown() {

        for (int i = 18; i >= 0; i--) {
            for (int j = 8; j >= 1; j--) {
                if (boardshape[i][j] == "*") {
                    boardshape[i][j] = " ";
                    boardshape[i + 1][j] = "*";
                }

            }
        }
        for (int i = 0; i < m; i = i + 2) {
            starLocation[i] = starLocation[i] + 1;
        }


    }

    //this methode moves the shape right and left and rotates it
    public void mover(char ch) {
        int n = 0;
        int s = 1;

        for (int i = 0; i < 16; i++) {
            if (starLocation[i] == 18) {
                m = i;
                break;
            }
        }
        switch (ch) {
            case 'd':
            case 'D':
            case 'ی':
                if (rightpermission(m) && rightpermission()) {
                    for (int i = 0; i < 19; i++) {
                        for (int j = 8; j >= 1; j--) {
                            if (boardshape[i][j] == "*") {
                                boardshape[i][j] = " ";
                                boardshape[i][j + 1] = "*";
                            }

                        }
                    }
                    for (int i = 1; i < m; i = i + 2) {
                        starLocation[i] = starLocation[i] + 1;
                    }
                }
                //yplayer++;
                break;
            case 'a':
            case 'A':
            case 'ش':
                if (leftpermission(m) && leftpermission()) {
                    for (int i = 0; i < 19; i++) {
                        for (int j = 1; j <= 8; j++) {
                            if (boardshape[i][j] == "*") {
                                boardshape[i][j] = " ";
                                boardshape[i][j - 1] = "*";
                            }

                        }
                    }
                    for (int i = 1; i < m; i = i + 2) {
                        starLocation[i] = starLocation[i] - 1;
                    }
                }
                break;
            case 'W':
            case 'w':
            case 'ص':

                try {
                    for (int i = 0; i < m; i = i + 2) {
                        boardshape[starLocation[i] + 1][starLocation[i + 1] + 1] = " ";
                    }
                } catch (Exception e) {

                }
                String ary[][] = new String[m / 2][m / 2];
                ary = rotateLeft(shape.mat);
                shape.mat = ary;
                String st = null;
                boolean finish = false;
                String boardtest[][] = new String[length][width];
                boardtest = boardshape;
                try {
                    for (int i = 0; i < m / 2; i++) {
                        for (int j = 0; j < m / 2; j++) {
                            st = boardshape[i + starLocation[0]][j + 2];
                            if (st == "#" || st == "*") {
                                finish = true;
                                boardshape = boardtest;
                                break;
                            }
                            boardshape[i + starLocation[0]][j + 2] = ary[i][j];

                        }
                        if (finish) {
                            break;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("you can't rotate your shape!!");
                }
                int v = 0;
                for (int i = 0; i < 19; i++) {
                    for (int j = 1; j <= 8; j++) {
                        if (boardshape[i][j] == "*") {
                            starLocation[v++] = i - 1;
                            starLocation[v++] = j - 1;
                        }
                    }
                }

                break;
            default:
                break;
        }

    }

    public boolean rightpermission(int m) {
        boolean right = true;

        for (int i = 1; i < m; i = i + 2) {
            if (starLocation[i] + 2 == 9) {
                right = false;
                break;
            }

        }

        return right;
    }

    public boolean leftpermission(int m) {
        boolean left = true;

        for (int i = 1; i < m; i = i + 2) {
            if (starLocation[i] - 2 == -2) {
                left = false;
                break;
            }

        }

        return left;
    }

    public boolean leftpermission() {
        boolean left = true;
        for (int i = 1; i < m; i = i + 2) {
            if (boardshape[starLocation[i - 1] + 1 + 1][starLocation[i] + 1 - 1] == "#" || boardshape[starLocation[i - 1] + 1][starLocation[i] + 1 - 1] == "#") {
                left = false;
                break;
            }
        }


        return left;
    }

    public boolean rightpermission() {
        boolean right = true;
        for (int i = 1; i < m; i = i + 2) {
            if (boardshape[starLocation[i - 1] + 1 + 1][starLocation[i] + 1 + 1] == "#" || boardshape[starLocation[i - 1] + 1][starLocation[i] + 1 + 1] == "#") {
                right = false;
                break;
            }
        }


        return right;
    }

    public void floor() {
        int s = 1;
        for (int i = 18; i >= 0; i--) {
            for (int j = 1; j <= 8; j++) {
                if (boardshape[i][j] == "*") {
                    for (int h = 0; h < m; h = h + 2) {

                        if (starLocation[h] + 2 == 19 || boardshape[i + 1][j] == "#") {
                            for (int k = 0; k < m; k = k + 2) {
                                boardshape[starLocation[k] + 1][starLocation[s] + 1] = "#";
                                s = s + 2;
                            }
                            for (int k = 0; k < m; k++) {
                                starLocation[k] = 0;
                            }
                            bool = true;
                            return;
                        }
                    }
                }
            }
        }
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void score() {
        for (int i = 18; i >= 0; i--) {
            if (boardshape[i][1] == "#" && boardshape[i][2] == "#" && boardshape[i][3] == "#" && boardshape[i][4] == "#" && boardshape[i][5] == "#" && boardshape[i][6] == "#" && boardshape[i][7] == "#" && boardshape[i][8] == "#") {
                boardshape[i][1] = boardshape[i][2] = boardshape[i][3] = boardshape[i][4] = boardshape[i][5] = boardshape[i][6] = boardshape[i][7] = boardshape[i][8] = " ";
                for (int j = i; j >= 0; j--) {
                    for (int k = 1; k < 8; k++) {
                        if (boardshape[j][k] == "#") {
                            boardshape[j][k] = " ";
                            boardshape[j + 1][k] = "#";
                        }
                    }
                }
                score = score + 100;

            }
        }

    }

    public void printScore() {
        System.out.print("score: ");
        System.out.println(score);

    }

    public boolean gameOverChecker() {
        boolean gameover = false;

        for (int j = 1; j < 9; j++) {
            if (boardshape[5][j] == "#") {
                score = score - 10;
                if (score < 0) {
                    gameover = true;
                }

                break;
            }
        }
        return gameover;
    }

    public boolean restartGame() {
        boolean restart = false;
        for (int j = 1; j < 9; j++) {
            if (boardshape[5][j] == "#") {

                restart = true;

                break;
            }
        }
        return restart;
    }

    public static String[][] rotateLeft(String[][] shape) {
        String[][] rotatedShape = new String[shape[0].length][shape.length];
        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[0].length; ++j) {
                rotatedShape[shape[0].length - j - 1][i] = shape[i][j];
            }
        }

        return rotatedShape;
    }

}

