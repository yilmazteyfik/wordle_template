import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class WinPanel extends JPanel implements ActionListener{

	int PANEL_WIDTH = 1000;
	int PANEL_HEIGHT = 800;
	Image star[][];
	Image star2;
	
	
	Timer t;
	
	int xV = 9;
	int yV = 9;
	int x[][] ;
	int y[][] ;
	
	public WinPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.LIGHT_GRAY);
		x = new int[4][8];
		y = new int[4][8];
		star = new Image[4][8];
		star2 = new ImageIcon("star.png").getImage();
		
		for(int fi = 0 ; fi < 4; fi++) {
			if(fi == 0) {
				for(int i = 0 ; i < 8 ; i++) {
					x[fi][i] = 250;
					y[fi][i] = 200;
				}
			}
			
			if(fi == 1) {
				for(int i = 0 ; i < 8 ; i++) {
					x[fi][i] = 250;
					y[fi][i] = 600;
				}
			}
			
			if(fi == 2) {
				for(int i = 0 ; i < 8 ; i++) {
					x[fi][i] = 750;
					y[fi][i] = 200;
				}
			}
			
			if(fi == 3) {
				for(int i = 0 ; i < 8 ; i++) {
					x[fi][i] = 750;
					y[fi][i] = 600;
				}
			}
		}
		
		for(int fi = 0 ; fi < 4; fi++)
			for(int i = 0 ; i < 8 ; i++)
				star[fi][i] = new ImageIcon("star.png").getImage();
		
		
		
		t = new Timer(10, this);
		t.start();
	}

	public void paint(Graphics g) {
		
		super.paint(g); 
		
		Graphics2D g2D = (Graphics2D) g;
		
		for(int fi = 0 ; fi < 4; fi++) {
			if(fi == 0) {
				for(int i = 0 ; i < 8 ; i++) {
					g2D.drawImage(star[fi][i], x[fi][i], y[fi][i], null);
				}
			}
			if(fi == 1) {
				for(int i = 0 ; i < 8 ; i++) {
					g2D.drawImage(star[fi][i], x[fi][i], y[fi][i], null);
				}
			}
			if(fi == 2) {
				for(int i = 0 ; i < 8 ; i++) {
					g2D.drawImage(star[fi][i], x[fi][i], y[fi][i], null);
				}
			}
			if(fi == 3) {
				for(int i = 0 ; i < 8 ; i++) {
					g2D.drawImage(star[fi][i], x[fi][i], y[fi][i], null);
				}
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for(int fi = 0 ; fi < 4 ; fi ++) {
			if(fi == 0) {
				for(int i = 0 ; i < 8 ; i++) {
					
					if(i == 0) {
						x[fi][0] -= xV/2;
						if(x[fi][0] < 0)
							x[fi][0] = 250;
					}
						
					else if(i == 1) {
						x[fi][1] += xV/2;
						if(x[fi][1] > 500)
							x[fi][1] = 250;
					}
					
					else if(i == 2) {
						y[fi][2] -= yV/2;
						if(y[fi][2] < -50)
							y[fi][2] = 200;
					}
					
					else if(i == 3) {
						y[fi][3] += yV/2;
						if(y[fi][3] > 450)
							y[fi][3] = 200;
					}
					
					else if(i == 4) {
						x[fi][4] -= xV/2;
						y[fi][4] -= yV/2;
						if(x[fi][4] < 0) {
							x[fi][4] = 250;
							y[fi][4] = 200;
						}
					}
					
					else if(i == 5) {
						x[fi][5] += xV/2;
						y[fi][5] -= yV/2;
						if(x[fi][5] > 500) {
							x[fi][5] = 250;
							y[fi][5] = 200;
						}
					}
					
					else if(i == 6) {
						x[fi][6] += xV/2;
						y[fi][6] += yV/2;
						if(x[fi][6] > 500) {
							x[fi][6] = 250;
							y[fi][6] = 200;
						}
					}
					
					else if(i == 7) {
						x[fi][7] -= xV/2;
						y[fi][7] += yV/2;
						if(x[fi][7] < 0) {
							x[fi][7] = 250;
							y[fi][7] = 200;
						}
					}
				}
			}
			
			if(fi == 1) {
				for(int i = 0 ; i < 8 ; i++) {
					if(i == 0) {
						x[fi][0] -= xV/2;
						if(x[fi][0] < 0)
							x[fi][0] = 250;
					}
					
					else if(i == 1) {
						x[fi][1] += xV/2;
						if(x[fi][1] > 500)
							x[fi][1] = 250;
					}
					
					else if(i == 2) {
						y[fi][2] -= yV/2;
						if(y[fi][2] < 350)
							y[fi][2] = 600;
					}
					
					else if(i == 3) {
						y[fi][3] += yV/2;
						if(y[fi][3] > 850)
							y[fi][3] = 600;
					}
					
					else if(i == 4) {
						x[fi][4] -= xV/2;
						y[fi][4] -= yV/2;
						if(x[fi][4] < 0) {
							x[fi][4] = 250;
							y[fi][4] = 600;
						}
					}
					
					else if(i == 5) {
						x[fi][5] += xV/2;
						y[fi][5] -= yV/2;
						if(x[fi][5] > 500) {
							x[fi][5] = 250;
							y[fi][5] = 600;
						}
					}
					
					else if(i == 6) {
						x[fi][6] += xV/2;
						y[fi][6] += yV/2;
						if(x[fi][6] > 500) {
							x[fi][6] = 250;
							y[fi][6] = 600;
						}
					}
					
					else if(i == 7) {
						x[fi][7] -= xV/2;
						y[fi][7] += yV/2;
						if(x[fi][7] < 0) {
							x[fi][7] = 250;
							y[fi][7] = 600;
						}
					}
				}
			}
			
			if(fi == 2) {
				for(int i = 0 ; i < 8 ; i++) {
					if(i == 0) {
						x[fi][0] -= xV/2;
						if(x[fi][0] < 500)
							x[fi][0] = 750;
					}
					
					else if(i == 1) {
						x[fi][1] += xV/2;
						if(x[fi][1] > 1000)
							x[fi][1] = 750;
					}
					
					else if(i == 2) {
						y[fi][2] -= yV/2;
						if(y[fi][2] < -50)
							y[fi][2] = 200;
					}
					
					else if(i == 3) {
						y[fi][3] += yV/2;
						if(y[fi][3] > 450)
							y[fi][3] = 200;
					}
					
					else if(i == 4) {
						x[fi][4] -= xV/2;
						y[fi][4] -= yV/2;
						if(x[fi][4] < 500) {
							x[fi][4] = 750;
							y[fi][4] = 200;
						}
					}
					
					else if(i == 5) {
						x[fi][5] += xV/2;
						y[fi][5] -= yV/2;
						if(x[fi][5] > 1000) {
							x[fi][5] = 750;
							y[fi][5] = 200;
						}
					}
					
					else if(i == 6) {
						x[fi][6] += xV/2;
						y[fi][6] += yV/2;
						if(x[fi][6] > 1000) {
							x[fi][6] = 750;
							y[fi][6] = 200;
						}
					}
					
					else if(i == 7) {
						x[fi][7] -= xV/2;
						y[fi][7] += yV/2;
						if(x[fi][7] < 500) {
							x[fi][7] = 750;
							y[fi][7] = 200;
						}
					}
				}
			}
			
			if(fi == 3) {
				for(int i = 0 ; i < 8 ; i++) {
					
					if(i == 0) {
						x[fi][0] -= xV/2;
						if(x[fi][0] < 500)
							x[fi][0] = 750;
					}
					
					else if(i == 1) {
						x[fi][1] += xV/2;
						if(x[fi][1] > 1000)
							x[fi][1] = 750;
					}
					
					else if(i == 2) {
						y[fi][2] -= yV/2;
						if(y[fi][2] < 350)
							y[fi][2] = 600;
					}
					
					else if(i == 3) {
						y[fi][3] += yV/2;
						if(y[fi][3] > 850)
							y[fi][3] = 600;
					}
					
					else if(i == 4) {
						x[fi][4] -= xV/2;
						y[fi][4] -= yV/2;
						if(x[fi][4] < 500) {
							x[fi][4] = 750;
							y[fi][4] = 600;
						}
					}
					
					else if(i == 5) {
						x[fi][5] += xV/2;
						y[fi][5] -= yV/2;
						if(x[fi][5] > 1000) {
							x[fi][5] = 750;
							y[fi][5] = 600;
						}
					}
					
					else if(i == 6) {
						x[fi][6] += xV/2;
						y[fi][6] += yV/2;
						if(x[fi][6] > 1000) {
							x[fi][6] = 750;
							y[fi][6] = 600;
						}
					}
					
					else if(i == 7) {
						x[fi][7] -= xV/2;
						y[fi][7] += yV/2;
						if(x[fi][7] < 500) {
							x[fi][7] = 750;
							y[fi][7] = 600;
						}
					}
					
				}
			}
		}
		
		repaint();
	}
}
