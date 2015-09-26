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
	
	static boolean startClip = false;	//�û��Ƿ�ʼ��ͼ�ı��
	
	/*
	 * �û��Ƿ�ѡ���˽�ͼ����֮����������������Ϊ���������bug��
	 * ���û�δ��ͼ�͵��������ʱҲ�����ļ�����Ի���
	 */
	static boolean hasCliped = false; 
	
	//��ʼ��ͼ
	public static void startClipImage(){
		
		System.out.println("hello");
		
		ow = new OpaqueWindow();
		// ow.setIconImage(kit.getImage("")); //����ͼ��
		canva = new MyCanva();
		canva.setDoubleBuffered(true); // �������˫����
		
		// Ĭ�ϱ���������,�ܱ���ΪGIF��PNG����ͼƬ��ʽ
		svChooser = new JFileChooser(
				"E:/����");
		//���ñ����ڵ�ǰĿ¼
		// svChooser.setCurrentDirectory(new File("."));
		// ������ʾ�ļ���(Ŀ¼)����Ϊ��ͼֻ�ܱ��浽�ļ���(��Ŀ¼)
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
		// ������All files��������
		svChooser.setAcceptAllFileFilterUsed(false);
		//���õ�ǰ��FileFilter����
		svChooser.setFileFilter(pngFilter);
		svChooser.setDialogTitle("�����ͼ");

		// Ϊ�����������¼�����
		canva.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) { // ���������������������ͼ�Ի���
					if (hasCliped) {
						// �ļ�����Ի���ĸ����ΪMyCanvaʵ��canva
						int returnVal = svChooser.showSaveDialog(canva);
						if (returnVal == JFileChooser.CANCEL_OPTION) {
							System.out.println("��ȡ���˱���!");
						} else if (returnVal == JFileChooser.APPROVE_OPTION) {
							// ʹ��JFileChooser��getSelectedFile().getPath���Ի���ļ�����������·��
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
							// System.out.println("�ļ����ͣ�" +
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

						} else if (returnVal == JFileChooser.ERROR_OPTION) { // δ��д�����ļ����͵������
							System.out.println("����д�����ļ���");
						}
						System.exit(0);
					}
				} else if (e.getButton() == MouseEvent.BUTTON3) { // ��������Ҽ�����ʾȡ����ͼ
//					System.out.println("�㰴������Ҽ���ȡ���˽�ͼ!");
					System.exit(0);
				}
			}

			int count = 0;

			public void mousePressed(MouseEvent e) {
				count++;
				if (count < 2) {
					startPoint = e.getPoint();
//					System.out.println("��걻���£�����Ϊ " + startPoint.x + " "
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
						hasCliped = true; // ����������
					} catch (AWTException e2) {
						e2.printStackTrace();
					}
				}
				// System.out.println("��걻�ͷ�!");
			}
		});
		canva.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endPoint = e.getPoint();
				canva.setEndPoint(endPoint);

				// �������յ��������߻��ϱߵ����
				if (endPoint.x < startPoint.x || endPoint.y < startPoint.y) {
					System.exit(0);
				}

				//�����ػ�
				canva.repaint();
//				System.out
//						.println("��걻�϶�������Ϊ " + endPoint.x + " " + endPoint.y);
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
//				//��ݼ�Ϊ Ctrl+Alt+A
//				if(keycode==KeyEvent.VK_A && e.isAltDown() && e.isControlDown()){
//					//��ʼ��ͼ
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