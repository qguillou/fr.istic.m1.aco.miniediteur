package caretaker;

import originator.CommandRecordable;

public interface Recorder {
	
	public void record(CommandRecordable c);
	
	public void replay();
	
	public void startRecording();
	
	public void stopRecording();
	
}
