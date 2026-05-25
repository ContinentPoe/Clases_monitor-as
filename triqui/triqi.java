package clases;

import java.util.Scanner;

import java.util.Scanner;

public class triqi {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        char jugador = '■';
        boolean juegoTerminado = false;

        while (!juegoTerminado) {

            mostrarTablero(tablero);

            System.out.println("Turno del jugador " + jugador);

            System.out.print("Fila (0-2): ");
            int fila = sc.nextInt();

            System.out.print("Columna (0-2): ");
            int columna = sc.nextInt();

            if (tablero[fila][columna] == '-') {

                tablero[fila][columna] = jugador;

                if (hayGanador(tablero, jugador)) {

                    mostrarTablero(tablero);
                    System.out.println("¡Oh! :O. Ganó el jugador ⋆✯≛ --> " + jugador + " <-- ≛✯⋆");
                    juegoTerminado = true;

                } else if (tableroLleno(tablero)) {

                    mostrarTablero(tablero);
                    System.out.println("Empate.");
                    juegoTerminado = true;

                } else {

                    if (jugador == '■') {
                        jugador = '•';
                    } else {
                        jugador = '■';
                    }
                }

            } else {
                System.out.println("Esa posición ya está ocupada. Agaarre otra.");
            }
        }

        sc.close();
    }

    public static void mostrarTablero(char[][] tablero) {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
            	
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static boolean hayGanador(char[][] t, char jugador) {

        for (int i = 0; i < 3; i++) {
            if (t[i][0] == jugador && t[i][1] == jugador && t[i][2] == jugador) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (t[0][i] == jugador && t[1][i] == jugador && t[2][i] == jugador) {
                return true;
            }
        }

        if (t[0][0] == jugador && t[1][1] == jugador && t[2][2] == jugador) {
            return true;
        }

        if (t[0][2] == jugador && t[1][1] == jugador && t[2][0] == jugador) {
            return true;
        }

        return false;
    }

    public static boolean tableroLleno(char[][] tablero) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}