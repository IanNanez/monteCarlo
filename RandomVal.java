public class RandomVal{

  public int ibm;
  private int mult;
  private int modulo;
  private double rmodulo;

  public RandomVal(int s){
    mult = 1277;
    modulo = (int) Math.pow(2,17);
    rmodulo = modulo;
    if(s%2 ==0){
      s--;
    }
    ibm = s;
  }

  public double generateRandom(){

    ibm = ibm * mult;
    ibm = ibm % modulo;
    //System.out.println(ibm);
    return ibm/rmodulo;

  }



}
