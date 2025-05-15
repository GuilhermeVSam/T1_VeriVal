package br.pucrs.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AreaPesca.Rede> redes = new ArrayList<>();

        int N = Integer.parseInt(scanner.nextLine());
        assert N >= 1 : "Deve haver ao menos uma rede no mar";
        assert N <= 100 : "Devem haver no máximo 100 redes no mar";

        for (int i = 0; i < N; i++) {
            String[] coord = scanner.nextLine().split("\\s+");
            int xi = Integer.parseInt(coord[0]);
            int xf = Integer.parseInt(coord[1]);
            int yi = Integer.parseInt(coord[2]);
            int yf = Integer.parseInt(coord[3]);
            AreaPesca.Rede rede = new AreaPesca.Rede(xi, xf, yi, yf);
            AreaPesca.validarRede(rede);
            redes.add(rede);
        }

        int area = AreaPesca.calcularAreaAproveitada(redes);
        System.out.println(area);
        scanner.close();
    }

    public class AreaPesca {

        public static int calcularAreaAproveitada(List<Rede> redes) {
            boolean[][] mar = new boolean[101][101];

            for (Rede rede : redes) {
                AreaPesca.validarRede(rede);
                for (int x = rede.xi; x < rede.xf; x++) {
                    for (int y = rede.yi; y < rede.yf; y++) {
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

            assert areaAproveitada >= 0 : "A área aproveitada deve ser >= 0";
            assert areaAproveitada <= 10000 : "A área aproveitada não pode exceder 10000";

            return areaAproveitada;
        }

        public static void validarRede(Rede rede) {
            assert rede.xi >= 1 : "Xi deve ser no mínimo 1";
            assert rede.xi <= rede.xf : "Xi deve ser <= Xf";
            assert rede.xf <= 100 : "Xf deve ser no máximo 100";

            assert rede.yi >= 1 : "Yi deve ser no mínimo 1";
            assert rede.yi <= rede.yf : "Yi deve ser <= Yf";
            assert rede.yf <= 100 : "Yf deve ser no máximo 100";
        }

        // Classe de apoio para representar uma rede de pesca
        public static class Rede {
            public final int xi, xf, yi, yf;

            public Rede(int xi, int xf, int yi, int yf) {
                this.xi = xi;
                this.xf = xf;
                this.yi = yi;
                this.yf = yf;
            }
        }
    }
}