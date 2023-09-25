package transitvehiclespeedcalculator;

import java.util.HashMap;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class App {

	private JFrame frame;
	private TransitVehicleSpeedCalculatorPanel transitVehicleSpeedCalculatorPanel;

	private HashMap<String,TransitVehicle> userTransitVehicleAttributes;
	public HashMap<String,TransitVehicle> getUserTransitVehicleAttributes() { return userTransitVehicleAttributes; }
	public void setUserTransitVehicleAttributes(HashMap<String,TransitVehicle> value) { userTransitVehicleAttributes = value; }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userTransitVehicleAttributes = new HashMap<String,TransitVehicle>(100, 0.75f);

		frame = new JFrame();
		frame.setBounds(100, 100, 1152, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		transitVehicleSpeedCalculatorPanel = new TransitVehicleSpeedCalculatorPanel(this);
		frame.setContentPane(transitVehicleSpeedCalculatorPanel);
	}
}