package com.jh.common;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File file = new File("src/main/webapp/resources/⁨static⁩/img/12.png");
		System.out.println(file.getAbsolutePath());
	}
}
