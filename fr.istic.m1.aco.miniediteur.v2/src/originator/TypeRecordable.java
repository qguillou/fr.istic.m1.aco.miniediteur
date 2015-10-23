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
	private Memento memento;
	
	public TypeRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
		this.name = "type";
	}
	
	@Override
	public void execute() {
		super.execute();
		recorder.record(this);
	}
	
	@Override
	public void replay() {
		ihm.setCommandText(" ");
		engine.type(memento.getMemento().charAt(0));
	}
	
	@Override
	public Memento getMemento() {
		Memento m = new MementoType();
		return m;
	}

	@Override
	public void setMemento(Memento m) {
		this.memento = m;
	}

	@Override
	public String getName() {
		return name;
	}
}
