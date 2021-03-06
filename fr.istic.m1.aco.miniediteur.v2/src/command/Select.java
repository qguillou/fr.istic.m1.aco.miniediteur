package command;

import invoker.IHM;
import receiver.EditorEngine;

/**
 * Select <br/>
 * implement Command<br/><br/>
 * Command to select text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Select implements Command {

	private IHM ihm;
	private EditorEngine engine;
	
	/**
	 * Select() <br/>
	 * Construct the Command Select
	 * @param engine the engine which will receive the command
	 */
	public Select(EditorEngine engine, IHM ihm) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Select Command
	 */
	@Override
	public void execute() {
		int start = ihm.getTextArea().getSelectionStart();
		int length = ihm.getTextArea().getSelectionEnd() - start;
		engine.select(start, length);
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
