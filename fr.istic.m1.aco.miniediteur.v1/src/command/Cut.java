package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Cut implements Command {
	
	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Cut
	 * @param engine the engine which will receive the command
	 */
	public Cut(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Cut Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + X");
		engine.cut();
	}
}
