
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

import CDataLayer.CDataBase;
import CDataLayer.CDefines;
import CDataLayer.CLabels;
import CDataLayer.CLabelsSingleton;
import CDataLayer.CPeople;
import CDataLayer.CStringAndID;

//import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import javax.swing.ListSelectionModel;
import javax.swing.*;
//import java.util.*;
//import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

// ------------------------------------------------------------
public class frmMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	public static DefaultTableModel model = new DefaultTableModel();
	private JButton btnInsert;
	private JButton btnDelete;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtAge;
	public JButton btnUpdate;
	private JTextField txtID;
	private JLabel lblNewLabel_3;
	public static CPeople m_peopleData = new CPeople();
	private JMenuBar menuBar;
	JLabel lblStatus;
	public static JComboBox<String> comboBox ;
	JRadioButton rdBtnMale;
	JRadioButton rdBtnFemale;

	// ------------------------------------------------------------
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupColumns();
					frmMain frame = new frmMain();
					frame.setVisible(true);
					 GetComboBoxValues(CDefines.TYPE_LABELS);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ------------------------------------------------------------
	/**
	 * Create the frame.
	 */
	public frmMain() {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 539, 499);

			menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			JMenu mnNewMenu = new JMenu("File");
			menuBar.add(mnNewMenu);

			JMenu mnNewMenu_1 = new JMenu("Close");
			mnNewMenu.add(mnNewMenu_1);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			lblStatus = new JLabel("Ready");
			lblStatus.setBounds(12, 406, 500, 16);
			contentPane.add(lblStatus);

			JScrollPane scrollPane = new JScrollPane(table);
			table.addMouseListener(new MouseAdapterTable());

			scrollPane.setBounds(12, 13, 500, 118);
			contentPane.add(scrollPane);
			scrollPane.setViewportView(table);
			contentPane.add(scrollPane);
			// ------------------------------------------------------------
			JButton btnLoad = new JButton("Refresh");
			btnLoad.addActionListener(new ButtonClickListenerRead());
			btnLoad.setBounds(393, 144, 97, 25);
			contentPane.add(btnLoad);
			// ------------------------------------------------------------
			btnInsert = new JButton("Insert");
			btnInsert.addActionListener(new ButtonClickListenerCreate());
			btnInsert.setBounds(46, 144, 97, 25);
			contentPane.add(btnInsert);
			// ------------------------------------------------------------
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ButtonClickListenerDelete());
			btnDelete.setBounds(168, 144, 97, 25);
			contentPane.add(btnDelete);
			// ------------------------------------------------------------
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ButtonClickListenerUpdate());
			btnUpdate.setBounds(284, 144, 97, 25);
			contentPane.add(btnUpdate);
			// ------------------------------------------------------------
			txtFirst = new JTextField();
			txtFirst.setBounds(140, 232, 116, 22);
			contentPane.add(txtFirst);
			txtFirst.setColumns(10);

			txtLast = new JTextField();
			txtLast.setBounds(268, 230, 116, 22);
			contentPane.add(txtLast);
			txtLast.setColumns(10);

			txtAge = new JTextField();
			txtAge.setBounds(393, 231, 116, 22);
			contentPane.add(txtAge);
			txtAge.setColumns(10);

			JLabel lblNewLabel = new JLabel("First");
			lblNewLabel.setBounds(140, 213, 56, 16);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Last");
			lblNewLabel_1.setBounds(268, 213, 56, 16);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Age");
			lblNewLabel_2.setBounds(393, 213, 56, 16);
			contentPane.add(lblNewLabel_2);

			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setBounds(12, 231, 116, 22);
			contentPane.add(txtID);
			txtID.setColumns(10);

			lblNewLabel_3 = new JLabel("nID");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_3.setBounds(12, 213, 56, 16);
			contentPane.add(lblNewLabel_3);

			rdBtnMale = new JRadioButton("Male", true);
			rdBtnMale.setBounds(12, 284, 127, 25);
			contentPane.add(rdBtnMale);

			rdBtnFemale = new JRadioButton("Female");
			rdBtnFemale.setBounds(12, 314, 127, 25);
			contentPane.add(rdBtnFemale);

			ButtonGroup myButtonGroup = new ButtonGroup();
			myButtonGroup.add(rdBtnMale);
			myButtonGroup.add(rdBtnFemale);

			comboBox = new JComboBox<String>();
			comboBox.setBounds(168, 285, 149, 22);
			contentPane.add(comboBox);

			JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
			chckbxNewCheckBox.setBounds(377, 284, 113, 25);
			contentPane.add(chckbxNewCheckBox);

			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBounds(2, 399, 521, -6);
			contentPane.add(horizontalStrut);

			Box horizontalBox = Box.createHorizontalBox();
			horizontalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			horizontalBox.setBounds(2, 399, 523, 2);
			contentPane.add(horizontalBox);


		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	// ------------------------------------------------------------
	private class ButtonClickListenerUpdate implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (ControlsToData()) {
//				/int result = Integer.parseInt(txtID.getText());
				CDataLayer.CDataBase.Update(m_peopleData);
			}
			UpdateStatusLine(CDefines.SQL_UPDATE);
		}
	}
	// ------------------------------------------------------------

	private class ButtonClickListenerDelete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int result = Integer.parseInt(txtID.getText());
			CDataLayer.CDataBase.Delete(result);
			UpdateStatusLine(CDefines.SQL_DELETE);
			PopulateTable();

		}
	}
	// ------------------------------------------------------------

	private class ButtonClickListenerCreate implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				int n = JOptionPane.showConfirmDialog(null, "Yes No Cancel", "YesNoCancel", JOptionPane.YES_NO_CANCEL_OPTION);
			    switch (n) {
			        case 0:
			            JOptionPane.showConfirmDialog(null, "You pressed YES\n"+"Pressed value is = "+n);
						if (ControlsToData()) {
							CDataLayer.CDataBase.Create(m_peopleData.m_szFirstName, m_peopleData.m_szLastName,
									m_peopleData.m_nAge, m_peopleData.m_bSex,m_peopleData.m_nTitle);
							UpdateStatusLine(CDefines.SQL_INSERT);
							PopulateTable();
						}
			            break;
			        case 1:
			            JOptionPane.showConfirmDialog(null, "You pressed NO\n"+"Pressed value is = "+n);
			            break;
			        case 2:
			            JOptionPane.showConfirmDialog(null, "You pressed CANCEL\n"+"Pressed value is = "+n);
			            break;
			        case -1:
			            JOptionPane.showConfirmDialog(null, "You pressed X\n"+"Pressed value is = "+n);
			            break;
			        default:
			            break;
			    }

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e, "btnInsert", JOptionPane.ERROR_MESSAGE);
				UpdateStatusLine(CDefines.SQL_INSERT);
			}

		}
	}
	// ------------------------------------------------------------

	private class ButtonClickListenerRead implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				PopulateTable();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2, "Read", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	// ------------------------------------------------------------
	private class MouseAdapterTable implements MouseListener {
		CStringAndID pStringID=null;
		public void mouseClicked(MouseEvent e) {
			model = (DefaultTableModel) table.getModel();
			int selectRowIndex = table.getSelectedRow();
			txtID.setText(model.getValueAt(selectRowIndex, 0).toString().trim());
			txtFirst.setText(model.getValueAt(selectRowIndex, 1).toString().trim());
			txtLast.setText(model.getValueAt(selectRowIndex, 2).toString().trim());
			txtAge.setText(model.getValueAt(selectRowIndex, 3).toString().trim());
			SetYesNoRadioValue(rdBtnMale, rdBtnFemale, model.getValueAt(selectRowIndex, 4).toString().trim());
			//comboBox.setSelectedIndex((int) model.getValueAt(selectRowIndex, 5));
			
			comboBox.setSelectedIndex((int) model.getValueAt(selectRowIndex, 5));
	
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
	// ------------------------------------------------------------

	public boolean ControlsToData() {
		boolean bReturn;
		try {
			bReturn = true;

			m_peopleData.m_szFirstName = txtFirst.getText();
			m_peopleData.m_szLastName = txtLast.getText();
			if (!txtID.getText().isEmpty()) {
				m_peopleData.m_nID = Integer.parseInt(txtID.getText());
			}
			if (!txtAge.getText().isEmpty()) {
				m_peopleData.m_nAge = Integer.parseInt(txtAge.getText());
			}
			m_peopleData.m_bSex = GetYesNoRadioValue(rdBtnMale.isSelected(), rdBtnFemale.isSelected());
			m_peopleData.m_nTitle = comboBox.getSelectedIndex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bReturn = false;
			JOptionPane.showMessageDialog(null, e, "ControlsToData", JOptionPane.ERROR_MESSAGE);
		}
		return bReturn;
	}

	// ------------------------------------------------------------
	public void DataToControls() {

		CStringAndID pStringID=null;
		try {


//			m_peopleData.m_szFirstName = txtFirst.getText();
//			m_peopleData.m_szLastName = txtLast.getText();
//			if (!txtID.getText().isEmpty()) {
//				m_peopleData.m_nID = Integer.parseInt(txtID.getText());
//			}
//			if (!txtAge.getText().isEmpty()) {
//				m_peopleData.m_nAge = Integer.parseInt(txtAge.getText());
//			}
//			m_peopleData.m_bSex = GetYesNoRadioValue(rdBtnMale.isSelected(), rdBtnFemale.isSelected());
			
			
			if(m_peopleData.m_nTitle>-1){
				for(int x=0; x< comboBox.getItemCount(); x++){
					pStringID=(CStringAndID)comboBox.getSelectedItem();
					if(pStringID.getM_nID()==m_peopleData.m_nTitle) {	
						comboBox.getSelectedIndex();
						//cmbDayOfWeek.SelectedIndex=x;
						break; 	// jump out of the for loop
					}	
				}
			}
			
			//m_peopleData.m_nTitle = comboBox.getSelectedIndex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "DataToControls", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ------------------------------------------------------------
	public static void SetupColumns() {
		try {
			table = new JTable(model);
			model.addColumn("Id");
			model.addColumn("FirstName");
			model.addColumn("LastName");
			model.addColumn("Age");
			model.addColumn("Sex");
			model.addColumn("Title");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------
	public void UpdateStatusLine(int nAction) {
		try {
			switch (nAction) {
			case 0:
				lblStatus.setText("Item as been successfully inserted.");
				break;
			case 1:
				lblStatus.setText("Table has been refresh.");
				break;
			case 2:
				lblStatus.setText("Record has been updated.");
				break;
			case 3:
				lblStatus.setText("Record has been deleted.");
				break;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------
	public void PopulateTable() {

		try {
			//CLabelsSingleton.getM_Instance().GetLabel(CLabelsSingleton.LABEL_YESNO, 2);
			
			ResultSet Rs = null;
			ArrayList<CPeople> list = (ArrayList<CPeople>) CDataBase.Read();
		
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			Object[] row = new Object[6];
			for (int i = 0; i < list.size(); i++) {
				row[0] = list.get(i).getnID();
				row[1] = list.get(i).getszFirstName();
				row[2] = list.get(i).getszLastName();
				row[3] = list.get(i).getnAge();
				row[4] = list.get(i).getbSex();
				row[5] = CLabelsSingleton.getM_Instance().GetLabel(CLabelsSingleton.LABEL_YESNO, list.get(i).getnTitle());
				
				String abc  = CLabelsSingleton.getM_Instance().GetLabel(CLabelsSingleton.LABEL_YESNO, list.get(i).getnTitle());

				model.addRow(row);

			}
			Clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e,"PopulateTable", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ------------------------------------------------------------
	public void Clear() {

		try {
			txtID.setText("");
			txtFirst.setText("");
			txtLast.setText("");
			txtAge.setText("");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(rdBtnMale, e, "Clear", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ---------------------------------------------------------------------------------------
	public boolean GetYesNoRadioValue(boolean b, boolean c) {
		boolean bValue = false;
		try {

			if (b == true) {
				bValue = true;
			}

			return bValue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "GetYesNoRadioValue", JOptionPane.ERROR_MESSAGE);
			return bValue;
		}

	}

	// ---------------------------------------------------------------------------------------
	public void SetYesNoRadioValue(JRadioButton a, JRadioButton b, String bValue) {
		try {
			if (bValue == "true") {
				a.setSelected(true);
			} else {
				b.setSelected(true);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "SetYesNoRadioValue", JOptionPane.ERROR_MESSAGE);

		}

	}

	// -------------------------------------------------------------

	public static void GetComboBox() {
	
		try {



			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e, "GetComboBox", JOptionPane.ERROR_MESSAGE);

		}
	}
	//----------------------------------------------------------------------
	public static void  GetComboBoxValues(int m_nTypeID) {
		ArrayList<CLabels> listCategory = new ArrayList<CLabels>();
		ResultSet Rs = null;
		PreparedStatement pstmt ;
		try {
			CDataBase.GetConn();
			String query = String.format("SELECT * FROM %s  ORDER BY szText", CDefines.m_szTableNames[m_nTypeID].toString());
			pstmt = CDataBase.con.prepareStatement(query);
			Rs = pstmt.executeQuery();

			while (Rs.next()) {
				comboBox.addItem(Rs.getString("szText"));

			}			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "GetComboBoxValues", JOptionPane.ERROR_MESSAGE);
		}		

	}
	//----------------------------------------------------------------------
	public static void  ConvertLabels(int m_nTypeID, int nLabelValue) {
		ArrayList<CLabels> listCategory = new ArrayList<CLabels>();
		ResultSet Rs = null;
		PreparedStatement pstmt ;
		try {
			CDataBase.GetConn();
			String query = String.format("SELECT * FROM %s where nLabelSingletonID = %n  ORDER BY szText", CDefines.m_szTableNames[m_nTypeID].toString(), nLabelValue);
			pstmt = CDataBase.con.prepareStatement(query);
			Rs = pstmt.executeQuery();

			while (Rs.next()) {
				comboBox.addItem(Rs.getString("szText"));

			}			
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "GetComboBoxValues", JOptionPane.ERROR_MESSAGE);
		}		

	}
	//----------------------------------------------------------------------
	
	
}
