package net.sf.image4j.codec.bmp;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class BMPDecoderTest {
	
	InputStream is;
	
	String filename = "/monochrome.bmp";
	
	@Before
	public void setUp() throws Exception {
		is = getClass().getResourceAsStream(filename);
	}

	@After
	public void tearDown() throws Exception {
		if(is != null){
			is.close();
		}
	}

	@Test
	public void test() throws Exception {
		assertNotNull("Test file missing", 
	               getClass().getResource(filename));
		BufferedImage img = BMPDecoder.read(is);
		
		javax.swing.JFrame f = new javax.swing.JFrame("test");
		f.getContentPane().setBackground(Color.green);
		f.getContentPane().setLayout(new java.awt.BorderLayout(0, 0));
		f.getContentPane().add(
				java.awt.BorderLayout.CENTER,
				new javax.swing.JLabel(
						new javax.swing.ImageIcon(img)));
		f.pack();
		f.setVisible(true);
		
		
	}

}
