package originator;

import static org.junit.Assert.fail;
import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;
import caretaker.Recorder;
import caretaker.RecorderImpl;

public class TestPasteRecordable {
	
	private CommandRecordable command;
	private EditorEngine engine;
	private ClipBoard clipboard;
	private Buffer buffer;
	private Selection selection;
	private IHM ihm;
	private Recorder recorder;
	
	@Before
	public void initialize() {
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		selection = new Selection();
		engine = new EngineImpl(selection, clipboard, buffer);
		recorder = new RecorderImpl();
		command = new PasteRecordable(engine, ihm, recorder);
		Map<String, CommandRecordable> commands = new HashMap<String, CommandRecordable>();
		commands.put("paste", command);
		recorder.setCommand(commands);
		
		//Tests of initialization
		Assert.assertTrue("PasteRecordable initialization - buffer text doesn't empty", engine.getText().equals(""));
		recorder.replay();
		Assert.assertTrue("PasteRecordable initialization - recorder isn't empty", engine.getText().equals(""));
		Assert.assertFalse("PasteRecordable initialization - recorder isn't default false", recorder.getRecording());
	}
	
	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

	@Test
	public void testPasteRecordable() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testRestore() {
		fail("Not yet implemented");
	}
}
