package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Type implements Command {
	
	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Type
	 * @param engine the engine which will receive the command
	 */
	public Type(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Type Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText(" ");
		engine.type(ihm.getListener().getLastChar());
	}
}
