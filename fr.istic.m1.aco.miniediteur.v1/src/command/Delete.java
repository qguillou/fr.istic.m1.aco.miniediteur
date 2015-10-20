package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Delete implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Delete
	 * @param engine the engine which will receive the command
	 */
	public Delete(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Erase Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("DELETE");
		engine.delete();
	}
}
