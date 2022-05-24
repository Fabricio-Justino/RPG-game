package br.com.game.player;

import java.lang.reflect.Method;

import br.com.game.protocols.Character;
import br.com.game.protocols.Weapon;
import br.com.game.utils.HelpTools;
import br.com.game.utils.PickLuck;

public class Player implements Character {

	private String name;
	private double flatAttack;
	private double hp;
	public double criticalChance;
	public double criticalDamage;
	public double attacksBuff;
	private Weapon weapon;
	private PickLuck isCritical;

	public Player(String name, double flatAttack) {
		this.name = name;
		this.flatAttack = flatAttack;
		this.criticalChance = 50;
		this.criticalDamage = 0;
		this.attacksBuff = 0;
		
		this.isCritical = new PickLuck(this.criticalChance);
	}
	
	// getters
	
	public double getCriticalChance() {
		return criticalChance;
	}

	public double getCriticalDamage() {
		return criticalDamage;
	}

	public double getAttacksBuff() {
		return attacksBuff;
	}
	
	// utils
	
	@SuppressWarnings("unused")
	private void attacksBuff(Weapon weapon) {
		this.attacksBuff += weapon.subAttr();
	}
	
	

	@SuppressWarnings("unused")
	private void criticalChance(Weapon weapon) {
		this.criticalChance += weapon.subAttr();
		
		this.isCritical.changeYouLuck(this.criticalChance);
	}
	
	@SuppressWarnings("unused")
	private void criticalDamage(Weapon weapon) {
		this.criticalDamage += weapon.subAttr();
	}
	
	
	public void equipWeapon(Weapon weapon) {
		this.flatAttack += weapon.damage();
		
		try {
			String methodName = HelpTools.snakeToCamel(weapon.SubAtrrType().toString());
			Method method = this.getClass().getDeclaredMethod(methodName, Weapon.class);
			
			method.invoke(this, weapon);
			
			this.weapon = weapon;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// override methods

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getFlatAttack() {
		return this.flatAttack;
	}

	@Override
	public double getHp() {
		return this.hp;
	}

	@Override
	public boolean damage(double damage) {
		this.hp -= (damage < this.hp) ? damage : this.hp;
		
		return this.hp <= 0;
	}

	@Override
	public double getTotalDamage() {
		double result = flatAttack * (1 + (attacksBuff/100));
				
		if (isCritical.areYouLuck()) {
			result *= (1 + ((50 + criticalDamage)/100)); 
		}
		
		return result;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
