import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.math.*;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Screen<p>
 *  
 *  Contains all the interactions the user can do with the program.
 * @author Eduardo Nieves
 *
 */

public class  Screen extends JPanel implements ActionListener, MouseListener{

	/**
	 * Creates the JPanel in which the user can interact with the mouse.
	 */
	public Screen(){
		setSize(700,700);
		this.addMouseListener(this);
	}

	Timer tm= new Timer(50, this);
	
	int counter=0,triangleXpos=0,revCount=0,num1=0,num2=0,num3=0,num4=0,num5=0,num6,
		cursorPos=315,angleCount=1;
	boolean timerIndic= false;
	double fMeterLvl=0,fTankLvl=0,velX=0,velY=0,r1=0,x1=410,y1=150,x2=410,y2=75,
			x2_45=465,y2_45=100,x2_360=485,y2_360=150,x2_315=465,y2_315=200,x2_270=410,y2_270=225,
			x2_225=355,y2_225=200,x2_180=335,y2_180=150,x2_135=355,y2_135=100,angle=90,angleVel=0,
			angleSpeedometer=315,angleSpeedMov=0,x1_Speed=95,y1_Speed=150,x2_Speed=65, y2_Speed=180,rSpeed=0;

	/**
	 * Draws all the figures, numbers, objects, etc in the JFrame.
	 */
	public void paint (Graphics g){

		super.paint(g);

		g.setFont(new Font("TimesRoman",Font.PLAIN,24));

		//Revolution Counter
		g.drawString(""+num1,340,41);
		g.drawString(""+num2,310,41);
		g.drawString(""+num3,280,41);
		g.drawString(""+num4,250,41);
		g.drawString(""+num5,220,41);
		g.drawString(""+num6,190,41);

		g.setFont(new Font("Banner",Font.BOLD,10));
		g.drawRect(180, 18, 30, 30);
		g.drawRect(210, 18, 30, 30);
		g.drawRect(240, 18, 30, 30);
		g.drawRect(270, 18, 30, 30);
		g.drawRect(300, 18, 30, 30);
		g.drawRect(330, 18, 30, 30);
		g.drawString("Revolutions Counter", 218, 70);

		//Speedometer
		g.setColor(Color.BLACK);
		g.drawString("S", 5, 100);
		g.drawString("P", 5, 110);
		g.drawString("E", 5, 120);
		g.drawString("E", 5, 130);
		g.drawString("D", 5, 140);
		g.drawString("O", 5, 150);
		g.drawString("M", 5, 160);
		g.drawString("E", 5, 170);
		g.drawString("T", 5, 180);
		g.drawString("E", 5, 190);
		g.drawString("R", 5, 200);

		g.drawOval(20, 75, 150, 150);
		g.setColor(Color.WHITE);
		g.fillOval(35,90,120,120);
		g.setColor(Color.BLACK);

		g.drawLine(95, 225, 95, 210);
		g.drawLine(96, 225, 96, 210);
		g.drawString("rpm", 85, 205);

		g.drawString("0", 52, 192);
		g.drawLine(35, 195, 50, 190);
		g.drawLine(35, 196, 50, 191);

		g.drawString("10", 35, 155);
		g.drawLine(20, 150, 35, 150);
		g.drawLine(20, 151, 35, 151);

		g.drawString("20", 52, 118);
		g.drawLine(45, 95, 55, 105);
		g.drawLine(45, 96, 55, 106);

		g.drawString("30", 89, 102);
		g.drawLine(95,75,95,90);
		g.drawLine(96,75,96,90);

		g.drawString("40",126 ,118 );
		g.drawLine(145,95,135,105);
		g.drawLine(145,96,135,106);

		g.drawString("50",140,155);
		g.drawLine(170,150,155,150);
		g.drawLine(170,151,155,151);

		g.drawString("60",125,192);
		g.drawLine(155,195,140,190);
		g.drawLine(155,196,140,191);

		g.setColor(Color.GRAY);
		g.drawOval(35,90,120,120);

		//Speedometer arm
		g.setColor(Color.BLACK);
		g.drawLine(95, 150,(int) x2_Speed,(int) y2_Speed);

		//Fuel Meter
		g.setColor(Color.BLACK);
		g.drawString("Fuel Meter",65,305);
		g.drawString("E",4,301);
		g.drawString("F",180,301);
		g.setColor(Color.WHITE);
		g.fillRect(5, 250, 180, 40);
		g.setColor(Color.BLACK);
		g.drawRect(5, 250, 180, 40);


		g.fillRect(45,260,2,25);
		g.fillRect(95,260,2,25);
		g.fillRect(145,260,2,25);

		g.setColor(Color.GRAY);

		g.fillRect(15,260,1,25);
		g.fillRect(25,260,1,25);
		g.fillRect(35,260,1,25);
		g.fillRect(55,260,1,25);
		g.fillRect(65,260,1,25);
		g.fillRect(75,260,1,25);
		g.fillRect(85,260,1,25);
		g.fillRect(105,260,1,25);
		g.fillRect(115,260,1,25);
		g.fillRect(125,260,1,25);
		g.fillRect(135,260,1,25);
		g.fillRect(155,260,1,25);
		g.fillRect(165,260,1,25);
		g.fillRect(175,260,1,25);

		//Fuel Meter Bar
		g.setColor(Color.GREEN);		
		g.fillRect(5,270,(int) fMeterLvl,5);

		//Fuel Tank
		g.setColor(Color.BLACK);
		g.drawString("F",660 ,150);
		g.drawString("U",660 ,170);
		g.drawString("E",660 ,190);
		g.drawString("L",660 ,210);
		g.drawString("T",660 ,250);
		g.drawString("A",660 ,270);
		g.drawString("N",660 ,290);
		g.drawString("K",660 ,310);
		
		//Fuel Tank Indicator
		g.setColor(Color.RED);
		g.fillRect(540,550,100,(int) fTankLvl);		//16 Liters 
		g.setColor(Color.BLACK);
		g.drawRect(540, 20, 100,530);

		//System Controller
		g.setColor(Color.WHITE);
		g.fillRect(320, 250, 180, 40);
		g.setColor(Color.BLACK);
		g.drawRect(320,250,180,40);
		g.fillRect(410,260,2,25);

		g.drawString("O",318, 302);
		g.drawString("F",318, 312);
		g.drawString("F",318, 322);

		g.drawString("M",407, 302);
		g.drawString("E",407, 312);
		g.drawString("D",407, 322);

		g.drawString("M",495, 302);
		g.drawString("A",495, 312);
		g.drawString("X",495, 322);

		g.setColor(Color.GRAY);
		g.fillRect(330,260,1,25);
		g.fillRect(340,260,1,25);
		g.fillRect(350,260,1,25);
		g.fillRect(360,260,1,25);
		g.fillRect(370,260,1,25);
		g.fillRect(380,260,1,25);
		g.fillRect(390,260,1,25);
		g.fillRect(400,260,1,25);
		g.fillRect(420,260,1,25);
		g.fillRect(430,260,1,25);
		g.fillRect(440,260,1,25);
		g.fillRect(450,260,1,25);
		g.fillRect(460,260,1,25);
		g.fillRect(470,260,1,25);
		g.fillRect(480,260,1,25);
		g.fillRect(490,260,1,25);

		g.fillRect(cursorPos,265, 12, 12);
		g.setColor(Color.BLACK);
		g.drawRect(cursorPos,265, 12, 12);

		//Speed +,- buttons
		g.setColor(Color.BLACK);
		g.fillRect(315,340,20,20);
		g.fillRect(315,370,20,20);
		g.drawString("Speed +",340,355);
		g.drawString("Speed -",340,385);

		//Fill Gas Button
		g.fillRect(5,320,20,20);
		g.drawString("Press to Add Gas",30,335);

		//Wheel
		g.setColor(Color.WHITE);
		g.fillOval(335, 75, 150, 150);
		g.setColor(Color.BLACK);
		g.drawOval(335, 75, 150, 150);
		
		g.drawString("W", 500, 135);
		g.drawString("H", 500, 145);
		g.drawString("E", 500, 155);
		g.drawString("E", 500, 165);
		g.drawString("L", 500, 175);
		
		//Wheel arms
		g.drawLine(410,150,(int)x2,(int)y2);//90
		g.drawLine(410, 150, (int)x2_45,(int)y2_45); //45
		g.drawLine(410, 150, (int)x2_360,(int)y2_360); //360
		g.drawLine(410, 150, (int)x2_315,(int)y2_315);//315
		g.drawLine(410, 150, (int)x2_270,(int)y2_270);//270
		g.drawLine(410, 150, (int)x2_225,(int)y2_225);//225
		g.drawLine(410, 150, (int)x2_180,(int)y2_180);//180
		g.drawLine(410, 150, (int)x2_135,(int)y2_135);//135
		g.fillOval((int)x2-7,(int)y2-10, 15,15);

	}	 

	/**
	 * Detects all the actions that occurs when the user starts the program.
	 * When the action is executed, it repaints to allow the animation of the program.
	 */
	
	public void actionPerformed(ActionEvent e){

		if(fMeterLvl>=1&&fTankLvl<=-1){
			fMeterLvl= fMeterLvl-velX;
			fTankLvl= fTankLvl+velY;
			r1=-75;
			rSpeed=-30;
			
			x2=x1+r1*Math.cos(Math.toRadians(angle));
			y2=y1+r1*Math.sin(Math.toRadians(angle));
			
			x2_45=x1+r1*Math.cos(Math.toRadians(angle+45));
			y2_45=y1+r1*Math.sin(Math.toRadians(angle+45));
			
			x2_360=x1+r1*Math.cos(Math.toRadians(angle+90));
			y2_360=y1+r1*Math.sin(Math.toRadians(angle+90));
			
			x2_315=x1+r1*Math.cos(Math.toRadians(angle+135));
			y2_315=y1+r1*Math.sin(Math.toRadians(angle+135));
			
			x2_270=x1+r1*Math.cos(Math.toRadians(angle+180));
			y2_270=y1+r1*Math.sin(Math.toRadians(angle+180));
			
			x2_225=x1+r1*Math.cos(Math.toRadians(angle+225));
			y2_225=y1+r1*Math.sin(Math.toRadians(angle+225));
			
			x2_180=x1+r1*Math.cos(Math.toRadians(angle+270));
			y2_180=y1+r1*Math.sin(Math.toRadians(angle+270));
			
			x2_135=x1+r1*Math.cos(Math.toRadians(angle+315));
			y2_135=y1+r1*Math.sin(Math.toRadians(angle+315));
			
			angle+=angleVel;
			
			//Speedometer Arm Position
			if(cursorPos==315){
				if(y2_Speed>163&&y2_Speed<170)
				speedometerReduction();
			}
			else if(cursorPos==325){
				speedometerRotation();
				if(y2_Speed>163&&y2_Speed<164){
					angleSpeedMov=0;
				}
				else if(y2_Speed>160&&y2_Speed<162){
					speedometerReduction();
				}
			}	
			else if(cursorPos==335){
				speedometerRotation();
				if(y2_Speed>160&&y2_Speed<162){
					angleSpeedMov=0;
					}
				else if(y2_Speed>151&&y2_Speed<153){
					speedometerReduction();
				}
			}
			else if(cursorPos==345){
				speedometerRotation();
				if(y2_Speed>150&&y2_Speed<152){
					angleSpeedMov=0;
					}
				else if(y2_Speed>143&&y2_Speed<145){
					speedometerReduction();
				}
			}
			else if(cursorPos==355){
				speedometerRotation();
				if(y2_Speed>143&&y2_Speed<145){
					angleSpeedMov=0;
					}
				else if(y2_Speed>129&y2_Speed<132){
					speedometerReduction();
				}
			}
			else if(cursorPos==365){
				speedometerRotation();
				if(y2_Speed>128&y2_Speed<130){
					angleSpeedMov=0;
					}
				else if(y2_Speed>125&y2_Speed<128){
					speedometerReduction();
				}
			}
			else if(cursorPos==375){
				speedometerRotation();
				if(y2_Speed>124&y2_Speed<126){
					angleSpeedMov=0;
					}
				else if(y2_Speed>124&y2_Speed<126){
					speedometerReduction();
				}
			}
			else if(cursorPos==385){
				speedometerRotation();
				if(y2_Speed>122&y2_Speed<124){
					angleSpeedMov=0;
					}
				else if(y2_Speed>122&&y2_Speed<124){
					speedometerReduction();
				}
			}
			else if(cursorPos==395){
				speedometerRotation();
				if(y2_Speed>120&&y2_Speed<122){
					angleSpeedMov=0;
					}
				else if(x2_Speed>96&&x2_Speed<98){
					speedometerReduction();
					}
			}
			else if(cursorPos==405){
				speedometerRotation();
				if(x2_Speed>94&&x2_Speed<96){
					angleSpeedMov=0;
					}
				else if(x2_Speed>102&&x2_Speed<104){
					speedometerReduction();
					}
			}
			else if(cursorPos==415){
				speedometerRotation();
				if(x2_Speed>100&&x2_Speed<102){
					angleSpeedMov=0;
					}
				else if(x2_Speed>108&&x2_Speed<110){
					speedometerReduction();
					}
			}
			else if(cursorPos==425){
				speedometerRotation();
				if(x2_Speed>106&&x2_Speed<108){
					angleSpeedMov=0;
					}
				else if(x2_Speed>114&&x2_Speed<116){
					speedometerReduction();
					}
			}
			else if(cursorPos==435){
				speedometerRotation();
				if(x2_Speed>112&&x2_Speed<114){
					angleSpeedMov=0;
					}
			}
			else if(cursorPos==445){
				speedometerRotation();
				if(x2_Speed>118&&x2_Speed<120){
					angleSpeedMov=0;
					}
				else if(x2_Speed>122&&x2_Speed<124){
					speedometerReduction();
					}
			}
			else if(cursorPos==455){
				speedometerRotation();
				if(x2_Speed>122&&x2_Speed<124){
					angleSpeedMov=0;
					}
				else if(x2_Speed>122&&x2_Speed<124){
					speedometerReduction();
					}
			}
			else if(cursorPos==465){
				speedometerRotation();
				if(x2_Speed>124&&x2_Speed<126){
					angleSpeedMov=0;
					}
				else if(y2_Speed>143&&y2_Speed>150&&x2_Speed>123&&x2_Speed<125){
					speedometerReduction();
					}
			}
			else if(cursorPos==475){
				speedometerRotation();
				if(y2_Speed>143&&y2_Speed>150&&x2_Speed>123&&x2_Speed<125){
					angleSpeedMov=0;
					}
				else if(y2_Speed>144&&y2_Speed>146&&x2_Speed>120&&x2_Speed<122){
					speedometerReduction();
					}
			}
			else if(cursorPos==485){
				speedometerRotation();
				if(y2_Speed>144&&y2_Speed>146&&x2_Speed>120&&x2_Speed<122){
					angleSpeedMov=0;
					}
				else if(y2_Speed>150&&y2_Speed>155&&x2_Speed>116&&x2_Speed<118){
					speedometerReduction();
					}
			}
			else if(cursorPos==495){
				speedometerRotation();
				if(y2_Speed>150&&y2_Speed>155&&x2_Speed>116&&x2_Speed<118){
					angleSpeedMov=0;
					}
			}
			
			//Detects when one rotation of the wheel is made.
			if(cursorPos==325&&y2>75&&y2<75.003)
			{
				revCont();
			}
			
			else if(cursorPos==335&y2>75&&y2<75.01)
			{
				revCont();
			}
			
			else if(cursorPos==345&y2>75&&y2<75.03)
			{
				revCont();
			}
			
			else if(cursorPos==355&y2>75&&y2<75.05)
			{
				revCont();
			}
			
			else if(cursorPos==365&y2>75&&y2<75.07)
			{
				revCont();
			}
			else if(cursorPos==375&y2>75&&y2<75.11)
			{
				revCont();
			}
			
			else if(cursorPos==385&y2>75&&y2<75.14)
			{
				revCont();
			}
			else if(cursorPos==395&y2>75&&y2<75.17)
			{
				revCont();
			}
			
			else if(cursorPos==405&y2>75&&y2<75.22)
			{
				revCont();
			}
			else if(cursorPos==415&y2>75&&y2<75.23)
			{
				revCont();
			}
			else if(cursorPos==425&y2>75&&y2<75.35)
			{
				revCont();
			}
			else if(cursorPos==435&y2>75&&y2<75.37)
			{
				revCont();
			}
			else if(cursorPos==445&y2>75&&y2<75.52)
			{
				revCont();
			}
			else if(cursorPos==455&y2>75&&y2<75.56)
			{
				revCont();
			}else if(cursorPos==465&y2>75&&y2<75.59)
			{
				revCont();
			}
			else if(cursorPos==475&y2>75&&y2<75.69)
			{
			revCont();
			}
			else if(cursorPos==485&y2>75&&y2<75.74)
			{
			revCont();
			}
			else if(cursorPos==495&y2>75&&y2<75.95)
			{
			revCont();
			}
			repaint();
			
		}
		
	}

	/**
	 * Rotates the indicator arm of the Speedometer
	 */
	public void speedometerRotation(){
		x2_Speed=x1_Speed+rSpeed*Math.cos(Math.toRadians(angleSpeedometer));
		y2_Speed=y1_Speed+rSpeed*Math.sin(Math.toRadians(angleSpeedometer));
		angleSpeedometer+=angleSpeedMov;
		angleSpeedMov=Math.sqrt(Math.PI/2);
	}
	
	/**
	 * It reduces the RPM of the Speedometer
	 */
	public void speedometerReduction(){
		
		x2_Speed=x1_Speed+rSpeed*Math.cos(Math.toRadians(angleSpeedometer));
		y2_Speed=y1_Speed+rSpeed*Math.sin(Math.toRadians(angleSpeedometer));
		angleSpeedMov=-Math.sqrt(Math.PI)*5;
		angleSpeedometer+=angleSpeedMov;
		
	}
	
	/**
	 * Prints each time the wheel makes one revolution.
	 */
	public void revCont(){
		num1++;
		if(num1==10)
		{
			num1=0;
			num2++;
			if(num2==10)
			{
				num1=0;
				num2=0;
				num3++;
				if(num3==10)
				{
					num1=0;
					num2=0;
					num3=0;
					num4++;
					if(num4==10)
					{
						num1=0;
						num2=0;
						num3=0;
						num4=0;
						num5++;
						if(num5==10)
						{
							num1=0;
							num2=0;
							num3=0;
							num4=0;
							num5=0;
							num6++;
						}
					}
				}	
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Detect when the mouse is pressed at a certain position to execute 
	 * the corresponding action.
	 */
	public void mousePressed(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();

		//Add Gas
		if(x>=5&&x<=25&&y>=320&&y<=340){
			fMeterLvl=180;
			fTankLvl=-530;
			this.repaint();
		}

		//Move Speed Controller to the right
		if(x>=315&&x<=335&&y>=340&&y<=360){
			//Speed Controller not off, start timer
			if(cursorPos==315){

				timerIndic=true;
			}
			
			if(timerIndic==true){
				tm.start();
			}
			
			if(cursorPos<495){
				
				velX+=.0303;
				velY+=.09;
				cursorPos+=10;
				angleVel+=Math.sqrt(Math.PI/3);			

				this.repaint();
			}
		}
		if(x>=315&&x<=335&&y>=370&&y<=390){
			if(cursorPos>315){
				velX-=.0303;
				velY-=.09;
				cursorPos-=10;
				angleVel-=Math.sqrt(Math.PI/3);
				speedometerReduction();

				this.repaint();
			}
		}
	}
}
