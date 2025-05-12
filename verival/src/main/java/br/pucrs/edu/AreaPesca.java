package br.pucrs.edu;

import java.util.Scanner;

public class AreaPesca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] mar = new boolean[101][101];

        System.out.print("Quantas redes foram lançadas ao mar?: ");
        int N = scanner.nextInt(); 

        for (int i = 0; i < N; i++) {
            System.out.printf("Informe os valores xi, xf, yi, yf da rede %d:%n", i + 1);
            System.out.print("xi: ");
            int xi = scanner.nextInt();
            System.out.print("xf: ");
            int xf = scanner.nextInt();
            System.out.print("yi: ");
            int yi = scanner.nextInt();
            System.out.print("yf: ");
            int yf = scanner.nextInt();

            for (int x = xi; x < xf; x++) {
                for (int y = yi; y < yf; y++) {
                    mar[x][y] = true;
                }
            }
        }

        int areaAproveitada = 0;
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (mar[x][y]) {
                    areaAproveitada++;
                }
            }
        }

        System.out.println("Área total aproveitada do mar: " + areaAproveitada);
        scanner.close();
    }
}
