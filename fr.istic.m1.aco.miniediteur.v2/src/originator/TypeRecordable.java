package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoType;
import receiver.EditorEngine;
import caretaker.Recorder;

import command.Type;

/**
 * TypeRecordable
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class TypeRecordable  extends Type implements CommandRecordable {
	
	private Recorder recorder;
	
	/**
	 * TypeRecordable() - Constructor<br/>
	 * initialize
	 * @param engine: the editor engine
	 * @param ihm: the ihm
	 * @param recorder: the recorder 
	 */
	public TypeRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}
	
	/**
	 * save()<br/>
	 * save the states (command executed and text)
	 */
	@Override
	public Memento save() {
		String c = ihm.getListener().getLastChar();
		Memento m = new MementoType(c);
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
	 * replay()<br/>
	 * replay the command with the states (command executed and text)
	 */
	@Override
	public void replay(Memento m) {
		ihm.getListener().setLastChar(m.getText());
		super.execute();
	}
}
