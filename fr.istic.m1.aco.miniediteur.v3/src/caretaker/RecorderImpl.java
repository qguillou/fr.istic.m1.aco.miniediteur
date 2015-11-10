package caretaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import memento.Memento;
import originator.CommandRecordable;

/**
 * RecorderImpl implements Recorder
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public class RecorderImpl implements Recorder {
	
	private Map<String, CommandRecordable> commands;
	private Collection<Memento> mementos;
	private boolean recording;
	
	/**
	 * RecorderImpl() <br/>
	 * Construct the Recorder
	 */
	public RecorderImpl() {
		mementos = new ArrayList<Memento>();
		recording = false;
	}
	
	/**
	 * record()<br/>
	 * Record a command
	 * @param c the command to record
	 */
	@Override
	public void record(CommandRecordable c) {
		Memento m = c.save();
		mementos.add(m);
	}

	/**
	 * replay()<br/>
	 * Replay the command which have been record
	 */
	@Override
	public void replay() {
		Iterator<Memento> it = mementos.iterator();
		Memento m;
		
		while(it.hasNext()) {			
			m = it.next();			
			commands.get(m.getCommand()).restore(m);
			commands.get(m.getCommand()).execute();
		}
	}
	
	/**
	 * setRecording()<br/>
	 * change status of recording
	 */
	@Override
	public void setRecording() {
		recording = !recording;
		if(recording)
			mementos = new ArrayList<Memento>();
	}
	
	/**
	 * getRecording()<br/>
	 * get the recording status
	 * @return boolean: the recording status
	 */
	public boolean getRecording() {
		return recording;
	}
	
	/**
	 * setCommand() <br/>
	 * Set the commands 
	 * @param commands: a map which contains all commands, the key is the name of command
	 */
	@Override
	public void setCommand(Map<String, CommandRecordable> commands) {
		this.commands = commands;
	}
}