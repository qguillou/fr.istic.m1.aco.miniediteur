package fr.istic.m1.aco.miniediteur.v1;


import invoker.IHM;
import invoker.IHMImpl;
import invoker.IHMListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestIHMImpl {
	
	IHM ihm;
	
	@Before
	public void initialize(){
		ihm = new IHMImpl(new IHMListener());
	}
	
	@Test
	public void testIHMImpl() {
		Assert.assertNotNull("IHMImpl() - Variables aren't initialized", ihm.getTextArea());
		Assert.assertNotNull("IHMImpl() - Variables aren't initialized", ihm.getListener());
	}

	@Test
	public void testGetTextArea() {
		Assert.assertNotNull("GetTextArea() - Variables is null", ihm.getTextArea());
	}

	@Test
	public void testGetListener() {
		Assert.assertNotNull("GetTextArea() - Variables is null", ihm.getListener());
	}
}
