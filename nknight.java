// package class_32(rec);
public class nknight {
    static int solcount;
    public static void main(String[] args) {
        ques();
    }

    static void ques(){

        int r=2;
        int c=2;
        solcount=1;
        int[][] ans=new int[5][5];

        tour(r,c,ans,1);
    }

    static void tour(int sr,int sc,int[][] ans,int count){
        // System.out.println(count);
        if(count==ans.length*ans[0].length){
            System.out.println("=="+solcount+++"*********");
            // solcount++;
            for(int i=0;i<ans.length;i++){
                for(int j=0;j<ans[0].length;j++){
                    System.out.print(ans[i][j]+"\t");
                }
                System.out.println("");
            }

            return;
        }

        int[][] direc={{-2,1},{-1,+2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

        ans[sr][sc]=count;

        for(int i=0;i<8;i++){
            int r=direc[i][0];
            int c=direc[i][1];

            if(issafe(sr+r, sc+c,ans)){
                tour(sr+r, sc+c, ans, count+1); 
            }
        
        }

        // if(issafe(sr-2, sc+1,ans)){
        //     tour(sr-2, sc+1, ans, count+1); //1
        // }
        // if(issafe(sr-1, sc+2,ans)){
        //     tour(sr-1, sc+2, ans, count+1); //2
        // }

        // if(issafe(sr+1, sc+2,ans)){
        //     tour(sr+1, sc+2, ans, count+1);// 3
        // }

        // if(issafe(sr+2, sc+1,ans)){
        //     tour(sr+2, sc+1, ans, count+1);//4
        // }

        // if(issafe(sr+2, sc-1,ans)){
        //     tour(sr+2, sc-1, ans, count+1);//5
        // }

        // if(issafe(sr+1, sc-2,ans)){
        //     tour(sr+1, sc-2, ans, count+1);//6
        // }

        // if(issafe(sr-1, sc-2,ans)){
        //     tour(sr-1, sc-2, ans, count+1);//7
        // }

        // if(issafe(sr-2, sc-1,ans)){
        //     tour(sr-2, sc-1, ans, count+1);//8
        // }
        
        ans[sr][sc]=0;



    }
    static boolean issafe(int sr,int sc,int[][] ans){
        if(sr<0 || sc<0 || sr>=ans.length || sc>=ans[0].length || ans[sr][sc]!=0) return false;

        return true;
    }

}
