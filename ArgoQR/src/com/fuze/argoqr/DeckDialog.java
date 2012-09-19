package com.fuze.argoqr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DeckDialog extends Activity implements View.OnClickListener {
	public static final String TEXT = "text";
	public static final String NAME = "name";
	public static final String IMAGE = "image";
	public static final String REQ = "req";
	public static final String COLOR_CARD = "color card";
	public static final String RES1 = "res1";
	public static final String RES2 = "res2";
	public static final String RES3 = "res3";
	String _text = "_text";
	String _name = "_name";
	int _req = 0;
	int _image = R.drawable.card01;
	int color_card = 0;

	int res1 = 0;
	int res2 = 0;
	int res3 = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.custom_layout);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			_text = extras.getString(TEXT);
			_name = extras.getString(NAME);
			_req = extras.getInt(REQ);
			_image += extras.getInt(IMAGE);
			color_card = extras.getInt(COLOR_CARD);
			res1 = extras.getInt(RES1);
			res2 = extras.getInt(RES2);
			res3 = extras.getInt(RES3);

		}
//		TextView text_error = (TextView) findViewById(R.id.text);
		TextView text = new TextView(this);
		text.setId(123);

		text.setTypeface(null, Typeface.BOLD);
		ImageView image = (ImageView) findViewById(R.id.image);
		// LinearLayout lay=(LinearLayout) findViewById(R.id.linearLayout1);

		// image.setImageResource(_image);
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inScaled = false;
		Bitmap im_;
		Button ok=(Button)findViewById(R.id.button1);
		// Log.d("color card",color_card);
		if (color_card == 0) {
			im_ = BitmapFactory.decodeResource(getResources(),
					R.drawable.cardred, opts);
			if (res1 < _req) {
				Log.d("res1 =", " " +res1 +" _req="+_req);
				ok.setEnabled(false);
				ok.setText(/*R.string.error_brick*/"error_brick");
				ok.setTextColor(Color.RED);

				//ok.setClickable(false);
				//ok.setBackgroundColor(Color.GRAY);
			}
		} else if (color_card == 1) {
			im_ = BitmapFactory.decodeResource(getResources(),
					R.drawable.cardblue, opts);
			if (res2 < _req) {
				ok.setEnabled(false);
				ok.setText(/*R.string.error_gem*/"error_gem");
				ok.setTextColor(Color.BLUE);
//				ok.setClickable(false);
//				ok.setBackgroundColor(Color.GRAY);
			}
		} else {
			im_ = BitmapFactory.decodeResource(getResources(),
					R.drawable.cardgreen, opts);
			if (res3 < _req) {
				ok.setEnabled(false);
				ok.setText(/*R.string.error_beast*/"error_beast");
				ok.setTextColor(Color.GREEN);
				
//				ok.setClickable(false);
//				ok.setBackgroundColor(Color.GRAY);
			}
		}
		Bitmap im_card = BitmapFactory.decodeResource(getResources(), _image,
				opts);
		/** свой битмап */
		Bitmap bmp = Bitmap.createBitmap(im_.getWidth(), im_.getHeight(),
				Bitmap.Config.ARGB_8888);
		// Bitmap bmp2=Bitmap.createBitmap(im_.getWidth()/2, im_.getHeight()/2,
		// Bitmap.Config.ARGB_8888);
		Canvas my_canvas = new Canvas(bmp);
		// Canvas my_canvas2 = new Cabitmapnvas(bmp2);
		/*
		 * Paint p=new Paint(); p.setColor(Color.YELLOW); p.setTextSize(10);
		 */

		text.setText(_text);

		text.setWidth(im_card.getWidth());

		text.setDrawingCacheEnabled(true);
		text.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		text.layout(0, 0, text.getMeasuredWidth(), text.getMeasuredHeight());

		text.buildDrawingCache(true);
		// Bitmap bmp_t = Bitmap.createBitmap(text.getDrawingCache());
		Bitmap bmp_t = text.getDrawingCache();
		bmp.eraseColor(Color.TRANSPARENT);

		// Rect src = new Rect(0, 0, im_.getWidth(), im_.getHeight());
		Rect dst = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
		my_canvas.drawBitmap(im_, null, dst, null);
		// src = new Rect(0, 0, im_card.getWidth(), im_card.getHeight());
		dst = new Rect(13, 45, 163, 145);
		my_canvas.drawBitmap(im_card, null, dst, null);
		dst = new Rect(10, 145, text.getWidth() + 10, text.getHeight() + 145);
		if (bmp_t == null) {
			Log.e("TEXTBITMAP", "NULL");
		} else {
			my_canvas.drawBitmap(bmp_t, null, dst, null);
		}
		text.setDrawingCacheEnabled(false);

		TextView text1 = new TextView(this);
		text1.setId(123);

		text1.setTypeface(null, Typeface.BOLD);
		text1.setTextSize(15);
		text1.setText(_name);
		text1.setWidth(im_card.getWidth());
		text1.setDrawingCacheEnabled(true);
		text1.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		text1.layout(0, 0, text1.getMeasuredWidth(), text1.getMeasuredHeight());

		text1.buildDrawingCache(true);
		bmp_t = text1.getDrawingCache();
		dst = new Rect(20, 20, text1.getWidth() + 20, text1.getHeight() + 20);
		my_canvas.drawBitmap(bmp_t, null, dst, null);
		// my_canvas.drawText(_text, 10, 150, p);
		text1.setDrawingCacheEnabled(false);

		TextView text11 = new TextView(this);
		text11.setId(123);

		text11.setTypeface(null, Typeface.BOLD);
		text11.setTextSize(18);
		text11.setText("" + _req);
		text11.setWidth(im_card.getWidth());
		text11.setDrawingCacheEnabled(true);
		text11.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		text11.layout(0, 0, text11.getMeasuredWidth(),
				text11.getMeasuredHeight());

		text11.buildDrawingCache(true);
		bmp_t = text11.getDrawingCache();
		dst = new Rect(141, 216, text11.getWidth() + 141,
				text11.getHeight() + 216);
		my_canvas.drawBitmap(bmp_t, null, dst, null);
		// my_canvas.drawText(_text, 10, 150, p);
		text11.setDrawingCacheEnabled(false);

		image.setImageBitmap(bmp);
		// text.setText(_text);
		// text.setWidth(im_.getWidth());
		// text.setBackgroundResource(R.drawable.red_bot);

	}

	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1:
		
			Intent res_data = new Intent();

			res_data.putExtra(TEXT, _text);

			setResult(RESULT_OK, res_data);

			break;
		case R.id.button3:

			setResult(RESULT_FIRST_USER);

			break;
		case R.id.button2:
			setResult(RESULT_CANCELED);

			break;
		}
		this.finish();

	}

}
