package CDataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CLabelsDB {

	
	public static ArrayList<CLabels> GetLabelsDB(int m_nTypeID, int nGroupID) {
		JOptionPane.showMessageDialog(null, "CLabelsDB");
		ArrayList<CLabels> listCategory = new ArrayList<CLabels>();
		ResultSet Rs = null;
		PreparedStatement pstmt ;
		try {
			CDataBase.GetConn();
			String query = String.format("SELECT * from %s where nGroupID=%s ", CDefines.m_szTableNames[m_nTypeID].toString(), nGroupID);
			pstmt = CDataBase.con.prepareStatement(query);
			Rs = pstmt.executeQuery();

			while (Rs.next()) {

				listCategory.add(new CLabels(query));
				//JOptionPane.showMessageDialog(null,listCategory.size());
				//pDataLabels = new CLabels(Rs.getString("szText"));
				//listCategory.add(pDataLabels);
			}			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "GetLabelsDB()", JOptionPane.ERROR_MESSAGE);
		}
		return listCategory;	
	}
	//---------------------------------------------------------------------------------------	
}
