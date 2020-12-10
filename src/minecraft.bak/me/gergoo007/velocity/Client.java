package me.gergoo007.velocity;

import org.lwjgl.opengl.Display;

public class Client {
	
	public static final String name = "Velocity";
	public static final String version = "B0";
	public static final String title = name + " " + version;

	public static void onStartup() {
		System.out.println("Starting up " + Client.title);
		
		Display.setTitle(Client.title);
	}
	
}
