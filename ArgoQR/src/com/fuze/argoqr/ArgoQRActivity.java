package com.fuze.argoqr;

import com.fuze.argoqr.R;

import android.app.Activity;
//import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.content.pm.ActivityInfo;
import android.util.Log;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
//import android.view.ViewGroup.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
//import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
//import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class ArgoQRActivity extends Activity  {

	/*
	 * TextView mTextValue; ImageView image;
	 */
	//RadioButton rb;
	/** игрок 1 */
	// GamePlayer player1;
	/** игрок 2 */
	// GamePlayer player2;

	/** игра */
	Game game;
	int flag_select = 0;
	//SeekBar seekBar;
	Card CurrentCard;
	private static final int ACTIVITY_SETTINGS_REQUEST = 0x252;
	Deck deck;
	
	 Button next_but;
	 Button sbros_but;
	 Button camera_but;
	 
	 boolean sbros_next=false;
/*
	OnClickListener radioButtonClick = new OnClickListener() {
		public void onClick(View v) {
			// Perform action on clicks

			//SeekBar sb = (SeekBar) findViewById(R.id.seek_bar);
			rb = (RadioButton) v;
			switch (rb.getId()) {
			case R.id.radio1:
				flag_select = Resources_player.BRICKS;
				break;
			case R.id.radio2:
				flag_select = Resources_player.BRICKS_MOD;
				break;
			case R.id.radio3:
				flag_select = Resources_player.GEMS;
				break;
			case R.id.radio4:
				flag_select = Resources_player.GEMS_MOD;
				break;
			case R.id.radio5:
				flag_select = Resources_player.BEASTS;
				break;
			case R.id.radio6:
				flag_select = Resources_player.BEASTS_MOD;
				
				break;

			}
		//	seekBar.setProgress(game.getCurent_player().getRes(flag_select));

			/*
			 * if (rb.getId() == R.id.radio5) {
			 * 
			 * sb.setVisibility(View.GONE); }else{
			 * sb.setVisibility(View.VISIBLE); }
			 */

	//	}
//	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		deck = new Deck();
		ParserDeck pars = new ParserDeck(this.getResources().getXml(R.xml.deck));
		deck = pars.parse();
		// если хотим, чтобы приложение было полноэкранным
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// и без заголовка
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main);
		// если хотим, чтобы приложение постоянно имело портретную ориентацию
		//seekBar = (SeekBar) findViewById(R.id.seek_bar);

		//seekBar.setOnSeekBarChangeListener(this);
		
		SharedPreferences setting=getSharedPreferences("fuze", 0);
		
		
		game = new Game("player1", new TW(
				// tower
				(ImageView) findViewById(R.id.ImageView01),
				(FrameLayout) findViewById(R.id.FrameLayout_tower1),
				(TextView) findViewById(R.id.TextView01), 
				setting.getInt("tower1", 30)
				, 100), new TW(
				// wall
				(ImageView) findViewById(R.id.ImageView03),
				(FrameLayout) findViewById(R.id.FrameLayout02),
				(TextView) findViewById(R.id.TextView02), 
				setting.getInt("wall1", 5)
				, 118), "player2",
				new TW(
						// tower
						(ImageView) findViewById(R.id.ImageView11),
						(FrameLayout) findViewById(R.id.FrameLayout11),
						(TextView) findViewById(R.id.TextView11), 
						setting.getInt("tower2", 30)
						, 100),
				new TW(
						// wall
						(ImageView) findViewById(R.id.ImageView05),
						(FrameLayout) findViewById(R.id.FrameLayout03),
						(TextView) findViewById(R.id.TextView03), 
						setting.getInt("wall2", 5)
						, 118));

		
		
		
	//Log.d("setting read", "");
	//Log.d("setting read BRICKS", ""+setting.getInt("Resources_player1.BRICKS",1));
		game.getPlayer1().AddRes(
				new Resources_player((TextView) findViewById(R.id.bricks_pl1),
						(TextView) findViewById(R.id.bricks_ch_pl1)));// кирпичи
		game.getPlayer1().AddRes(
				new Resources_player(
						(TextView) findViewById(R.id.bricks_mod_pl1),
						(TextView) findViewById(R.id.bricks_mod_ch_pl1)));// рудник

		game.getPlayer1().AddRes(
				new Resources_player((TextView) findViewById(R.id.gems_pl1),
						(TextView) findViewById(R.id.gems_ch_pl1)));// Мана
		game.getPlayer1().AddRes(
				new Resources_player(
						(TextView) findViewById(R.id.gems_mod_pl1),
						(TextView) findViewById(R.id.gems_mod_ch_pl1)));// Магия

		game.getPlayer1().AddRes(
				new Resources_player((TextView) findViewById(R.id.beasts_pl1),
						(TextView) findViewById(R.id.beasts_ch_pl1)));// Существа
		game.getPlayer1().AddRes(
				new Resources_player(
						(TextView) findViewById(R.id.beasts_mod_pl1),
						(TextView) findViewById(R.id.beasts_mod_ch_pl1)));// Зверинец

		game.getPlayer1().setRes(Resources_player.BRICKS,setting.getInt("Resources_player1BRICKS",1));

		game.getPlayer1().setRes(Resources_player.BRICKS_MOD,setting.getInt("Resources_player1.BRICKS_MOD",1));

		game.getPlayer1().setRes(Resources_player.GEMS, setting.getInt("Resources_player1.GEMS",1));

		game.getPlayer1().setRes(Resources_player.GEMS_MOD,setting.getInt("Resources_player1.GEMS_MOD",1));

		game.getPlayer1().setRes(Resources_player.BEASTS, setting.getInt("Resources_player1.BEASTS",1));

		game.getPlayer1().setRes(Resources_player.BEASTS_MOD, setting.getInt("Resources_player1.BEASTS_MOD",1));

		game.getPlayer2().AddRes(
				new Resources_player((TextView) findViewById(R.id.bricks_pl2),
						(TextView) findViewById(R.id.bricks_ch_pl2)));// кирпичи
		game.getPlayer2().AddRes(
				new Resources_player(
						(TextView) findViewById(R.id.bricks_mod_pl2),
						(TextView) findViewById(R.id.bricks_mod_ch_pl2)));// рудник

		game.getPlayer2().AddRes(
				new Resources_player((TextView) findViewById(R.id.gems_pl2),
						(TextView) findViewById(R.id.gems_ch_pl2)));// Мана
		game.getPlayer2().AddRes(
				new Resources_player(
						(TextView) findViewById(R.id.gems_mod_pl2),
						(TextView) findViewById(R.id.gems_mod_ch_pl2)));// Магия

		game.getPlayer2().AddRes(
				new Resources_player((TextView) findViewById(R.id.beasts_pl2),
						(TextView) findViewById(R.id.beasts_ch_pl2)));// Существа
		game.getPlayer2().AddRes(
				new Resources_player(
						(TextView)  findViewById(R.id.beasts_mod_pl2),
						(TextView) findViewById(R.id.beasts_mod_ch_pl2)));// Зверинец


		game.getPlayer2().setRes(Resources_player.BRICKS,setting.getInt("Resources_player2.BRICKS",1));

		game.getPlayer2().setRes(Resources_player.BRICKS_MOD,setting.getInt("Resources_player2.BRICKS_MOD",1));

		game.getPlayer2().setRes(Resources_player.GEMS, setting.getInt("Resources_player2.GEMS",1));

		game.getPlayer2().setRes(Resources_player.GEMS_MOD,setting.getInt("Resources_player2.GEMS_MOD",1));

		game.getPlayer2().setRes(Resources_player.BEASTS, setting.getInt("Resources_player2.BEASTS",1));

		game.getPlayer2().setRes(Resources_player.BEASTS_MOD, setting.getInt("Resources_player2.BEASTS_MOD",1));
		// resize_layout();
		// beasts
		/*
		 * mTextValue = (TextView) findViewById(R.id.text_value); image =
		 * (ImageView) findViewById(R.id.imageView1);
		 * image.setScaleType(ScaleType.CENTER); LayoutParams params =
		 * image.getLayoutParams(); params.height = 1;
		 * image.setLayoutParams(params); FrameLayout fr = (FrameLayout)
		 * findViewById(R.id.fr); params = fr.getLayoutParams(); params.height =
		 * 100 ; fr.setLayoutParams(params); image = (ImageView)
		 * findViewById(R.id.ImageView01); image.setScaleType(ScaleType.CENTER);
		 * params = image.getLayoutParams(); params.height = 1;
		 * image.setLayoutParams(params); fr = (FrameLayout)
		 * findViewById(R.id.FrameLayout01); params = fr.getLayoutParams();
		 * params.height = 100 ; fr.setLayoutParams(params);
		 */
		/*final RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
		final RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
		final RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
		final RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
		final RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);
		final RadioButton radio6 = (RadioButton) findViewById(R.id.radio6);
		radio1.setOnClickListener(radioButtonClick);
		radio2.setOnClickListener(radioButtonClick);
		radio3.setOnClickListener(radioButtonClick);
		radio4.setOnClickListener(radioButtonClick);
		radio5.setOnClickListener(radioButtonClick);
		radio6.setOnClickListener(radioButtonClick);*/
	//	rb = radio1;
		next_but = (Button) findViewById(R.id.next_button);
		but_enab(next_but, setting.getBoolean("nextbut", false));
		sbros_but=(Button) findViewById(R.id.sbros_);
		but_enab(sbros_but, setting.getBoolean("sbrosbut", true));
		camera_but=(Button) findViewById(R.id.button_ok);
		but_enab(camera_but, setting.getBoolean("camerabut", true));
		if(setting.getBoolean("curplay", true)){
			game.set_curent_pl1();
		}else{
			game.set_curent_pl2();
		}
		

	}

	/*public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		 progress_(seekBar);

	}*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_qr, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case R.id.menu_settings:

    		
    		game = new Game("player1", new TW(
    				// tower
    				(ImageView) findViewById(R.id.ImageView01),
    				(FrameLayout) findViewById(R.id.FrameLayout_tower1),
    				(TextView) findViewById(R.id.TextView01), 
    				 30
    				, 100), new TW(
    				// wall
    				(ImageView) findViewById(R.id.ImageView03),
    				(FrameLayout) findViewById(R.id.FrameLayout02),
    				(TextView) findViewById(R.id.TextView02), 
    				 5
    				, 118), "player2",
    				new TW(
    						// tower
    						(ImageView) findViewById(R.id.ImageView11),
    						(FrameLayout) findViewById(R.id.FrameLayout11),
    						(TextView) findViewById(R.id.TextView11), 
    						30
    						, 100),
    				new TW(
    						// wall
    						(ImageView) findViewById(R.id.ImageView05),
    						(FrameLayout) findViewById(R.id.FrameLayout03),
    						(TextView) findViewById(R.id.TextView03), 
    						 5
    						, 118));

    		
    		
    		
    	//Log.d("setting read", "");
    	//Log.d("setting read BRICKS", ""+setting.getInt("Resources_player1.BRICKS",1));
    		game.getPlayer1().AddRes(
    				new Resources_player((TextView) findViewById(R.id.bricks_pl1),
    						(TextView) findViewById(R.id.bricks_ch_pl1)));// кирпичи
    		game.getPlayer1().AddRes(
    				new Resources_player(
    						(TextView) findViewById(R.id.bricks_mod_pl1),
    						(TextView) findViewById(R.id.bricks_mod_ch_pl1)));// рудник

    		game.getPlayer1().AddRes(
    				new Resources_player((TextView) findViewById(R.id.gems_pl1),
    						(TextView) findViewById(R.id.gems_ch_pl1)));// Мана
    		game.getPlayer1().AddRes(
    				new Resources_player(
    						(TextView) findViewById(R.id.gems_mod_pl1),
    						(TextView) findViewById(R.id.gems_mod_ch_pl1)));// Магия

    		game.getPlayer1().AddRes(
    				new Resources_player((TextView) findViewById(R.id.beasts_pl1),
    						(TextView) findViewById(R.id.beasts_ch_pl1)));// Существа
    		game.getPlayer1().AddRes(
    				new Resources_player(
    						(TextView) findViewById(R.id.beasts_mod_pl1),
    						(TextView) findViewById(R.id.beasts_mod_ch_pl1)));// Зверинец

    		game.getPlayer1().setRes(Resources_player.BRICKS,1);

    		game.getPlayer1().setRes(Resources_player.BRICKS_MOD,1);

    		game.getPlayer1().setRes(Resources_player.GEMS,1);

    		game.getPlayer1().setRes(Resources_player.GEMS_MOD,1);

    		game.getPlayer1().setRes(Resources_player.BEASTS,1);

    		game.getPlayer1().setRes(Resources_player.BEASTS_MOD,1);

    		game.getPlayer2().AddRes(
    				new Resources_player((TextView) findViewById(R.id.bricks_pl2),
    						(TextView) findViewById(R.id.bricks_ch_pl2)));// кирпичи
    		game.getPlayer2().AddRes(
    				new Resources_player(
    						(TextView) findViewById(R.id.bricks_mod_pl2),
    						(TextView) findViewById(R.id.bricks_mod_ch_pl2)));// рудник

    		game.getPlayer2().AddRes(
    				new Resources_player((TextView) findViewById(R.id.gems_pl2),
    						(TextView) findViewById(R.id.gems_ch_pl2)));// Мана
    		game.getPlayer2().AddRes(
    				new Resources_player(
    						(TextView) findViewById(R.id.gems_mod_pl2),
    						(TextView) findViewById(R.id.gems_mod_ch_pl2)));// Магия

    		game.getPlayer2().AddRes(
    				new Resources_player((TextView) findViewById(R.id.beasts_pl2),
    						(TextView) findViewById(R.id.beasts_ch_pl2)));// Существа
    		game.getPlayer2().AddRes(
    				new Resources_player(
    						(TextView)  findViewById(R.id.beasts_mod_pl2),
    						(TextView) findViewById(R.id.beasts_mod_ch_pl2)));// Зверинец


    		game.getPlayer2().setRes(Resources_player.BRICKS,1);

    		game.getPlayer2().setRes(Resources_player.BRICKS_MOD,1);

    		game.getPlayer2().setRes(Resources_player.GEMS,1);

    		game.getPlayer2().setRes(Resources_player.GEMS_MOD,1);

    		game.getPlayer2().setRes(Resources_player.BEASTS,1);

    		game.getPlayer2().setRes(Resources_player.BEASTS_MOD,1);
    		// resize_layout();
    		// beasts
    		/*
    		 * mTextValue = (TextView) findViewById(R.id.text_value); image =
    		 * (ImageView) findViewById(R.id.imageView1);
    		 * image.setScaleType(ScaleType.CENTER); LayoutParams params =
    		 * image.getLayoutParams(); params.height = 1;
    		 * image.setLayoutParams(params); FrameLayout fr = (FrameLayout)
    		 * findViewById(R.id.fr); params = fr.getLayoutParams(); params.height =
    		 * 100 ; fr.setLayoutParams(params); image = (ImageView)
    		 * findViewById(R.id.ImageView01); image.setScaleType(ScaleType.CENTER);
    		 * params = image.getLayoutParams(); params.height = 1;
    		 * image.setLayoutParams(params); fr = (FrameLayout)
    		 * findViewById(R.id.FrameLayout01); params = fr.getLayoutParams();
    		 * params.height = 100 ; fr.setLayoutParams(params);
    		 */
    		/*final RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
    		final RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
    		final RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
    		final RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
    		final RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);
    		final RadioButton radio6 = (RadioButton) findViewById(R.id.radio6);
    		radio1.setOnClickListener(radioButtonClick);
    		radio2.setOnClickListener(radioButtonClick);
    		radio3.setOnClickListener(radioButtonClick);
    		radio4.setOnClickListener(radioButtonClick);
    		radio5.setOnClickListener(radioButtonClick);
    		radio6.setOnClickListener(radioButtonClick);*/
    	//	rb = radio1;
    		next_but = (Button) findViewById(R.id.next_button);
    		but_enab(next_but, false);
    		sbros_but=(Button) findViewById(R.id.sbros_);
    		but_enab(sbros_but,true);
    		camera_but=(Button) findViewById(R.id.button_ok);
    		but_enab(camera_but,true);
    		
    			game.setCurent_player(game.getPlayer1());

            break;
       
        }
        return super.onOptionsItemSelected(item);
    }
	/*
	 * private void resize_layout(){
	 * 
	 * LayoutParams params_c =((FrameLayout)
	 * findViewById(R.id.FrameLayout_centr)).getLayoutParams();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * params_c.width=120; //Log.d("argo","params_c.width: "+
	 * String.valueOf(params_c.width)); ((FrameLayout)
	 * findViewById(R.id.FrameLayout_centr)).setLayoutParams(params_c);
	 * 
	 * }
	 */
	/*
	int flag_progress = 0;

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		// player1.setRes(Resources_player.BRICKS)
		flag_progress = seekBar.getProgress();

	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		progress_(seekBar);
	}
	*/
	//установка видимости кнопок
	void but_enab(Button but,boolean val){
		but.setClickable(val);
		if(val){
			but.setEnabled(val);}else but.setEnabled(val);
	}
	void set_but(boolean next_but,boolean sbros_but,boolean camera_but){
		SharedPreferences setting = getSharedPreferences("fuze", 0);
		SharedPreferences.Editor editor= setting.edit();
		
		but_enab(this.next_but,next_but);
		editor.putBoolean("nextbut", next_but);
		
		but_enab(this.sbros_but, sbros_but);
		editor.putBoolean("sbrosbut", sbros_but);
		
		but_enab(this.camera_but, camera_but);
		editor.putBoolean("camerabut", camera_but);
		editor.commit();

	}
	 

	public void onClick(View view) {
		scan();

	}
	public void next_(boolean next_hod){
		
		set_but(false, true, true);
		if(next_hod){
			SharedPreferences setting = getSharedPreferences("fuze", 0);
			SharedPreferences.Editor editor= setting.edit();
			
			game.set_next_player_curent();
			editor.putBoolean("curplay", game.isPlayer_flag());
			editor.commit();
			Toast.makeText(getApplicationContext(), "game "+game.getCurent_player().getName(), Toast.LENGTH_SHORT).show();
		}
//		next_but.setClickable(false);
//		sbros_but.setClickable(true);
//		camera_but.setClickable(true);
		//

	}
	public void next_Player(View view) {
		
		next_(true);

	}
	public void sbros_(View view) {
		if(sbros_next){
			Toast.makeText(getApplicationContext(), "DisCard "+game.getCurent_player().getName(), Toast.LENGTH_SHORT).show();
			next_(false);
			sbros_next=false;
			}else{next_(true);}

		
	}

	public void scan() {
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

	public void progress_(SeekBar seekBar) {
/*
		game.getCurent_player().chang(flag_select,
				(seekBar.getProgress() - flag_progress));
*/
		// resize_layout();

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {

		if (requestCode == ACTIVITY_SETTINGS_REQUEST) {
			// EditText Editpars = (EditText) findViewById(R.id.editText3);
			//String text = "null";
			if (resultCode == RESULT_OK) {
				if (CurrentCard != null){
					
					CurrentCard.Action(game.getCurent_player(),game.getN_curent_player());
					
					if(CurrentCard.getTurn()==0){
						set_but(true, false, false);
					}else{
						if(CurrentCard.getDiscardCard()==1){
							set_but(false, true, false);
							sbros_next=true;
							}else{
							set_but(false, true, true);
						}
						
						
					}
						/*next_but.setClickable(true);*/
					
					
					
					
				/*
				 * if (CurrentCard != null) { text = "id=" + CurrentCard.getId()
				 * + " \nname=" + CurrentCard.getName() + " \npic=" +
				 * CurrentCard.getPicture() +
				 * 
				 * "\n\nурон врагу=" + CurrentCard.getDamage_enemy() +
				 * "\nурон себе=" + CurrentCard.getDamage_self() +
				 * 
				 * "\n\nвр жив=" + CurrentCard.getEnemyChanges_beasts() +
				 * "\nвр кирп=" + CurrentCard.getEnemyChanges_bricks() +
				 * "\nвр драг=" + CurrentCard.getEnemyChanges_gems() +
				 * "\nвр башн=" + CurrentCard.getEnemyChanges_tower() +
				 * "\nвр стена=" + CurrentCard.getEnemyChanges_wall() +
				 * 
				 * "\n\nвр зооп=" + CurrentCard.getEnemyMod_beasts() +
				 * "\nвр рудн=" + CurrentCard.getEnemyMod_bricks() + "\nвр маг="
				 * + CurrentCard.getEnemyMod_gems() +
				 * 
				 * "\n\nсв жив=" + CurrentCard.getPlayerChanges_beasts() +
				 * "\nсв кирп=" + CurrentCard.getPlayerChanges_bricks() +
				 * "\nсв драг=" + CurrentCard.getPlayerChanges_gems() +
				 * "\nсв башн=" + CurrentCard.getPlayerChanges_tower() +
				 * "\nсв стена=" + CurrentCard.getPlayerChanges_wall() +
				 * 
				 * "\n\nсв зооп=" + CurrentCard.getPlayerMod_beasts() +
				 * "\nсв рудн=" + CurrentCard.getPlayerMod_bricks() +
				 * "\nсв маг=" + CurrentCard.getPlayerMod_gems() +
				 * 
				 * "\nscript=" + CurrentCard.getScript() + "\nturn=" +
				 * CurrentCard.getTurn() + " \ndec=" +
				 * CurrentCard.getDescription() + "\n\n"; }
				 */
				}} else if (resultCode == RESULT_CANCELED) {

			} else if (resultCode == RESULT_FIRST_USER) {
				scan();

			}
			// Editpars.setText(text);
		} else {
			Log.d("requestCode ", " " + requestCode);//
			Log.d("resultCode ", " " + resultCode);//
			Log.d("intent ", " " + intent);//
			
			
			if (intent != null) {// если нажали назад в сканере
				IntentResult scanResult = IntentIntegrator.parseActivityResult(
						requestCode, resultCode, intent);
				if (scanResult != null) {
					String code;
					// String type;
					code = scanResult.getContents();
					
					
					// type = scanResult.getFormatName();

					// EditText EditCode = (EditText)
					// findViewById(R.id.editText1);
					// EditText EditType = (EditText)
					// findViewById(R.id.editText2);

					// EditCode.setText(code);
					// EditType.setText(type);

					//
					// LayoutInflater inflater = getLayoutInflater();
					// View layout = inflater.inflate(R.layout.custom_layout,
					// (ViewGroup) findViewById(R.id.toast_layout));
			
			
			

					CurrentCard = deck.search_card(code);
					// Gambler current_player=play1;

					Intent intent1 = new Intent();// создаёт намерение
					intent1.setClass(this, DeckDialog.class);// намерение
																// запустить
																// класс
																// DeckDialog
					intent1.putExtra(DeckDialog.TEXT,
							CurrentCard.getDescription());// передаём
					intent1.putExtra(DeckDialog.IMAGE, CurrentCard.getNumer());
					intent1.putExtra(DeckDialog.COLOR_CARD,
							CurrentCard.getType());
					intent1.putExtra(DeckDialog.NAME, CurrentCard.getName());
					intent1.putExtra(DeckDialog.REQ,
							CurrentCard.getRequirements());

					intent1.putExtra(DeckDialog.RES1, game.getCurent_player()
							.getRes(Resources_player.BRICKS));
					intent1.putExtra(DeckDialog.RES2, game.getCurent_player()
							.getRes(Resources_player.GEMS));
					intent1.putExtra(DeckDialog.RES3, game.getCurent_player()
							.getRes(Resources_player.BEASTS));
					Log.d("COLOR_CARD", " " + CurrentCard.getType());// данные
					startActivityForResult(intent1, ACTIVITY_SETTINGS_REQUEST);// стартуем
																				// это
																				// активити

					/*	
			
						*/
					// showDialog(IDD_CUSTOM);
					// }

				}
			}
		}
		// else continue with any other code you need in the method
		// ...
	}
	void setting_w(){
		//Log.d("setting_w ", "write");
		SharedPreferences setting = getSharedPreferences("fuze", 0);
		SharedPreferences.Editor editor= setting.edit();
		//Log.d("tower1 ", " game.getPlayer1().getTower_val()");
		editor.putInt("tower1", game.getPlayer1().getTower_val());
		editor.putInt("tower2", game.getPlayer2().getTower_val());
		editor.putInt("wall1", game.getPlayer1().getWall_val());
		editor.putInt("wall2", game.getPlayer2().getWall_val());
		
		
		
		/*
		 * 		game.getPlayer1().setRes(Resources_player.BRICKS,setting.getInt("Resources_player1.BRICKS",1));

		game.getPlayer1().setRes(Resources_player.BRICKS_MOD,setting.getInt("Resources_player1.BRICKS_MOD",1));

		game.getPlayer1().setRes(Resources_player.GEMS, setting.getInt("Resources_player1.GEMS",1));

		game.getPlayer1().setRes(Resources_player.GEMS_MOD,setting.getInt("Resources_player1.GEMS_MOD",1));

		game.getPlayer1().setRes(Resources_player.BEASTS, setting.getInt("Resources_player1.BEASTS",1));

		game.getPlayer1().setRes(Resources_player.BEASTS_MOD, setting.getInt("Resources_player1.BEASTS_MOD",1));
*/
		
		editor.putInt("Resources_player1BRICKS", game.getPlayer1().getRes(Resources_player.BRICKS)); 
		editor.putInt("Resources_player1.BRICKS_MOD", game.getPlayer1().getRes(Resources_player.BRICKS_MOD)); 
		editor.putInt("Resources_player1.GEMS", game.getPlayer1().getRes(Resources_player.GEMS)); 
		editor.putInt("Resources_player1.GEMS_MOD", game.getPlayer1().getRes(Resources_player.GEMS_MOD)); 
		editor.putInt("Resources_player1.BEASTS", game.getPlayer1().getRes(Resources_player.BEASTS)); 
		editor.putInt("Resources_player1.BEASTS_MOD", game.getPlayer1().getRes(Resources_player.BEASTS_MOD)); 
		Log.d("Resources_player1.BRICKS", " "+game.getPlayer1().getRes(Resources_player.BRICKS));
		editor.putInt("Resources_player2.BRICKS", game.getPlayer2().getRes(Resources_player.BRICKS)); 
		editor.putInt("Resources_player2.BRICKS_MOD", game.getPlayer2().getRes(Resources_player.BRICKS_MOD)); 
		editor.putInt("Resources_player2.GEMS", game.getPlayer2().getRes(Resources_player.GEMS)); 
		editor.putInt("Resources_player2.GEMS_MOD", game.getPlayer2().getRes(Resources_player.GEMS_MOD)); 
		editor.putInt("Resources_player2.BEASTS", game.getPlayer2().getRes(Resources_player.BEASTS)); 
		editor.putInt("Resources_player2.BEASTS_MOD", game.getPlayer2().getRes(Resources_player.BEASTS_MOD)); 
		editor.commit();
		
	}
	@Override
	protected void onStop(){
		setting_w();
		super.onStop();	
	}
	
    @Override
    public void onBackPressed(){
    	setting_w();
    	super.onBackPressed();
    	
    }
	
	

}