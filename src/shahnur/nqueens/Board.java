package shahnur.nqueens;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 @author Shahnur Isgandarli
 */
public class Board {
    private Image queenWhite = new Image("file:img/queen-white.png");
    private Image queenBlue = new Image("file:img/queen-blue.png");
    private Image white = new Image("file:img/white.png");
    private Image blue = new Image("file:img/blue.png");

    private GridPane grid;
    private int size;
    private int[][] board;
    private QueenPlacer placer;

    /**
     * This is constructor of {@link Board} class.
     * @param size The size of the chess board.
     * @param placer The QueenPlacer instance.
     */
    public Board(int size, QueenPlacer placer) {
        this.board = new int[size][size];
        this.size = size;
        this.grid = new GridPane();
        this.placer = placer;
    }

    /**
     * This method generates a solution using a {@link QueenPlacer} instance
     * and then copies the solution board of {@link QueenPlacer} instance to the class
     * instance variable.
     */
    private void generateSolution() {
        this.placer.placeQueens();

        int[][] solutionBoard = this.placer.getBoard();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = solutionBoard[i][j];
            }
        }
    }

    /**
     * This method creates a desired ImageView specified by parameters of the method
     * and returns it.
     * @param i The row of the board.
     * @param j The column of the board.
     * @param value The value of the board: 1 (one) if there is a queen, and 0 (zero) otherwise.
     * @return ImageView
     */
    private ImageView createImageView(int i, int j, int value) {
        int color = 0;
        if (i % 2 == 0) {
            if (j % 2 == 0) {
                color = 0;
            } else {
                color = 1;
            }
        } else {
            if (j % 2 == 0) {
                color = 1;
            } else {
                color = 0;
            }
        }
        if (value == 1) {
            if (color == 1) {
                return new ImageView(queenBlue);
            } else {
                return new ImageView(queenWhite);
            }
        } else {
            if (color == 0) {
                return new ImageView(white);
            } else {
                return new ImageView(blue);
            }
        }
    }

    /**
     * This method populates the class instance variable grid with the ImageViews
     * generated by createImageView method.
     */
    public void drawBoard() {
        generateSolution();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ImageView imageView = createImageView(i, j, board[i][j]);
                grid.addRow(i, imageView);
            }
        }
    }

    /**
     * This is a getter method for retrieving the grid.
     * @return GridPane
     */
    public GridPane getGrid() {
        return grid;
    }

}
