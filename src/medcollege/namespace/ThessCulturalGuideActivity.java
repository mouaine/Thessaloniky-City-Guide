package medcollege.namespace;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class ThessCulturalGuideActivity extends TabActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// First Tab
		intent = new Intent().setClass(this, ListMonuments.class);
		spec = tabHost
				.newTabSpec("Tab 1")
				.setIndicator("List",
						res.getDrawable(android.R.drawable.ic_menu_today))
				.setContent(intent);
		tabHost.addTab(spec);

		// Second Tab
		intent = new Intent().setClass(this, MonumentMap.class);
		spec = tabHost
				.newTabSpec("Tab 2")
				.setIndicator("Map View",
						res.getDrawable(android.R.drawable.ic_menu_mapmode))
				.setContent(intent);
		tabHost.addTab(spec);
		tabHost.setCurrentTab(0);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.prefs:
			Intent intent = new Intent(this, ListSettings.class);
			this.startActivity(intent);
			return true;
		case R.id.exit:

			System.exit(0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}