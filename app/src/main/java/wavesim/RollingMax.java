package wavesim;

import java.util.Arrays;

// Takes a rolling max of the absolute values of the array
public class RollingMax {

    private double[][] array;

    // size is the sample size of arrays
    public RollingMax(int size) {
        array = new double[size][];
        Arrays.fill(array, new double[0]);
    }

    public void add(double[] value) {
        System.arraycopy(array, 0, array, 1, array.length-1);
        array[0] = value;
    }

    public double getMax() {
        double max = Arrays.stream(array).flatMapToDouble(Arrays::stream).map(Math::abs).max().orElse(1);
        return max == 0 ? 1 : max;
    }

    public void reset() {
        Arrays.fill(array, new double[0]);
    }

}
