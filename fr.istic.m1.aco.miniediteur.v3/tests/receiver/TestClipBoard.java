package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClipBoard {
	
	private ClipBoard clipboard;
	
	@Before
	public void initialize(){
		clipboard = new ClipBoard();
	}
	
	@Test
	public void testBuffer(){
		Assert.assertTrue("ClipBoard() - Content clipboard isn't empty after initialized", clipboard.getText().equals(""));
	}
	
	@Test
	public void testGetText() {
		Assert.assertTrue("GetText() - Content clipboard isn't empty after initialized", clipboard.getText().equals(""));
		clipboard.setText("test");
		Assert.assertTrue("GetText() - Content clipboard isn't the set text", clipboard.getText().equals("test"));
	}

	@Test
	public void testSetText() {
		clipboard.setText("test");
		Assert.assertTrue("SetText() - Content clipboard isn't the set text", clipboard.getText().equals("test"));
	}

}
