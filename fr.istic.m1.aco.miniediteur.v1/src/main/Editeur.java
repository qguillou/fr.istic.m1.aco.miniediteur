package main;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import command.Copy;
import command.Cut;
import command.Delete;
import command.Erase;
import command.Paste;
import command.Select;
import command.Type;
import invoker.IHM;
import invoker.IHMListener;
import invoker.IHMImpl;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class Editeur {

	public static void main(String[] args) {
		IHMListener listener = new IHMListener();
		IHM ihm = new IHMImpl(listener);
		
		ClipBoard clipboard = new ClipBoard();
		Selection selection = new Selection();
		Buffer buffer = new Buffer();		
		EditorEngine engine = new EngineImpl(selection, clipboard, buffer);
		
		Command copy = new Copy(engine, ihm);
		Command cut = new Cut(engine, ihm);
		Command erase = new Erase(engine, ihm);
		Command paste = new Paste(engine, ihm);
		Command select = new Select(engine, ihm);
		Command type = new Type(engine, ihm);
		Command delete = new Delete(engine, ihm);
		
		Map<String, Command> commands = new HashMap<String, Command>();
		commands.put("copy", copy);
		commands.put("cut", cut);
		commands.put("erase", erase);
		commands.put("paste", paste);
		commands.put("select", select);
		commands.put("type", type);
		commands.put("delete", delete);
		
		listener.setCommand(commands);
		
		ihm.createView();
	}

}
