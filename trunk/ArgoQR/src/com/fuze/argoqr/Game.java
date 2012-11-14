package com.fuze.argoqr;

import android.content.Context;
import android.widget.Toast;
  

public class Game {
	private GamePlayer player1;
	private GamePlayer player2;
	/** текущий игрок*/
	private GamePlayer curent_player;
	/** противник текущего*/
	private GamePlayer n_curent_player;
	/**true ==player1  false ==player2*/
	private boolean player_flag;
	
	
	
	Game(String name1,TW tower_play1,TW wall_play1,
		 String name2,TW tower_play2,TW wall_play2){
		setPlayer1(new GamePlayer(tower_play1, wall_play1, name1));
		setPlayer2(new GamePlayer(tower_play2, wall_play2, name2));
		set_curent_pl1();
		
		
	}
	
	private void set_curent_pl1(){
		setCurent_player(player1);
		setN_curent_player(player2);
		player_flag=true;
	}
	
	private void set_curent_pl2(){
		setCurent_player(player2);
		setN_curent_player(player1);
		player_flag=false;
	}
	
	public void set_next_player_curent()
	{
		if(player_flag==true){
			set_curent_pl2();
		}else{
			set_curent_pl1();
		}
	}
	
	public GamePlayer getPlayer1() {
		return player1;
	}
	public void setPlayer1(GamePlayer player1) {
		this.player1 = player1;
	}
	public GamePlayer getPlayer2() {
		return player2;
	}
	public void setPlayer2(GamePlayer player2) {
		this.player2 = player2;
	}
	public GamePlayer getCurent_player() {
		return curent_player;
	}
	public void setCurent_player(GamePlayer curent_player) {
		this.curent_player = curent_player;
	}

	public GamePlayer getN_curent_player() {
		return n_curent_player;
	}

	public void setN_curent_player(GamePlayer n_curent_player) {
		this.n_curent_player = n_curent_player;
	}

	public boolean isPlayer_flag() {
		return player_flag;
	}

	public void setPlayer_flag(boolean player_flag) {
		this.player_flag = player_flag;
	}
	
}
