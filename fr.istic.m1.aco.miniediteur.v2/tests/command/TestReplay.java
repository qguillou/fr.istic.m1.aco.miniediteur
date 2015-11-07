package command;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import originator.CommandRecordable;
import originator.PasteRecordable;
import originator.TypeRecordable;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;
import caretaker.Recorder;
import caretaker.RecorderImpl;

public class TestReplay {
	
	private Command command;
	private EditorEngine engine;
	private ClipBoard clipboard;
	private Buffer buffer;
	private Selection selection;
	private IHM ihm;
	private Recorder recorder;
	private Map<String, CommandRecordable> commandsRecordable;
	
	@Before
	public void initialize() {
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		recorder = new RecorderImpl();
		commandsRecordable = new HashMap<String, CommandRecordable>();
		commandsRecordable.put("paste", new PasteRecordable(engine, ihm, recorder));
		commandsRecordable.put("type", new TypeRecordable(engine, ihm, recorder));
		recorder.setCommand(commandsRecordable);
		command = new Replay(engine, ihm, recorder);
	}
	
	@Test
	public void testExecute() {
		clipboard.setText("Texte copié");
		recorder.setRecording();
		commandsRecordable.get("paste").execute();
		Assert.assertTrue("TestExecute() - Text doesn't paste in buffer", engine.getText().equals("Texte copié"));
		recorder.setRecording();
		command.execute();
		Assert.assertTrue("TestExecute() - Replay doesn't execute well", engine.getText().equals("Texte copiéTexte copié"));
		
		buffer.setText("");
		selection.setStart(0);
		selection.setLength(0);
		recorder.setRecording();
		commandsRecordable.get("paste").execute();
		ihm.getListener().setLastChar("a");
		commandsRecordable.get("type").execute();
		recorder.setRecording();
		command.execute();
		Assert.assertTrue("TestExecute() - Replay doesn't execute well", engine.getText().equals("Texte copiéaTexte copiéa"));
	}

}
