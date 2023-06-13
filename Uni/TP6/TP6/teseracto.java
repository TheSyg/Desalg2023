package TP6;

public class teseracto {

    public static void recorreLocura(int[][][][] tes, int i, int j, int k, int l) {

        if (i < tes.length) {
            if (j < tes[i].length) {
                if (k < tes[i][j].length) {
                    if (l < tes[i][j][k].length) {
                        System.out.print("|" + tes[i][j][k][l]);
                        recorreLocura(tes,i,j,k,l+1);
                    }
                    System.out.println("|");
                    recorreLocura(tes, i, j, k + 1, 0);
                }
                recorreLocura(tes, i, j + 1, 0, 0);
            }
            recorreLocura(tes, i + 1, 0, 0, 0);
        }

    }

    public static void main(String[] args) {
        int[][][][] loco = new int[3][3][3][3];

        for (int i = 0; i < loco.length; i++) {
            for (int j = 0; j < loco[i].length; j++) {
                for (int j2 = 0; j2 < loco[i][j].length; j2++) {
                    for (int index = 0; index < loco[i][j][j2].length; index++) {
                        loco[i][j][j2][index] = 420;
                    }
                }
            }
        }

        for (int i = 0; i < loco.length; i++) {
            for (int j = 0; j < loco[i].length; j++) {
                for (int j2 = 0; j2 < loco[i][j].length; j2++) {
                    for (int index = 0; index < loco[i][j][j2].length; index++) {
                        System.out.print("|" + loco[i][j][j2][index]);
                    }
                    System.out.println("|");
                }
                System.out.println("|");
            }
            System.out.println("|");
        }
        System.out.println("|");

        recorreLocura(loco, 0, 0, 0, 0);

    }
}
