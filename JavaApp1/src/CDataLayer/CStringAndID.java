package CDataLayer;

//---------------------------------------------------------------------------------------
public class CStringAndID  {
	//---------------------------------------------------------------------------------------
	private String	m_szText;
	private int		m_nID;
	//---------------------------------------------------------------------------------------
	public CStringAndID() {
		m_szText="";
		m_nID	=-1;
	}
	//---------------------------------------------------------------------------------------
	public CStringAndID(String szText, int nID) {
		m_szText=szText;
		m_nID	=nID;
	}
	//---------------------------------------------------------------------------------------
	public  String ToString() {
		return m_szText.trim();
	}
	//---------------------------------------------------------------------------------------
	// get/sets
	//---------------------------------------------------------------------------------------
	public String getM_szText() {
		return m_szText;
	}
	public void setM_szText(String m_szText) {
		this.m_szText = m_szText;
	}
	public int getM_nID() {
		return m_nID;
	}
	public void setM_nID(int m_nID) {
		this.m_nID = m_nID;
	}

	//---------------------------------------------------------------------------------------
}
//---------------------------------------------------------------------------------------
