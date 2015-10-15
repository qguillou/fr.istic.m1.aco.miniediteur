package receiver;

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
	
	public void type() throws NumberFormatException;	
}
