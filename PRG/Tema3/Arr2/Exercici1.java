public class Exercici1 {

    // Method to initialize the array values corresponding to its position
    // Doesn't modify the input value and returns an array with same dimensions
    public static int[][] initializeArr(final int[][] arr) {
        int[][] tmpArr = new int[arr.length][];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = new int[arr[i].length];

            for (int j = 0; j < arr[i].length; j++) {
                tmpArr[i][j] = count++;
            }
        }
        return tmpArr;
    }

    public static void main(String[] args) {
        int[][] numArr = new int[5][8];
        numArr = initializeArr(numArr);

        // Outputs every value in the array by looping it with a for-each loop
        for (int[] row : numArr) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}

