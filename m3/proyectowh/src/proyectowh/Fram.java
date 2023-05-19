package proyectowh;

import java.awt.*;
import javax.swing.JFrame;

class Window extends JFrame{
	public  Window(){
		Toolkit mw = Toolkit.getDefaultToolkit();
		Dimension SS = mw.getScreenSize();
		int SH = SS.height;
		int SW = SS.width;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(SW/6, SH/6, (SW*2)/3, (SH*2)/3);
		setTitle("Project");
		Image icon = mw.getImage("src/proyectowh/Logo.jpg");
		setIconImage(icon);
		setResizable(false);
		
	}
}