package receiver;

import command.Command;

/**
 * EditorEngine - Interface
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */

public interface EditorEngine {
	public String copy();
	
	public String paste() throws NumberFormatException;
	
	public String cut() throws NumberFormatException;
	
	public String erase() throws NumberFormatException;
	
	public String type() throws NumberFormatException;
	
	public String select() throws NumberFormatException;
	
	public String getText() throws NumberFormatException;

	public void setCommand(Command copy, Command cut, Command erase, Command paste, Command select, Command type);
}
