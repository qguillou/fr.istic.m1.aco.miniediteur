package originator;

import memento.Memento;
import command.Command;

public interface CommandRecordable extends Command {
	
	public Memento save();
	
	public void restore(Memento m);
}
