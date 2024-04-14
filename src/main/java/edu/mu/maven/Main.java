package edu.mu.maven;

import java.util.Scanner;

import edu.mu.maven.loginWindow.InitialScreen;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		new InitialScreen(scanner);

	}

}
