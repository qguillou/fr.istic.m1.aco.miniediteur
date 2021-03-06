package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoDelete;
import receiver.EditorEngine;
import caretaker.Recorder;

import command.Cut;

/**
 * CutRecordable
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class CutRecordable  extends Cut implements CommandRecordable {
	
	private Recorder recorder;
	
	/**
	 * CutRecordable() - Constructor<br/>
	 * initialize
	 * @param engine: the editor engine
	 * @param ihm: the ihm
	 * @param recorder: the recorder 
	 */
	public CutRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}
	
	/**
	 * save()<br/>
	 * save the states (command executed and text)
	 */
	@Override
	public Memento save() {
		String text = engine.getClipboard().getText();
		Memento m = new MementoDelete(text);
		return m;
	}
	
	/**
	 * execute()<br/>
	 * Redeclared execute method of Delete
	 * Execute a command, but save the command if it's necessary
	 */
	public void execute(){
		super.execute();
		if(recorder.getRecording()){
			recorder.record(this);
		}
	}
	
	/**
	 * replay()<br/>
	 * replay the command with the states (command executed and text)
	 */
	@Override
	public void replay(Memento m) {
		engine.getClipboard().setText(m.getText());
	}
}
