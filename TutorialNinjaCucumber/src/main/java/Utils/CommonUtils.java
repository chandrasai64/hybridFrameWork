package Utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGELOAD_WAIT_TIME=10;
	public static final int EXPLICIT_WAIT_BASIC_TIME=10;
	public  String getEmailWithTimestamp()
	{
		Date date=new Date();
	return	"chandra"+date.toString().replace(" ","").replace(":", "_")+"@gmail.com";
	}

}
