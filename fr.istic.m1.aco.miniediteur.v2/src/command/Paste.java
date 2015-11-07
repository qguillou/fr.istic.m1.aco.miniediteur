package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Paste<br/>
 * implement Command<br/><br/>
 * Command to paste text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Paste implements Command {

	private IHM ihm;
	protected EditorEngine engine;
	
	/**
	 * Paste() <br/>
	 * Construct the Command Paste
	 * @param engine the engine which will receive the command
	 */
	public Paste(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Paste Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + V");
		engine.paste();
	}
}
