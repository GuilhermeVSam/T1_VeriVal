package br.pucrs.edu;

import java.util.Scanner;

public class AreaPescaContratos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean[][] mar = new boolean[101][101];

        System.out.print("Quantas redes foram lançadas ao mar?: ");
        int N = scanner.nextInt();
        assert N >= 1 : "Devem haver ao menos uma rede de pesca";
        assert N <= 100: "Devem haver no máximo 100 redes de pesca";

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

            assert xi >= 1 : "O valor inicial de X (Xi) deve ser no mínimo 1.";
            assert xi <= xf : "O valor inicial de X (Xi) deve ser menor ou igual ao final (Xf).";
            assert xf <= 100 : "O valor final de X (Xf) deve ser no máximo 100.";

            assert yi >= 1 : "O valor inicial de Y (Yi) deve ser no mínimo 1.";
            assert yi <= yf : "O valor inicial de Y (Yi) deve ser menor ou igual ao final (Yf).";
            assert yf <= 100 : "O valor final de Y (Yf) deve ser no máximo 100.";


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

        assert areaAproveitada > 0 : "O mar deve estar coberto por ao menos uma rede de pesca";

        System.out.println("Área total aproveitada do mar: " + areaAproveitada);
        scanner.close();
    }
}
