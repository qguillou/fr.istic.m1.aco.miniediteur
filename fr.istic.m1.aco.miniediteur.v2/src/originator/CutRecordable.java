package originator;

import command.Cut;

import invoker.IHM;
import receiver.EditorEngine;
import caretaker.Recorder;
import memento.Memento;

public class CutRecordable extends Cut implements CommandRecordable {
	
	private Recorder recorder;
	private String name;
	
	public CutRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
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
