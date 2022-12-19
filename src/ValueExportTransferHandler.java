import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class ValueExportTransferHandler extends TransferHandler{
	public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
	private String value;
	
	public ValueExportTransferHandler(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	@Override
	public int getSourceActions(JComponent c) {
		return DnDConstants.ACTION_COPY_OR_MOVE;
	}
	@Override
	public Transferable createTransferable(JComponent c) {
		Transferable t = new StringSelection(getValue());
		return t;
	}
	@Override
	public void exportDone(JComponent source, Transferable data, int action) {
		super.exportDone(source, data, action);
	}
}
