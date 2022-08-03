// package class 32(rec);
public class pipe_que {
    static int solcount;
    public static void main(String[] args) {
        ques();
    }

    static void ques(){
        int r=2;
        int c=2;
        solcount=1;
        
        int[][] ans=new int[8][8];

        tour(r,c,ans,1,1);
    }

    static void tour(int cr,int cc,int[][] ans,int count,int cnt){
        // System.out.println(count);
        // if(count==ans.length*ans[0].length){
        if(cnt==ans.length*ans[0].length){
        // if(count==60){
            System.out.println("=="+solcount+++"************");

            for(int i=0;i<ans.length;i++){
                for(int j=0;j<ans[0].length;j++){
                    System.out.print(ans[i][j]+"     ");
                }
                System.out.println("");
            }

            return;

        }

        int[][] src={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,1}};
        // int[][] pipe={{0,2},{2,2},{-2,2},{2,0}};
        int[][] pipe={{0,1},{-1,0},{0,-1},{1,0}};

        ans[cr][cc]=count;
        
        for(int i=0;i<src.length;i++){
            int sr=cr+src[i][0];
            int sc=cc+src[i][1];

            if(issafe(sr,sc,ans)){
                ans[sr][sc]=count;
                cnt++;
            }

            for(int j=0;j<pipe.length;j++){
                int r=sr+pipe[j][0];
                int c=sc+pipe[j][1];
                
                if(issafe(r,c,ans)){
                    tour(r, c, ans, count+1,cnt+1);
                }
            }
        }
    }

    static boolean issafe(int sr,int sc,int[][] ans){
        if(sr<0 || sc<0 || sr>=ans.length || sc>=ans[0].length || ans[sr][sc]!=0) return false;
        
        return true;
    }

}
