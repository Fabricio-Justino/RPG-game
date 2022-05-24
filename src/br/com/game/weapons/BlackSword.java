package br.com.game.weapons;

import br.com.game.protocols.Sword;
import br.com.game.utils.SubAtributesType;

public class BlackSword implements Sword {
	private int damage;
	private int ussageTimes;
	
	public BlackSword() {
		this.damage = 200;
		this.ussageTimes = swordDefalultUsageTime();
	}

	@Override
	public double damage() {
		return this.damage;
	}

	@Override
	public double subAttr() {
		return 200;
	}

	@Override
	public SubAtributesType SubAtrrType() {
		return SubAtributesType.ATTACKS_BUFF;
	}

	@Override
	public int tier() {
		return 4;
	}

	@Override
	public int getUsageTime() {
		return 0;
	}

	@Override
	public void setUsageTime(int usageTimes) {
		if (usageTimes <= 0) {
			throw new IllegalArgumentException("uageTime must be positive");
		}
		this.ussageTimes = ussageTimes;
	}

}
