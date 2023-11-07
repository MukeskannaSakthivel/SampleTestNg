package org.sampletestng;

import org.testng.annotations.Test;

public class IgnoreSample {
	/*@Test()
	private void tc111() {
		System.out.println("Test-111");
	}
	@Test
	private void tc222() {
		System.out.println("Test-555");
	}
	@Test()
	private void tc333() {
		System.out.println("Test-444");
	}
	@Test()
	private void tc444() {
		System.out.println("Test-222");
	}*/
	@Test(enabled=false)
	private void tc555() {
		System.out.println("Test-333");
	}
}
