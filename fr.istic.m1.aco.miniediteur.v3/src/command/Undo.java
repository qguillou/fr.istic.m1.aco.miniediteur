package command;

import memento.MementoEngine;
import invoker.IHM;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.RecorderEngine;
import receiver.Selection;

/**
 * Undo<br/>
 * implement Command<br/><br/>
 * Command to Undo action
 * @author Yann Jegu & Quentin Guillou
 * @version 1.0
 */
public class Undo implements Command {
	
	protected IHM ihm;
	protected EditorEngine engine;
	private RecorderEngine recorder;
	
	/**
	 * Undo() <br/>
	 * Construct the Command Undo
	 * @param engine the engine which will receive the command
	 */
	public Undo(EditorEngine engine, IHM ihm, RecorderEngine recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Undo Command
	 */
	@Override
	public void execute() {
		ihm.setCommandText("Ctrl + Z");
		
		MementoEngine m = recorder.undo();
		try {
			engine.setState(m.getState());
		}
		catch(NullPointerException npe){
			ihm.setCommandText("Ctrl + Z - Nothing to do");
			engine.setState(new MementoEngine(new EngineImpl(new Selection(), new ClipBoard(), new Buffer())).getState());
		}
		ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
	}
}
