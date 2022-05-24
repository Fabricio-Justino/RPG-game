package br.com.run.test;

import br.com.game.player.Player;
import br.com.game.weapons.BlackSword;

public class main {

	public static void main(String[] args) {
		
		Player pp = new Player("fabricio", 200);
		
		System.out.println("attack: " + pp.getFlatAttack());
		
		System.out.println(pp);
		
		System.out.println(pp.getAttacksBuff());
		
		BlackSword bs = new BlackSword();
		pp.equipWeapon(bs);
		
		System.out.println("attack: " + pp.getFlatAttack());
		
		System.out.println(pp.getTotalDamage());
		
		
		
	}

}
