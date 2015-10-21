package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Type<br/>
 * implement Command<br/><br/>
 * Command to type text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Type implements Command {
	
	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Type() <br/>
	 * Construct the Command Type
	 * @param engine the engine which will receive the command
	 */
	public Type(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Type Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText(" ");
		engine.type(ihm.getListener().getLastChar());
	}
}
