package originator;

import caretaker.Recorder;
import memento.Memento;
import memento.MementoType;
import invoker.IHM;
import receiver.EditorEngine;
import command.Type;

public class TypeRecordable extends Type implements CommandRecordable {

	private Recorder recorder;
	private String name;
	
	public TypeRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
		this.name = "copy";
	}
	
	@Override
	public void execute() {
		super.execute();
		recorder.record(this);
	}
	
	@Override
	public Memento getMemento() {
		Memento m = new MementoType();
		return m;
	}

	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return name;
	}

}
