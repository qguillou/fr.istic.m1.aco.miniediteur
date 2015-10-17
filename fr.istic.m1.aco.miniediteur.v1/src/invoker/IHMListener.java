package invoker;

import javax.swing.event.*;

import command.Command;

public class IHMListener implements CaretListener {
	
	private Command copy;
	private Command cut;
	private Command erase;
	private Command paste;
	private Command select;
	private Command type;
	
	@Override
	public void caretUpdate(CaretEvent arg0) {
		
	}
	
	public void setCommand(Command copy, Command cut, Command erase, Command paste, Command select, Command type) {
		this.copy = copy;
		this.cut = cut;
		this.erase = erase;
		this.paste = paste;
		this.select = select;
		this.type = type;
	}

}
