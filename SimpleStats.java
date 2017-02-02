public class SimpleStats{
    double[] data;
    int size;

    public SimpleStats(double[] d){
        data = d;
        size = d.length;
    }

    public double getMean(){
        double sum = 0.0;
        for(double a : data)
            sum += a;
        return sum/size;
    }

    public double getVariance(){
        double mean = getMean();
        double temp = 0;
        for(double a :data)
            temp += (a-mean)*(a-mean);
        return temp/size;
    }

    public double getStdDev(){
        return Math.sqrt(getVariance());
    }


}
