package CodeSchool;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input table length: ");
        int tableLength = sc.nextInt();

        System.out.print("Player1(X) Name: ");
        String player1 = sc.next();

        System.out.print("Player2(O) Name: ");
        String player2 = sc.next();

        String[][] table = new String[tableLength][tableLength];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = "-";
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }

        play(player1, player2, table);

    }


    //PLAY method
    public static void play(String player1, String player2, String[][] table) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);

        boolean playerStart = rn.nextBoolean();


        for (int i = 0; i < table.length * table.length; i++) {
            int row;
            int column;

            //Yst playerStart-i tvac arjeqi xaxi hertakanutyunne apahovum
            if (playerStart) { //--------> player1-i hamar

                System.out.print(player1 + " input row(0-" + (table.length - 1) + "): ");
                row = sc.nextInt();

                System.out.print(player1 + " input column(0-" + (table.length - 1) + "): ");
                column = sc.nextInt();


                //Stuguma ete nshvac vandaky trvac chaperic durs chi kam vandaky azata nor gorcoxutyuna anum
                if (row >= 0 && row <= table.length - 1 && column >= 0 && column <= table.length - 1 && table[row][column].equals("-")) {
                    table[row][column] = "X";
                } else {
                    System.out.println("Row and Column input 0-" + (table.length - 1) + " or already in this box:");
                    play(player1, player2, table);
                }

                tablePrint(table);

                playerStart = false;

            } else { //--------> player2-i hamar

                System.out.print(player2 + " input row(0-" + (table.length - 1) + "): ");
                row = sc.nextInt();

                System.out.print(player2 + " input column(0-" + (table.length - 1) + "): ");
                column = sc.nextInt();


                //Stuguma ete nshvac vandaky trvac chaperic durs chi kam vandaky azata nor gorcoxutyuna anum
                if (row >= 0 && row <= table.length - 1 && column >= 0 && column <= table.length - 1 && table[row][column].equals("-")) {
                    table[row][column] = "O";
                } else {
                    System.out.println("Row and Column input 0-" + (table.length - 1) + " or already in this box:");
                    play(player1, player2, table);
                }

                tablePrint(table);

                playerStart = true;
            }


            boolean isWon = false;


            //Haxtoxin voroshelu 1 depq stuguma toxerov
            for (int j = 0; j < table.length; j++) {
                isWon = true;

                for (int k = 1; k < table[j].length; k++) {
                    if (!table[j][k].equals(table[j][k - 1]) || table[j][k].equals("-") || table[j][k - 1].equals("-")) {
                        isWon = false;
                        break;
                    }
                }

                if (isWon && playerStart) {
                    System.out.println(player2 + " WIIIN!");
                    break;
                } else if (isWon && !playerStart) {
                    System.out.println(player1 + " WIIIN!");
                    break;
                }
            }

            //Ete ka haxtox kangnecnuma
            if (isWon) {
                break;
            }


            //Haxtoxin voroshelu 2-rd depq stuguma syunerov
            for (int j = 1; j < table.length; j++) {
                isWon = true;

                for (int k = 1; k < table[j].length; k++) {
                    if (!table[k][j].equals(table[k - 1][j]) || table[k][j].equals("-") || table[k - 1][j].equals("-")) {
                        isWon = false;
                        break;
                    }
                }

                if (isWon && playerStart) {
                    System.out.println(player2 + " WIIIN!");
                    break;
                } else if (isWon && !playerStart) {
                    System.out.println(player1 + " WIIIN!");
                    break;
                }
            }

            //Ete ka haxtox kangnecnuma
            if (isWon) {
                break;
            }


            //Haxtoxin voroshelu 3-rd depq stuguma dzaxic aj verevic nerqev ankyunagcov

            isWon = true; //---> ayd uxutyamb hamematac 1 ev 2 depqeri ka 1 ankyunagic, dra hamar ays popoxakany haytararumenq ciklic durs

            for (int j = 1; j < table.length; j++) {
                if (!table[j][j].equals(table[j - 1][j - 1]) || table[j][j].equals("-") || table[j - 1][j - 1].equals("_")) {
                    isWon = false;
                    break;
                }
            }

            if (isWon && playerStart) {
                System.out.println(player2 + " WIIIN!");
                break;
            } else if (isWon && !playerStart) {
                System.out.println(player1 + " WIIIN!");
                break;
            }


            //Haxtoxin voroshelu 4-rd depq stuguma ajic dzax verevic nerqev ankyunagcov
            isWon = true; //---> ayd uxutyamb hamematac 1 ev 2 depqeri ka 1 ankyunagic, dra hamar ays popoxakany haytararumenq ciklic durs

            int column1 = table.length - 2;
            for (int j = 1; j < table.length; j++) {
                if (!table[j][column1].equals(table[j - 1][column1 + 1]) || table[j][column1].equals("-") || table[j - 1][column1 + 1].equals("-")) {
                    isWon = false;
                    break;
                }
                column1--;
            }

            if (isWon && playerStart) {
                System.out.println(player2 + " WIIIN!");
                break;
            } else if (isWon && !playerStart) {
                System.out.println(player1 + " WIIIN!");
                break;
            }

            //Verjum haxtox xaxacox chlinelu depqum
            if (i == table.length * table.length - 1) {
                System.out.println("NO ONE!!!");
            }
        }
    }


    //Print All Table
    public static void tablePrint(String table[][]) {
        for (int j = 0; j < table.length; j++) {
            for (int k = 0; k < table[j].length; k++) {
                System.out.print(table[j][k] + "  ");
            }
            System.out.println();
        }
    }

}
