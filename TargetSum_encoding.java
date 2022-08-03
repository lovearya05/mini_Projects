// package class33(rec);

public class TargetSum_encoding {
    public static void main(String[] args) {
        // targetSum();
        encoding("123","");
    }

    static void encoding(String str,String asf){

        if(str.length()==0){
            System.out.println(asf.substring(0,asf.length()-1));
            return;
        }

        if(str.length()==1){
            char ch1=str.charAt(0);
            int num1=ch1-'0';

            if(num1==0) return;

            char ans1=(char)('a'+num1-1);
            encoding(str.substring(1),asf+ans1+"-");

        }else{
            
            char ch1=str.charAt(0);
            int num1=ch1-'0';

            if(num1==0) return;

            char ans1=(char)('a'+num1-1);
            encoding(str.substring(1), asf+ans1+"-");

            // for 2 digits
            char ch2=str.charAt(1);
            int num2=ch2-'0';
            int orgnum=num1*10+num2;

            if(orgnum>26) return;

            char ans2=(char)('a'+orgnum-1);
            encoding(str.substring(2), asf+ans2+"-");

        }
    }

    static void targetSum(){
        int[] arr={10,20,30,40,50};
        int target=80;
        int count=target(arr,0,target,"");
        System.out.println(count);
    }

    static int target(int[] arr,int idx,int target,String ans){
        if(target==0){
            System.out.println(ans);
            return 1;
        }
        if(target<0 || idx>=arr.length) return 0;

        int count=0;
        count+=target(arr,idx+1,target-arr[idx],ans+arr[idx]+",");
        count+=target(arr,idx+1,target,ans);
        
        return count;

    }

}
