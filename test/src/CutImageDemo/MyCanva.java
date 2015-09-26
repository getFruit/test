package CutImageDemo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyCanva extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Point startPoint = null;
	private static Point oldEndPoint = null;
	private static Point newEndPoint   = null;
	
	public void setStartPoint(Point startPoint){
		MyCanva.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint){
		if(oldEndPoint==null){
			oldEndPoint = endPoint;
		}
		MyCanva.newEndPoint = endPoint;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		BufferedImage bim = null;
		try {
			// 图片读取,作为panel背景,也是整个窗体的背景
			bim = ImageIO.read(new File("src/rect2.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		g2.drawImage(bim, 0, 0, (int) dim.getWidth(), (int) dim.getHeight(),
				null);

		g2.setPaint(new Color(42, 15, 24));
//		g2.drawRect(200, 200, 400, 400);
		if(startPoint!=null && newEndPoint!=null){
			int x = startPoint.x;
			int y  = startPoint.y;
			int ow = oldEndPoint.x-x;
			int oh = oldEndPoint.y-y;
			g2.clearRect(x, y, ow, oh);
			int nw = newEndPoint.x-x;
			int nh = newEndPoint.y-y;
			g2.drawRect(x, y, nw, nh);
		}
		g2.dispose();
	}
	
}