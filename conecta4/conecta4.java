package clases;

import java.util.Scanner;

public class conecta4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] tablero = new char[4][4];

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                tablero[i][j] = '-';
            }
        }

        char jugador = '■';
        boolean juegoTerminado = false;

        while (!juegoTerminado) {

            mostrarTablero(tablero);

            System.out.println("Turno del jugador " + jugador);

            System.out.print("Ingrese columna (0-3): ");
            int columna = sc.nextInt();

            if (columna < 0 || columna > 3) {

                System.out.println("Columna no rs válida.");
                continue;
            }

            boolean fichaPuesta = false;

            for (int fila = 3; fila >= 0; fila--) {

                if (tablero[fila][columna] == '-') {

                    tablero[fila][columna] = jugador;
                    fichaPuesta = true;

                    if (hayGanador(tablero, jugador)) {

                        mostrarTablero(tablero);
                        System.out.println("¡Oh! Ganó el jugador " + jugador + ". :D");
                        juegoTerminado = true;

                    } else if (tableroLlenado(tablero)) {

                        mostrarTablero(tablero);
                        System.out.println("Empate.");
                        juegoTerminado = true;

                    } else {

                        if (jugador == '■') {
                            jugador = '○';
                        } else {
                            jugador = '■';
                        }
                    }

                    break;
                }
            }

            if (!fichaPuesta) {
                System.out.println("Esa columna está llena :(");
            }
        }

        sc.close();
    }

    public static void mostrarTablero(char[][] tablero) {
    	
        System.out.println();

    	System.out.println("0 1 2 3");

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                System.out.print(tablero[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static boolean hayGanador(char[][] t, char jugador) {

    	for (int i = 0; i < 4; i++) {

            if (t[i][0] == jugador && t[i][1] == jugador && t[i][2] == jugador && t[i][3] == jugador) {

                return true;
            }
        }

        for (int j = 0; j < 4; j++) {

            if (t[0][j] == jugador && t[1][j] == jugador && t[2][j] == jugador && t[3][j] == jugador) {

                return true;
            }
        }

        if (t[0][0] == jugador && t[1][1] == jugador && t[2][2] == jugador && t[3][3] == jugador) {

            return true;
        }

        if (t[0][3] == jugador && t[1][2] == jugador && t[2][1] == jugador && t[3][0] == jugador) {

            return true;
        }

        return false;
    }

    public static boolean tableroLlenado(char[][] tablero) {

        for (int j = 0; j < 4; j++) {

            if (tablero[0][j] == '-') {
                return false;
            }
        }

        return true;
    }
}
