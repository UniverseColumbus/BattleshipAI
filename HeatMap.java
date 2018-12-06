import java.util.Arrays;
public class HeatMap{
    public static String makeGuess(char[][] guesses){
    //public static void main(String[] args){

        int[][] heatMap = {
                ///////1  2  3  4  5  6  7  8  9  10
                /*A*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*B*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*C*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*D*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*E*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*F*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*G*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*H*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*I*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*J*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
            }; 
        
        //char[][] guesses = {
                ///////1   2   3   4   5   6   7   8   9  10
                /*A*///{'.','O','.','O','O','4','.','O','O','.'},
                /*B*///{'O','O','O','.','O','4','O','.','3','O'},
                /*C*///{'O','O','.','O','.','4','.','O','3','.'},
                /*D*///{'.','O','2','O','O','4','O','.','3','O'},
                /*E*///{'O','.','2','O','.','5','5','5','5','5'},
                /*F*///{'.','O','2','.','O','O','.','O','O','.'},
                /*G*///{'O','O','O','.','O','.','O','O','.','O'},
                /*H*///{'.','O','.','O','.','O','O','.','O','.'},
                /*I*///{'O','.','O','.','O','.','O','O','.','O'},
                /*J*///{'.','O','.','O','.','O','.','O','O','.'}
            //};
        //for(int row=0;row<heatMap.length;row++){
        //for(int col=0;col<heatMap[row].length;col+=2){
        //heatMap[row][col] = 1;                                
        //}            
        //}                
        String guess = new String("");
        int aircraftcarrier = 0;        
        int battleship = 0;        
        int destroyer = 0;        
        int submarine = 0;
        int patrolboat = 0;
        for(int row=0;row<guesses.length;row++){
            for(int col=0;col<guesses[row].length;col++){                
                if(guesses[row][col] == '5'){
                    aircraftcarrier++;
                }
                if(guesses[row][col] == '4'){
                    battleship++;
                }
                if(guesses[row][col] == '3'){
                    destroyer++;
                }
                if(guesses[row][col] == '2'){
                    submarine++;
                }
                if(guesses[row][col] == '1'){
                    patrolboat++;
                }
            }
        }        
        for(int row=0;row<guesses.length;row++){
            for(int col=0;col<guesses[row].length;col++){                                
                if(row-1>=0 && guesses[row-1][col]=='.' && guesses[row][col]=='.'
                && (patrolboat!=2 || (patrolboat==2 && destroyer!=3) || (patrolboat==2 && submarine!=3) 
                || (patrolboat==2 && battleship!=4)
                || (patrolboat==2 && aircraftcarrier!=5))){//for every open position above add 1
                    heatMap[row][col] += 1;
                    if(row-2>=0 && guesses[row-2][col]=='.'
                    && (destroyer!=3 || (destroyer==3 && submarine!=3) 
                    || (destroyer==3 && battleship!=4) || (destroyer==3 && aircraftcarrier!=5))){                                                                                    
                        heatMap[row][col] += 1;
                        if(row-2>=0 && guesses[row-2][col]=='.'
                        && (submarine!=3 || (submarine==3 && destroyer!=3) 
                        || (submarine==3 && battleship!=4) || (submarine==3 && aircraftcarrier!=5))){                                                                                    
                            heatMap[row][col] += 1; 
                            if(row-3>=0 && guesses[row-3][col]=='.' 
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                heatMap[row][col] += 1;
                                if(row-4>=0 && guesses[row-4][col]=='.' && aircraftcarrier!=5){
                                    heatMap[row][col] += 1;
                                }
                            }
                        }
                    }
                }
                if(row+1<=9 && guesses[row+1][col]=='.' && guesses[row][col]=='.'
                && (patrolboat!=2 || (patrolboat==2 && destroyer!=3) || (patrolboat==2 && battleship!=4)
                || (patrolboat==2 && aircraftcarrier!=5))){//for every open position below add 1
                    heatMap[row][col] += 1;
                    if(row+2<=9 && guesses[row+2][col]=='.' 
                    && (destroyer!=3 || (destroyer==3 && submarine!=3)
                    || (destroyer==3 && battleship!=4) || (destroyer==3 && aircraftcarrier!=5))){
                        heatMap[row][col] += 1;
                        if(row+2<=9 && guesses[row+2][col]=='.'
                        && (submarine!=3 || (submarine==3 && destroyer!=3) 
                        || (submarine==3 && battleship!=4) || (submarine==3 && aircraftcarrier!=5))){                                                                                    
                            heatMap[row][col] += 1;
                            if(row+3<=9 && guesses[row+3][col]=='.' 
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                heatMap[row][col] += 1;
                                if(row+4<=9 && guesses[row+4][col]=='.' && aircraftcarrier!=5){
                                    heatMap[row][col] += 1;
                                }
                            }
                        }
                    }
                }
                if(col-1>=0 && guesses[row][col-1]=='.' && guesses[row][col]=='.'
                && (patrolboat!=2 || (patrolboat==2 && destroyer!=3) || (patrolboat==2 && battleship!=4)
                || (patrolboat==2 && aircraftcarrier!=5))){//for every open position to the left add 1
                    heatMap[row][col] += 1;
                    if(col-2>=0 && guesses[row][col-2]=='.' 
                    && (destroyer!=3 || (destroyer==3 && submarine!=3)
                    || (destroyer==3 && battleship!=4) || (destroyer==3 && aircraftcarrier!=5))){
                        heatMap[row][col] += 1;
                        if(col-2>=0 && guesses[row][col-2]=='.'
                        && (submarine!=3 || (submarine==3 && destroyer!=3) 
                        || (submarine==3 && battleship!=4) || (submarine==3 && aircraftcarrier!=5))){                                                                                    
                            heatMap[row][col] += 1;
                            if(col-3>=0 && guesses[row][col-3]=='.' 
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                heatMap[row][col] += 1;
                                if(col-4>=0 && guesses[row][col-4]=='.' && aircraftcarrier!=5){
                                    heatMap[row][col] += 1;
                                }
                            }
                        }
                    }
                }
                if(col+1<=9 && guesses[row][col+1]=='.' && guesses[row][col]=='.'
                && (patrolboat!=2 || (patrolboat==2 && destroyer!=3) || (patrolboat==2 && battleship!=4)
                || (patrolboat==2 && aircraftcarrier!=5))){//for every open position to the right add 1
                    heatMap[row][col] += 1;
                    if(col+2<=9 && guesses[row][col+2]=='.' 
                    && (destroyer!=3 || (destroyer==3 && submarine!=3)
                    || (destroyer==3 && battleship!=4) || (destroyer==3 && aircraftcarrier!=5))){
                        heatMap[row][col] += 1;
                        if(col+2<=9 && guesses[row][col+2]=='.'
                        && (submarine!=3 || (submarine==3 && destroyer!=3) 
                        || (submarine==3 && battleship!=4) || (submarine==3 && aircraftcarrier!=5))){                                                                                    
                            heatMap[row][col] += 1;
                            if(col+3<=9 && guesses[row][col+3]=='.' 
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                heatMap[row][col] += 1;
                                if(col+4<=9 && guesses[row][col+4]=='.' && aircraftcarrier!=5){
                                    heatMap[row][col] += 1;
                                }
                            }
                        }
                    }
                }
                if(destroyer!=3 && guesses[row][col]=='.'){//other possible destroyer positions
                    if(row-1>=0 && row+1<=9 && guesses[row-1][col]=='.' && guesses[row+1][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col+1<=9 && guesses[row][col-1]=='.' && guesses[row][col+1]=='.'){
                        heatMap[row][col] += 1;
                    }
                }
                if(submarine!=3 && guesses[row][col]=='.'){//other possible submarine positions
                    if(row-1>=0 && row+1<=9 && guesses[row-1][col]=='.' && guesses[row+1][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col+1<=9 && guesses[row][col-1]=='.' && guesses[row][col+1]=='.'){
                        heatMap[row][col] += 1;
                    }
                }
                if(battleship!=4 && guesses[row][col]=='.'){//other possible battleship positions
                    if(row-1>=0 && row+1<=9 && row+2<=9 
                    && guesses[row-1][col]=='.' && guesses[row+1][col]=='.' && guesses[row+2][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(row-1>=0 && row-2>=0 && row+1<=9
                    && guesses[row-1][col]=='.' && guesses[row-2][col]=='.' && guesses[row+1][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col+1<=9 && col+2<=9 
                    && guesses[row][col-1]=='.' && guesses[row][col+1]=='.' && guesses[row][col+2]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col-2>=0 && col+1<=9
                    && guesses[row][col-1]=='.' && guesses[row][col-2]=='.' && guesses[row][col+1]=='.'){
                        heatMap[row][col] += 1;
                    }
                }
                if(aircraftcarrier!=5 && guesses[row][col]=='.'){//other possible aircraftcarrier positions                    
                    if(row-1>=0 && row+1<=9 && row+2<=9 && row+3<=9
                    && guesses[row-1][col]=='.' && guesses[row+1][col]=='.'
                    && guesses[row+2][col]=='.' && guesses[row+3][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(row-1>=0 && row-2>=0 && row+1<=9 && row+2<=9
                    && guesses[row-1][col]=='.' && guesses[row-2][col]=='.'
                    && guesses[row+1][col]=='.' && guesses[row+2][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(row-1>=0 && row-2>=0 && row-3>=0 && row+1<=9
                    && guesses[row-1][col]=='.' && guesses[row-2][col]=='.'
                    && guesses[row-3][col]=='.' && guesses[row+1][col]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col+1<=9 && col+2<=9 && col+3<=9
                    && guesses[row][col-1]=='.' && guesses[row][col+1]=='.'
                    && guesses[row][col+2]=='.' && guesses[row][col+3]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col-2>=0 && col+1<=9 && col+2<=9
                    && guesses[row][col-1]=='.' && guesses[row][col-2]=='.'
                    && guesses[row][col+1]=='.' && guesses[row][col+2]=='.'){
                        heatMap[row][col] += 1;
                    }
                    if(col-1>=0 && col-2>=0 && col-3>=0 && col+1<=9
                    && guesses[row][col-1]=='.' && guesses[row][col-2]=='.'
                    && guesses[row][col-3]=='.' && guesses[row][col+1]=='.'){
                        heatMap[row][col] += 1;
                    }
                }
                if(guesses[row][col] == 'X'){                   
                    if(row-1>=0 && guesses[row-1][col]=='.'){
                        heatMap[row-1][col] += 50;//next to an X
                        if(row+1<=9 && guesses[row+1][col]=='X'){
                            heatMap[row-1][col] += 100;                            
                        }
                    }
                    if(row+1<=9 && guesses[row+1][col]=='.'){
                        heatMap[row+1][col] += 50;//next to an X
                        if(row-1>=0 && guesses[row-1][col]=='X'){
                            heatMap[row+1][col] += 100;
                        }
                    }
                    if(col-1>=0 && guesses[row][col-1]=='.'){
                        heatMap[row][col-1] += 50;//next to an X
                        if(col+1<=9 && guesses[row][col+1]=='X'){
                            heatMap[row][col-1] += 100;
                        }
                    }
                    if(col+1<=9 && guesses[row][col+1]=='.'){
                        heatMap[row][col+1] += 50;//next to an X
                        if(col-1>=0 && guesses[row][col-1]=='X'){
                            heatMap[row][col+1] += 100;
                        }
                    }
                    int counter1 = 0;//left to right (check only left to right if the ship doesn't fit up and down)
                    int counter2 = 0;//up and down (check only up to down if the ship doesn't fit left to right)
                    int counter3 = 0;//count to the left of the X (0-4)
                    int counter4 = 0;//count to the right of the X (0-4)
                    int counter5 = 0;//count above the X (0-4)
                    int counter6 = 0;//count below the X (0-4)
                    if(col-1>=0 && guesses[row][col-1]=='.'){
                        counter3++;
                        if(col-2>=0 && guesses[row][col-2]=='.'
                        && (destroyer!=3 || submarine!=3 || (destroyer==3 && submarine==3 && battleship!=4) 
                        || (destroyer==3 && submarine==3 && aircraftcarrier!=5))){
                            counter3++;
                            if(col-3>=0 && guesses[row][col-3]=='.'
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                counter3++;
                                if(col-4>=0 && guesses[row][col-4]=='.'
                                && aircraftcarrier!=5){
                                    counter3++;
                                }
                            }
                        }
                    }
                    if(col+1<=9 && guesses[row][col+1]=='.'){
                        counter4++;
                        if(col+2<=9 && guesses[row][col+2]=='.'
                        && (destroyer!=3 || submarine!=3 || (destroyer==3 && submarine==3 && battleship!=4) 
                        || (destroyer==3 && submarine==3 && aircraftcarrier!=5))){
                            counter4++;
                            if(col+3<=9 && guesses[row][col+3]=='.'
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                counter4++;
                                if(col+4<=9 && guesses[row][col+4]=='.'
                                && aircraftcarrier!=5){
                                    counter4++;
                                }
                            }
                        }
                    }
                    if(row-1>=0 && guesses[row-1][col]=='.'){
                        counter5++;
                        if(row-2>=0 && guesses[row-2][col]=='.'
                        && (destroyer!=3 || submarine!=3 || (destroyer==3 && submarine==3 && battleship!=4) 
                        || (destroyer==3 && submarine==3 && aircraftcarrier!=5))){
                            counter5++;
                            if(row-3>=0 && guesses[row-3][col]=='.'
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                counter5++;
                                if(row-4>=0 && guesses[row-4][col]=='.'
                                && aircraftcarrier!=5){
                                    counter5++;
                                }
                            }
                        }
                    }
                    if(row+1<=9 && guesses[row+1][col]=='.'){
                        counter6++;
                        if(row+2<=9 && guesses[row+2][col]=='.'
                        && (destroyer!=3 || submarine!=3 || (destroyer==3 && submarine==3 && battleship!=4) 
                        || (destroyer==3 && submarine==3 && aircraftcarrier!=5))){
                            counter6++;
                            if(row+3<=9 && guesses[row+3][col]=='.'
                            && (battleship!=4 || (battleship==4 && aircraftcarrier!=5))){
                                counter6++;
                                if(row+4<=9 && guesses[row+4][col]=='.'
                                && aircraftcarrier!=5){
                                    counter6++;
                                }
                            }
                        }
                    }
                    if(counter3>=counter4 && counter3>=counter5 && counter3>=counter6){
                        if(col-1>=0 && guesses[row][col-1]=='.'){
                            heatMap[row][col-1] += 10;
                        }
                    }
                    if(counter4>=counter3 && counter4>=counter5 && counter4>=counter6){
                        if(col+1<=9 && guesses[row][col+1]=='.'){
                            heatMap[row][col+1] += 10;
                        }
                    }
                    if(counter5>=counter3 && counter5>=counter4 && counter5>=counter6){
                        if(row-1>=0 && guesses[row-1][col]=='.'){
                            heatMap[row-1][col] += 10;
                        }
                    }
                    if(counter6>=counter3 && counter6>=counter4 && counter6>=counter5){
                        if(row+1<=9 && guesses[row+1][col]=='.'){
                            heatMap[row+1][col] += 10;
                        }
                    }
                    counter1 = 1 + counter3 + counter4;
                    counter2 = 1 + counter5 + counter6;
                    if(counter2>counter1){
                        if(counter5>counter6 && row-1>=0 && guesses[row-1][col]=='.'){
                            heatMap[row-1][col] += 5;
                        }
                        else if(counter6>counter5 && row+1<=9 && guesses[row+1][col]=='.'){
                            heatMap[row+1][col] += 5;
                        }
                        else if(counter5==counter6 && row-1>=0 && row+1<=9 
                        && guesses[row-1][col]=='.' && guesses[row+1][col]=='.'){
                            heatMap[row-1][col] += 5;
                            heatMap[row+1][col] += 5;
                        }
                    }
                    if(counter1>counter2){
                        if(counter3>counter4 && col-1>=0 && guesses[row][col-1]=='.'){
                            heatMap[row][col-1] += 5;
                        }
                        else if(counter4>counter3 && col+1<=9 && guesses[row][col+1]=='.'){
                            heatMap[row][col+1] += 5;
                        }
                        else if(counter3==counter4 && col-1>=0 && col+1<=9 
                        && guesses[row][col-1]=='.' && guesses[row][col+1]=='.'){
                            heatMap[row][col-1] += 5;
                            heatMap[row][col+1] += 5;
                        }
                    }        
                    if(patrolboat==2 && destroyer==3 && submarine==3 && battleship==4 && aircraftcarrier!=5){
                        if(counter1>=5 && counter2<5){
                            if(col-1>=0 && guesses[row][col-1]=='.'){
                                heatMap[row][col-1] += 1000;
                            }
                            if(col+1<=9 && guesses[row][col+1]=='.'){
                                heatMap[row][col+1] += 1000;
                            }
                        }
                        if(counter1<5 && counter2>=5){
                            if(row-1>=0 && guesses[row-1][col]=='.'){
                                heatMap[row-1][col] += 1000;
                            }
                            if(row+1<=9 && guesses[row+1][col]=='.'){
                                heatMap[row+1][col] += 1000;
                            }
                        }
                    }
                    if(patrolboat==2 && destroyer==3 && submarine==3 && battleship!=4){
                        if(counter1>=4 && counter2<4){
                            if(col-1>=0 && guesses[row][col-1]=='.'){
                                heatMap[row][col-1] += 1000;
                            }
                            if(col+1<=9 && guesses[row][col+1]=='.'){
                                heatMap[row][col+1] += 1000;
                            }
                        }
                        if(counter1<4 && counter2>=4){
                            if(row-1>=0 && guesses[row-1][col]=='.'){
                                heatMap[row-1][col] += 1000;
                            }
                            if(row+1<=9 && guesses[row+1][col]=='.'){
                                heatMap[row+1][col] += 1000;
                            }
                        }
                    }
                    if(patrolboat==2 && (destroyer!=3 || submarine!=3)){
                        if(counter1>=3 && counter2<3){
                            if(col-1>=0 && guesses[row][col-1]=='.'){
                                heatMap[row][col-1] += 1000;
                            }
                            if(col+1<=9 && guesses[row][col+1]=='.'){
                                heatMap[row][col+1] += 1000;
                            }
                        }
                        if(counter1<3 && counter2>=3){
                            if(row-1>=0 && guesses[row-1][col]=='.'){
                                heatMap[row-1][col] += 1000;
                            }
                            if(row+1<=9 && guesses[row+1][col]=='.'){
                                heatMap[row+1][col] += 1000;
                            }
                        }
                    }                                                           
                }
            }
            //char a = (char)((int)'A'+row);                    
            //guess = a + Integer.toString(col+1);            
        }

        /*for(int i=1;i<=heatMap.length;i++){
            System.out.print(String.format("\t %s", i));
        }
        System.out.println();
        System.out.println();
        for(int row=0;row<heatMap.length;row++){
            System.out.print(""+(char)('A'+row));
            for(int col=0;col<heatMap[row].length;col++){                               
                System.out.print(String.format("\t %s", heatMap[row][col]));

            }
            System.out.println();
        }
        //char a = (char)((int)'A'+row);
        //String guess = a + Integer.toString(col+1);
        System.out.println("-------------------------------------------------------------------------------------------");        

        for(int i=1;i<=guesses.length;i++){
            System.out.print(String.format("\t %s", i));
        }
        System.out.println();
        System.out.println();
        for(int row=0;row<guesses.length;row++){
            System.out.print(""+(char)('A'+row));
            for(int col=0;col<guesses[row].length;col++){                               
                System.out.print(String.format("\t %s", guesses[row][col]));

            }
            System.out.println();
        }*/

        int high = 0;
        int high2 = 0;
        int specialCounter = 0;
        int[][] newarray = {
                ///////1  2  3  4  5  6  7  8  9  10
                /*A*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*B*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*C*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*D*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*E*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*F*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*G*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*H*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*I*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                /*J*/{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
                  
        for(int row=0;row<heatMap.length;row++){
            for(int col=0;col<heatMap.length;col++){
                if(heatMap[row][col]>high){
                    high=heatMap[row][col];
                }
            }
        }
        for(int row=0;row<heatMap.length;row++){
            for(int col=0;col<heatMap.length;col++){
                if(heatMap[row][col]==high){
                    specialCounter++;
                    newarray[row][col]=high;
                }
            }
        }
        if(specialCounter>1){
            for(int row=0;row<newarray.length;row++){
                for(int col=0;col<newarray.length;col++){
                    if(high!=0 && newarray[row][col]==high){                        
                        if(row-1>=0 && guesses[row-1][col]=='.'){
                        newarray[row][col]++;
                        }
                        if(row+1<=9 && guesses[row+1][col]=='.'){
                        newarray[row][col]++;
                        }
                        if(col-1>=0 && guesses[row][col-1]=='.'){
                        newarray[row][col]++;
                        }
                        if(col+1<=9 && guesses[row][col+1]=='.'){
                        newarray[row][col]++;
                        }
                    }
                }
            }
        }
        for(int row=0;row<newarray.length;row++){
            for(int col=0;col<newarray[row].length;col++){
                if(newarray[row][col]>high2){
                    high2=newarray[row][col];
                    char a = (char)((int)'A'+row);
                    guess = a + Integer.toString(col+1);
                }
            }
        }
        /*System.out.println("-------------------------------------------------------------------------------------------");        

        for(int i=1;i<=newarray.length;i++){
            System.out.print(String.format("\t %s", i));
        }
        System.out.println();
        System.out.println();
        for(int row=0;row<newarray.length;row++){
            System.out.print(""+(char)('A'+row));
            for(int col=0;col<newarray[row].length;col++){                               
                System.out.print(String.format("\t %s", newarray[row][col]));
            }
            System.out.println();
        }
        System.out.println("next guess at: " + guess);*/
        return guess;
    }
} 

