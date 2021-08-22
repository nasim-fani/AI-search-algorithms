import java.util.Scanner;

public class ReadMatrix {
    public static int[][] readMatrixByUser() {
        int n, i, j;
        Scanner in = null;
        in = new Scanner(System.in);
        n = in.nextInt();
        int rootState[][] = new int[n][n];
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                rootState[i][j] = in.nextInt();


        return rootState;
    }
}

