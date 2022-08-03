
public class sudoku {

    public static void main(String[] args) {

        int[][] sudo={  {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
                        {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                        {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                        {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                        {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                        {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                        {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        sudoku(sudo,0,0);
        // System.out.println(issafe(sudo, 2, 0, 4));
    
    }
    static int count=0;
    static void sudoku(int[][] sudo, int r,int c){
        if(r==sudo.length-1 && c==sudo[0].length){
            count++;
            System.out.println("*********"+count+"*************");
            for(int i=0;i<sudo.length;i++){
                for(int j=0;j<sudo[0].length;j++){
                    System.out.print(sudo[i][j]+"  ");
                }
                System.out.println("");
            }

            return;
        }

        if(c==sudo[0].length){
            r++;
            c=0;
        }

        if(sudo[r][c]!=0){
            sudoku(sudo, r, c+1);
        }else{
            for(int val=1;val<=9;val++){
                if(issafe(sudo, r, c,val)){
                    sudo[r][c]=val;
                    sudoku(sudo, r, c+1);
                    sudo[r][c]=0;
                }
                
            }
        }
        
        // sudo[r][c]=0;
    }

    static boolean issafe(int[][] sudo,int r,int c,int count){
        // if(r<0 || c<0 || r>=sudo.length || c>=sudo[0].length || sudo[r][c]!=0) return false;

        for(int i=0;i<sudo.length;i++){
            if(sudo[i][c]==count) return false;
            if(sudo[r][i]==count) return false;
        }
        // for(int i=0;i<sudo[0].length;i++){
        //     if(sudo[r][i]==count) return false;
        // }

        int sr=r-r%3;
        int sc=c-c%3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudo[i][j]==count){
                    return false;
                }
            }
        }

        return true;

    } 
}
