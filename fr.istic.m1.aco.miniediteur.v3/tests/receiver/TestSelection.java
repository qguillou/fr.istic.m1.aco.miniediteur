package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSelection {
	
	private Selection selection;
	
	@Before
	public void initialize(){
		selection = new Selection();
	}
	
	@Test
	public void testSelection() {
		Assert.assertTrue("Selection() - Start isn't initialized at 0", selection.getStart() == 0);
		Assert.assertTrue("Selection() - Length isn't initialized at 0", selection.getLength() == 0);
	}

	@Test
	public void testGetStart() {
		Assert.assertTrue("GetStart() - Start isn't initialized at 0", selection.getStart() == 0);
		selection.setStart(1);
		Assert.assertTrue("GetStart() - Start isn't set", selection.getStart() == 1);
	}

	@Test
	public void testSetStart() {
		selection.setStart(1);
		Assert.assertTrue("SetStart() - Start isn't set", selection.getStart() == 1);
	}

	@Test
	public void testGetLength() {
		Assert.assertTrue("GetLength() - Length isn't initialized at 0", selection.getLength() == 0);
		selection.setLength(1);
		Assert.assertTrue("GetLength() - Length isn't set", selection.getLength() == 1);
	}

	@Test
	public void testSetLength() {
		selection.setLength(1);
		Assert.assertTrue("SetLength() - Length isn't set", selection.getLength() == 1);
	}

}
