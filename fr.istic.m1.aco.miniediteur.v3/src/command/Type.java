package command;

import memento.MementoEngine;
import invoker.IHM;
import receiver.EditorEngine;
import receiver.RecorderEngine;

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
	private RecorderEngine recorder;
	
	/**
	 * Type() <br/>
	 * Construct the Command Type
	 * @param engine the engine which will receive the command
	 */
	public Type(EditorEngine engine, IHM ihm, RecorderEngine recorderState) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorderState;
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
	
		MementoEngine m = new MementoEngine(engine.getState());
		recorder.save(m);
	}
}
