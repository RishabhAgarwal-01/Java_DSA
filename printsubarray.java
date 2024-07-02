
public class printsubarray {
//WE USED THE BRUTE FORCE APPRAOCH TO SOLVE THE MAX SUBARRAY SUM Problem
    public static int subarray(int arr[]){
        int greatestTotal=0;
        for(int i=0;i<arr.length;i++)
        {
            int start_index=i;

            for(int j=0;j<arr.length;j++)
            {
                int end_index=j;
                 int sum=0;
                for(int k=start_index;k<=end_index;k++)
                {
                    System.out.print(arr[k]+" ");
                    sum=sum+arr[k];
                }
                if(sum>greatestTotal)
                   greatestTotal=sum;
                System.out.println();
            }
            System.out.println();
        }
        return greatestTotal;
    }
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,6};
        int greatestTotalSumOfSubarray= subarray(arr);
        System.out.println(greatestTotalSumOfSubarray);
    }
}
