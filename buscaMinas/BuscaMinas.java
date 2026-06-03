package clases;

import java.util.Scanner;

public class BuscaMinas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = new char[5][5];
        boolean[][] minas = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = '-';
            }
        }

        // 4 minas potentemente fijas 100% real no fake
        minas[0][1] = true;
        minas[1][3] = true;
        minas[3][0] = true;
        minas[4][4] = true;

        int casillasDescubiertas = 0;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {

            mostrarTablero(tablero);

            int fila;

            do {
                System.out.print("Fila (1-5): ");
                fila = sc.nextInt();

                if (fila < 1 || fila > 5) {
                    System.out.println("Fila inválida.");
                }

            } while (fila < 1 || fila > 5);

            int columna;

            do {
                System.out.print("Columna (1-5): ");
                columna = sc.nextInt();

                if (columna < 1 || columna > 5) {
                    System.out.println("Columna inválida.");
                }

            } while (columna < 1 || columna > 5);

            fila--;
            columna--;

            if (tablero[fila][columna] != '-') {
                System.out.println("Esa casilla ya fue descubierta.");
                continue;
            }

            if (minas[fila][columna]) {

                tablero[fila][columna] = '*';

                mostrarTablero(tablero);

                System.out.println("¡BOOM! Has perdido.");
                juegoTerminado = true;

            } else {

                int contador = 0;

                for (int i = fila - 1; i <= fila + 1; i++) {

                    for (int j = columna - 1; j <= columna + 1; j++) {

                        if (i >= 0 && i < 5 && j >= 0 && j < 5) {

                            if (minas[i][j]) {
                                contador++;
                            }

                        }
                    }
                }

                tablero[fila][columna] = (char) (contador + '0');

                casillasDescubiertas++;

                if (casillasDescubiertas == 21) {

                    mostrarTablero(tablero);

                    System.out.println("¡Ganaste!");
                    juegoTerminado = true;
                }
            }
        }

    }

    public static void mostrarTablero(char[][] tablero) {

        System.out.println();

        System.out.print("  ");

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {

            System.out.print((i + 1) + " ");

            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}