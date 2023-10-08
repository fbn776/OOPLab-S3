class Matrix {
    int[][] arr;
    int m, n;
    public Matrix(int[][] arr, int m, int n) {
        this.arr = arr;
        this.m = m;
        this.n = n;
    }

    public void display() {
        for(int i=0; i<this.m; i++) {
            for(int j=0; j<this.n; j++) {
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static Matrix mult(Matrix A, Matrix B) {
        int[][] arr = new int[A.m][B.n];

        for(int i=0; i<A.m; i++) {
            for(int j=0; j<B.n; j++) {
                arr[i][j] = 0;
                for(int k=0; k<A.n; k++) {
                    arr[i][j] += A.arr[i][k] * B.arr[k][j];
                }
            }
        }
        return new Matrix(arr, A.m, B.n);
    }
}

public class MatrixWithClass {
    public static void main(String[] args) {
        int m = 3, n = 3, p = 3, q = 3;
        int[][] arrA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, arrB = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Matrix A = new Matrix(arrA, m, n),
                B = new Matrix(arrB, p, q);

        Matrix C = Matrix.mult(A, B);

        C.display();
    }
}
