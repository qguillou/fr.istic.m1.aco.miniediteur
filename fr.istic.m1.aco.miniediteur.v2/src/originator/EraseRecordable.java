package originator;

import invoker.IHM;
import memento.Memento;
import memento.MementoErase;
import receiver.EditorEngine;
import caretaker.Recorder;
import command.Erase;

public class EraseRecordable  extends Erase implements CommandRecordable {
	
	private Recorder recorder;
	
	public EraseRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}

	@Override
	public Memento save() {
		String text = engine.getClipboard().getText();
		Memento m = new MementoErase(text);
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
