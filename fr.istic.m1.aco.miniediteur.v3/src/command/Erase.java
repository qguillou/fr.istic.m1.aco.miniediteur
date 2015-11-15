package command;

import memento.MementoEngine;
import caretaker.Recorder;
import invoker.IHM;
import receiver.EditorEngine;

/**
 * Erase<br/>
 * implement Command<br/><br/>
 * Command to erase text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Erase implements Command {

	private IHM ihm;
	protected EditorEngine engine;
	protected Recorder recorder;
	
	/**
	 * Erase() <br/>
	 * Construct the Command Erase
	 * @param engine the engine which will receive the command
	 */
	public Erase(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Erase Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("BACK SPACE");
		engine.erase();
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());

		MementoEngine m = new MementoEngine(engine.getState());
		recorder.save(m);
	}
}
