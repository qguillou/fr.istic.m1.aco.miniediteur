package command;

import receiver.EditorEngine;

public class Copy implements Command {

	private EditorEngine engine;
	
	/**
	 * Construct the Command Copy
	 * @param engine the engine which will receive the command
	 */
	public Copy(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Copy Command
	 */
	@Override
	public void execute() {
		engine.copy();
	}

	@Override
	public String getText() {
		return "";
	}

}
