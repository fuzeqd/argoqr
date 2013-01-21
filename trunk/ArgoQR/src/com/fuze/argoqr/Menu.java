package com.fuze.argoqr;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class Menu extends Activity {

    private static final int ACTIVITY_SETTINGS_REQUEST5 = 5;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, (android.view.Menu) menu);
        return true;
    }
    public void start_game(View view){
    	Intent intent = new Intent();// создаёт намерение
		intent.setClass(this, ArgoQRActivity.class);// намерение
													// запустить
													// класс
													// ArgoQRActivity
		
		
		startActivityForResult(intent, ACTIVITY_SETTINGS_REQUEST5);// стартуем
		// это
		// активити
    }
    
    public void about(View view){
    	Intent intent = new Intent();// создаёт намерение
		intent.setClass(this, AboutActivity.class);// намерение
													// запустить
													// класс
													// ArgoQRActivity
		
		
		startActivityForResult(intent, ACTIVITY_SETTINGS_REQUEST5);// стартуем
		// это
		// активити
    }
    
    public void exit_game(View view){
    	System.exit(RESULT_OK);
    }
    @Override
    public void onBackPressed(){
    	
    }
    
}
