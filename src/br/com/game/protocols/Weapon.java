package br.com.game.protocols;

import br.com.game.utils.SubAtributesType;

public interface Weapon {
	
	public double damage();
	
	public double subAttr();
	
	public SubAtributesType SubAtrrType();
	
	public String type();
	
	public int tier();
}
