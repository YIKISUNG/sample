package Clock;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClockTab
{
	static JPanel createInnerPanel()
	{
		JPanel jplPanel = new JPanel();
		JPanel[] p = new JPanel[4];
		ClockLabel dateLable = new ClockLabel("date");
	    ClockLabel timeLable = new ClockLabel("time");
	    ClockLabel dayLable = new ClockLabel("day");
	    JButton btnSet = new JButton("Change date & Time");
	    btnSet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		jplPanel.setLayout(new GridLayout(4, 1));
		jplPanel.setPreferredSize(new Dimension(400, 200));
		//p[1].setPreferredSize(new Dimension(400, 70));
		
		for (int i = 0; i < p.length; i++)
		{
			p[i] = new JPanel();
			jplPanel.add(p[i]);
		}
		
		p[0].add(dateLable);
		p[1].add(timeLable);
		p[2].add(dayLable);
		p[3].add(btnSet);
		return jplPanel;
	}
	
	static class ClockLabel extends JLabel implements ActionListener
	{

		String type;
		SimpleDateFormat sdf;

		public ClockLabel(String type)
		{
			this.type = type;
			// setForeground(Color.green);

			switch (type)
			{
			case "date":
				sdf = new SimpleDateFormat("  MMMM dd yyyy");
				setFont(new Font("sans-serif", Font.PLAIN, 14));
				setHorizontalAlignment(SwingConstants.LEFT);
				break;
			case "time":
				sdf = new SimpleDateFormat("hh:mm:ss" + "\n a");
				setFont(new Font("sans-serif", Font.PLAIN, 40));
				setHorizontalAlignment(SwingConstants.CENTER);
				break;
			case "day":
				sdf = new SimpleDateFormat("EEEE  ");
				setFont(new Font("sans-serif", Font.PLAIN, 16));
				setHorizontalAlignment(SwingConstants.RIGHT);
				break;
			default:
				sdf = new SimpleDateFormat();
				break;
			}

			Timer t = new Timer(1000, this);
			t.start();
		}

		public void actionPerformed(ActionEvent ae)
		{
			Date d = new Date();
			setText(sdf.format(d));
		}
	}
}
