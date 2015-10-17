package command;

import receiver.EditorEngine;

public class Select implements Command {

	private EditorEngine engine;
	
	/**
	 * Construct the Command Select
	 * @param engine the engine which will receive the command
	 */
	public Select(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Select Command
	 */
	@Override
	public void execute() {
		engine.select();
	}
	
	@Override
	public String getText() {
		return "";
	}

}
