package br.com.game.utils;

public class PickLuck {
	
	private boolean[] wasLuck;
	private double chanceToLuck;
	
	public PickLuck(double chanceToLuck) {
		initialize(chanceToLuck);
	}
	
	private void initialize(double chanceToLuck) {
		this.chanceToLuck =  Math.round(chanceToLuck);
		wasLuck = new boolean[100];
		for (int i = 0; i < 100; i++) {
			wasLuck[i] = i + 1 < this.chanceToLuck; 
		}
	}
	
	public boolean areYouLuck() {
		int result = (int) Math.floor(Math.random() * 100);
		return wasLuck[result];
	}
	
	public void changeYouLuck(double newChance) {
		initialize(newChance);
	}
	
	public void increaseYouLuck(double luckIncrease) {
		initialize(this.chanceToLuck + luckIncrease);
	}
}
