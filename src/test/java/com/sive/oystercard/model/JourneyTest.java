package com.sive.oystercard.model;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class JourneyTest {

	private Station startStation;
	private Station endStation;
	private TransportationType transportationType;
	private Journey journey;

	@Before
	public void setUp() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		startStation = new Station("Holborn", set1);

		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(1);
		set2.add(2);
		endStation = new Station("EarlsCourt", set2);
		transportationType = TransportationType.TUBE;
		journey = new Journey(startStation, endStation, transportationType);
	}

	@Test
	public void testExpect1AsCommonZone() {
		assertEquals(1, journey.getCommonZone(), 0);
	}
	
	@Test
	public void testExpect2AsCommonZone() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		startStation = new Station("EarlsCourt", set1);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		endStation = new Station("Hammersmith", set2);
		
		transportationType = TransportationType.TUBE;
		journey = new Journey(startStation, endStation, transportationType);
		assertEquals(2, journey.getCommonZone(), 0);
	}

}
