import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 * The InputGenerator class generates input data for the Minesweeper game and writes it to a file.
 * It creates various Minesweeper board configurations for testing purposes.
 * @author huyhuynh
 * @since Apr 5 2024
 * Team member: Huy Huynh, Drew Brown, Jafar AI-Salehi
 *
 * OFFICIAL SOLUTION
 *
 */
public class InputGenerator {
    /**
     * The main method of the InputGenerator class.
     * It creates a file named "team_minesweeper_input.txt" and generates Minesweeper board configurations.
     * @param agrs The command-line arguments (not used in this program).
     */
    public static void main(String[] agrs) {
        PrintStream file = fileCreated();
        addCase(file);

    }
    /**
     * Creates a new file named "team_minesweeper_input.txt" for writing.
     * @return A PrintStream object representing the output file.
     */
    private static PrintStream fileCreated() {
        PrintStream inputFile = null;

        try {
            inputFile = new PrintStream("team_minesweeper_input.txt");
        } catch(FileNotFoundException e) {
            System.out.println("Can't generate the file");
            System.exit(-1);
        }

        return inputFile;
    }
    /**
     * Adds different Minesweeper board configurations to the output file.
     * @param file The PrintStream object representing the output file.
     */
    private static void addCase(PrintStream file) {
        // Rate to get bomb is 1/5 = 20%
        Random rand = new Random();

        // Case 100 x 100 no mines
        file.println(100 + " " + 100);
        char[][] caseOne = new char[100][100];
        for(int i = 0; i < caseOne.length; i++) {
            for(int j = 0; j < caseOne[i].length; j++) {
                caseOne[i][j] = '.';
            }
        }
        writeIntoFile(caseOne, file);

        // Case 100 x 100 all mines
        file.println(100 + " " + 100);
        char[][] caseTwo = new char[100][100];
        for(int i = 0; i < caseOne.length; i++) {
            for(int j = 0; j < caseOne[i].length; j++) {
                caseTwo[i][j] = '*';
            }
        }
        writeIntoFile(caseTwo, file);

        // case 1 x 100
        file.println(1 + " " + 100);
        char[][] caseThree = new char[1][100];
        for(int i = 0; i < caseThree.length; i++) {
            for(int j = 0; j < caseThree[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseThree[i][j] = '*';
                } else {
                    caseThree[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseThree, file);

        // Case 100 x 1
        file.println(100 + " " + 1);
        char[][] caseFour = new char[100][1];
        for(int i = 0; i < caseFour.length; i++) {
            for(int j = 0; j < caseFour[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseFour[i][j] = '*';
                } else {
                    caseFour[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseFour, file);

        // Case 1 x 1
        file.println(1 + " " + 1);
        char[][] caseFive = new char[1][1];
        for(int i = 0; i < caseFive.length; i++) {
            for(int j = 0; j < caseFive[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseFive[i][j] = '*';
                } else {
                    caseFive[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseFive, file);

        // case 3 x 4
        file.println(3 + " " + 4);
        char[][] caseSix = new char[3][4];
        for(int i = 0; i < caseSix.length; i++) {
            for(int j = 0; j < caseSix[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseSix[i][j] = '*';
                } else {
                    caseSix[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseSix, file);

        // case 5 x 5
        file.println(5 + " " + 5);
        char[][] caseSeven = new char[5][5];
        for(int i = 0; i < caseSeven.length; i++) {
            for(int j = 0; j < caseSeven[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseSeven[i][j] = '*';
                } else {
                    caseSeven[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseSeven, file);

        // case 50 x 3
        file.println(50 + " " + 3);
        char[][] caseEight = new char[50][3];
        for(int i = 0; i < caseEight.length; i++) {
            for(int j = 0; j < caseEight[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseEight[i][j] = '*';
                } else {
                    caseEight[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseEight, file);

        // case 10 x 10
        file.println(10 + " " + 10);
        char[][] caseNine = new char[10][10];
        for(int i = 0; i < caseNine.length; i++) {
            for(int j = 0; j < caseNine[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseNine[i][j] = '*';
                } else {
                    caseNine[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseNine, file);

        // case 20 x 10
        file.println(20 + " " + 10);
        char[][] caseTen = new char[20][10];
        for(int i = 0; i < caseTen.length; i++) {
            for(int j = 0; j < caseTen[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseTen[i][j] = '*';
                } else {
                    caseTen[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseTen, file);

        // case 40 x 70
        file.println(40 + " " + 70);
        char[][] caseEleven = new char[40][70];
        for(int i = 0; i < caseEleven.length; i++) {
            for(int j = 0; j < caseEleven[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseEleven[i][j] = '*';
                } else {
                    caseEleven[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseEleven, file);

        // case 31 x 11
        file.println(31 + " " + 11);
        char[][] caseTwelve = new char[31][11];
        for(int i = 0; i < caseTwelve.length; i++) {
            for(int j = 0; j < caseTwelve[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseTwelve[i][j] = '*';
                } else {
                    caseTwelve[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseTwelve, file);

        // case 40 x 40
        file.println(40 + " " + 40);
        char[][] caseThirteen = new char[40][40];
        for(int i = 0; i < caseThirteen.length; i++) {
            for(int j = 0; j < caseThirteen[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseThirteen[i][j] = '*';
                } else {
                    caseThirteen[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseThirteen, file);

        // case 80 x 10
        file.println(80 + " " + 10);
        char[][] caseFourteen = new char[80][10];
        for(int i = 0; i < caseFourteen.length; i++) {
            for(int j = 0; j < caseFourteen[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseFourteen[i][j] = '*';
                } else {
                    caseFourteen[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseFourteen, file);

        // case 30 x 10
        file.println(30 + " " + 10);
        char[][] caseFifteen = new char[30][10];
        for(int i = 0; i < caseFifteen.length; i++) {
            for(int j = 0; j < caseFifteen[i].length; j++) {
                int bombRate = rand.nextInt(5);
                if(bombRate == 1) {
                    caseFifteen[i][j] = '*';
                } else {
                    caseFifteen[i][j] = '.';
                }
            }
        }
        writeIntoFile(caseFifteen, file);
    }
    /**
     * Writes a 2D char array into the specified PrintStream.
     * @param array The 2D char array to be written.
     * @param file The PrintStream object representing the output file.
     */
    private static void writeIntoFile(char[][] array, PrintStream file) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                file.print(array[i][j]);
            }
            file.println();
        }
    }
}
