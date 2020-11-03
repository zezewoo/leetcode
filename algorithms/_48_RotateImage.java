package algorithms;

/**
 * @author wxb
 * @date 2020-11-02 : 15:42
 */



public class _48_RotateImage {


    public static void main(String[] args) {

        _48_RotateImage rotateImage = new _48_RotateImage();


        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        rotateImage.rotate(matrix);
        rotateImage.rotate(matrix);
    }


    public void rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] tmp = new int[n][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                tmp[i][j] = matrix[i][j];
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                int key = n - i - 1;
                matrix[j][key] = tmp[i][j];
            }
        }
    }

}
