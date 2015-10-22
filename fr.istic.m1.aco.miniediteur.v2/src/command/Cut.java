package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Cut<br/>
 * implement Command<br/><br/>
 * Command to cut text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Cut implements Command {
	
	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Cut() <br/>
	 * Construct the Command Cut
	 * @param engine the engine which will receive the command
	 * @param ihm the ihm
	 */
	public Cut(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Cut Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + X");
		engine.cut();
	}
}
