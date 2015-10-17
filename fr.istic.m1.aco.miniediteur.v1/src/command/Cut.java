package command;

import receiver.EditorEngine;

public class Cut implements Command {
	
	private EditorEngine engine;
	
	/**
	 * Construct the Command Cut
	 * @param engine the engine which will receive the command
	 */
	public Cut(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Cut Command
	 */
	@Override
	public void execute() {
		engine.cut();
	}
	
	@Override
	public String getText() {
		return "";
	}

}
