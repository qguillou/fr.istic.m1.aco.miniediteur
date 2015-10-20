package receiver;

import observer.Observer;

/**
 * EditorEngine - Interface
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */

public interface EditorEngine {
	public void copy();
	
	public void paste() throws NumberFormatException;
	
	public void cut() throws NumberFormatException;
	
	public void erase() throws NumberFormatException;
	
	public void type(char c) throws NumberFormatException;
	
	public void select(int start, int length) throws NumberFormatException;
	
	public String getText() throws NumberFormatException;

	public int getSelectionStart();
	
	public int getSelectionEnd();

	public void registerObserver(Observer o);
}
