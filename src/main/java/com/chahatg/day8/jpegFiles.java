package com.chahatg.day8;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.*;





/*	Create a program to read files from a directory and allow
 *  to queue only jpeg files and display that jpeg content 
 *  whose size is more than 1MB.*/

public class jpegFiles {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Image display");
		JPanel jp = new JPanel();
		//Jlabel label = new JLabel();
		//jp.add(label);
		//frame.setSize(400, 400);
		//frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File folder = new File("C:\\Users\\Chahat\\Desktop\\pics");
		File fileList[] = null;
		
		Queue<File> fileQueue = new LinkedList<File>();
		fileList = folder.listFiles();
		System.out.println(fileList.length);

		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].getName().matches("([^\\s]+(\\.(?i)(jpg|jpeg|JPG|JPEG))$)") && fileList[i].length() > 1000000L) {
				fileQueue.add(fileList[i]);
			}
		}
		System.out.println(fileQueue.size());
		BufferedImage image = null;
		frame.setSize(600, 600);
		while(!fileQueue.isEmpty()) {
			try{
				image = ImageIO.read(fileQueue.remove());
			}
			catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			JLabel label = new JLabel(new ImageIcon(image));
			jp.add(label);
			System.out.println( "Painting image" );
			//frame.revalidate();
			
			
			frame.getContentPane().add(label, BorderLayout.CENTER);
		    //frame.pack();
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    frame.repaint();
			try{
			    Thread.sleep( 3000 );
			} 
			catch ( InterruptedException ie ){}
			System.out.println("After sleep" );
			
		    frame.getContentPane().remove(jp);
		}
		
		
		
		
	}
	
}

/*
 *
			
			
			
			
			
			
 *ImageIcon imgicon =  new ImageIcon(image);
		JLabel jLabel = new JLabel();
	    jLabel.setIcon(imgicon);
	    frame.getContentPane().add(jLabel, BorderLayout.CENTER);

	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
 * 
 * */



