import java.util.Scanner;

public class igra {
    public void getStarted(char[][] gameMap) {
        Scanner sc = new Scanner(System.in);
        int y;
        int x;
        int x1;
        int y1;
        int score = 0;

        boolean z = false;

        while (!z) {
            System.out.println("Ваш ход");
            y = sc.nextInt();
            x = sc.nextInt();

            if ((x < 1) || (x > 3) || (y < 1) || (y > 3)) {
                System.out.println("Нет такой ячейки , оба значения должны входить в промежуток [1;3]");
            } else {

                if (y == 2) {
                    y = 3;
                } else if (y == 3) {
                    y = 5;
                }

                if (gameMap[x][y] == '_') {
                    gameMap[x][y] = 'x';
                    score++;

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(gameMap[i][j]);
                        }


                        System.out.println();
                    }
                    System.out.println("ходит компьютер");

                    if (score == 9) {
                        break;
                    }

                    do {
                        x1 = (int) (Math.random() * 3 + 1);
                        y1 = (int) (Math.random() * 5 + 1);
                    } while (gameMap[x1][y1] != '_');

                    gameMap[x1][y1] = '0';
                    score++;

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(gameMap[i][j]);
                        }


                        System.out.println();
                    }
                    z = check(gameMap, 'x') || check(gameMap, '0');

                } else {
                    System.out.println("Ячейка занята");
                }
            }
        }

        if (check(gameMap, 'x')) {
            System.out.println("Вы выиграли");
        } else if (check(gameMap, '0')) {
            System.out.println("Вы проиграли");
        } else {
            System.out.println("Ничья");
        }
    }

    public boolean check(char[][] gameMap, char c) {
        for (int i = 1; i <= 3; i++) {
            if (gameMap[i][1] == c && gameMap[i][3] == c && gameMap[i][5] == c) {
                return true;
            }
        }
        for (int i = 1; i <= 5; i += 2) {
            if (gameMap[1][i] == c && gameMap[2][i] == c && gameMap[3][i] == c) {
                return true;
            }
        }

        if ((gameMap[1][1] == c && gameMap[2][3] == c && gameMap[3][5] == c) || (gameMap[1][5] == c && gameMap[2][3] == c && gameMap[3][1] == c)) {
            return true;
        }
        return false;

    }


}
