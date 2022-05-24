package br.com.game.protocols;

public interface Character {
	
	// getters
	
	public String getName();
	
	public double getFlatAttack();
	
	public double getHp();
	
	// utils
	
	public boolean damage(double damage);
	
	public double getTotalDamage();
	
	// default
	
	
}
