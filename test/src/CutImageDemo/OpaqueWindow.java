package CutImageDemo;


import java.awt.FileDialog;

import javax.swing.JWindow;
import com.sun.awt.AWTUtilities;
public class OpaqueWindow extends JWindow
{
	
	private static FileDialog svn= null;	//�����ͼ�Ի���
    {
         //͸������
         AWTUtilities.setWindowOpaque(this,false);
        
         this.setAlwaysOnTop(true);
 
    }
    
}
