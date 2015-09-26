package CutImageDemo;


import java.awt.FileDialog;

import javax.swing.JWindow;
import com.sun.awt.AWTUtilities;
public class OpaqueWindow extends JWindow
{
	
	private static FileDialog svn= null;	//保存截图对话框
    {
         //透明窗体
         AWTUtilities.setWindowOpaque(this,false);
        
         this.setAlwaysOnTop(true);
 
    }
    
}
