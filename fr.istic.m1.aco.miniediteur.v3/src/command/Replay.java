package command;

import memento.MementoEngine;
import caretaker.Recorder;
import invoker.IHM;
import receiver.EditorEngine;

/**
 * Replay<br/>
 * implement Command<br/><br/>
 * Command to replay macro
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class Replay implements Command  {

	private IHM ihm;
	protected EditorEngine engine;
	private Recorder recorder;
	
	/**
	 * Replay() <br/>
	 * Construct the Command Replay
	 * @param engine the engine which will receive the command
	 * @param ihm the ihm
	 * @param recorder the recorder
	 */
	public Replay(EditorEngine engine, IHM ihm, Recorder recorder) {
		this.engine = engine;
		this.ihm = ihm;
		this.recorder = recorder;
	}
	
	/**
	 * Execute() <br/>
	 * Execute the Replay Command
	 */
	@Override
	public void execute() {
		if(!recorder.getRecording()){
			recorder.replay();
			ihm.getTextArea().update(engine.getText(), engine.getSelectionStart(), engine.getSelectionStart()+engine.getSelectionLength());
		}
		else 
			ihm.setCommandText("Error - Recording ON can't replay");

		MementoEngine m = new MementoEngine(engine.getState());
		recorder.save(m);
	}

}
