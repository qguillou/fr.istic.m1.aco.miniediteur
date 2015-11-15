package receiver;


/**
 * EditorEngine - Interface
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */

public interface EditorEngine {
	
	/**
	 * copy()
	 * copy text into clipboard
	 */
	public void copy();
	
	/**
	 * paste()
	 * paste text into buffer
	 */
	public void paste() throws NumberFormatException;
	
	/**
	 * cut()
	 * cut text into buffer and put text into clipboard
	 */
	public void cut() throws NumberFormatException;
	
	/**
	 * erase()
	 * erase text into buffer
	 */
	public void erase() throws NumberFormatException;
	
	/**
	 * delete()
	 * delete text into buffer
	 */
	public void delete() throws NumberFormatException;
	
	/**
	 * type()
	 * type text into buffer
	 * @param c: the last char typed
	 */
	public void type(String c) throws NumberFormatException;
	
	/**
	 * select()
	 * set the selection start end length
	 * @param start: the start of new selection
	 * @param length: the length of new selection
	 */
	public void select(int start, int length) throws NumberFormatException;
	
	/**
	 * getText()
	 * get the text of buffer
	 * @return String text: the content of buffer
	 */
	public String getText() throws NumberFormatException;
	
	/**
	 * getSelectionStart() <br/>
	 * get the selection start
	 * @return int the start of cursor position
	 */
	public int getSelectionStart();
	
	/**
	 * getSelectionEnd() <br/>
	 * get the selection end
	 * @return int the end of cursor position
	 */
	public int getSelectionLength();
	
	/**
	 * getClipboard() <br/>
	 * get the clipboard
	 * @return Clipboard: the clipboard
	 */
	public ClipBoard getClipboard();
	
	public EditorEngine getState();

	public void setState(EditorEngine e);
}
