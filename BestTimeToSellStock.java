public class BestTimeToSellStock{
    public static String calculateDailyProfit(int prices[])
     {
        int maxProfit=0, BuyingPrice=prices[0];
        for(int i=1;i<prices.length;i++) //starting from 1st index to compare it with buying price a day before 
        //at least
        {
            if(BuyingPrice < prices[i]){ //sell only at profit otherwise update the buying price
             int TodayProfit= prices[i]-BuyingPrice; 
             maxProfit=Math.max(TodayProfit, maxProfit);    
            }
            else{
                BuyingPrice=prices[i];
            }
        }
        return "The max profit is :"+ maxProfit+"\nselling price is :"+ (maxProfit+BuyingPrice)+"\nbuying price is: "+ BuyingPrice;
     }
     public static void main(String[] args) {
        int num[]={7,1,5,3,6,4};
        System.out.println(calculateDailyProfit(num));
     }
}