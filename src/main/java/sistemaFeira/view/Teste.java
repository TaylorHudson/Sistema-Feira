package sistemaFeira.view;

import java.util.Date;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Teste  extends JFrame{

	public Teste() {
		t();
	}
	
	public void t() {
		
		setSize(500,500);
		setVisible(true);
		setLayout(null);
		
		JDateChooser c = new JDateChooser(new Date());
		c.setBounds(50, 10, 150, 50);
		add(c);

	}
	
	public static void main(String[] args) {
		new Teste();
	}
}

