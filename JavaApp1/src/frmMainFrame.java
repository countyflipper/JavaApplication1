

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import CDataLayer.CDefines;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class frmMainFrame extends JFrame {

	static JDesktopPane desktop;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frmMainFrame frame = new frmMainFrame();
				frame.setVisible(true);
				createFrame(); 
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMainFrame() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		JMenu mnNewView= new JMenu("View");
		JMenu mnNewConfiguration= new JMenu("Configuration");
		JMenu mnNewWindow= new JMenu("Window");			
		JMenu mnNewAbout= new JMenu("About");
		
		
		menuBar.add(mnNewMenu);
		menuBar.add(mnNewView);
		menuBar.add(mnNewConfiguration);
		menuBar.add(mnNewWindow);			
		menuBar.add(mnNewAbout);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Java Application Template");

		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, 1000,600);

		desktop = new JDesktopPane();
		desktop.setBackground(SystemColor.activeCaption);
		setContentPane(desktop);

		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		
	}

	protected static void createFrame() {
		frmMain frame = new frmMain();
		frame.setVisible(true);
		frame.GetComboBoxValues(CDefines.TYPE_LABELS);
		desktop.add(frame);
		try {
			//frame.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
