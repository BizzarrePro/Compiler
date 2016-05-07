package team.weird.texteditor.implement;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

import team.weird.texteditor.function.EditMenuItemFunc;
public class EditAction extends AbstractAction implements EditMenuItemFunc{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tab;
	private UndoManager um =new  UndoManager();
	public EditAction(String name, JTabbedPane tab){
		super(name);
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cut")){
			cutTextAction();
			
		}
		if(e.getActionCommand().equals("Copy")){
			copyTextAction();
		}
		if(e.getActionCommand().equals("Paste")){
			pasteTextAction();
		}
		if(e.getActionCommand().equals("Undo")){
			 undoTextAction();
		}
		if(e.getActionCommand().equals("Redo")){
			 redoTextAction();
		}
		if(e.getActionCommand().equals("SelectAll")){
			selectAllAction();
		}
	}
	@Override
	public void cutTextAction() {
		// TODO Auto-generated method stub
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				JTextArea temp = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
				temp.cut();
	}

	@Override
	public void copyTextAction() {
		// TODO Auto-generated method stub
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		JTextArea temp = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
		String text=temp.getSelectedText();
		if(text==null){
			text=temp.getText();
		}
		StringSelection selection = new StringSelection(text);
		clipboard.setContents(selection, null);
	}

	@Override
	public void pasteTextAction() {
		// TODO Auto-generated method stub
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		JTextArea temp = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
		DataFlavor flavor = DataFlavor.stringFlavor;
		if(clipboard.isDataFlavorAvailable(flavor)){
			try{
				String text = (String) clipboard.getData(flavor);
				temp.replaceSelection(text);
			}
			catch (UnsupportedFlavorException e) {
				// TODO: handle exception
				JOptionPane.showInputDialog(this, e);
			}
			catch (IOException e) {
				// TODO: handle exception
				JOptionPane.showInputDialog(this, e);
			}
			
		}
	}

	@Override
	public void undoTextAction() {
		// TODO Auto-generated method stub
		JTextArea text = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
		//text.set
		if(um.canUndo()){
			um.undo();
		}
	}

	@Override
	public void redoTextAction() {
		// TODO Auto-generated method stub
		JTextArea text = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
		if(um.canRedo()){
			um.redo();
		}
	}

	@Override
	public void selectAllAction() {
		// TODO Auto-generated method stub
		JTextArea text = (JTextArea) ((JScrollPane) tab.getSelectedComponent()).getViewport().getView();
		text.selectAll();
	}
}