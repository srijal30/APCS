/*
TNPG: Flying Sullen Actors (Alif Rahman, Salaj Rijal, Faiyaz Rafee)
APCS
L09: Some Folks Call It A Charades
2022-04-27
time spent: 4 hours
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class SimpleGUIRunner
{
	public static JFrame tmp;

	public static void open( String path ){
		JFrame tmp = new JFrame();
		tmp.add( new JLabel(new ImageIcon(path)));

		tmp.setSize(800,800);
		tmp.setTitle("Celebrity Clue");
		//tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tmp.setVisible(true);

	}

	public static void close(){
		tmp.dispose();
		tmp = null;
	}

	public static void main(String[] args)
	{
		open("tmp/WpVqQv.gif");
	}

}
