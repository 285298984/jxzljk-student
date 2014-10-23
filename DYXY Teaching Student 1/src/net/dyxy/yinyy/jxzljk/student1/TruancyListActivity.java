package net.dyxy.yinyy.jxzljk.student1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class TruancyListActivity extends Activity {
	private ListView listview;
	private TextView truants;
	private TextView courses;
	private TextView days;
	private TextView parts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truancy_list);
		
		listview=(ListView)findViewById(R.id.listview);
		truants=(TextView)findViewById(R.id.truants);
		courses=(TextView)findViewById(R.id.courses);
		days=(TextView)findViewById(R.id.days);
		parts=(TextView)findViewById(R.id.parts);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.truancy_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
