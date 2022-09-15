package CDataLayer;

import java.util.*;
import java.text.SimpleDateFormat;

public class CDefines {
	// ----------------------------------------------------------------------------
	public static int NO_VALUE = -1;
	public int NEW_RECORD = -1;
	// ----------------------------------------------------------------------------
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Date date = new Date();
	// ----------------------------------------------------------------------------
	public static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String m_szConn = "jdbc:sqlserver://ITS-661VCP2\\SQLEXPRESS:1433;databaseName=webforms;user=dt;password=Qu@lity2";
	// ---------------------------------------------------------------------------
	//----------------------------------------------------------------------------
	// Standard app wide MessageBox titles and message
	//----------------------------------------------------------------------------
	public static String MSG_CONFIRM				= "Please confirm";

	public static String MSG_DATE_PROBLEM_TITLE	= "This date conflicts with other dates.";

	public static String MSG_PROBLEM_SAVING		="Data not saved...";
	public static String MSG_PROBLEM_TITLE		="Problem encountered";

	public static String MSG_DATA_CHANGED_TITLE	="Data has changed...";

	public static String MSG_SET_CONNECTION_FALIED ="Not able to create the relationship between these objects...";

	public static String MSG_INSUFFICIENT_RIGHTS	="You do not have sufficient user rights for this action.";
	public static String MSG_DATA_CHANGED		="This item's data has changed, do you want to reload it?";

	public static String MSG_GEN_PROBLEM_TITLE	="Problem encountered in that operation...";

	public static String MSG_DELETE_MSG			="Delete this information, are you sure?";
	public static String MSG_DELETE_TITLE		="Confirm delete";

	public static String MSG_TRASH_MSG			="Move this information to Trash, are you sure?";
	public static String MSG_TRASH_TITLE			="Confirm Trash";

	public static String MSG_NO_DELETE_MSG		="This object is delete protected";
	public static String MSG_NO_DELETE_TITLE		="Delete not allowed";

	public static String MSG_BAD_DATA_MSG		="This entry is not of the correct format";
	public static String MSG_BAD_DATA_TITLE		="Invalid data";

	public static String MSG_EMAIL_ERROR_MSG		="Was not able to send the email.";
	public static String MSG_EMAIL_ERROR_TITLE	="Problem sending that email";

	public static String MSG_UNSAVED_MSG			="Changes not saved, close and loose changes?";
	public static String MSG_UNSAVED_TITLE		="Changes not saved";
	//----------------------------------------------------------------------------
	public static int SQL_INSERT = 0;
	public static int SQL_FETCH_SINGLE = 1;
	public static int SQL_UPDATE = 2;
	public static int SQL_DELETE = 3;
	// ----------------------------------------------------------------------------
	public int 			TYPE_ROOT 	= -1;
	public int 			TYPE_NONE 	= 0;
	public static int 	TYPE_PEOPLE = 1;
	public static int 	TYPE_LABELS = 2;
	// ----------------------------------------------------------------------------
	public String DEAD_DATE_SQL = formatter.format("1/1/0001");
	public String DEAD_DATE_NET = formatter.format("1/1/1900");
	public static String OUR_DEAD_DATE = "1/1/1800";
	public static String TODAYS_DATE = formatter.format(date);
	// ----------------------------------------------------------------------------
	public static String[] m_szTableNames = { 	
			"None", 			// TYPE_NONE 0
			"tblPeople", 	    // TYPE_PEOPLE 1
			"tblLabels", 		// TYPE_LABELS 2
	};
	//---------------------------------------------------------------------------------------
	public static String[] m_szObjectNames ={	
			"None",
			"CPeople",
			"CLabels",
};
//---------------------------------------------------------------------------------------

}
