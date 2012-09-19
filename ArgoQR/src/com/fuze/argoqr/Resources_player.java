package com.fuze.argoqr;

import android.widget.TextView;

public class Resources_player {
	
	/**кирпичи*/
	static final int BRICKS=0;
	/**рудник*/
	static final int BRICKS_MOD=1;
	/**мана*/
	static final int GEMS=2;
	/**магия*/
	static final int GEMS_MOD=3;
	/**Существа*/
	static final int BEASTS=4;
	/**Зверинец*/
	static final int BEASTS_MOD=5;
	
	
	
	/** значение */
	private int val=0;
	/** изменение */
	private int change=0;
	/** текстовый виджет значения */
	private TextView text_val;
	/** текстовый виджет изменения */
	private TextView text_change;

	Resources_player(TextView text_val,TextView text_change) {
		
		this.text_val = text_val;
		this.text_change = text_change;
		Canged(0);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
		text_val.setText(String.valueOf(val));
	}



	

	/** изменяем ресурс и отображение*/
	public void Canged(int c) {
		val = val + c;
		change = c;
		if (val < 1)
			val = 1;
		text_val.setText(String.valueOf(val));
		if(c==0){
			text_change.setText(" ");
		}else if(c<0){
		
			text_change.setText(" "+String.valueOf(change)+" ");
		}else{
			text_change.setText(" +"+String.valueOf(change)+" ");
		}

	}
	
	/**очищаем изменения*/
	/*public void Canged_clean(){
		change=0;
		text_change.setText(" ");
	}*/

}
