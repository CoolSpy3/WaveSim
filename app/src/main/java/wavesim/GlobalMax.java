package wavesim;

import java.util.Arrays;

// Takes the absolute max over the lifetime of the program
public class GlobalMax {

    private double max = 0;
    private int trim;

    // trim is the number of elements to skip at the beginning of the array (I added this to remove some noise in the first few elements)
    public GlobalMax(int trim) {
        this.trim = trim;
    }

    public void add(double[] value) {
        max = Math.max(max, Arrays.stream(value).skip(trim).map(Math::abs).max().orElse(0));
    }

    public double getMax() {
        return max == 0 ? 1 : max;
    }

    public void reset() {
        max = 0;
    }

}
