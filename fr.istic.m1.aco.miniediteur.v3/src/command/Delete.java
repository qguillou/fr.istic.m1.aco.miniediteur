package command;

import memento.MementoEngine;
import caretaker.Recorder;
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
	protected Recorder recorder;
	
	/**
	 * Delete() <br/>
	 * Construct the Command Delete
	 * @param engine the engine which will receive the command
	 */
	public Delete(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
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
	
		MementoEngine m = new MementoEngine(engine.getText(), engine.getSelectionStart(), engine.getSelectionLength());
		recorder.save(m);
	}
}
