package com.fuze.argoqr;
import com.fuze.argoqr.Resources_player;

/** карта */
public class Card {
	/** код карты */
	private String id;
	/** её текущий номер в колоде */
	private int numer;
	/** имя карты */
	private String Name;
	/** файл картинки */
	private String Picture;
	/** описание карты */
	private String Description;
	/** тип карты(цвет) 0-красная 1-синяя 2-зелёная */
	private int Type;
	/** cтоимость */
	private int Requirements;

	/** свои животные */
	private int PlayerChanges_beasts = 0;
	/** свои кирпичей */
	private int PlayerChanges_bricks = 0;
	/** свои драгоценности */
	private int PlayerChanges_gems = 0;
	/** свои башня */
	private int PlayerChanges_tower = 0;
	/** свои стена */
	private int PlayerChanges_wall = 0;

	/** врага животные */
	private int EnemyChanges_beasts = 0;
	/** врага кирпичи */
	private int EnemyChanges_bricks = 0;
	/** врага драгоценности */
	private int EnemyChanges_gems = 0;
	/** врага башня */
	private int EnemyChanges_tower = 0;
	/** врага стена */
	private int EnemyChanges_wall = 0;

	/** свои зоопарк */
	private int PlayerMod_beasts = 0;
	/** свои рудник */
	private int PlayerMod_bricks = 0;
	/** свои магия */
	private int PlayerMod_gems = 0;
	/** врага зоопарк */
	private int EnemyMod_beasts = 0;
	/** врага рудник */
	private int EnemyMod_bricks = 0;
	/** врага магия */
	private int EnemyMod_gems = 0;

	/** урон врагу */
	private int Damage_enemy = 0;
	/** урон себе */
	private int Damage_self = 0;

	/** ещё ход */
	private int Turn = 0;
	/**выбросить карту*/
	private int DiscardCard=0;

	/**
	 * Спец ход
	 * 
	 * @param 1 "Если Карьер меньше чем у врагa\nКарьер +2\nиначе Карьер +1
	 * @param 2 Если Карьер меньше вражьего то Карьер равен вражьему Карьеру
	 * @param 3 если Стена = 0\nСтена +6 иначе Стена +3
	 * @param 4 Магия всех одинакова
	 * @param 5 если стена врага = 0 враг получает 10 урона, иначе 6 урона
	 * @param 6 если стена врага > 0,враг получает 10 урона,иначе 7 урона
	 * @param 7 если Магия больше Магии врага враг получает 12 урона иначе 7
	 *        урона
	 * @param 8 если стена больше стены врага башня врага -6, иначе враг
	 *        получает 6 урона
	 */
	private int Script = 0;

	public Card(String id, int num) {

		this.id = id;
		this.numer = num;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getPicture() {
		return Picture;
	}

	public String getDescription() {
		return Description;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	/** её текущий номер в колоде */
	public int getNumer() {
		return numer;
	}

	/** её текущий номер в колоде */
	public void setNumer(int numer) {
		this.numer = numer;
	}

	/** тип карты(цвет) 0-красная 1-синяя 2-зелёная */
	public int getType() {
		return Type;
	}

	/** тип карты(цвет) 0-красная 1-синяя 2-зелёная */
	public void setType(int type) {
		Type = type;
	}

	/** cтоимость */
	public int getRequirements() {
		return Requirements;
	}

	/** cтоимость */
	public void setRequirements(int requirements) {
		Requirements = requirements;
	}

	/**
	 * свои животные
	 * 
	 * @return the playerChanges_beasts
	 * 
	 */
	public int getPlayerChanges_beasts() {
		return PlayerChanges_beasts;
	}

	/**
	 * свои животные
	 * 
	 * @param playerChanges_beasts
	 *            the playerChanges_beasts to set
	 * 
	 */
	public void setPlayerChanges_beasts(int playerChanges_beasts) {
		PlayerChanges_beasts = playerChanges_beasts;
	}

	/**
	 * свои кирпичей
	 * 
	 * @return the playerChanges_bricks
	 */
	public int getPlayerChanges_bricks() {
		return PlayerChanges_bricks;
	}

	/**
	 * свои кирпичей
	 * 
	 * @param playerChanges_bricks
	 *            the playerChanges_bricks to set
	 */
	public void setPlayerChanges_bricks(int playerChanges_bricks) {
		PlayerChanges_bricks = playerChanges_bricks;
	}

	/**
	 * свои драгоценности
	 * 
	 * @return the playerChanges_gems
	 */
	public int getPlayerChanges_gems() {
		return PlayerChanges_gems;
	}

	/**
	 * свои драгоценности
	 * 
	 * @param playerChanges_gems
	 *            the playerChanges_gems to set
	 */
	public void setPlayerChanges_gems(int playerChanges_gems) {
		PlayerChanges_gems = playerChanges_gems;
	}

	/**
	 * свои башня
	 * 
	 * @return the playerChanges_tower
	 */
	public int getPlayerChanges_tower() {
		return PlayerChanges_tower;
	}

	/**
	 * свои башня
	 * 
	 * @param playerChanges_tower
	 *            the playerChanges_tower to set
	 */
	public void setPlayerChanges_tower(int playerChanges_tower) {
		PlayerChanges_tower = playerChanges_tower;
	}

	/**
	 * свои стена
	 * 
	 * @return the playerChanges_wall
	 */
	public int getPlayerChanges_wall() {
		return PlayerChanges_wall;
	}

	/**
	 * свои стена
	 * 
	 * @param playerChanges_wall
	 *            the playerChanges_wall to set
	 */
	public void setPlayerChanges_wall(int playerChanges_wall) {
		PlayerChanges_wall = playerChanges_wall;
	}

	/**
	 * врага животные
	 * 
	 * @return the enemyChanges_beasts
	 */
	public int getEnemyChanges_beasts() {
		return EnemyChanges_beasts;
	}

	/**
	 * врага животные
	 * 
	 * @param enemyChanges_beasts
	 *            the enemyChanges_beasts to set
	 */
	public void setEnemyChanges_beasts(int enemyChanges_beasts) {
		EnemyChanges_beasts = enemyChanges_beasts;
	}

	/**
	 * врага кирпичи
	 * 
	 * @return the enemyChanges_bricks
	 */
	public int getEnemyChanges_bricks() {
		return EnemyChanges_bricks;
	}

	/**
	 * врага кирпичи
	 * 
	 * @param enemyChanges_bricks
	 *            the enemyChanges_bricks to set
	 */
	public void setEnemyChanges_bricks(int enemyChanges_bricks) {
		EnemyChanges_bricks = enemyChanges_bricks;
	}

	/**
	 * врага драгоценности
	 * 
	 * @return the enemyChanges_gems
	 */
	public int getEnemyChanges_gems() {
		return EnemyChanges_gems;
	}

	/**
	 * врага драгоценности
	 * 
	 * @param enemyChanges_gems
	 *            the enemyChanges_gems to set
	 */
	public void setEnemyChanges_gems(int enemyChanges_gems) {
		EnemyChanges_gems = enemyChanges_gems;
	}

	/**
	 * врага башня
	 * 
	 * @return the enemyChanges_tower
	 */
	public int getEnemyChanges_tower() {
		return EnemyChanges_tower;
	}

	/**
	 * врага башня
	 * 
	 * @param enemyChanges_tower
	 *            the enemyChanges_tower to set
	 */
	public void setEnemyChanges_tower(int enemyChanges_tower) {
		EnemyChanges_tower = enemyChanges_tower;
	}

	/**
	 * врага стена
	 * 
	 * @return the enemyChanges_wall
	 */
	public int getEnemyChanges_wall() {
		return EnemyChanges_wall;
	}

	/**
	 * врага стена
	 * 
	 * @param enemyChanges_wall
	 *            the enemyChanges_wall to set
	 */
	public void setEnemyChanges_wall(int enemyChanges_wall) {
		EnemyChanges_wall = enemyChanges_wall;
	}

	/**
	 * свои зоопарк
	 * 
	 * @return the playerMod_beasts
	 */
	public int getPlayerMod_beasts() {
		return PlayerMod_beasts;
	}

	/**
	 * свои зоопарк
	 * 
	 * @param playerMod_beasts
	 *            the playerMod_beasts to set
	 */
	public void setPlayerMod_beasts(int playerMod_beasts) {
		PlayerMod_beasts = playerMod_beasts;
	}

	/**
	 * свои рудник
	 * 
	 * @return the playerMod_bricks
	 */
	public int getPlayerMod_bricks() {
		return PlayerMod_bricks;
	}

	/**
	 * свои рудник
	 * 
	 * @param playerMod_bricks
	 *            the playerMod_bricks to set
	 */
	public void setPlayerMod_bricks(int playerMod_bricks) {
		PlayerMod_bricks = playerMod_bricks;
	}

	/**
	 * свои магия
	 * 
	 * @return the playerMod_gems
	 */
	public int getPlayerMod_gems() {
		return PlayerMod_gems;
	}

	/**
	 * свои магия
	 * 
	 * @param playerMod_gems
	 *            the playerMod_gems to set
	 */
	public void setPlayerMod_gems(int playerMod_gems) {
		PlayerMod_gems = playerMod_gems;
	}

	/**
	 * врага зоопарк
	 * 
	 * @return the enemyMod_beasts
	 */
	public int getEnemyMod_beasts() {
		return EnemyMod_beasts;
	}

	/**
	 * врага зоопарк
	 * 
	 * @param enemyMod_beasts
	 *            the enemyMod_beasts to set
	 */
	public void setEnemyMod_beasts(int enemyMod_beasts) {
		EnemyMod_beasts = enemyMod_beasts;
	}

	/**
	 * врага рудник
	 * 
	 * @return the enemyMod_bricks
	 */
	public int getEnemyMod_bricks() {
		return EnemyMod_bricks;
	}

	/**
	 * врага рудник
	 * 
	 * @param enemyMod_bricks
	 *            the enemyMod_bricks to set
	 */
	public void setEnemyMod_bricks(int enemyMod_bricks) {
		EnemyMod_bricks = enemyMod_bricks;
	}

	/**
	 * врага магия
	 * 
	 * @return the enemyMod_gems
	 */
	public int getEnemyMod_gems() {
		return EnemyMod_gems;
	}

	/**
	 * врага магия
	 * 
	 * @param enemyMod_gems
	 *            the enemyMod_gems to set
	 */
	public void setEnemyMod_gems(int enemyMod_gems) {
		EnemyMod_gems = enemyMod_gems;
	}

	/**
	 * урон врагу
	 * 
	 * @return the damage_enemy
	 */
	public int getDamage_enemy() {
		return Damage_enemy;
	}

	/**
	 * урон врагу
	 * 
	 * @param damage_enemy
	 *            the damage_enemy to set
	 */
	public void setDamage_enemy(int damage_enemy) {
		Damage_enemy = damage_enemy;
	}

	/**
	 * урон себе
	 * 
	 * @return the damage_self
	 */
	public int getDamage_self() {
		return Damage_self;
	}

	/**
	 * урон себе
	 * 
	 * @param damage_self
	 *            the damage_self to set
	 */
	public void setDamage_self(int damage_self) {
		Damage_self = damage_self;
	}

	/**
	 * ещё ход
	 * 
	 * @return the turn
	 */
	public int getTurn() {
		return Turn;
	}

	/**
	 * ещё ход
	 * 
	 * @param turn
	 *            the turn to set
	 */
	public void setTurn(int turn) {
		Turn = turn;
	}

	/**
	 * Спец ход
	 * 
	 * @return the script
	 */
	public int getScript() {
		return Script;
	}

	/**
	 * Спец ход
	 * 
	 * @param script
	 *            the script to set
	 */
	public void setScript(int script) {
		Script = script;
	}

	/**
	 * действие карты
	 * 
	 * @param свой
	 *            игрок
	 * @param враг
	 * @return ещё ход если 1
	 */
	//public int Action(Gambler player_self, Gambler player_enemy) {
	public int Action(GamePlayer player_self, GamePlayer player_enemy) {
		/**
		 * Спец ход

		 */

		switch (Script) {
		/** Если Карьер меньше чем у врагa\nКарьер +2\nиначе Карьер +1 */
		case 1:
			if (player_self.getRes(Resources_player.BRICKS_MOD) < player_enemy.getRes(Resources_player.BRICKS_MOD)) {
				player_self.chang(Resources_player.BRICKS_MOD, 2);
			} else {
				player_self.chang(Resources_player.BRICKS_MOD, 1);
			}
//			if (player_self.getMod_bricks() < player_enemy.getMod_bricks()) {
//				player_self.setMod_bricks(player_self.getMod_bricks() + 2);
//			} else {
//				player_self.setMod_bricks(player_self.getMod_bricks() + 1);
//			}

			return 0;
			/** Если Карьер меньше вражьего то Карьер равен вражьему Карьеру */
		case 2:
			if (player_self.getRes(Resources_player.BRICKS_MOD)  < player_enemy.getRes(Resources_player.BRICKS_MOD) ) {
				player_self.setRes(Resources_player.BRICKS_MOD, player_enemy.getRes(Resources_player.BRICKS_MOD));
			}

			return 0;
			/**если Стена = 0\nСтена +6 иначе Стена +3*/
		case 3:
			if(player_self.getWall_val()==0){
				player_self.setWall_val(6);
			}else{
				player_self.setWall_val(player_self.getWall_val()+3);
			}
			return 0;
		case 4:
			/**Магия всех одинакова*/
			if(player_self.getRes(Resources_player.GEMS_MOD)>player_enemy.getRes(Resources_player.GEMS_MOD)){
				player_enemy.setRes(Resources_player.GEMS_MOD,player_self.getRes(Resources_player.GEMS_MOD));
			}else{
				player_self.setRes(Resources_player.GEMS_MOD, player_enemy.getRes(Resources_player.GEMS_MOD));
			}

			return 0;
			/**если стена врага = 0 враг получает 10 урона, иначе 6 урона*/
		case 5:
			TowerWall tw=new TowerWall(player_enemy.getTower_val(),player_enemy.getWall_val());
			if(player_enemy.getWall_val()==0){
				
				datamage(tw,10);
				
			}else{
				datamage(tw,6);
			}
			player_enemy.setTower_val(tw.tower);
			player_enemy.setWall_val(tw.wall);
				
			return 0;
			/**если стена врага > 0,враг получает 10 урона,иначе 7 урона*/
		case 6:
			TowerWall tw1=new TowerWall(player_enemy.getTower_val(),player_enemy.getWall_val());
			if(player_enemy.getWall_val()>0){
				
				datamage(tw1,10);
				
			}else{
				datamage(tw1,7);
			}
			player_enemy.setTower_val(tw1.tower);
			player_enemy.setWall_val(tw1.wall);
			return 0;
			/**если Магия больше Магии врага враг получает 12 урона иначе 7  урона*/
		case 7:
			TowerWall tw11=new TowerWall(player_enemy.getTower_val(),player_enemy.getWall_val());
			if(player_self.getRes(Resources_player.GEMS_MOD)>player_enemy.getRes(Resources_player.GEMS_MOD)){
				
				datamage(tw11,12);
				
			}else{
				datamage(tw11,7);
			}
			player_enemy.setTower_val(tw11.tower);
			player_enemy.setWall_val(tw11.wall);
			return 0;
			/**если стена больше стены врага башня врага -6, иначе враг получает 6 урона*/
		case 8:
			TowerWall tw111=new TowerWall(player_enemy.getTower_val(),player_enemy.getWall_val());
			if(player_self.getWall_val()>player_enemy.getWall_val()){
				
				player_enemy.setTower_val(player_enemy.getTower_val()-6);
				
			}else{
				datamage(tw111,6);
			}
			player_enemy.setTower_val(tw111.tower);
			player_enemy.setWall_val(tw111.wall);
			return 0;
		}
		
	if(Type==0)	{player_self.chang(Resources_player.BRICKS, PlayerChanges_bricks-Requirements);}else{
		player_self.chang(Resources_player.BRICKS, PlayerChanges_bricks);
	}
	if(Type==1)	{player_self.chang(Resources_player.GEMS, PlayerChanges_gems-Requirements);}else{
		player_self.chang(Resources_player.GEMS, PlayerChanges_gems);
	}
	if(Type==2)	{player_self.chang(Resources_player.BEASTS, PlayerChanges_beasts-Requirements);}else{
		player_self.chang(Resources_player.BEASTS, PlayerChanges_beasts);
	}
		
		
		
		player_self.chang(Resources_player.BEASTS_MOD, PlayerMod_beasts);
		
		player_self.chang(Resources_player.BRICKS_MOD, PlayerMod_bricks);
		
		player_self.chang(Resources_player.GEMS_MOD, PlayerMod_gems);
		
		player_self.setTower_val(player_self.getTower_val() + PlayerChanges_tower);
		player_self.setWall_val(player_self.getWall_val() + PlayerChanges_wall);

		
		
		player_enemy.chang(Resources_player.BEASTS, EnemyChanges_beasts);
		
		player_enemy.chang(Resources_player.BRICKS, EnemyChanges_beasts);
		
		player_enemy.chang(Resources_player.GEMS, EnemyChanges_gems);
		
		player_enemy.chang(Resources_player.BEASTS_MOD, EnemyMod_beasts);
		
		player_enemy.chang(Resources_player.BRICKS_MOD, EnemyMod_bricks);
		
		player_enemy.chang(Resources_player.GEMS_MOD, EnemyMod_gems);
		

		player_enemy.setTower_val(player_enemy.getTower_val() + EnemyChanges_tower);
		player_enemy.setWall_val(player_enemy.getWall_val() + EnemyChanges_wall);
		
		TowerWall tw=new TowerWall(player_self.getTower_val(),player_self.getWall_val());
		datamage(tw,Damage_self);
		player_self.setTower_val(tw.tower);
		player_self.setWall_val(tw.wall);
		
		tw=new TowerWall(player_enemy.getTower_val(),player_enemy.getWall_val());
		datamage(tw,Damage_enemy);
		player_enemy.setTower_val(tw.tower);
		player_enemy.setWall_val(tw.wall);

		if (Turn == 1)
			return 1;

		return 0;

	}
	
	/**расчет обычного урона*/
	public  void datamage(TowerWall tw,int d){
		
		
		if(d<=tw.wall){
			tw.wall-=d;
		}else{
			d-=tw.wall;
			tw.wall=0;
			tw.tower-=d;
		}
		
	}

	/**выбросить карту
	 * @return the discardCard
	 */
	public int getDiscardCard() {
		return DiscardCard;
	}

	/**выбросить карту
	 * @param discardCard the discardCard to set
	 */
	public void setDiscardCard(int discardCard) {
		DiscardCard = discardCard;
	}
	
}
