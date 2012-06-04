package histogramme;

public class GaussianDistributed extends UniformlyDistributed {
	@Override
	protected int draw(int n) {
		return (int) (rnd.nextGaussian() * n/2)+n/2;
	}
}
