import javax.swing.JFrame;
/**
 * Window <p>
 * 
 * Creates the JFrame
 * @author Eduardo Nieves
 *
 */
public class Window extends JFrame {
	
	/**
	 * It creates and sets the size and position of the JFrame.
	 */
	public Window(){
		JFrame f= new JFrame();
		f.setTitle("Car Controls");
		f.add(new Screen());
		f.setSize(700, 700);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen p= new Screen();
		add(p);
	}
}
