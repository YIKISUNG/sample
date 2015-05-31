package Clock;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class Clock extends JFrame
{

	private JPanel contentPane;
	private JPanel panel;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					
					UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					Clock frame = new Clock();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clock()
	{
		setTitle("iClock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		JPanel jplInnerPanel1 = ClockTab.createInnerPanel();
		tabbedPane.addTab("Clock", jplInnerPanel1);
		tabbedPane.setSelectedIndex(0);
		JPanel jplInnerPanel2 = ClockTab.createInnerPanel();
		tabbedPane.addTab("Alarm", jplInnerPanel2);
		JPanel jplInnerPanel3 = ClockTab.createInnerPanel();
		tabbedPane.addTab("Stop Watch", jplInnerPanel3);
		JPanel jplInnerPanel4 = ClockTab.createInnerPanel();
		tabbedPane.addTab("Timer", jplInnerPanel4);
		JPanel jplInnerPanel5 = createInnerPanel1("Tab 4 Contains Text only");
		tabbedPane.addTab("Setting", jplInnerPanel5);
		panel.add(tabbedPane);
	}
	
	protected JPanel createInnerPanel1(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 3));
		jplPanel.setPreferredSize(new Dimension(400,200));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}


}
