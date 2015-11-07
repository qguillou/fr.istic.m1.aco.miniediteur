package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoType;
import receiver.EditorEngine;
import caretaker.Recorder;

import command.Type;

public class TypeRecordable  extends Type implements CommandRecordable {
	
	private Recorder recorder;
	
	public TypeRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}

	@Override
	public Memento save() {
		String c = ihm.getListener().getLastChar();
		Memento m = new MementoType(c);
		return m;
	}
	
	public void execute(){
		if(recorder.getRecording()){
			recorder.record(this);
		}
		super.execute();
	}

	@Override
	public void restore(Memento m) {
		ihm.getListener().setLastChar(m.getText());
	}
}
