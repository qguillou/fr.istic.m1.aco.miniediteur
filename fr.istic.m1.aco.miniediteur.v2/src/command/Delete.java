package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Delete<br/>
 * implement Command<br/><br/>
 * Command to delete text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Delete implements Command {

	private IHM ihm;
	protected EditorEngine engine;
	
	/**
	 * Delete() <br/>
	 * Construct the Command Delete
	 * @param engine the engine which will receive the command
	 */
	public Delete(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the delete Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("DELETE");
		engine.delete();
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
