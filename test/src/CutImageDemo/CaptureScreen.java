package CutImageDemo;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class CaptureScreen {

	private static Robot robot = null;

	public static Robot getRobot() throws AWTException {
		// ���Ĭ����Ļ�豸
		GraphicsEnvironment environment = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice screen = environment.getDefaultScreenDevice();

		// Creates a Robot for the given screen device
		robot = new Robot(screen);

		return robot;
	}

	// ����rect��ȡ��Ļ��ͼ��Ӧ��BufferedImage����
	public static BufferedImage captureImage(Rectangle rect)
			throws AWTException {
		if (robot == null) {
			//����Robot����
			GraphicsEnvironment environment = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			GraphicsDevice screen = environment.getDefaultScreenDevice();
			// Creates a Robot for the given screen device
			robot = new Robot(screen);
		}
		BufferedImage image = robot.createScreenCapture(rect);
		return image;
	}

	// ����x��y��w��h��ȡ��Ļ��ͼ��Ӧ��BufferedImage����
	public static BufferedImage captureImage(int x, int y, int w, int h)
			throws AWTException {
		Rectangle rect = new Rectangle(x, y, w, h);
		if (robot == null) {
			robot = getRobot();
		}
		if (rect != null && rect.width>0 && rect.height>0) {
				BufferedImage image = robot.createScreenCapture(rect);
				return image;
		}
		else
			return null;
	}
	
	public static void main(String[]args) throws AWTException, IOException{
		
		BufferedImage image = CaptureScreen.captureImage(0, 0, 400, 400);
//		ImageIO
//		.write(image,"jpg",new File("C:/Documents and Settings/Administrator/����/��ͼ2.jpg"));
		JFrame frame = new JFrame();
		frame.setIconImage(image);
		frame.setVisible(true);
	}

}
