import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.*;

import javax.swing.JPanel;

public class EndPanel extends JPanel implements ActionListener{

	Rectangle2D.Double[] rec;
	Timer t;
	public EndPanel(){
		this.setPreferredSize(new Dimension(3000,2000));
		this.setBackground(Color.BLACK);
		rec = new Rectangle2D.Double[3000];
		
		for(int i = 0 ; i < 3000 ; i++) {
			Random rand = new Random();
			rec[i] =  new Rectangle2D.Double(rand.nextInt(3000),(-1 * rand.nextInt(2000)),rand.nextInt(3)+2,rand.nextInt(10)+10);

		}
		t = new Timer(10, this);
		t.start();
		
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setPaint(Color.DARK_GRAY);
		for(int i = 0 ; i < 3000 ; i++) {
			
			g2d.fill(rec[i]);
		}
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		// TODO Auto-generated method stub
		for(int i = 0; i < 3000 ; i++) {
			rec[i].y += rand.nextInt(5)+15;
			if(rec[i].y > 2000) {
				rec[i].y = -1 * rand.nextInt(250);
				rec[i].y += rand.nextInt(5)+15;
			}
		}

		repaint();
		
	}
}