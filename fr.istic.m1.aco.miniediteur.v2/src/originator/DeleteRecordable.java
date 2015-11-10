package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoDelete;
import receiver.EditorEngine;
import caretaker.Recorder;

import command.Delete;

public class DeleteRecordable  extends Delete implements CommandRecordable {
	
	private Recorder recorder;
	
	public DeleteRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}

	@Override
	public Memento save() {
		String text = engine.getClipboard().getText();
		Memento m = new MementoDelete(text);
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
		engine.getClipboard().setText(m.getText());
	}
}
