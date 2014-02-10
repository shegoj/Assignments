package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartApp {

	public static void main (String args[]) throws IOException {

		T_App t_app = new T_App();

		boolean CONTINUE = true;
		BufferedReader reader = null;
		System.out.println("Console Based Social Networking\n=================================\n");
		System.out.println("press 'q' is quit");

		while (CONTINUE) {	
			System.out.print(">");
			reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			if (input.equals("q"))
				break;

			t_app.commandAnaylzer(input);	
		}
		reader.close();
	}
}
