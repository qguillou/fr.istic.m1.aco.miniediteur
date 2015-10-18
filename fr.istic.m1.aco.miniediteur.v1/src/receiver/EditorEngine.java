package receiver;

import observer.Observer;
import command.Command;

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
	
	public void select() throws NumberFormatException;
	
	public String getText() throws NumberFormatException;

	public void setCommand(Command copy, Command cut, Command erase, Command paste, Command select, Command type);

	public int getSelectionStart();
	
	public int getSelectionEnd();

	public void registerObserver(Observer o);
}
