package br.com.game.protocols;

public interface Sword extends Weapon{
	
	// utils
	public int getUsageTime();
	
	public void setUsageTime(int usageTime);
	
	// default methods
	
	@Override
	default String type() {
		return this.getClass().getSimpleName();
	}
	
	default int swordDefalultUsageTime() {
		return 2;
	}
	
	default public boolean decreaseUsageTime() {
		int result = this.getUsageTime() - 1; 
		
		if (result > 0) {
			this.setUsageTime(result);
			return true;
		}
		
		return false;
	}
}
