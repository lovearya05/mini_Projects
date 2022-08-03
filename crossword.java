import java.util.Arrays;
public class crossword{
    
    public static void main(String[] args){

        char[][] grid={
            "+++++++++-".toCharArray(),
            "-++++++++-".toCharArray(),
            "-------++-".toCharArray(),
            "-++++++++-".toCharArray(),
            "-++++++++-".toCharArray(),
            "-++++-----".toCharArray(),
            "------+++-".toCharArray(),
            "-++++++++-".toCharArray(),
            "+---------".toCharArray(),
            "++++++++++".toCharArray()
        };

        String[] words={"physics","chemistry","maths","history","civics","geography"};

        solve(grid,words,0);
    }

    static int count=0;

    static void solve(char[][] grid,String[] words,int idx){


        if(idx==words.length){
            count++;
            System.out.println("===="+count+"====");
            for(char[] arr:grid){
                System.out.println(Arrays.toString(arr));
            }

            return;
        }


        String word=words[idx];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(cwpv(grid,i,j,word)){
                    boolean[] usedplace=placev(grid,i,j,word);
                    solve(grid, words, idx+1);
                    unplacev(grid,i,j,usedplace);
                }
                if(cwph(grid,i,j,word)){
                    boolean[] usedplace=placeh(grid,i,j,word);
                    solve(grid, words, idx+1);
                    unplaceh(grid,i,j,usedplace);
                }

            }
        }


    }
    // unplace the whole word on vertically and horizontally

    static void unplacev(char[][] grid,int r,int c,boolean[] usedplace){

        for(int i=0;i<usedplace.length;i++){
            if(usedplace[i]){
                grid[r+i][c]='-';
            }
        }
    }

    static void unplaceh(char[][] grid,int r,int c,boolean[] usedplace){

        for(int j=0;j<usedplace.length;j++){
            if(usedplace[j]){
                grid[r][c+j]='-';
            }
        }
    }

    // place the whole word on vertically and horizontally

    static boolean[] placev(char[][] grid,int r,int c,String word){

        boolean[] usedplace=new boolean[word.length()];

        for(int i=0;i<word.length();i++){

            char ch_w=word.charAt(i);
            if(grid[r+i][c]=='-'){
                grid[r+i][c]=ch_w;
                usedplace[i]=true;
            }

        }

        return usedplace;

    }

    static boolean[] placeh(char[][] grid,int r,int c,String word){

        boolean[] usedplace=new boolean[word.length()];

        for(int j=0;j<word.length();j++){

            char ch_w=word.charAt(j);
            if(grid[r][c+j]=='-'){
                grid[r][c+j]=ch_w;
                usedplace[j]=true;
            }

        }

        return usedplace;

    }


    // check safe or note for vertical and hrozontal
    static boolean cwpv(char[][] grid,int r,int c,String word){

        for(int i=0;i<word.length();i++){
            if(i+r==grid.length) return false;

            char grid_val=grid[i+r][c];
            char ch_w=word.charAt(i);

            if(grid_val!='-' && grid_val!=ch_w) return false;

        }

        if(r-1>=0 && grid[r-1][c]!='+'){
            return false;
        }else if(r+word.length()<grid.length && grid[r+word.length()][c]!='+'){
            return false;
        }

        return true;

    }

    static boolean cwph(char[][] grid,int r,int c,String word){

        for(int j=0;j<word.length();j++){
            if(j+c==grid[0].length) return false;

            char grid_val=grid[r][j+c];
            char ch_w=word.charAt(j);

            if(grid_val!='-' && grid_val!=ch_w) return false;

        }

        if(c-1>=0 && grid[r][c-1]!='+'){
            return false;
        }else if(c+word.length()<grid[0].length && grid[r][c+word.length()]!='+'){
            return false;
        }

        return true;

    }
}