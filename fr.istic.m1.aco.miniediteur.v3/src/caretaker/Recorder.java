package caretaker;

import java.util.Map;

import memento.MementoEngine;
import originator.CommandRecordable;

/**
 * Interface Recorder
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public interface Recorder {
	
	/**
	 * record()<br/>
	 * Record a command
	 * @param c the command to record
	 */
	public void record(CommandRecordable c);
	
	/**
	 * replay()<br/>
	 * Replay the command which have been record
	 */
	public void replay();
	
	/**
	 * setRecording()<br/>
	 * change status of recording
	 */
	public void setRecording();
	
	/**
	 * getRecording()<br/>
	 * get the recording status
	 * @return boolean: the recording status
	 */
	public boolean getRecording();
	
	/**
	 * setCommand() <br/>
	 * Set the commands 
	 * @param commands: a map which contains all commands, the key is the name of command
	 */
	public void setCommand(Map<String, CommandRecordable> commands);
	
	/**
	 * save() <br/>
	 * Save the memento
	 * @param m the memento to save
	 */
	public void save(MementoEngine m);
	
	/**
	 * undo() <br/>
	 * Undo an action
	 * @return the before state of engine
	 */
	public MementoEngine undo();
	
	/**
	 * Redo() <br/>
	 * Redo an action
	 * @return the after state of engine
	 */
	public MementoEngine redo();
}
