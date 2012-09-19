package com.fuze.argoqr;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class TW {

	private ImageView image;
	private FrameLayout image_top;
	private int val=100;
	private TextView mTextValue;
	private int max_size=100;

	TW(ImageView res_image, FrameLayout res_image_top, TextView res_textview, int val, int max_size) {
		image = res_image;
		image_top=res_image_top;
		image.setScaleType(ScaleType.CENTER);
		
		mTextValue=res_textview;
		
		this.max_size=max_size;
		setVal(val);

	}
	
	

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
		
		LayoutParams params = image.getLayoutParams();
		params.height = val;
		image.setLayoutParams(params);
		
		
		params = image_top.getLayoutParams();
		params.height = max_size-val ;
		if(params.height<=0)params.height=1;
		image_top.setLayoutParams(params);
		mTextValue.setText(String.valueOf(val));
	}

	public int getMax_size() {
		return max_size;
	}

	public void setMax_size(int max_size) {
		this.max_size = max_size;
	}

}
