package exp1;

import java.awt.*;
import java.awt.event.*;

public class exp1 extends WindowAdapter implements KeyListener{

	Frame f;
	Label l;

	exp1(){
		f = new Frame("Exp1");
		f.setLayout(null);
		f.setSize(400,300);
		f.setLocation(400,400);
		f.addWindowListener(this);
		
		
		l = new Label("Hello");
		l.setBounds(50,50,300,60);
		l.setBackground(Color.YELLOW);
		l.setAlignment(Label.CENTER);
		f.addKeyListener(this);
		f.add(l);
		
		f.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
		l.setText("key typed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		l.setText("key pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
		l.setText("key released");
	}
	
	public static void main(String[] args) {
		new exp1();
	}

}
