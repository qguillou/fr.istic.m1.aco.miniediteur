package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Erase<br/>
 * implement Command<br/><br/>
 * Command to erase text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Erase implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Erase() <br/>
	 * Construct the Command Erase
	 * @param engine the engine which will receive the command
	 */
	public Erase(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Erase Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("BACK SPACE");
		engine.erase();
	}
}
