package originator;

import java.util.HashMap;
import java.util.Map;

import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

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

public class TestDeleteRecordable {
	
	private static final String COMMAND = "delete";
	private EditorEngine engine;
	private Selection selection;
	private IHM ihm;
	private Recorder recorder;
	private Map<String, CommandRecordable> command;
	
	@Before
	public void initialize() {
		selection = new Selection();
		engine = new EngineImpl(selection, new ClipBoard(), new Buffer());
		ihm = new IHMImpl(new IHMListener());
		recorder = new RecorderImpl();
		command = new HashMap<String, CommandRecordable>();
		command.put("delete", new DeleteRecordable(engine, ihm, recorder));
		
		recorder.setCommand(command);
		
		//Vérification de l'initialisation
		Assert.assertFalse("Recorder - recording attribute doesn't false", recorder.getRecording());
	}

	@Test
	public void testReplay() {
		engine.type("test");
		command.get(COMMAND).execute();		
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals("test"));
		
		selection.setStart(0);
		command.get(COMMAND).execute();	
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals("est"));
		
		recorder.replay();
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals("est"));
		
		recorder.setRecording();
		command.get(COMMAND).execute();	
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals("st"));
		recorder.setRecording();
		recorder.replay();
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals("t"));
		
		recorder.replay();
		Assert.assertTrue("TestReplay() - DeleteRecordable doesn't well update buffer content", engine.getText().equals(""));
	}

}
