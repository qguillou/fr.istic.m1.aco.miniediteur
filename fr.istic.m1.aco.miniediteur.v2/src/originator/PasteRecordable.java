package originator;

import caretaker.Recorder;
import invoker.IHM;
import receiver.EditorEngine;
import command.Paste;
import memento.Memento;
import memento.MementoPaste;

public class PasteRecordable  extends Paste implements CommandRecordable {
	
	private Recorder recorder;
	
	public PasteRecordable(EditorEngine engine, IHM ihm, Recorder recorder) {
		super(engine, ihm);
		this.recorder = recorder;
	}

	@Override
	public Memento save() {
		String text = engine.getClipboard().getText();
		Memento m = new MementoPaste(text);
		return m;
	}
	
	public void execute(){
		if(recorder.getRecording()){
			recorder.record(this);
		}
		super.execute();
	}
}
