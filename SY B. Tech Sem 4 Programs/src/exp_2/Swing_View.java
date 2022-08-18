package exp_2;
import javax.swing.*;
import java.awt.*;

public class Swing_View {

	static void addbutton(int a[][], int num) {
		
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.setSize(400,400);
		JButton b[] =  new JButton[num];
		for(int i=0;i<b.length;i++) {
			
			b[i] = new JButton(" "+i);
			f.add(b[i]);
		}
		for(int i=0;i<a.length;i++) {
			
			for(int j=0;j<a[i].length;j++) {
				
				System.out.print(a[i][j]);
			}
		}
	}
	
}
