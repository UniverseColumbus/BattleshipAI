import java.util.Arrays;
public class BattleShipTools{
    public static final int DIMENSIONS = 10;

    private static void shuffleArray(int[] array)
    {
        int index, temp;

        for (int i = array.length - 1; i > 0; i--)
        {
            index = (int)Math.random()*(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void randomBoard(int[][] gameBoard){
        int[] ships = new int [5];
        int[] shipIndex = {0,1,2,3,4};
        ships[0] = 2;
        ships[1] = 3;
        ships[2] = 3;
        ships[3] = 4;
        ships[4] = 5;

        shuffleArray(shipIndex);
        for(int temp = 0; temp < ships.length; temp++){
            int ship = shipIndex[temp];
            boolean valid = false;
            int orient = (int) (Math.random()*2);
            int x, y;
            if(orient == 0) {// horizontal
                //System.out.println("Horizontal");
                while(!valid){
                    //x = (int)(Math.random()* (gameBoard.length - ships[ship] -1)) +1;
                    //y = (int)(Math.random()* (gameBoard.length -2)) +1 ;
                    x = (int)(Math.random()* (gameBoard.length - ships[ship] +1));
                    y = (int)(Math.random()* (gameBoard.length));
                    int check = 0;
                    for(int i = 0; i<ships[ship]; i++){
                        check += gameBoard[x+i][y];
                    }
                    if(check == 0){
                        for(int i = 0; i<ships[ship]; i++){
                            gameBoard[x+i][y] = ship+1;
                        }
                        valid = true;
                    }
                }
            }else{ // vertical
                //System.out.println("Vertical");
                while(!valid){
                    x = (int)(Math.random()* (gameBoard.length));
                    y = (int)(Math.random()* (gameBoard.length - ships[ship] +1));
                    //x = (int)(Math.random()* (gameBoard.length - 2 ))+1;
                    //y = (int)(Math.random()* (gameBoard.length - ships[ship] -1))+1;
                    int check = 0;
                    for(int i = 0; i<ships[ship]; i++){
                        check += gameBoard[x][y+i];
                    }
                    if(check == 0){
                        for(int i = 0; i<ships[ship]; i++){
                            gameBoard[x][y+i] = ship +1;
                        }
                        valid = true;
                    }
                }
            }
        }
    }

    public static void problemBoard(int[][] gameBoard){
        
        gameBoard[9][5] = 1;
        gameBoard[9][6] = 1;
        gameBoard[3][6] = 2;
        gameBoard[3][7] = 2;
        gameBoard[3][8] = 2;
        gameBoard[4][1] = 3;
        gameBoard[4][2] = 3;
        gameBoard[4][3] = 3;
        gameBoard[5][3] = 4;
        gameBoard[5][4] = 4;
        gameBoard[5][5] = 4;
        gameBoard[5][6] = 4;
        gameBoard[0][9] = 5;
        gameBoard[1][9] = 5;
        gameBoard[2][9] = 5;
        gameBoard[3][9] = 5;
        gameBoard[4][9] = 5;
        
    }
    
    public static void printBoard(int[][] gameBoard){
        //System.out.println("gameBoard is: "+Arrays.deepToString(gameBoard)); 
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static void printBoard(char[][] playerBoard){
        for(int i = 0; i < playerBoard.length; i++){
            for(int j = 0; j < playerBoard.length; j++){
                System.out.print(playerBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean updateGuess(char[][] guessMap, String guess, int[][] gameBoard){
        boolean complete = false;
        int y = Character.toUpperCase(guess.charAt(0)) - 'A';
        int x;
        if(guess.charAt(1) == '1' && guess.length() > 2 && guess.charAt(2) == '0'){
            x = 9;
        }else{
            x = (guess.charAt(1) - '1');
        }

        //int temp = y;
        //y = x;
        //x = temp;

        //System.out.println("Guess at " + x + ", " + y);
        if(x >= 0 && x < gameBoard.length && y >= 0 && y < gameBoard.length){
            complete = true;
            if(gameBoard[y][x] == 0){
                guessMap[y][x] = 'O';
                complete = false;
            }else{
                guessMap[y][x] = 'X';
                int num = gameBoard[y][x];
                boolean last = true;
                for(int row = 0; row < gameBoard.length; row++){
                    for(int col = 0; col < gameBoard[row].length; col++){
                        if(num == gameBoard[row][col] && guessMap[row][col] != 'X'){
                            last = false;
                        }
                    }
                }

                if(last){
                    //System.out.println("Sunk " + num);
                    for(int row = 0; row < gameBoard.length; row++){
                        for(int col = 0; col < gameBoard[row].length; col++){
                            if(num == gameBoard[row][col])
                                guessMap[row][col] = (char) (gameBoard[row][col] + 48);
                        }
                    }
                }
                else{
                    //System.out.println("Hit " + num);
                    guessMap[y][x] = 'X';
                }

                for(int row = 0; row < gameBoard.length; row++){
                    for(int col = 0; col < gameBoard[row].length; col++){
                        if(gameBoard[row][col] > 0 && guessMap[row][col] == '.')
                            complete = false;
                    }
                }

            }
        }
        return complete;
    }

    public static int hit1miss0(String guess, int[][] gameBoard){
        int y = Character.toUpperCase(guess.charAt(0)) - 'A';
        int x;
        if(guess.charAt(1) == '1' && guess.length() > 2 && guess.charAt(2) == '0'){
            x = 9;
        }else{
            x = (guess.charAt(1) - '1');
        }

        if(x >= 0 && x < gameBoard.length && y >= 0 && y < gameBoard.length){
            if(gameBoard[y][x] == 0){
                return 0;
            }else{
                return 1;

            }
        }
        return 0;
    }

}