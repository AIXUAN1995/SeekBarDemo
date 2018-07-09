package com.ax.seekbardemo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by VERTU on 2018/7/9.
 */

public class MySeekBar extends android.support.v7.widget.AppCompatSeekBar {
	OnClickThumbListener listener;
	public MySeekBar(Context context) {
		super(context);
	}

	public MySeekBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()){
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_UP:
				if (isTouchInThumb(event, getThumb().getBounds())){
					if (listener != null)
						listener.onClickThumb();
				}
				break;
		}
		return true;
	}

	/**
	 * 判断MotionEvent事件是否位于thumb上
	 * @param event
	 * @param thumbBounds
	 * @return
	 */
	private boolean isTouchInThumb(MotionEvent event, Rect thumbBounds){
		float x = event.getX();
		float y = event.getY();
		//根据偏移量和左边距确定thumb位置
		int left = thumbBounds.left - getThumbOffset() + getPaddingLeft();
		int right = left + thumbBounds.width();
		if (x >= left && x <= right
				&& y >= thumbBounds.top && y <= thumbBounds.bottom)
			return true;
		return false;
	}

	public void setOnClickThumbListener(OnClickThumbListener listener){
		this.listener = listener;
	}

	interface OnClickThumbListener{
		void onClickThumb();
	}
}
