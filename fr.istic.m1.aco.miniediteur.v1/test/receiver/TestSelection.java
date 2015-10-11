package receiver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSelection {
	
	Selection selection;
	
	@Before
	public void initialize() {
		selection = new Selection();
	}
	
	@Test
	public void testGetStart() {
		Assert.assertTrue("GetStart() - ", selection.getStart() == 0);
	}

	@Test
	public void testSetStart() {
		selection.setStart(1);
		Assert.assertTrue("setStart() - ", selection.getStart() == 1);
	}

	@Test
	public void testGetLength() {
		Assert.assertTrue("GetLength() - ", selection.getLength() == 0);
	}

	@Test
	public void testSetLength() {
		selection.setLength(1);
		Assert.assertTrue("setLength() - ", selection.getLength() == 1);
	}

}
