package br.com.game.utils;

import java.util.List;

public class HelpTools {
	
	
	private static String title(String noTitled) {
		return (noTitled.charAt(0)+"").toUpperCase() + noTitled.substring(1, noTitled.length());
	}
	
	public static String snakeToCamel(String snake) {
		String[] splited = snake.toLowerCase().split("[_]");
		return splited[0] + List.of(splited).stream()
		.skip(1)
		.map(el -> title(el))
		.reduce((a, b) -> a+b)
		.get();
	}
}
