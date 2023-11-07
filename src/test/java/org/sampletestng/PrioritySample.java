package org.sampletestng;

import org.testng.annotations.Test;

public class PrioritySample {
	@Test()
	private void tc11() {
		System.out.println("Test-11");
	}
	@Test
	private void tc22() {
		System.out.println("Test-55");
	}
	@Test()
	private void tc33() {
		System.out.println("Test-44");
	}
	@Test()
	private void tc44() {
		System.out.println("Test-22");
	}
	@Test()
	private void tc55() {
		System.out.println("Test-33");
	}
}
