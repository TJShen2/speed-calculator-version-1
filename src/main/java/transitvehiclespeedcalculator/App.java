package transitvehiclespeedcalculator;

import java.util.ArrayList;
import java.util.List;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.lang.reflect.Type;

import javax.swing.JFrame;

import com.google.gson.reflect.TypeToken;

public class App {

	private JFrame frame;
	private TransitVehicleSpeedCalculatorPanel transitVehicleSpeedCalculatorPanel;

	private List<TransitVehicle> userTransitVehicleAttributes;
	public List<TransitVehicle> getUserTransitVehicleAttributes() { return userTransitVehicleAttributes; }
	public void setUserTransitVehicleAttributes(List<TransitVehicle> value) { userTransitVehicleAttributes = value; }
	private Type userTransitVehicleAttributesType;

	private JsonHandler userTransitVehiclesJsonHandler;

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
		userTransitVehiclesJsonHandler = new JsonHandler("vehicles.json");

		try {
			userTransitVehicleAttributes = userTransitVehiclesJsonHandler.ReadObjectFromJson();
		} catch (Exception e) {
			userTransitVehicleAttributes = new ArrayList<TransitVehicle>();
			e.printStackTrace();
		}
		userTransitVehicleAttributesType = new TypeToken<List<TransitVehicle>>() {}.getType();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1152, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		transitVehicleSpeedCalculatorPanel = new TransitVehicleSpeedCalculatorPanel(this);
		frame.setContentPane(transitVehicleSpeedCalculatorPanel);
	}

	public void saveChanges() {
		userTransitVehiclesJsonHandler.WriteObjectAsJson(userTransitVehicleAttributes, userTransitVehicleAttributesType);
	}

	class WindowClosingEvent extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				saveChanges();
			}
		}
}