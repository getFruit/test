package CutImageDemo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestMain {
	
	static OpaqueWindow ow = null;
	static MyCanva canva = null;

	static Point startPoint = null;
	static Point endPoint = null;

	static JFileChooser svChooser = null;

	static BufferedImage image = null;
	
	static boolean startClip = false;	//用户是否开始截图的标记
	
	/*
	 * 用户是否选择了截图区域，之所以添加这个属性是为了消除这个bug：
	 * 当用户未截图就点击鼠标左键时也弹出文件保存对话框
	 */
	static boolean hasCliped = false; 
	
	//开始截图
	public static void startClipImage(){
		
		System.out.println("hello");
		
		ow = new OpaqueWindow();
		// ow.setIconImage(kit.getImage("")); //设置图标
		canva = new MyCanva();
		canva.setDoubleBuffered(true); // 设置面板双缓冲
		
		// 默认保存在桌面,能保存为GIF、PNG两种图片格式
		svChooser = new JFileChooser(
				"E:/桌面");
		//设置保存在当前目录
		// svChooser.setCurrentDirectory(new File("."));
		// 设置显示文件夹(目录)，因为截图只能被存到文件夹(或目录)
		// svChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		FileNameExtensionFilter gifFilter = new FileNameExtensionFilter("GIF",
				"gif");
//		 svChooser.setFileFilter(filter);
		FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG",
				"png");
		FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("JPG",
				"jpg");
		svChooser.addChoosableFileFilter(gifFilter);
		svChooser.addChoosableFileFilter(pngFilter);
		svChooser.addChoosableFileFilter(jpgFilter);
		// 放弃“All files”过滤器
		svChooser.setAcceptAllFileFilterUsed(false);
		//设置当前的FileFilter类型
		svChooser.setFileFilter(pngFilter);
		svChooser.setDialogTitle("保存截图");

		// 为画板添加鼠标事件监听
		canva.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) { // 按下鼠标左键，弹出保存截图对话框
					if (hasCliped) {
						// 文件保存对话框的父组件为MyCanva实例canva
						int returnVal = svChooser.showSaveDialog(canva);
						if (returnVal == JFileChooser.CANCEL_OPTION) {
							System.out.println("你取消了保存!");
						} else if (returnVal == JFileChooser.APPROVE_OPTION) {
							// 使用JFileChooser的getSelectedFile().getPath可以获得文件的完整保存路径
							// System.out.println(svChooser.getSelectedFile()
							// .getPath());
							String fileType = svChooser.getFileFilter()
									.getDescription();
							
							File file = null;
							if(svChooser.getSelectedFile().getPath()!=null){
								file = 	new File(svChooser.getSelectedFile()
										.getPath()
										+ "." + fileType);
							}
							// System.out.println("文件类型：" +
							// svChooser.getFileFilter().getDescription());
							// System.out.println(svChooser.getDescription(file));
							// System.out.println(svChooser.getTypeDescription(file));
							// System.out.println(svChooser.getName());

							try {
								if (fileType.equals("PNG")) {
									ImageIO.write(image, "png", file);
								} else if (fileType.equals("GIF")) {
									ImageIO.write(image, "gif", file);
								} else {
									ImageIO.write(image, "jpg", file);
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						} else if (returnVal == JFileChooser.ERROR_OPTION) { // 未填写保存文件名就点击保存
							System.out.println("请填写保存文件名");
						}
						System.exit(0);
					}
				} else if (e.getButton() == MouseEvent.BUTTON3) { // 按下鼠标右键，表示取消截图
//					System.out.println("你按下鼠标右键，取消了截图!");
					System.exit(0);
				}
			}

			int count = 0;

			public void mousePressed(MouseEvent e) {
				count++;
				if (count < 2) {
					startPoint = e.getPoint();
//					System.out.println("鼠标被按下，坐标为 " + startPoint.x + " "
//							+ startPoint.y);
					canva.setStartPoint(startPoint);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (startPoint != null && endPoint != null) {
					try {
						image = CaptureScreen.captureImage(startPoint.x,
								startPoint.y, endPoint.x - startPoint.x,
								endPoint.y - startPoint.y);
						hasCliped = true; // 更改其属性
					} catch (AWTException e2) {
						e2.printStackTrace();
					}
				}
				// System.out.println("鼠标被释放!");
			}
		});
		canva.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endPoint = e.getPoint();
				canva.setEndPoint(endPoint);

				// 不处理终点在起点左边或上边的情况
				if (endPoint.x < startPoint.x || endPoint.y < startPoint.y) {
					System.exit(0);
				}

				//不断重绘
				canva.repaint();
//				System.out
//						.println("鼠标被拖动，坐标为 " + endPoint.x + " " + endPoint.y);
			}
		});

		ow.setContentPane(canva);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ow.setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());

		canva.repaint();

		ow.setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		
//		canva.addKeyListener(new KeyAdapter(){
//			public void keyPressed(KeyEvent e){
//				int keycode = e.getKeyCode();
//				//快捷键为 Ctrl+Alt+A
//				if(keycode==KeyEvent.VK_A && e.isAltDown() && e.isControlDown()){
//					//开始截图
//					startClip = true;
//				}
//			}
//		});
//		
		EventQueue.invokeAndWait(new Runnable(){

			public void run() {
				startClipImage();
			}
			
		});
		
//		System.out.println("hello");
//		while(true) {
//			if(startClip){
//				startClipImage();
//				break;
//			}
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//		}
	
	}

}