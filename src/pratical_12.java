import java.util.Random;

public class pratical_12 {
    private static int mcsOn3(int[] X){
        int n=X.length;
        int maxsofar=0;
        for(int low=0;low<n;low++){
            for(int high=1;high<n;high++){
                int sum=0;

                for(int r=1;r<high;r++){
                    sum+=X[r];

                    if(sum>maxsofar){
                        maxsofar=sum;
                    }

                }
            }


        }
        return maxsofar;


    }
    private static int mcsOn2A(int []X){
        int n=X.length;
        int maxsofar=0;
        for(int low=0;low<n;low++){
            int sum=0;
            for(int r=1;r<n;r++){
                sum+=X[r];

                if(sum>maxsofar){
                    maxsofar=sum;
                }
            }
        }
        return maxsofar;

    }

    private static int mcsOn2B(int []X){
        int n=X.length;
        int d=X[0]*(n+1);
        int []sumTo=new int[d];
        for(int i=0;i<n;i++){

            sumTo[i]=sumTo[i-1]+X[i];


        }
        int maxsofar=0;
        for(int low=0;low<n;low++) {
            for (int high = 1; high < n; high++) {
                int sum;
                if(low==0){
                    sum=sumTo[high];

                }else {
                    sum = sumTo[high] - sumTo[low - 1];
                }
                if (sum > maxsofar) {
                    maxsofar = sum;
                }
            }

        }
        return maxsofar;

    }
    private static int mcsOn(int[]X){
        int N=X.length;
        double maxSoFar=0.0;
        double maxToHere=0.0;
        for(int i=1;i<N;N++){
            maxToHere=Math.max(maxToHere+X[i],0.0);
            maxSoFar=Math.max(maxSoFar,maxToHere);
        }
        return (int) maxSoFar;



    }
    public static void main(String[]args){
        int n=20;
        Random rand=new Random();
        int[] x=new int[n];
        for(int k=0;k<n;k++){
            int r=rand.nextInt(n)+1;
            int p=(int)Math.pow(-1,rand.nextInt(3)+2);
            x[k]=r*p;
        }

        int CountP=0;
        int CountM=0;
        for(int f:x){
            if(f<0){
                CountM+=1;
            }else{
                CountP+=1;
            }
        }
        System.out.println( mcsOn3(x) + mcsOn3(x));
        System.out.println( mcsOn(x) + mcsOn(x));
        System.out.println( mcsOn2B(x) + mcsOn2B(x));
        System.out.println( mcsOn2A(x) + mcsOn2A(x));

    }
}
