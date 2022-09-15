package CDataLayer;

import java.util.*;

import javax.swing.JOptionPane;

//----------------------------------------------------------------
public class CLabelsSingleton {
	// A static member to hold a reference to the singleton instance
	private static CLabelsSingleton m_Instance;

	public static String m_szWorkDirectory="";

	public static int LABEL_LABEL_GROUPS			=0;


	public static  int LABEL_YESNO				=1;
	public static  ArrayList  m_szYesNo			=null;


	
	//----------------------------------------------------------------
	// function to sort an array of CStringAndID objects by text
//	public class CStringArrayComparer : IComparer {
//
//		public int Compare(object x, object y) {
//			CLabel pData1	=(CLabel)x;
//			CLabel pData2	= (CLabel)y;
//			return string.Compare(pData1.ToString(), pData2.ToString());
//		}
//	}

	//----------------------------------------------------------------
	// A static constructor to create the singleton instance. 
	  CLabelsSingleton() {
		
		try {	

			JOptionPane.showMessageDialog(null,"CLabelsSingleton1");
			RefreshLabels();
			
		}
		catch(Exception xpt){
			JOptionPane.showMessageDialog(null,xpt,"CLabelsSingleton", JOptionPane.ERROR_MESSAGE);
		}
	}
	//----------------------------------------------------------------
	// A private constructor to stop code from creating additional instances of the singleton type
//	public String CLabelsSingleton() {
//		RefreshLabels();
//	}
//	//----------------------------------------------------------------
//	// A public property to provide access to the singleton instance
//	public static String CLabelsSingleton Instance {
//		get {
//			return m_Instance;
//		}
//	}
	//----------------------------------------------------------------
	public static void Initialize() {
		try {
			JOptionPane.showMessageDialog(null,"Initialize");
			m_Instance = new CLabelsSingleton();
		}
		catch(Exception xpt){
			JOptionPane.showMessageDialog(null,xpt,"CLabelsSingleton", JOptionPane.ERROR_MESSAGE);
		}
	}
	//----------------------------------------------------------------	

	public static CLabelsSingleton getM_Instance() {
		m_Instance = new CLabelsSingleton();
		try {
			return m_Instance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "getM_Instance", JOptionPane.ERROR_MESSAGE);
			return m_Instance;
		}
	}
	//----------------------------------------------------------------		
	private void LoadPermissions() {
	
	}
	//----------------------------------------------------------------
	public void RefreshLabels() {
		m_szYesNo = CLabelsDB.GetLabelsDB(CDefines.TYPE_LABELS, LABEL_YESNO);
	}
	//----------------------------------------------------------------
	public static void SelectArray(int nListID, ArrayList pArrayList){

		try {		
			switch(nListID) {

			case 1:
					pArrayList=m_szYesNo;
					break;
    
                default:
					break;
			}
		}
		catch(Exception xpt) {
		}
	}
	//----------------------------------------------------------------		

	public String GetLabel(int nListID, int nValue) {
		ArrayList	pArrayList = null;
		int			x=0, nID=-1;
		boolean		bNotFound=true;
		String		szLabel="";

		try {
			if(nValue!=-1){
				SelectArray(nListID,  pArrayList);
				while(x<pArrayList.size()){
					
	
						if(((CLabels)pArrayList.get(x)).getM_nLabelID()==nValue) {

							szLabel=((CBaseData)pArrayList.get(x)).toString();
						}
						x++;
				}
				
			}			
		}
		catch(Exception xpt) {
			JOptionPane.showMessageDialog(null,"GetLabel");
		}
		return szLabel;
	}
	//---------------------------------------------------------------------------------------


	//---------------------------------------------------------------------------------------		
	
}
//---------------------------------------------------------------------------------------
