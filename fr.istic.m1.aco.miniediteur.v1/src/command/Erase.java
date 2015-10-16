package command;

import receiver.EditorEngine;

public class Erase implements Command {

	private EditorEngine engine;
	
	/**
	 * Construct the Command Erase
	 * @param engine the engine which will receive the command
	 */
	public Erase(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Erase Command
	 */
	@Override
	public void execute() {
		engine.erase();
	}
}
