package command;

import invoker.IHM;
import memento.MementoEngine;
import receiver.EditorEngine;
import caretaker.Recorder;

/**
 * Type<br/>
 * implement Command<br/><br/>
 * Command to type text
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Type implements Command {
	
	protected IHM ihm;
	protected EditorEngine engine;
	protected Recorder recorder;
	
	/**
	 * Type() <br/>
	 * Construct the Command Type
	 * @param engine the engine which will receive the command
	 */
	public Type(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Type Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText(" ");
		engine.type(ihm.getListener().getLastChar());
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	
		MementoEngine m = new MementoEngine(engine.getText(), engine.getSelectionStart(), engine.getSelectionLength());
		recorder.save(m);
	}
}
