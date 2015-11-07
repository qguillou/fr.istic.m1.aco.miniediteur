package caretaker;

import java.util.Collection;
import java.util.Map;

import memento.Memento;
import originator.CommandRecordable;

public class RecorderImpl implements Recorder {
	
	private Collection<Memento> mementos;
	private boolean recording;
	
	public RecorderImpl(Map<String, CommandRecordable> commands){
		
	}
	
	@Override
	public void record(CommandRecordable c) {
		Memento m = c.save();
	}

	@Override
	public void replay() {
		
	}

	@Override
	public void startRecording() {
		recording = true;
	}

	@Override
	public void stopRecording() {
		recording = false;
	}
	
	public boolean getRecording() {
		return recording;
	}
}