package com.fuze.argoqr;

import java.util.ArrayList;

public class GamePlayer {
	private String name;
	private TW tower_play;
	private TW wall_play;
	// Resources_player res_p[]=new Resources_player[];
	private  ArrayList<Resources_player> res_p = new ArrayList<Resources_player>(6);
	GamePlayer(TW tower_play,TW wall_play,String name){
		this.setName(name);
		this.setTower_play(tower_play);
		this.setWall_play(wall_play);
	}

	public TW getTower_play() {
		return tower_play;
	}
	//высота башни
	public int getTower_val(){
		return getTower_play().getVal();
	}
	
	
	public void  AddRes(Resources_player res){
		res_p.add(res);
		
	}
	/**Установка высоты башни*/
	public void setTower_val(int val) {
		this.tower_play.setVal(val);
	}
	

	public void setTower_play(TW tower_play) {
		this.tower_play = tower_play;
	}
	
	/**устанавливаем ресурс*/
	public void setRes(int index,int val){
		res_p.get(index).setVal(val);
		}
	
	/**значение ресурса*/
	public int getRes(int index){
		return res_p.get(index).getVal();
		
	}
	/**изменяем ресурс*/
	public void chang(int index,int c){
		res_p.get(index).Canged(c);
	}

	public TW getWall_play() {
		return wall_play;
	}
	/**высота стены*/
	public int getWall_val(){
		return getWall_play().getVal();
	}
	/**Установка высоты стены*/
	public void setWall_val(int val){
		this.wall_play.setVal(val);
	}

	public void setWall_play(TW wall_play) {
		this.wall_play = wall_play;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
