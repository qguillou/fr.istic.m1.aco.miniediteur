package originator;

import memento.Memento;
import command.Command;

/**
 * Interface CommandRecordable
 * @author Yann Jegu & Quentin Guillou
 * @version 2.0
 */
public interface CommandRecordable extends Command {
	
	/**
	 * save()<br/>
	 * save the states (command executed and text)
	 */
	public Memento save();
	
	/**
	 * restore()<br/>
	 * restore the states (command executed and text)
	 */
	public void restore(Memento m);
}
