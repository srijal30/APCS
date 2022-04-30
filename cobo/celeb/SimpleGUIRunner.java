/*
TNPG: Flying Sullen Actors (Alif Rahman, Salaj Rijal, Faiyaz Rafee)
APCS
L09: Some Folks Call It A Charades
2022-04-27
time spent: 4 hours
*/

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class SimpleGUIRunner
{
	public static JFrame tmp;

	public static void open( String path ) throws MalformedURLException, IOException{

		//alot of help for this from: https://www.programcreek.com/2012/12/download-image-from-url-in-java/
		URL url = new URL(path);
		String fileName = url.getFile();
		String destName = "temp." + fileName.substring( fileName.lastIndexOf(".") );

		InputStream is = url.openStream();
		FileOutputStream os = new FileOutputStream(destName);

		byte[] b = new byte[2048];
		int length;

		while( (length = is.read(b)) != -1 ){
 			os.write(b, 0, length);
		}
		
		is.close();
		os.close();

		JFrame tmp = new JFrame();
		tmp.add( new JLabel(new ImageIcon(destName)));

		tmp.setSize(800,800);
		tmp.setTitle("Celebrity Clue");
		//tmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tmp.setVisible(true);

	}

	public static void close(){
		//avoid errors
		if ( tmp == null ){
			return;
		}
		tmp.dispose();
		tmp = null;
	}

	public static void main(String[] args) throws MalformedURLException, IOException
	{

		open("https://www.pixsy.com/wp-content/uploads/2021/04/ben-sweet-2LowviVHZ-E-unsplash-1.jpeg");
	}

}
