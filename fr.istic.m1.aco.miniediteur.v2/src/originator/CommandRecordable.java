package originator;

import memento.Memento;
import command.Command;

public interface CommandRecordable extends Command {
	
	public Memento getMemento();
	
	public void setMemento(Memento m);

	public String getName();

	public void replay();	
	
}
