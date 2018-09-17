public class test{
  public static long a(long num, int c){
    if( num <= 9)
      return num;
    return a(num/10,69) + num%10;
  
  
  }

}