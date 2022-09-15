package CDataLayer;

//import java.util.*;
//import java.text.SimpleDateFormat;

public abstract class CBaseData {

	public int		m_nID				=CDefines.NO_VALUE;
	public int		m_nTypeID			=CDefines.NO_VALUE;
	protected int	m_nDeptID			=CDefines.NO_VALUE;

	protected String m_szClassName	="";
	protected String m_szGuid		="";
	protected Boolean m_bReadOnly		=false;
	protected Boolean m_bEnabled		=true;
	protected Boolean m_bLogDeletion	=false;		// used locally to log delete, not a SQL col
	protected Boolean m_bDisplay		=true;
	protected Boolean m_bIsParent		=true;
	
	protected String m_szTableName		="";
	protected String m_szSqlConn		="";
	protected String m_szGroupToExpand	="";
	

	public int m_nLastUpdatedUserID	=-1;
	//public Date m_dtLastUpdated	=Date.parse(CDefines.OUR_DEAD_DATE);
}
