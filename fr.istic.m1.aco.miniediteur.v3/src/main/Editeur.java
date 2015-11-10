package main;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import java.util.HashMap;
import java.util.Map;

import originator.CommandRecordable;
import originator.DeleteRecordable;
import originator.EraseRecordable;
import originator.PasteRecordable;
import originator.TypeRecordable;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;
import caretaker.Recorder;
import caretaker.RecorderImpl;

import command.Command;
import command.Copy;
import command.Cut;
import command.Replay;
import command.Select;

public class Editeur {

	public static void main(String[] args) {
		IHMListener listener = new IHMListener();
		IHM ihm = new IHMImpl(listener);
		
		ClipBoard clipboard = new ClipBoard();
		Selection selection = new Selection();
		Buffer buffer = new Buffer();		
		EditorEngine engine = new EngineImpl(selection, clipboard, buffer);
		
		Recorder recorder = new RecorderImpl();
		listener.setRecorder(recorder);
		
		Command copy = new Copy(engine, ihm);
		Command cut = new Cut(engine, ihm);
		CommandRecordable erase = new EraseRecordable(engine, ihm, recorder);
		CommandRecordable paste = new PasteRecordable(engine, ihm, recorder);
		Command select = new Select(engine, ihm);
		CommandRecordable type = new TypeRecordable(engine, ihm, recorder);
		CommandRecordable delete = new DeleteRecordable(engine, ihm, recorder);
		Command replay = new Replay(engine, ihm, recorder);
		
		Map<String, Command> commands = new HashMap<String, Command>();
		commands.put("copy", copy);
		commands.put("cut", cut);
		commands.put("erase", erase);
		commands.put("paste", paste);
		commands.put("select", select);
		commands.put("type", type);
		commands.put("delete", delete);
		commands.put("replay", replay);
		
		Map<String, CommandRecordable> commandsRecordable = new HashMap<String, CommandRecordable>();
		commandsRecordable.put("paste", paste);
		commandsRecordable.put("type", type);
		commandsRecordable.put("delete", delete);
		commandsRecordable.put("erase", erase);
				
		listener.setCommand(commands);
		recorder.setCommand(commandsRecordable);
		
		ihm.createView();
	}

}
