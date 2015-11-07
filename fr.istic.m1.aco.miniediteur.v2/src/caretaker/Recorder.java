package caretaker;

import java.util.Map;


import originator.CommandRecordable;

public interface Recorder {
	
	public void record(CommandRecordable c);
	
	public void replay();
	
	public void setRecording();
	
	public boolean getRecording();
	
	/**
	 * setCommand() <br/>
	 * Set the commands 
	 * @param commands: a map which contains all commands, the key is the name of command
	 */
	public void setCommand(Map<String, CommandRecordable> commands);
}
