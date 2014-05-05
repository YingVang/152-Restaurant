package com.tablenow;

//import com.tablenow.Editor.webviewclient;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class UserLayout extends Activity {
	
	private WebView myview2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_layout);
		// Show the Up button in the action bar.
		setupActionBar();

		String url = "http://50.161.166.152/restaurant/pages/restaurant.html";
		myview2 = (WebView) this.findViewById(R.id.webView2);
		myview2.loadUrl(url);
		myview2.setWebViewClient(new webviewclient());
		myview2.getSettings().setJavaScriptEnabled(true);
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
		if((keyCode == KeyEvent.KEYCODE_BACK) && myview2.canGoBack())
		{
			myview2.goBack();
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
	        	AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
        		        UserLayout.this);

        		// Setting Dialog Title
        		alertDialog2.setTitle("Warning");

        		// Setting Dialog Message
        		alertDialog2.setMessage("Are You Sure You Want To Sign Out?");

        		// yes button
        		alertDialog2.setPositiveButton("Yes",
        		        new DialogInterface.OnClickListener() {
        		            public void onClick(DialogInterface dialog, int which) {
        		                // Write your code here to execute after dialog
        		                Toast.makeText(getApplicationContext(),
        		                        "You Have Signed Out", Toast.LENGTH_SHORT)
        		                        .show();
        		                startActivity(new Intent(UserLayout.this, MainActivity.class));
        		            }
        		        });
        		
        		// no button
        		alertDialog2.setNegativeButton("No", 
        				new DialogInterface.OnClickListener() {
        					public void onClick(DialogInterface dialog, int which) {
        						dialog.cancel();
        			}
        		});

        		// Showing Alert Dialog
        		alertDialog2.show();
	            return true;
	        case R.id.action_settings:
	        	startActivity(new Intent(UserLayout.this, User_update.class));
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }

	}

}
