public class enter {
     char[][] Nul(){
        char[][] fMap = new char[4][7] ;
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if ((j%2==0) && (i != 0)){
                    fMap[i][j] = '|';
                }else if((j%2 == 1)){
                    fMap[i][j] = '_';
                }else{
                    fMap[i][j] = ' ';
                }
            }
        }
        return fMap;
    }

    void soutMap(char[][] chars){
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}


//  _ _ _
// |_|_|_|
// |_|_|_|
// |_|_|_|
