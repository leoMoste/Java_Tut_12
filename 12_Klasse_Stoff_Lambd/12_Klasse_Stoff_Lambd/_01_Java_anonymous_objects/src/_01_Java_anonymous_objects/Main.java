package _01_Java_anonymous_objects;

import javax.swing.JLabel;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		
		// instantiate an Object like this
		// JLabel lable1 = new JLabel();
		
		// anonymous_objects => without the JLabel lable1 =
		// we need just new JLabel()
		
		JFrame frame = new JFrame();
		ArrayList<JLabel> deck = new ArrayList<JLabel>();
		
		/*
		ImageIcon AC = new ImageIcon("src\\cards\\1.png");
		JLabel AClabel = new JLabel(AC);
		deck.add(AClabel);
		
		ImageIcon TwoC = new ImageIcon("src\\cards\\2.png");
		JLabel TwoClabel = new JLabel(TwoC);
		deck.add(TwoClabel);
		
		... repeat for all 52 cards :(
		*/
		
		/*
		 * You can use the nameless object, if you're passing it
		 * into a constructor for something
		 * */
		
		for(int i =1;i<=52;i++) {
			         // anonymous_objects, first one is the ( new JLabel ), 
					//  the second anonymous_objects( new ImageIcon )
			deck.add(new JLabel(new ImageIcon("src\\cards\\"+i+".png")));
			frame.add(deck.get(i-1));
		}
			
		//frame.add(deck.get(0));
		//frame.add(deck.get(1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}

}
