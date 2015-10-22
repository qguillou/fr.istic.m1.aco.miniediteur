package originator;

import caretaker.Recorder;
import invoker.IHM;
import receiver.EditorEngine;
import command.Copy;

import memento.Memento;

public class CopyRecordable  extends Copy implements CommandRecordable {
	
	private Recorder recorder;
	private String name;
	
	public CopyRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento m) {
		
	}

	@Override
	public String getName() {
		return name;
	}

}
