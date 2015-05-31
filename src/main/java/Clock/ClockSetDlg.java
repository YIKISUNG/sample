package Clock;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JCheckBox;

public class ClockSetDlg extends JDialog
{
	private final JPanel RightPanel = new JPanel();
	private final JPanel TimePanel = new JPanel();
	private final JPanel contentPanel = new JPanel();
	private final JPanel DatePanel = new JPanel();

	public ClockSetDlg()
	{
		setTitle("Set Time");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1,2));
		RightPanel.setLayout(new GridLayout(2,1));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		RightPanel.add(TimePanel);
		RightPanel.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			TimePanel.add(buttonPane, BorderLayout.SOUTH);
			{
				JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
				buttonPane.add(chckbxNewCheckBox);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
