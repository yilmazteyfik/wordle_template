import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

public class ValueImportTransferHandler  extends TransferHandler{
	
	JTextField nextLetter;
	Border borderColor = BorderFactory.createLineBorder(Color.blue, 2);
	public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
	
	public ValueImportTransferHandler() {
	}
	
	public ValueImportTransferHandler(JTextField nextLetter) {
		this.nextLetter = nextLetter;
	}
	
	@Override
	public boolean canImport(TransferHandler.TransferSupport support) {
		return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
	}
	
	public boolean importData(TransferHandler.TransferSupport support) {
		boolean accept = false;
		if(canImport(support)) {
			try{
				Transferable t = support.getTransferable();
				Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
				if(value instanceof String) {
					Component component = support.getComponent();
					if(component instanceof JTextField && component.isFocusable() == true) {
						
						((JTextField) component).setText(value.toString());

						
						if (nextLetter != null && nextLetter.getText().length() == 0)
						{
							((JTextField) component).setBorder(nextLetter.getBorder());
							((JTextField) component).setFocusable(false);
							nextLetter.setFocusable(true);
							nextLetter.grabFocus();
							nextLetter.setBorder(borderColor);
						}
						accept = true;
					}
					
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return accept;
	}
}
