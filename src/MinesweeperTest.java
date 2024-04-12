import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains JUnit tests for the Minesweeper class.
 * It tests various scenarios and edge cases related to generating Minesweeper boards.
 */
public class MinesweeperTest {
    /**
     * Tests the generation of a 4x4 Minesweeper board with normal input data.
     */
    @Test
    public void testBoard4x4Normal() {
        // Input data for testing generateBoard method
        char[][] inputArray = {
                {'*', '.', '*', '.'},
                {'.', '*', '.', '.'},
                {'*', '.', '.', '*'}
        };
        char[][] expectedOutput = {
                {'*', '3', '*', '1'},
                {'3', '*', '3', '2'},
                {'*', '2', '2', '*'}
        };

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(expectedOutput, inputArray);
    }
    /**
     * Tests the generation of a 2x10 Minesweeper board with normal input data.
     */
    @Test
    public void testBoard2x10Normal() {
        // Input data for testing generateBoard method
        char[][] inputArray = {
                {'*', '.', '*', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '*', '.', '.', '*', '*', '*', '*', '*', '*'},
        };
        char[][] expectedOutput = {
                {'*', '3', '*', '2', '2', '3', '3', '3', '3', '2'},
                {'2', '*', '2', '2', '*', '*', '*', '*', '*', '*'},
        };

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(expectedOutput, inputArray);
    }
    /**
     * Tests the generation of a 1x1 Minesweeper board with normal input data.
     */
    @Test
    public void testBoard1x1Normal() {
        // Input data for testing generateBoard method
        char[][] inputArray = {
                {'*'}
        };
        char[][] expectedOutput = {
                {'*'}
        };

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(expectedOutput, inputArray);
    }
    /**
     * Tests the generation of a 1x4 Minesweeper board with normal input data.
     */
    @Test
    public void testBoardEdgeCaseNormal1x4() {
        // Input data for testing generateBoard method
        char[][] inputArray = {
                {'*'},
                {'.'},
                {'.'},
                {'*'}
        };
        char[][] expectedOutput = {
                {'*'},
                {'1'},
                {'1'},
                {'*'}
        };

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(expectedOutput, inputArray);
    }
    /**
     * Tests the generation of a 7x1 Minesweeper board with normal input data.
     */
    @Test
    public void testBoardEdgeCaseNormal7x1() {
        // Input data for testing generateBoard method
        char[][] inputArray = {
                {'*', '.', '.', '.' ,'*' , '.', '.'}
        };
        char[][] expectedOutput = {
                {'*', '1', '0', '1' ,'*' , '1', '0'}
        };

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(expectedOutput, inputArray);
    }
    /**
     * Tests the generation of a 100x100 Minesweeper board with no bombs input data.
     */
    @Test
    public void testBoard100x100NoBombs() {
        int row = 100;
        int column = 100;
        char[][] inputArray = new char[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                inputArray[i][j] = '.';
            }
        }

        char[][] expectedOutput = new char[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                expectedOutput[i][j] = '0';
            }
        }

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(inputArray, expectedOutput);
    }
    /**
     * Tests the generation of a 100x100 Minesweeper board with all bombs input data.
     */
    @Test
    public void testBoard100x100AllBombs() {
        int row = 100;
        int column = 100;
        char[][] inputArray = new char[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                inputArray[i][j] = '*';
            }
        }

        char[][] expectedOutput = new char[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                expectedOutput[i][j] = '*';
            }
        }
        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(inputArray, expectedOutput);
    }
    /**
     * Tests the generation of a 100x1 Minesweeper board with all bombs input data.
     */
    @Test
    public void testBoardEdgeCase100x1AllBombs() {
        int row = 100;
        int column = 1;
        char[][] inputArray = new char[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                inputArray[i][j] = '*';
            }
        }

        char[][] expectedOutput = new char[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                expectedOutput[i][j] = '*';
            }
        }

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(inputArray, expectedOutput);
    }
    /**
     * Tests the generation of a 1x100 Minesweeper board with no bombs input data.
     */
    @Test
    public void testBoardEdgeCase1x100NoBombs() {
        int row = 1;
        int column = 100;
        char[][] inputArray = new char[row][column];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                inputArray[i][j] = '*';
            }
        }

        char[][] expectedOutput = new char[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                expectedOutput[i][j] = '*';
            }
        }

        Minesweeper.generateBoard(inputArray);

        Assertions.assertArrayEquals(inputArray, expectedOutput);
    }
    /**
     * Tests the generation of a Minesweeper board with an empty grid.
     */
    @Test
    public void testGenerateInput_EmptyGrid() {
        String input = "0 0";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        Minesweeper.generateInput(scanner);

        assertArrayEquals(new char[0][0], Minesweeper.processGrid(0, 0, scanner));
    }
}