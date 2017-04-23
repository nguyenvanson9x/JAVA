package gameCard;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class CardComponent extends JComponent {
	private Card card ;
	private Image img ;
	private int open = 0 ;
	
	public CardComponent( int rank , int suit) {
		card = new Card(rank, suit);
		String name = "icon/" + card.toString() + ".png";
		ClassLoader cl = this.getClass().getClassLoader();
		ImageIcon icon = new ImageIcon(cl.getResource(name));	
		img = icon.getImage();
		
		int width = icon.getIconWidth();
		int hight = icon.getIconHeight();
		setBounds(0,0,width,hight);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				open = 1 - open ;
				if (open == 1) {
					String name = "icon/" + card.toString() + ".png";
					ClassLoader cl = this.getClass().getClassLoader();
					ImageIcon icon = new ImageIcon(cl.getResource(name));	
					img = icon.getImage();
				}
				else {
					String name = "icon/back.png";
					ClassLoader cl = this.getClass().getClassLoader();
					ImageIcon icon = new ImageIcon(cl.getResource(name));	
					img = icon.getImage();
				}
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0,0,null);
	}
}
