package command;

import receiver.EditorEngine;

public class Paste implements Command {

	private EditorEngine engine;
	
	/**
	 * Construct the Command Paste
	 * @param engine the engine which will receive the command
	 */
	public Paste(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Paste Command
	 */
	@Override
	public void execute() {
		engine.paste();
	}
	
	@Override
	public String getText() {
		return "";
	}

}
