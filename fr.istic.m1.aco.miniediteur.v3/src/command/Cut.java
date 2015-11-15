package command;

import invoker.IHM;
import memento.MementoEngine;
import receiver.EditorEngine;
import caretaker.Recorder;

/**
 * Cut<br/>
 * implement Command<br/><br/>
 * Command to cut text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Cut implements Command {
	
	private IHM ihm;
	protected EditorEngine engine;
	protected Recorder recorder;
	
	/**
	 * Cut() <br/>
	 * Construct the Command Cut
	 * @param engine the engine which will receive the command
	 * @param ihm the ihm
	 */
	public Cut(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Cut Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + X");
		engine.cut();
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	
		MementoEngine m = new MementoEngine(engine.getState());
		recorder.save(m);
	}
}
