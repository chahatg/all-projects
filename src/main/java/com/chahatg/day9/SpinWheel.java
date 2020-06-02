package com.chahatg.day9;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;  
import javax.swing.*;    
/*4.) Create spin a wheel game in java, with 8 options as draw. 
 * No need of display.. need only logic implementation 
*/

public class SpinWheel {
	private Random random = new Random();
	static int total = 0;
	public static void main(String[] args) {
		List<String> spinwheel = Arrays.asList("400 pts", "0 pts", "1000 pts", "20 pts", "Jackpot", "100 pts", "200 pts", "600 pts");
		
		String regex = "^(\\d+)";
		Pattern p = Pattern.compile(regex);
		
		SpinWheel wheel = new SpinWheel();
		
		JFrame f=new JFrame("Button Example");  
		final JTextField tf=new JTextField();  
		tf.setBounds(50,50, 300,20);  
		JButton b=new JButton("Spin the Wheel"); 
		b.setBounds(50,100,125,30); 
		final JTextField totalField=new JTextField();
		totalField.setBounds(50,150, 300,20);
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				String result = wheel.getRandomList(spinwheel);
				System.out.println("result" + result);
				Matcher m = p.matcher(result);
				//System.out.println("m to string:" + m.group());
				if(m.find()) {
					total += Integer.parseInt(m.group());
				}
				tf.setText("You spun the wheel and got: " + result);
				totalField.setText("Your total is now: " + total);
			}  
		});  
		f.add(b);f.add(tf);f.add(totalField); 
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true);   
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getRandomList(List<String> wheel) {

	    //0-4
	    int index = random.nextInt(wheel.size());
	    System.out.println("\nIndex :" + index );
	    return wheel.get(index);

	}
}
