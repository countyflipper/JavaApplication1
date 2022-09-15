package CDataLayer;

//import java.util.Date;

//----------------------------------------------------------------------------	
public class CLabels extends CBaseData {
	//----------------------------------------------------------------------------	
	private int		m_nGroupID;
	private int		m_nLabelID;
	private int		m_nOrder;
	public String	m_szText;
	//----------------------------------------------------------------------------	
	public CLabels( String szText)
	{
		m_szText=szText;
	}
	//----------------------------------------------------------------------------	
	void Initialize() {
		m_szTableName		=CDefines.m_szTableNames[CDefines.TYPE_LABELS];
		m_szSqlConn			=CDefines.m_szConn;	
		m_nTypeID			=CDefines.TYPE_LABELS;
		m_szClassName		="CLabel";									
		m_szGroupToExpand	="Properties";
		//m_CtrlList			=new ArrayList();
		//m_nPropGridHeight	=200;
		Clear();
	}
	//----------------------------------------------------------------------------				
	public  void Clear() {
	

			m_nGroupID		=-1;
			m_nLabelID		=-1;
			m_nOrder		=0;
			m_szText		="";
			m_bReadOnly		=false;

			//m_dtLastUpdated			=CDefines.TODAYS_DATE;
			m_nLastUpdatedUserID	=1;//CUserSingleton.Instance.User.nID;								

	}
	//---------------------------------------------------------------------------
	public  String ToString() {
		return m_szText;
	}
	//---------------------------------------------------------------------------	
	public int getM_nGroupID() {
		return m_nGroupID;
	}
	public void setM_nGroupID(int m_nGroupID) {
		this.m_nGroupID = m_nGroupID;
	}
	public int getM_nLabelID() {
		return m_nLabelID;
	}
	public void setM_nLabelID(int m_nLabelID) {
		this.m_nLabelID = m_nLabelID;
	}
	public int getM_nOrder() {
		return m_nOrder;
	}
	public void setM_nOrder(int m_nOrder) {
		this.m_nOrder = m_nOrder;
	}
	public String getM_szText() {
		return m_szText;
	}
	public void setM_szText(String m_szText) {
		this.m_szText = m_szText;
	}
	
	//----------------------------------------------------------------------------	
}
