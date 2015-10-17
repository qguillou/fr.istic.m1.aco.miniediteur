package command;

import receiver.EditorEngine;

public class Type implements Command {

	private EditorEngine engine;
	
	/**
	 * Construct the Command Type
	 * @param engine the engine which will receive the command
	 */
	public Type(EditorEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Execute the Type Command
	 */
	@Override
	public void execute() {
		engine.type();
	}
	
	public String getText(){
		return "";
	}

}
