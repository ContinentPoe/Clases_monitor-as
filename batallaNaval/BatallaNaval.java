package clases;

import java.util.Scanner;

public class BatallaNaval {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = new char[9][9];
        boolean[][] barcos = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablero[i][j] = '-';
            }
        }

        barcos[1][1] = true;
        barcos[1][2] = true;
        barcos[1][3] = true;

        barcos[4][5] = true;
        barcos[5][5] = true;

        barcos[7][7] = true;

        int partesHundidas = 0;
        int totalPartes = 6;

        boolean barco3Hundido = false;
        boolean barco2Hundido = false;
        boolean barco1Hundido = false;

        while (partesHundidas < totalPartes) {

            mostrarTablero(tablero);

            int fila;

            do {
                System.out.print("Fila (1-9): ");
                fila = sc.nextInt();

                if (fila < 1 || fila > 9) {
                    System.out.println("Fila inválida.");
                }

            } while (fila < 1 || fila > 9);

            int columna;

            do {
                System.out.print("Columna (1-9): ");
                columna = sc.nextInt();

                if (columna < 1 || columna > 9) {
                    System.out.println("Columna inválida.");
                }

            } while (columna < 1 || columna > 9);

            fila--;
            columna--;

            if (tablero[fila][columna] != '-') {
                System.out.println("Ya disparaste en esa posición.");
                continue;
            }

            if (barcos[fila][columna]) {

                tablero[fila][columna] = 'X';
                partesHundidas++;

                if (!barco3Hundido
                        && tablero[1][1] == 'X'
                        && tablero[1][2] == 'X'
                        && tablero[1][3] == 'X') {

                    System.out.println("Hundiste mi barco de 3 casillas. Eso fue suerte.");
                    barco3Hundido = true;
                }

                // Verificar barco de 2 casillas
                if (!barco2Hundido
                        && tablero[4][5] == 'X'
                        && tablero[5][5] == 'X') {

                    System.out.println("Hundiste mi barco de 2 casillas! :(");
                    barco2Hundido = true;
                }

                // Verificar barco de 1 casilla
                if (!barco1Hundido
                        && tablero[7][7] == 'X') {

                    System.out.println("Hundiste mi barco de 1 casilla... :(");
                    barco1Hundido = true;
                }

            } else {

                tablero[fila][columna] = 'O';
                System.out.println("Agua.");
            }
        }

        mostrarTablero(tablero);

        System.out.println("¡GANASTE! Hundiste todos mis barcos :(");

        sc.close();
    }

    public static void mostrarTablero(char[][] tablero) {

        System.out.println();

        System.out.print("   ");

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < 9; i++) {

            System.out.print((i + 1) + "  ");

            for (int j = 0; j < 9; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}