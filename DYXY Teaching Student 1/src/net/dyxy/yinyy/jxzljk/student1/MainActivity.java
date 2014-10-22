package net.dyxy.yinyy.jxzljk.student1;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			GridView gridview = (GridView) rootView.findViewById(R.id.grid01);
			ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();
			String[] text = new String[] { "请假销假", "课程表", "违纪预警", "信息推送" };
			int[] image = new int[] { R.drawable.leave, R.drawable.course,
					R.drawable.truang, R.drawable.message };
			for (int i = 0; i < 9; i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("ItemImage", image[i % 4]);
				map.put("ItemText", text[i % 4]);
				meumList.add(map);
			}
			SimpleAdapter saItem = new SimpleAdapter(getActivity(), meumList, // 数据源
					R.layout.activty_grid_main,
					new String[] { "ItemImage", "ItemText" },
					new int[] { R.id.Image, R.id.Text });

			gridview.setAdapter(saItem);
			gridview.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					int index = arg2 % 4;
					switch (index) {
					case 0:
						Intent intent = new Intent(getActivity(),
								LeaveListActivity.class);
						startActivity(intent);
						break;
					case 1:
						Intent intent1 = new Intent(getActivity(),
								CourseScheduleActivity.class);
						startActivity(intent1);

						break;
					case 2:
						Intent intent2 = new Intent(getActivity(),
								TruancyListActivity.class);
						startActivity(intent2);
						break;
					case 3:
						Intent intent3 = new Intent(getActivity(),
								MessageListActivity.class);
						startActivity(intent3);
						break;
					default:
						break;
					}
				}
			});
			return rootView;
		}
	}

}
