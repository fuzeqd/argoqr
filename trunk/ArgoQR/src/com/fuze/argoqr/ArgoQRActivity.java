package com.fuze.argoqr;

import com.fuze.argoqr.R;

import android.app.Activity;
//import android.content.DialogInterface;
import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View.OnClickListener;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
//import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
//import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
//import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class ArgoQRActivity extends Activity implements
		SeekBar.OnSeekBarChangeListener {

	/*
	 * TextView mTextValue; ImageView image;
	 */
	RadioButton rb;
	/** игрок 1 */
	// GamePlayer player1;
	/** игрок 2 */
	// GamePlayer player2;

	/** игра */
	Game game;
	int flag_select = 0;
	SeekBar seekBar;
	Card CurrentCard;
	private static final int ACTIVITY_SETTINGS_REQUEST = 0x252;
	Deck deck;

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
			seekBar.setProgress(game.getCurent_player().getRes(flag_select));

			/*
			 * if (rb.getId() == R.id.radio5) {
			 * 
			 * sb.setVisibility(View.GONE); }else{
			 * sb.setVisibility(View.VISIBLE); }
			 */

		}
	};

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
		seekBar = (SeekBar) findViewById(R.id.seek_bar);

		seekBar.setOnSeekBarChangeListener(this);
		game = new Game("player1", new TW(
				// tower
				(ImageView) findViewById(R.id.ImageView01),
				(FrameLayout) findViewById(R.id.FrameLayout_tower1),
				(TextView) findViewById(R.id.TextView01), 99, 100), new TW(
				// wall
				(ImageView) findViewById(R.id.ImageView03),
				(FrameLayout) findViewById(R.id.FrameLayout02),
				(TextView) findViewById(R.id.TextView02), 99, 118), "player2",
				new TW(
						// tower
						(ImageView) findViewById(R.id.ImageView11),
						(FrameLayout) findViewById(R.id.FrameLayout11),
						(TextView) findViewById(R.id.TextView11), 99, 100),
				new TW(
						// wall
						(ImageView) findViewById(R.id.ImageView05),
						(FrameLayout) findViewById(R.id.FrameLayout03),
						(TextView) findViewById(R.id.TextView03), 99, 118));

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

		game.getPlayer1().setRes(Resources_player.BRICKS, 1);

		game.getPlayer1().setRes(Resources_player.BRICKS_MOD, 1);

		game.getPlayer1().setRes(Resources_player.GEMS, 1);

		game.getPlayer1().setRes(Resources_player.GEMS_MOD, 1);

		game.getPlayer1().setRes(Resources_player.BEASTS, 1);

		game.getPlayer1().setRes(Resources_player.BEASTS_MOD, 1);

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
						(TextView) findViewById(R.id.beasts_mod_pl2),
						(TextView) findViewById(R.id.beasts_mod_ch_pl2)));// Зверинец

		game.getPlayer2().setRes(Resources_player.BRICKS, 1);

		game.getPlayer2().setRes(Resources_player.BRICKS_MOD, 1);

		game.getPlayer2().setRes(Resources_player.GEMS, 1);

		game.getPlayer2().setRes(Resources_player.GEMS_MOD, 1);

		game.getPlayer2().setRes(Resources_player.BEASTS, 1);

		game.getPlayer2().setRes(Resources_player.BEASTS_MOD, 1);
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
		final RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
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
		radio6.setOnClickListener(radioButtonClick);
		rb = radio1;

	}

	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// progress_(seekBar);

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
	int flag_progress = 0;

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		// player1.setRes(Resources_player.BRICKS)
		flag_progress = seekBar.getProgress();

	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		progress_(seekBar);

	}

	public void onClick(View view) {
		scan();

	}
	public void onClick2(View view) {
		game.set_next_player_curent();
		Toast.makeText(getApplicationContext(), "game "+game.getCurent_player().getName(), Toast.LENGTH_SHORT).show();

	}

	public void scan() {
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

	public void progress_(SeekBar seekBar) {

		game.getCurent_player().chang(flag_select,
				(seekBar.getProgress() - flag_progress));

		// resize_layout();

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {

		if (requestCode == ACTIVITY_SETTINGS_REQUEST) {
			// EditText Editpars = (EditText) findViewById(R.id.editText3);
			//String text = "null";
			if (resultCode == RESULT_OK) {
				if (CurrentCard != null)
					CurrentCard.Action(game.getCurent_player(),
							game.getN_curent_player());
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
				 */} else if (resultCode == RESULT_CANCELED) {

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

}