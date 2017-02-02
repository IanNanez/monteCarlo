
import java.util.Scanner;

public class RandomWalks{

  public static void main(String [] args){


    //int n_samples = Integer.parseInt(args[0]);
    //int n = Integer.parseInt(args[1]);
    int seed = Integer.parseInt(args[0]);
    int l = Integer.parseInt(args[1]);
    int attempts = Integer.parseInt(args[2]);





    //randomWalk(n_samples, n, seed);

    System.out.println(checkRandom2D(seed, l, attempts)*100 + "%");


  }

  public static void randomWalk(int n_samples, int n, int seed){

    double xLoc = 0;
    double yLoc = 0;

    double [] xDistances = new double [n_samples];
    double [] yDistances = new double [n_samples];

    double [] xPosDistances = new double [n_samples];
    double [] yPosDistances = new double [n_samples];

    double rXSum = 0;
    double rYSum = 0;
    double rAvgX = 0;
    double rAvgY = 0;

    double xSum = 0;
    double ySum = 0;
    double xAvg = 0;
    double yAvg = 0;


    RandomVal r = new RandomVal(seed);

    for(int i=0; i<n_samples; i++){
      xLoc = 0;
      yLoc = 0;
      for(int j=0; j<n ; j++){
        //generate one step
        int ir =  (int) (r.generateRandom()*4.0);
        //int ir = (int) (Math.random() * 4.0);

        switch (ir) {
          case 1:  xLoc++;
          break;
          case 2:  yLoc++;
          break;
          case 3:  xLoc--;
          break;
          default: yLoc--;
          break;
        }
        //System.out.print("(" + xLoc + "," + yLoc+ ") ");
      }
      xDistances[i] = xLoc;
      yDistances[i] = yLoc;

      //xSum += xLoc;
      //ySum += yLoc;
      //xSqrSum += xSum*xSum;
      //ySqrSum += ySum*ySum;

      //System.out.println("(" + xLoc + "," + yLoc+ ") ");

    }

    //calculae results

    //calculate rAvgY and rAvgX
    //calculate xAvg and yAvg

    for(int i=0; i<n_samples; i++){
      //System.out.println(Math.abs(xDistances[i]));
      rXSum += Math.abs(xDistances[i]);
      rYSum += Math.abs(yDistances[i]);

      xPosDistances[i] = Math.abs(xDistances[i]);
      yPosDistances[i] = Math.abs(yDistances[i]);

      xSum += xDistances[i];
      ySum += yDistances[i];
    }

    rAvgX = rXSum/n_samples;
    rAvgY = rYSum/n_samples;

    xAvg = xSum/n_samples;
    yAvg = ySum/n_samples;

    //calculate results
    //xAvg = xSum/n_samples;
    //yAvg = ySum/n_samples;
    //print results
    System.out.println(rAvgX);
    System.out.println(rAvgY);
    System.out.println(xSum);
    System.out.println(ySum);

    SimpleStats xVals = new SimpleStats(xDistances);
    SimpleStats yVals = new SimpleStats(yDistances);

    System.out.println(xVals.getStdDev());
    System.out.println(yVals.getStdDev());

    SimpleStats xPVals = new SimpleStats(xPosDistances);
    SimpleStats yPVals = new SimpleStats(yPosDistances);

    System.out.println(xPVals.getStdDev());
    System.out.println(yPVals.getStdDev());
    //System.out.println(xSum);
    //System.out.println(ySum);


  }

  public static double checkRandom2D(int seed, int l, int attempts){



    boolean [][] lattice = new boolean [l][l];
    RandomVal r = new RandomVal(seed);

    double ll = l;

    for(int i=0; i<attempts; i++){
      int x =  (int) (r.generateRandom()*ll);
      int y =  (int) (r.generateRandom()*ll);
      //int x = (int) (Math.random() * ll);
      //int y = (int) (Math.random() * ll);
      lattice[x][y] = true;
    }

/*
    for(int i=0; i<l; i++){
      for(int j=0; j<l; j++){
        //int x =  (int) (r.generateRandom()*ll);
        //int y =  (int) (r.generateRandom()*ll);

        int x = (int) (Math.random() * ll);
        int y = (int) (Math.random() * ll);
        lattice[x][y] = true;
        //System.out.println("<" + x + ", " + y + ">");
      }
    }
    */
    int sum = 0;
    for(int i=0; i<l; i++){
      for(int j=0; j<l; j++){
        if(lattice[i][j])
        sum++;
      }
    }


    return sum/(ll*ll);


  }


}
