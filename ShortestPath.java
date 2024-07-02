public class ShortestPath {
   public static void calculateCoordinate(String str)
   {
       int xAxis=0, yAxis=0;
       str.trim();
      for(int i=0;i<str.length();i++)
      {
         char direction = str.charAt(i);
         if(direction == 'E')
            xAxis++;
         else if(direction=='W')
            xAxis--;
         else if(direction=='N')
            yAxis++;
         else if(direction=='S')
            yAxis--;
         else
           continue;
      }
        calculateDisplacement(xAxis, yAxis);
   } 
   public static void calculateDisplacement(int x, int y)
   {
       double temp =Math.pow((x-0), 2)+ Math.pow((y-0), 2);
       double displacement= Math.sqrt(temp);
       System.out.println(displacement);
   }
   public static void main(String[] args) {
    calculateCoordinate("WNEENESENNN");
   }
}
