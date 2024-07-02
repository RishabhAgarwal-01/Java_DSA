import java.util.Arrays;
public class TrappingRainwater {
    public static boolean MinimumBar(int BarHeight[]){
        if(BarHeight.length<=2)
          return false;
        else
          return true;
    }
    public static void calculateTrappedWater(int BarHeight[]){
        int num=BarHeight.length;
        int left_max[]= new int[num];
        int right_max[]= new int[num];
        left_max[0]=BarHeight[0];
        right_max[num-1]= BarHeight[num-1];
        for(int i=1;i<num;i++){
            //left max boundaries auxilary array
            if(BarHeight[i]>left_max[i-1])
               left_max[i]=BarHeight[i];
            else
               left_max[i]=left_max[i-1];

            //right max boundary auxilary array
            if(BarHeight[num-i-1]>right_max[num-i])
               right_max[num-i-1]=BarHeight[num-i-1];
            else
               right_max[num-i-1]=right_max[num-i];
        }

        System.out.println("Left Max boundary "+ Arrays.toString(left_max));
        System.out.println("Right Max boundary "+Arrays.toString(right_max));
        //rainwater level trapped calculation for each bar
          int waterLevel[]= new int[num];
          int trappedWater=0, width=1;
          for(int i=0;i<num;i++){
            waterLevel[i]= Math.min(left_max[i], right_max[i]);
            trappedWater+=(waterLevel[i]-BarHeight[i])*width;
          }
          System.out.println(trappedWater);
    }
    public static void main(String[] args) {
      int num[]={4,2,0,6,3,2,5};
      if(MinimumBar(num))
        calculateTrappedWater(num);
      else
        System.out.println("The minimum number of bars are less than 2");
    }
}
