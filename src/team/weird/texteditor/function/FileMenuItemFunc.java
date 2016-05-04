package team.weird.texteditor.function;

import javax.swing.JTextArea;
/**
 * @author Siyuan_Liu
 * @description All of functions of file menu is here
 */
public interface FileMenuItemFunc {
	JTextArea newFileAction(String name);
	void newWindowsAction();
	void openFileAction();
	void saveFileAction();
	void saveAsFileAction();
	void closeFileAction();
	void closeAllFileAction();
	void exitFileAction();
}
