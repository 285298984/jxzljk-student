package net.dyxy.yinyy.jxzljk.student1;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	// 声明所需控件
	private EditText login_user_edit, login_passwd_edit;
	private Button login_login_btn1;
	private CheckBox savepwd;
	SharedPreferences remdname1;
	// 命名空间
	final String service_name = "http://tempuri.org/";
	// ServiceURL
	final String service_url = "http://10.40.58.220:8099/WebServiceStudent.asmx";
	// 需要调用的方法名
	String methodName = "Login";
	String soapAction = "http://tempuri.org/Login";
	// 用户名
	String sno = null;
	// 口令
	String card = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		//保存用户名密码
		savePasswd();
		// 调用方法查找控件
		findViews();
		// 绑定按钮监听器
		login_login_btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获得webservice服务验证用户名密码
				getWebService();
			}
		});
	}

	// 查找activity所需控件
	public void findViews() {
		login_user_edit = (EditText) findViewById(R.id.login_user_edit);
		login_passwd_edit = (EditText) findViewById(R.id.login_passwd_edit);
		login_login_btn1 = (Button) findViewById(R.id.login_login_btn1);
	}

	// 调用webservice服务，进行用户名密码验证登陆操作
	public void getWebService() {
		// 指定WebService的命名空间和调用的方法名
		SoapObject soapObject = new SoapObject(service_name, methodName);
		// 获取文本框输入
		sno = login_user_edit.getText().toString();
		card = login_passwd_edit.getText().toString();

		// 设置需调用WebService接口需要传入的两个参数username、password
		soapObject.addProperty("sno", sno);
		soapObject.addProperty("card", card);
		// 生成调用WebService方法的SOAP请求信息,并指定SOAP的版本
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER12);
		// 设置是否调用的是dotNet开发的WebService
		envelope.dotNet = true;
		envelope.bodyOut = soapObject;
		// 将soapObject对象设置为envelop对象，传出消息
		envelope.setOutputSoapObject(soapObject);

		HttpTransportSE httpSE = new HttpTransportSE(service_url);
		// 调用webservice
		try {
			httpSE.call(soapAction, envelope);
			// 判断返回的KeyId和Name是否为空
			if (envelope.getResponse() != null) {
				// 得到远程方法返回的SOAP对象
				SoapObject resultObj = (SoapObject) envelope.bodyIn;
				System.out.println("resultObj----->>" + resultObj);
				// 接受得到的参数
				String KeyAndName = resultObj.getProperty(0).toString();
				System.out.println("KyeAndName----->>" + KeyAndName);
				// 页面跳转
				Intent intent = new Intent(LoginActivity.this,
						MainActivity.class);
				startActivity(intent);
				// Toast，浮动显示信息给用户。
				Toast.makeText(LoginActivity.this, "恭喜您，登陆成功。",
						Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新输入~",
						Toast.LENGTH_LONG).show();
			}

		} catch (HttpResponseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
	//记住用户名和密码
	public void savePasswd() {
		savepwd = (CheckBox) findViewById(R.id.savepwd);
		if (savepwd.isChecked()) {
			SharedPreferences remdname1 = getPreferences(Activity.MODE_PRIVATE);
			SharedPreferences.Editor edit = remdname1.edit();
			edit.putString("name", sno);
			edit.putString("password", card);
			edit.commit();
			login_user_edit.setText(remdname1.getString("name", ""));
			login_passwd_edit.setText(remdname1.getString("password", ""));
		}
	}
}
