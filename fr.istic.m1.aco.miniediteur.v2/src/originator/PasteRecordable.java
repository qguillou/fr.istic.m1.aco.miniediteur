package originator;

import caretaker.Recorder;
import invoker.IHM;
import receiver.EditorEngine;
import command.Paste;
import memento.Memento;
import memento.MementoPaste;

/**
 * PasteRecordable
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class PasteRecordable  extends Paste implements CommandRecordable {
	
	private Recorder recorder;
	
	/**
	 * PasteRecordable() - Constructor<br/>
	 * initialize
	 * @param engine: the editor engine
	 * @param ihm: the ihm
	 * @param recorder: the recorder 
	 */
	public PasteRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
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
		Memento m = new MementoPaste(text);
		return m;
	}
	
	/**
	 * execute()<br/>
	 * Redeclared execute method of Delete
	 * Execute a command, but save the command if it's necessary
	 */
	public void execute(){
		if(recorder.getRecording()){
			recorder.record(this);
		}
		super.execute();
	}
	
	/**
	 * restore()<br/>
	 * restore the states (command executed and text)
	 */
	@Override
	public void restore(Memento m) {
		engine.getClipboard().setText(m.getText());
	}
}
