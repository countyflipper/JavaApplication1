package CDataLayer;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CDataBase {
	//----------------------------------------------------------------------
	static CPeople pData = null;
	static CLabels pDataLabels = null;
	public static Connection con = null;
	public static String szQuery;
	//----------------------------------------------------------------------
	public  static Connection  GetConn()
	{
        try {
			Class.forName(CDefines.JDBC_DRIVER);
			con = DriverManager.getConnection(CDefines.m_szConn);
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	//----------------------------------------------------------------------
	public static ArrayList<CPeople> Read()
	{
		ArrayList<CPeople> PeopleList = new ArrayList<>();
		ResultSet Rs = null;
		try {
			GetConn();
			PreparedStatement pstm = con
					.prepareStatement("SELECT nID, szFirstName, szLastName, nAge,bSex, nTitle FROM tblPeople");
			Rs = pstm.executeQuery();
			while (Rs.next()) {

				pData = new CPeople(Rs.getInt(1), Rs.getString(2), Rs.getString(3), Rs.getInt(4), Rs.getBoolean(5), Rs.getInt(6));
				PeopleList.add(pData);
			}
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return PeopleList;
	}
	//----------------------------------------------------------------------
	public static void Create(String szTextFirst, String szTextLast, int nTextAge, boolean rbSex, int nTitle)
	{
		try {
			GetConn();
	         Statement statement = con.createStatement();
             statement.executeUpdate("INSERT INTO tblPeople( szFirstName, szLastName, nAge, bSex, nTitle) VALUES('"+szTextFirst+"','"+szTextLast+"','"+nTextAge+"','"+rbSex+"','"+nTitle+"')"+" SELECT SCOPE_IDENTITY();");
 			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
	//----------------------------------------------------------------------
	public static void Delete(int nID)
	{
        String sql = "DELETE FROM tblPeople WHERE nID = ?";
        
        try (Connection conn = GetConn();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(nID, nID);
            // execute the delete statement
            pstmt.executeUpdate();
			con.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	//----------------------------------------------------------------------

	public static void Update(CPeople list)
	{
		GetConn();
        String query = String.format("update tblPeople set szFirstName = ?, szLastName = ?,nAge= ?, bSex = ?, nTitle = ? WHERE nID = ?");
        PreparedStatement pstmt = null;

        try  {

        	pstmt = con.prepareStatement(query);

            pstmt.setString(1, list.m_szFirstName);
            pstmt.setString(2, list.m_szLastName);
            pstmt.setInt(3, list.m_nAge);
            pstmt.setBoolean(4, list.m_bSex);
            pstmt.setInt(5, list.m_nTitle);
            pstmt.setInt(6, list.m_nID);
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
	}
	//---------------------------------------------------------------------------------------	
	public static ArrayList<CLabels> GetLabels(int m_nTypeID, int nGroupID) {
		ArrayList<CLabels> listCategory = new ArrayList<CLabels>();
		ResultSet Rs = null;
		PreparedStatement pstmt ;
		try {
			CDataBase.GetConn();
			String query = String.format("SELECT szText FROM %s right join tblPeople on tblLabels.nLabelSingletonID = tblPeopleTest.nTitle", CDefines.m_szTableNames[m_nTypeID].toString(), nGroupID);
			pstmt = CDataBase.con.prepareStatement(query);
			Rs = pstmt.executeQuery();

			while (Rs.next()) {


				pDataLabels = new CLabels(Rs.getString("szText"));
				listCategory.add(pDataLabels);
			}			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "GetComboBoxValues", JOptionPane.ERROR_MESSAGE);
		}
		return listCategory;	
	}
	//---------------------------------------------------------------------------------------	

	
}
