package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoErase;
import receiver.EditorEngine;
import caretaker.Recorder;
import command.Erase;

/**
 * EraseRecordable
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class EraseRecordable  extends Erase implements CommandRecordable {
	
	private Recorder recorder;
	
	/**
	 * EraseRecordable() - Constructor<br/>
	 * initialize
	 * @param engine: the editor engine
	 * @param ihm: the ihm
	 * @param recorder: the recorder 
	 */
	public EraseRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
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
		Memento m = new MementoErase(text);
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
