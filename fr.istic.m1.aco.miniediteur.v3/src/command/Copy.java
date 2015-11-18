package command;

import invoker.IHM;
import receiver.EditorEngine;
import caretaker.Recorder;

/**
 * Copy<br/>
 * implement Command<br/><br/>
 * Command to copy text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Copy implements Command {

	private IHM ihm;
	protected EditorEngine engine;
	protected Recorder recorder;
	
	/**
	 * Copy() <br/>
	 * Construct the Command Copy
	 * @param engine the engine which will receive the command
	 * @param ihm the ihm
	 */
	public Copy(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Copy Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + C");
		engine.copy();
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
