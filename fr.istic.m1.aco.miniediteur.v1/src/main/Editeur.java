package main;

import command.Command;
import command.Copy;
import command.Cut;
import command.Erase;
import command.Paste;
import command.Select;
import command.Type;
import invoker.IHM;
import invoker.IHMListener;
import invoker.IHMimpl;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class Editeur {

	public static void main(String[] args) {
		IHM ihm = new IHMimpl();
		
		ClipBoard clipboard = new ClipBoard();
		Selection selection = new Selection();
		Buffer buffer = new Buffer();		
		EditorEngine engine = new EngineImpl(selection, clipboard, buffer);
		
		IHMListener listener = ihm.createListener();		
		Command copy = new Copy(engine);
		Command cut = new Cut(engine);
		Command erase = new Erase(engine);
		Command paste = new Paste(engine);
		Command select = new Select(engine);
		Command type = new Type(engine);
		listener.setCommand(copy, cut, erase, paste, select, type);
		engine.setCommand(copy, cut, erase, paste, select, type);
		
		ihm.createView();
	}

}
