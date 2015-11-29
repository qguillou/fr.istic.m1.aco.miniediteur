package caretaker;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;
import memento.MementoEngine;
import originator.CommandRecordable;
import originator.PasteRecordable;
import receiver.Buffer;
import receiver.ClipBoard;
import receiver.EditorEngine;
import receiver.EngineImpl;
import receiver.Selection;

public class TestRecorderImpl {
	
	private Recorder recorder;
	private EditorEngine engine;
	private ClipBoard clipboard;
	private Buffer buffer;
	private IHM ihm;
	
	@Before
	public void initialize() {
		ihm = new IHMImpl(new IHMListener());
		clipboard = new ClipBoard();
		buffer = new Buffer();
		engine = new EngineImpl(new Selection(), clipboard, buffer);
		recorder = new RecorderImpl();
	}

	@Test
	public void testRecord() {
		clipboard.setText("test");
		Map<String, CommandRecordable> commands = new HashMap<String, CommandRecordable>();
		CommandRecordable command = new PasteRecordable(engine, ihm, recorder);
		commands.put("paste", command);
		recorder.setCommand(commands);
		recorder.record(command);
		
		recorder.replay();
		Assert.assertTrue("Command doesn't been record", buffer.getText().equals("test"));
	}

	@Test
	public void testReplay() {
		recorder.replay();
		Assert.assertTrue("Command replay but no command record", buffer.getText().equals(""));
		
		clipboard.setText("test");
		Map<String, CommandRecordable> commands = new HashMap<String, CommandRecordable>();
		CommandRecordable command = new PasteRecordable(engine, ihm, recorder);
		commands.put("paste", command);
		recorder.setCommand(commands);
		recorder.record(command);
		
		recorder.replay();
		Assert.assertTrue("Command doesn't been replay", buffer.getText().equals("test"));
	}

	@Test
	public void testSetRecording() {
		Assert.assertFalse("Recording default true", recorder.getRecording());
		recorder.setRecording();
		Assert.assertTrue("Recording default true", recorder.getRecording());
	}

	@Test
	public void testGetRecording() {
		Assert.assertFalse("Recording default true", recorder.getRecording());
		recorder.setRecording();
		Assert.assertTrue("Recording default true", recorder.getRecording());
	}

	@Test
	public void testUndoAndRedo() {
		clipboard.setText("test");
		Map<String, CommandRecordable> commands = new HashMap<String, CommandRecordable>();
		CommandRecordable command = new PasteRecordable(engine, ihm, recorder);
		commands.put("paste", command);
		recorder.setCommand(commands);		
		command.execute();
		clipboard.setText(" ok");
		command.execute();
		
		Assert.assertTrue("Buffer content doesn't the expect content", buffer.getText().equals("test ok"));
	
		MementoEngine mEngine = recorder.undo();
		Assert.assertTrue("Buffer content doesn't the expect content", mEngine.getStateBuffer().equals("test"));
		mEngine = recorder.undo();
		//Nous devons retourner à l'état d'un buffer vide, le traitement n'est pas effectué ici
		Assert.assertNull("Buffer content doesn't the expect content", mEngine);
		
		mEngine = recorder.redo();
		mEngine = recorder.redo(); //retour à l'état test ok
		Assert.assertTrue("Buffer content doesn't the expect content", mEngine.getStateBuffer().equals("test ok"));
		
		mEngine = recorder.undo(); // test
		buffer.setText(mEngine.getStateBuffer());
		engine.select(4, 0);
		clipboard.setText(" fail");
		command.execute(); // test fail
		Assert.assertTrue("Buffer content doesn't the expect content", buffer.getText().equals("test fail"));
		buffer.setText(mEngine.getStateBuffer());
		mEngine = recorder.undo();
		Assert.assertTrue("Buffer content doesn't the expect content", mEngine.getStateBuffer().equals("test"));
		buffer.setText(mEngine.getStateBuffer());
		mEngine = recorder.redo();
		buffer.setText(mEngine.getStateBuffer());
		Assert.assertTrue("Buffer content doesn't the expect content", mEngine.getStateBuffer().equals("test fail"));
	}
}
