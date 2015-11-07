package caretaker;

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
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

import command.Command;
import command.Replay;

public class TestRecorderImpl {
	
	private Recorder recorder;
	private Map<String, CommandRecordable> commandsRecordable;
	private Map<String, Command> commands;
	private EditorEngine engine;
	
	@Before
	public void initialize() {
		recorder = new RecorderImpl();
		commandsRecordable = new HashMap<String, CommandRecordable>();
		commands = new HashMap<String, Command>();
		engine = new EngineImpl(new Selection(), new ClipBoard(), new Buffer());
		IHMListener listener = new IHMListener();
		IHM ihm = new IHMImpl(listener);
		commandsRecordable.put("paste", new PasteRecordable(engine, ihm, recorder));
		commands.put("replay", new Replay(engine, ihm, recorder));
		recorder.setCommand(commandsRecordable);
	}
	
	@Test
	public void testRecord() {
		
	}

	@Test
	public void testReplay() {
		recorder.replay();
		Assert.assertTrue("TestReplay() - Replay something but no comand record", engine.getText().equals(""));
		
		engine.getClipboard().setText("Mon texte");
		recorder.setRecording();
		commandsRecordable.get("paste").execute();
		Assert.assertTrue("TestReplay() - Paste doesn't been execute", engine.getText().equals("Mon texte"));
		recorder.setRecording();
		commands.get("replay").execute();
		Assert.assertTrue("TestReplay() - Paste doesn't been execute", engine.getText().equals("Mon texteMon texte"));
		commands.get("replay").execute();
		Assert.assertTrue("TestReplay() - Paste doesn't been execute", engine.getText().equals("Mon texteMon texteMon texte"));
		recorder.setRecording();
		commands.get("replay").execute();
		Assert.assertTrue("TestReplay() - Paste doesn't been execute", engine.getText().equals("Mon texteMon texteMon texte"));
	}
}
