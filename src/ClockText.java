import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockText extends JPanel {
	
	JLabel clockField = new JLabel();
	Font clockFont = new Font("serif", Font.PLAIN, 26);
    
    public ClockText() {
    	
        javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
        
        t.start();
        this.add(clockField);
    }
    
    class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
            String hh = String.format("%02d", h);
            String mm = String.format("%02d", m);
            String ss = String.format("%02d", s);
            clockField.setText("  " + hh + ":" + mm + ":" + ss + "  ");
            clockField.setFont(clockFont);
           
    	}
    }
}

