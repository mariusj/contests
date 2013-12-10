import java.io.IOException;


public class ImageScannerVisExt extends ImageScannerVis {
	private ImageScanner imgs;

	public ImageScannerVisExt(ImageScanner imgs, String seed) {
		super(seed);
    	ImageScannerVis.vis = false;
    	ImageScannerVis.SZ = 9;
    	ImageScannerVis.manual = false; 
		ImageScannerVis.hint = false;
		ImageScannerVis.del = 100;
		this.imgs = imgs;
		ImageToScan.vis = this;
        System.out.println("Score = "+runTest(seed));
	}
	
    String[] restore(int H, int W, int nb, int nLetter) throws IOException {
    	return imgs.restore(H, W, nb, nLetter);
    }
    
    @Override
    public double runTest(String seed) {
    	if (this.imgs == null)
    		return 0.0;
    	return super.runTest(seed);
    }
	

}
