package io.ffreedom.jctp;

import java.io.File;

import io.ffreedom.common.env.SysPropertys;

public class PathTest {
	
	public static void main(String[] args) {
		
		SysPropertys.showAll();
		
		System.out.println("=========================================");
		
		System.out.println(new File("").getAbsolutePath() + "/lib");
		
	}

}
