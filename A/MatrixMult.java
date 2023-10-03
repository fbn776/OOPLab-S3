public class MatrixMult {
    public static void main(String[] args) {
        int n = 2, m = 2, p = 2, q = 2, i = 0, j = 0, k = 0;
        int[][] A = {
                {1, 2},
                {3, 4}
        }, B = {
                {1, 0},
                {0, 1},
        }, C = new int[n][q];

        for(i=0; i<n; i++)
            for(j=0; j<q; j++) {
                C[i][j] = 0;
                for(k=0; k<m; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }

        for(i=0; i<n; i++) {
            for (j = 0; j < q; j++)
                System.out.print(C[i][j] + " ");
            System.out.println();
        }
    }
}
