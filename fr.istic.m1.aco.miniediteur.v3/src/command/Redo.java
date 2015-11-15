package command;

import memento.MementoEngine;
import invoker.IHM;
import receiver.EditorEngine;
import receiver.RecorderEngine;

/**
 * Redo<br/>
 * implement Command<br/><br/>
 * Command to Redo action
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Redo implements Command {
	
	protected IHM ihm;
	protected EditorEngine engine;
	private RecorderEngine recorder;
	
	/**
	 * Redo() <br/>
	 * Construct the Command Redo
	 * @param engine the engine which will receive the command
	 */
	public Redo(EditorEngine engine, IHM ihm, RecorderEngine recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Redo Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + Y");
		
		MementoEngine m = recorder.redo();
		try {
			engine.setState(m.getState());
		}
		catch(NullPointerException npe){
			ihm.setCommandText("Ctrl + Y - Nothing to do");
		}
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
