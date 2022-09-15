package CDataLayer;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CPeople extends CBaseData  {
	//----------------------------------------------------------------------------		
	public int m_nID;
	public String m_szFirstName;
	public String m_szLastName;
	public int m_nAge;
	public boolean m_bSex;
	public int m_nTitle;
	public CDataBase pData;
	//----------------------------------------------------------------------------		
	public  CPeople()
	{
		try {
			Initialize();
		} catch (Exception xpt) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, xpt, "CPeople", JOptionPane.ERROR_MESSAGE);
		}
	}
	//----------------------------------------------------------------------------		
	public  CPeople(int nID, String szFirstName, String szLastName, int nAge, boolean nSex, int nTitle)
	{
		this.m_nID = 			nID;
		this.m_szFirstName=		szFirstName;
		this.m_szLastName=		szLastName;
		this.m_nAge = 		 	nAge;
		this.m_bSex = 		 	nSex;
		this.m_nTitle = 		nTitle;
		
	}
	//----------------------------------------------------------------------------			
	void Initialize() {

		try {
			m_szTableName		=CDefines.m_szTableNames[CDefines.TYPE_PEOPLE];
			m_szSqlConn			=CDefines.m_szConn;
			m_nTypeID			=CDefines.TYPE_PEOPLE;
			m_szClassName		=CDefines.m_szObjectNames[CDefines.TYPE_PEOPLE].toString();
			m_szGroupToExpand	="Properties";

			Clear();
		}
		catch(Exception xpt) {
			JOptionPane.showMessageDialog(null, xpt, "Initialize - CPeople", JOptionPane.ERROR_MESSAGE);
		}
	}
	//----------------------------------------------------------------------------	 
	public void Clear()
	{
		this.m_nID = 			-1;
		this.m_szFirstName=		"";
		this.m_szLastName=		"";
		this.m_nAge = 		 	-1;
		this.m_bSex = 		 	false;
		this.m_nTitle = 		-1;
	}
	//----------------------------------------------------------------------------	 
	public boolean getbSex() {
		return m_bSex;
	}

	public void setbSex(boolean m_bSex) {
		this.m_bSex = m_bSex;
	}

	public String getszFirstName() {
		return m_szFirstName;
	}

	public void setszFirstName(String m_szFirstName) {
		this.m_szFirstName = m_szFirstName;
	}

	public String getszLastName() {
		return m_szLastName;
	}

	public void setszLastName(String m_szLastName) {
		this.m_szLastName = m_szLastName;
	}

	public int getnAge() {
		return m_nAge;
	}

	public void setnAge(int m_nAge) {
		this.m_nAge = m_nAge;
	}

	public int getnID() {
		return m_nID;
	}

	public void setnID(int m_nID) {
		this.m_nID = m_nID;
	}
	
	public int getnTitle() {

		return m_nTitle;
	}

	public void setnTitle(int m_nTitle) {
		this.m_nTitle = m_nTitle;
	}
	
	
}
