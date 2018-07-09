package com.ax.seekbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MySeekBar seekBar = (MySeekBar) findViewById(R.id.seek_bar);
		seekBar.setOnClickThumbListener(new MySeekBar.OnClickThumbListener() {
			@Override
			public void onClickThumb() {
				Toast.makeText(MainActivity.this, "发生点击事件", Toast.LENGTH_SHORT).show();
			}
		});
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					final int finalI = i;
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							seekBar.setProgress(finalI);
						}
					});
				}
			}
		}.start();
	}
}
