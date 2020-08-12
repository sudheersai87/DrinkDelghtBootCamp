package com.cg.drinkDelight.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.drinkDelight.dao.DrinkDelightDao;
import com.cg.drinkDelight.entity.Vendor;
import com.cg.drinkDelight.exception.NoVendorException;
import com.cg.drinkDelight.service.DrinkDelightService;
import com.cg.drinkDelight.service.ServiceImpl;

/*@SpringBootTest*/
public class VendorTest {

	@Mock
	private DrinkDelightDao dao;
	
	@InjectMocks
	private ServiceImpl ser;
	
	@Mock
	private Vendor vendor;
	@BeforeEach
	
	  public void setup() { //if we don't call below, we will get NullPointerException 
	  MockitoAnnotations.initMocks(this); }
	 
	@Test
	public void addVendorTest() throws NoVendorException {
		Vendor ven = new Vendor();
		ven.setAddress("abcdef");;
		
		when(dao.addVendor(ven)).thenReturn(false);
		assertFalse("vendor added", ser.addvendor(ven));
		
		

		
		
	}
	@Test
	public void test2() throws NoVendorException {
		
		when(dao.viewVendor(1001)).thenReturn(vendor);
		assertEquals(vendor, ser.viewvendor(1001));
	}
	
	@Test
	public void test3() throws NoVendorException {
		
		when(dao.editVendor(vendor)).thenReturn(true);
		assertEquals("vendor edited",true, ser.editvendor(vendor));
	}
	@Test
	public void test4() throws NoVendorException {
		List<Vendor> vendor1 = new ArrayList<Vendor>();
		vendor1.add(vendor);
		when(dao.viewVendorbyType("supplier")).thenReturn(vendor1);
		assertEquals(vendor1, ser.viewvendorbyType("supplier"));
	}
	
	@Test
	public void test5() throws NoVendorException {
		Vendor ven = new Vendor();
		ven.setAddress("abcdef");
		when(dao.addVendor(ven)).thenReturn(true);
		assertTrue("vendor added", ser.addvendor(ven));
		
	}

	
	

}
