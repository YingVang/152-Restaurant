package com.tablenow;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class Editor extends Activity {

	private WebView myview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editor);
		// Show the Up button in the action bar.
		setupActionBar();
		
		String url = "http://www.google.com";
		myview = (WebView) this.findViewById(R.id.webView1);
		myview.loadUrl(url);
		myview.setWebViewClient(new webviewclient());
	}
	
	private class webviewclient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webview, String url)
		{
			webview.loadUrl(url);
			return true;
		}
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if((keyCode == KeyEvent.KEYCODE_BACK) && myview.canGoBack())
		{
			myview.goBack();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_sign_out:
	        	startActivity(new Intent(Editor.this, MainActivity.class));
	            return true;
	        case R.id.action_settings:
	        	startActivity(new Intent(Editor.this, User_update.class));
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
