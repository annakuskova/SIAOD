public class Ex_3 {
    public static boolean isSafe(int[][] chessboard, int row, int col){
        int i, j;

        // Определяем, есть ли над элементом ферзь
        for (i = row - 1, j = col; i >= 0; i--) {
            if (chessboard[i][j] == 1) return false;
        }

        // Определяем, есть ли ферзь в верхнем левом углу элемента
        for(i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessboard[i][j] == 1) {
                return false;
            }
        }

        // Определяем, есть ли ферзь в правом верхнем углу элемента
        for(i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
            if(chessboard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void drawChessboard(int[][] chessboard) {
        int i, j;

        for(i = 0; i < 8; i++) {
            for(j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueen (int row, int[][] chessboard){
        int col;
        if (row == 8) {
            drawChessboard(chessboard);
        } else {
            for (col = 0; col < 8; col++){
                if (isSafe(chessboard, row, col)){
                    chessboard[row][col] = 1;
                    nQueen(row + 1, chessboard);
                }
                chessboard[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] chessboard = new int[8][8];
        for (int i = 0; i < chessboard.length; i++){
            for (int j = 0; j < chessboard[i].length; j++){
                chessboard[i][j] = 0;
            }
        }
        nQueen(0, chessboard);
    }

}
