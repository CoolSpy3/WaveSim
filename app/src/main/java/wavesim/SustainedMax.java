package wavesim;

import java.util.Arrays;

// Similar to GlobalMax, but requires a sustained max over a certain number of elements (specified in constructor)
public class SustainedMax {

    private double max = 0;
    private double[][] array;

    public SustainedMax(int size) {
        array = new double[size][];
        Arrays.fill(array, new double[0]);
    }

    public void add(double[] value) {
        System.arraycopy(array, 0, array, 1, array.length-1);
        array[0] = value;
        max = Math.max(max, Arrays.stream(array).mapToDouble(arr -> Arrays.stream(arr).map(Math::abs).max().orElse(0)).min().orElse(0));
    }

    public double getMax() {
        return max == 0 ? 1 : max;
    }

    public void reset() {
        max = 0;
    }

}
