package command;

import invoker.IHM;
import memento.MementoEngine;
import receiver.EditorEngine;
import caretaker.Recorder;

/**
 * Paste<br/>
 * implement Command<br/><br/>
 * Command to paste text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Paste implements Command {

	protected IHM ihm;
	protected EditorEngine engine;
	protected Recorder recorder;
	
	/**
	 * Paste() <br/>
	 * Construct the Command Paste
	 * @param engine the engine which will receive the command
	 */
	public Paste(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Paste Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + V");
		engine.paste();
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	
		MementoEngine m = new MementoEngine(engine.getText(), engine.getSelectionStart(), engine.getSelectionLength());
		recorder.save(m);
	}
}
