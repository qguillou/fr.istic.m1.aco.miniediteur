package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClipBoard {
	
	ClipBoard clipboard;
	
	@Before
	public void initialize() {
		clipboard = new ClipBoard();
	}
	
	@Test
	public void testGetText() {
		Assert.assertTrue("GetText() - text doesn't void at start", clipboard.getText().equals(""));
	}

	@Test
	public void testSetText() {
		clipboard.setText("texte");
		Assert.assertTrue("SetText() - text doesn't set", clipboard.getText().equals("texte"));
	}

}
