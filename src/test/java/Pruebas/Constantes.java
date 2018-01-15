package Pruebas;

import java.text.SimpleDateFormat;
import java.util.Map;

public class Constantes {
	
	public static String TE_VERSION = "5.0";
	
	public static String TE_LAST_UPD = "28-11-2017";

	public static String SERVICE_URL = "";
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat uniqueFormat = new SimpleDateFormat("yyMMddHHmmss");
	
	public static final String NEWLINE = "\n";
	
	public static final String NEWLINE_HTML = "<br/>";
	
	public static final String NEWLINE_LOG = System.getProperty("line.separator");
	
	public static String CURRENT = "";
	
	public static final String QRY_GET_EXECUTION_FLOW = "getExecutionFlow";
	public static final String QRY_GET_EXECUTION_FLOW_DETAIL = "getExecutionFlowDetail";
	public static final String QRY_GET_SCHEDULE_DATA = "getExecutionData";
	
	public static String BASE_PATH = "";
	
	public static String EXECUTOR_UID = "";
	
	public static int MANUAL_TEST = 2;
	public static int SCHEDULE_TEST = 3;

	
	public static final int DEFAULT_WAIT_TIME_IN_SECONDS = 30;
	
	public static final String DEFAULT_IMAGE_FORMAT = "jpg";
	
	public static final String DEFAULT_IMAGE_EXTENSION = ".jpg";
	
	public static final String DEFAULT_MOBILE_EXTENSION = ".png";
	
	public static final int DEFAULT_IMAGE_PORCENTAGE = 15;
	
	public static final int DEFAULT_THINKTIME = 20 * 1000;
	
	public static boolean IS_ACTIVE = true;
	
	public static String SCREENS_PATH = BASE_PATH + "EVIDENCE/";
	
	public static String LICENSE_PATH = BASE_PATH + "LICENSE/";
	
	public static String DRIVER_PATH = BASE_PATH + "DRIVERS/";
	
	public static String DOWNLOAD_PATH = BASE_PATH + "DOWNLOAD/";
	
	public static String REST_SERVICE_URL = SERVICE_URL + "service/client";
	
	public static String EVIDENCE_SERVICE_URL = SERVICE_URL + "service/evserv?";
	
	public static String EVIDENCE_REGRESION_URL = SERVICE_URL + "service/evservregr?";
	
	public static String MESSAGES = "";
	
	public static void clean(){
		SCREENS_PATH = BASE_PATH + "EVIDENCE/";
		LICENSE_PATH = BASE_PATH + "LICENSE/";
		DRIVER_PATH = BASE_PATH + "DRIVERS/";
	}
	
	public static Map<String,String> values = null;
	
	public static String DYNAMIC_VALUE = "9999";
	public static int REGRESION_TYPE = 4;
	public static int FULL_ERROR_TYPE = 3;
	
	public static String USR_EMAIL = "";
	public static String USR_NOTIFICATIONS = "";
	
	public static String DEVICE_ID = "0";
	
	public static boolean isMAC = false;
	
	public static String OCR_PATH = "C:\\testConfig\\OCR\\crop.png";
	public static String TESS4J_FOLDER_PATH = "C:\\testConfig\\OCR\\tessdata\\";

}
