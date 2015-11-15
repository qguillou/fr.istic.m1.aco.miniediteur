package command;

import memento.MementoEngine;
import invoker.IHM;
import receiver.EditorEngine;
import receiver.RecorderEngine;

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
	private RecorderEngine recorder;
	
	/**
	 * Paste() <br/>
	 * Construct the Command Paste
	 * @param engine the engine which will receive the command
	 */
	public Paste(EditorEngine engine, IHM ihm, RecorderEngine recorderState) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorderState;
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
	
		MementoEngine m = new MementoEngine(engine.getState());
		recorder.save(m);
	}
}
