package command;

import invoker.IHM;
import receiver.EditorEngine;

public class Select implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Construct the Command Select
	 * @param engine the engine which will receive the command
	 */
	public Select(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute the Select Command
	 */
	@Override
	public void execute() {
		int start = ihm.getTextArea().getSelectionStart();
		int length = ihm.getTextArea().getSelectionEnd() - start;
		engine.select(start, length);
	}
}
