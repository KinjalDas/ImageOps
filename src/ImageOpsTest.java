import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.awt.Color;

class ImageOpsTest extends ImageOps {

	@Test
	void testCreateImage1() {
		ImageOps img1=new ImageOps();
		int[][] result1=img1.CreateImage1();
		assertEquals(1,checkPixels(result1));
	}

	@Test
	void testCreateImage2() {
		ImageOps img1=new ImageOps();
		int[][] result1=img1.CreateImage1();
		assertEquals(1,checkPixels(result1));
	}

	@Test
	void testCreateImage3() {
		ImageOps img1=new ImageOps();
		int[][] result1=img1.CreateImage1();
		assertEquals(1,checkPixels(result1));
	}

	@Test
	void testOperations() {
		ImageOps img1=new ImageOps();
		int[][] img=img1.CreateImage1();
		int resultOps=img1.Operations(img);
		assertEquals(1,resultOps);
	}

	int checkPixels(int[][] result) {
		int count=0;
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				Color mycolor= new Color(result[i][j]);
				if(mycolor.getRed()<0||mycolor.getRed()>255||mycolor.getGreen()<0||mycolor.getGreen()>255||mycolor.getBlue()<0||mycolor.getBlue()>255) {
					return 0;
				}
				count++;
			}
		}
		if (count!=625) {
			return 0;
		}
		return 1;
	}
}
