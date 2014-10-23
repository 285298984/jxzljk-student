package net.dyxy.yinyy.jxzljk.student1;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class CourseScheduleActivity extends Activity {

	String[][] text = new String[6][8];
	String[][] text1 = new String[30][6];
	GridView gridview;
	ArrayList<HashMap<String, Object>> meumList;
	HashMap<String, Object> map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course_schedule);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		handler.sendEmptyMessage(0);
				
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.course_schedule, menu);
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

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

	}

	private void getRemoteInfo() {

		String nameSpace = "http://tempuri.org/";// 命名空间
		String methodName = "GetCoueseScheduleByStudent";// 调用的方法名称
		String endPoint = "http://10.40.58.220:8099/webserviceStudent.asmx";// url
		String soapAction = "http://tempuri.org/GetCoueseScheduleByStudent"; // SOAP
		// Action
		SoapObject request = new SoapObject(nameSpace, methodName); // 指定WebService的命名空间和调用的方法名

		request.addProperty("sno", "201201060118");//这里直接用学号测试

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER12);
		envelope.bodyOut = request;
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);

		HttpTransportSE se = new HttpTransportSE(endPoint);
		try {
			se.call(soapAction, envelope);
			if (envelope.getResponse() != null) {
				
				SoapObject object = (SoapObject) envelope.bodyIn;

				SoapObject result = (SoapObject) object.getProperty(0);
				int len = result.getPropertyCount();
				for (int j = 0; j < len; j++) {
					SoapObject result1 = (SoapObject) result.getProperty(j);
					System.out.println();
						String str = result1.getProperty(0).toString();
						int DayOfWeek = Integer.parseInt( result1.getProperty(1).toString());
						int SectionOfDay = Integer.parseInt( result1.getProperty(2).toString());
						String str1 = result1.getProperty(3).toString();
						text[SectionOfDay+1][DayOfWeek+1] = str+"\n"+str1;			
						System.out.println(str);
						System.out.println(DayOfWeek);
						System.out.println(SectionOfDay);
				}		
				System.out.println(len);
				// ArrayList aList = new ArrayList();
			} else {
				System.out.println("没有返回值");
			}

		} catch (Exception e) {
			System.out.println("代码运行出现异常" + e);
			e.printStackTrace();
		}
	}

	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			gridview = (GridView) findViewById(R.id.grid02);
			meumList = new ArrayList<HashMap<String, Object>>();

			text[0] = new String[] { "", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六",
					"星期七" };
			text[1] = new String[] { "1-2节", "", "", "", "", "", "", "" };
			text[2] = new String[] { "3-4节", "", "", "", "", "", "", "" };
			text[3] = new String[] { "5-6节", "", "", "", "", "", "", "" };
			text[4] = new String[] { "7-8节", "", "", "", "", "", "", "" };
			text[5] = new String[] { "9-10节", "", "", "", "", "", "", "" };

			getRemoteInfo();
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 8; j++) {
					map = new HashMap<String, Object>();
					map.put("ItemText", text[i][j]);
					meumList.add(map);
				}
			}
			
			SimpleAdapter saItem = new SimpleAdapter(CourseScheduleActivity.this,
					meumList,
					R.layout.activity_coures,
					new String[] { "ItemText" },
					new int[] { R.id.Text1 });

			gridview.setAdapter(saItem);
			gridview.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					switch (arg2) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;
					case 10:
						break;
					case 11:
						break;
					case 12:
						break;
					case 13:
						break;
					case 14:
						break;
					case 15:
						break;
					case 16:
						break;
					case 17:
						break;
					case 18:
						break;
					case 19:
						break;
					case 20:
						break;
					case 21:
						break;
					case 22:
						break;
					case 23:
						break;
					case 24:
						break;
					case 25:
						break;
					case 26:
						break;
					case 27:
						break;
					case 28:
						break;
					case 29:
						break;
					case 30:
						break;
					case 31:
						break;
					case 32:
						break;
					case 33:
						break;
					case 34:
						break;
					case 35:
						break;
					case 36:
						break;
					case 37:
						break;
					case 38:
						break;
					case 39:
						break;
					case 40:
						break;
					case 41:
						break;
					case 42:
						break;
					case 43:
						break;
					case 44:
						break;
					case 45:
						break;
					case 46:
						break;
					case 47:
						break;
					default:
						break;
					}
				}
			});
		}
	};
		
}
