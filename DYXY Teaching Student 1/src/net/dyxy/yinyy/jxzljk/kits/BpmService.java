package net.dyxy.yinyy.jxzljk.kits;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class BpmService {
	//private static final String SERVER_URL = "http://10.0.2.2/bpm";
	// private static final String SERVER_URL = "http://192.168.191.1/bpm";
	// private static final String SERVER_URL = "http://192.168.1.117/bpm";
	private static final String SERVER_URL = "http://10.40.58.220:8099";
	//private static final String SERVER_URL = "http://192.168.0.11/bpm";
	private static final String SERVICE_URL = SERVER_URL + "/WebService2.asmx";
	private static final String SERVICE_NAMESPACE = "http://tempuri.org/";

	public static final class Methods {
		public static final String GetCourseSchedulesByTeacher = "GetCourseSchedulesByTeacher";
		public static final String GetCourseSchedulesByClass = "GetCourseSchedulesByClass";
		public static final String GetAttendanceByTeacherId = "GetAttendanceByTeacherId";
		public static final String GetAttendanceByTeachCheckId = "GetAttendanceByTeachCheckId";
		public static final String SaveJournal = "SaveJournal";
		public static final String GetLoggersByTeacgerId = "GetLoggersByTeacgerId";
		public static final String GetBuildings = "GetBuildings";
		public static final String GetRoomsByBuildingId = "GetRoomsByBuildingId";
		public static final String GetCourseScheduleByRoomId = "GetCourseScheduleByRoomId";
		public static final String GetInspectByInspectorAndTeachCourseDetailId = "GetInspectByInspectorAndTeachCourseDetailId";
		public static final String SaveInspect = "SaveInspect";
		public static final String DeleteInspect = "DeleteInspect";
		public static final String GetInspecstByInspector = "GetInspectsByInspector";
		public static final String GetInspecstByTeacher = "GetInspectsByTeacher";
		public static final String GetInspectById = "GetInspectById";
		public static final String GetClassesByTeacher = "GetClassesByTeacher";
		public static final String GetTermAttendenceByTeacher= "GetTermAttendenceByTeacher";
		public static final String GetTodayAttendanceByTeacher= "GetTodayAttendanceByTeacher";
		public static final String GetAttendanceByStudent= "GetAttendanceByStudent";
		public static final String ValidateUser= "ValidateUser";
	}

	public static final class Params {
		public static final String username = "username";
		public static final String password = "password";
		public static final String json = "json";
		public static final String teachCheckId = "teachCheckId";
		public static final String inspectId = "inspectId";
		public static final String id = "id";
	}

	public static final class Answer {
		public static final String SUCCESS = "success";
		public static final String FAILURE = "failure";

	}

	// http://www.cnblogs.com/strayromeo/archive/2010/12/07/1899404.html
	public static SoapSerializationEnvelope SoapInvoke(String method, Object[][] params) {
		SoapObject request = new SoapObject(SERVICE_NAMESPACE, method);

		for (int i = 0; i < params.length; i++) {
			request.addProperty((String) params[i][0], params[i][1]);
		}

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
		envelope.dotNet = true;
		envelope.bodyOut = request;

		HttpTransportSE trans = new HttpTransportSE(SERVICE_URL);

		try {
			trans.call(SERVICE_NAMESPACE + method, envelope);
		} catch (Exception e) {
			// e.printStackTrace();
			Log.d("TEST", "Soap调用发生异常:" + e.getMessage());
		}

		return envelope;
	}

}
