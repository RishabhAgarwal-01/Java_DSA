import java.util.Arrays;

public class BestTimeToSellTheStockTypeII {
    public static int maxProfit(int[] prices) {
         int length = prices.length;
         int buyingPrice []= Arrays.copyOfRange(prices,0, length-1);
//         System.out.println(Arrays.toString(buyingPrice));
         int  sellingPrice []= Arrays.copyOfRange(prices,1, length);
//         System.out.println(Arrays.toString(sellingPrice));
         int profit=0;
         for(int i=0;i<length-1;i++) {
             int dailyProfit = sellingPrice[i] - buyingPrice[i];
             if(dailyProfit>0){
                 profit += dailyProfit;
             }
         }
         return profit;
    }

    public static void main(String[] args) {
        int prices[]= {1,2,3,4,5};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}
