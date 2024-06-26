import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program going to generate the board of mines fields
 * and produce a hint for Minesweeper game.

 * @author huyhuynh
 * @since Apr 5 2024
 * Team member: Huy Huynh, Drew Brown, Jafar AI-Salehi
 *
 * OFFICIAL SOLUTION
 *
 */
public class Minesweeper {
    /**
     * Main method of the game, this method would receive
     * input from console/keyboard generate file and produce
     * output file.
     * @param args hold command-lines argument passed to program.
     * @throws FileNotFoundException In case the file received is not existed.
     */
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner;

        if (args.length > 0) {
            File file = new File(args[0]);
            scanner = new Scanner(file);
        } else {
            scanner = new Scanner(System.in);
        }

        generateInput(scanner);
        scanner.close();
    }

    /**
     * This method Generate input from the console and
     * collect each 2D arrays by rows and columns, and data
     * would be pass to processGrid() method to collect bombs
     * and space, after having completed single 2D array the
     * 2D would be generated by generateBoard method.
     *
     * @param input the file after being scanned.
     */
    public static void generateInput(final Scanner input) {
        int fieldNumber = 1;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScanner = new Scanner(line);

            if (lineScanner.hasNextInt()) {
                int row = lineScanner.nextInt();
                int column = lineScanner.nextInt();

                if (row == 0 && column == 0) {
                    break;
                }

                char[][] singleArray = processGrid(row, column, input);
                System.out.println("Field #" + fieldNumber + ":");
                fieldNumber++;
                generateBoard(singleArray);
            }
            lineScanner.close();
        }
        input.close();
    }

    /**
     * This method receive 2D arrays with data of bombs and space,
     * generate the board, give out the hint and print back to the
     * console.
     *
     * @param array a single completed 2D array from txt file.
     */
    public static void generateBoard(final char[][] array) {
        // Set up the temp array with size of padding + normal size
        int row = array.length;
        int column =  array[0].length;

        int padding = 2;
        int newRow = row + padding;
        int newColumn = column + padding;
        char[][] tempArray = new char[newRow][newColumn];

        // Fill up temp array all by 'x'
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                tempArray[i][j] = 'x';
            }
        }

        // Copy the bombs and space of original 2D arrays except the padding part.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                tempArray[i + padding / 2][j + padding / 2] = array[i][j];
            }
        }

        // Check all 8 directions to generate the hints.
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                if (tempArray[i][j] != 'x' && tempArray[i][j] != '*') {

                    int bombCount = 0;

                    if (tempArray[i - 1][j - 1] == '*') { // check left upper corner
                        bombCount++;
                    }
                    if (tempArray[i - 1][j] == '*') { // check top
                        bombCount++;
                    }
                    if (tempArray[i - 1][j + 1] == '*') { // check right upper corner
                        bombCount++;
                    }
                    if (tempArray[i][j - 1] == '*') { // check left
                        bombCount++;
                    }
                    if (tempArray[i][j + 1] == '*') { // check right
                        bombCount++;
                    }
                    if (tempArray[i + 1][j - 1] == '*') { // check lower left corner
                        bombCount++;
                    }
                    if (tempArray[i + 1][j] == '*') { // check bottom
                        bombCount++;
                    }
                    if (tempArray[i + 1][j + 1] == '*') { // check lower right corner
                        bombCount++;
                    }
                    tempArray[i][j] = (char) (bombCount + '0');
                }
            }
        }

        // After generate hint copy data back to original array.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = tempArray[i + padding / 2][j + padding / 2];
            }
        }
        // print them into console.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method would read the txt file and collect data from each 2D array.
     * @param row of the array.
     * @param column of the array.
     * @param input txt file.
     * @return the new completed 2D arrays from txt file.
     */
    public static char[][] processGrid(final int row, final int column, final Scanner input) {
        char[][] grid = new char[row][column];
        // Read grid data
        for (int i = 0; i < row; i++) {
            String line = input.nextLine();
            for (int j = 0; j < column; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        return grid;
    }
}
