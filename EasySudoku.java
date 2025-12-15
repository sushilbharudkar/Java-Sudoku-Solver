public class EasySudoku {

    int[][] grid = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static void main(String[] args) {
        EasySudoku s = new EasySudoku();

        int result = s.solve();

        if (result == 1) {
            s.print();
        } else {
            System.out.println("No solution");
        }
    }

    // Solve Sudoku using recursion, return 1 = solved, 0 = not solved

    int solve() {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (grid[r][c] == 0) { // Empty place

                    for (int num = 1; num <= 9; num++) {

                        if (canPlace(r, c, num) == 1) {
                            grid[r][c] = num;

                            if (solve() == 1)
                                return 1;

                            grid[r][c] = 0; // backtrack
                        }
                    }

                    return 0;
                }
            }
        }

        return 1;
    }

    int canPlace(int row, int col, int num) {


        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num)
                return 0;
        }
        
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num)
                return 0;
        }

        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[r + i][c + j] == num)
                    return 0;
            }
        }

        return 1;
    }

    void print() {
	
	System.out.println();
	System.out.println("The Solved Sudoku Puzzle!");
	System.out.println();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}