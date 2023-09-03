package transitvehiclespeedcalculator;

import java.util.HashMap;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class App {

	private JFrame frame;
	private TransitVehicleSpeedCalculatorPanel transitVehicleSpeedCalculatorPanel;

	private HashMap<String,TransitVehicle> userTransitVehicleAttributes = new HashMap<String,TransitVehicle>(100, 0.75f);

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
		frame = new JFrame();
		frame.setBounds(100, 100, 1152, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		transitVehicleSpeedCalculatorPanel = new TransitVehicleSpeedCalculatorPanel();
		frame.setContentPane(transitVehicleSpeedCalculatorPanel);

		transitVehicleSpeedCalculatorPanel.calculateAverageSpeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TransitVehicle newTrain = new TransitVehicle(new Double(transitVehicleSpeedCalculatorPanel.stationCountTextPane.getText()), 
						new Double(transitVehicleSpeedCalculatorPanel.accelerationRateTextPane.getText()), 
						new Double(transitVehicleSpeedCalculatorPanel.decelerationRateTextPane.getText()), 
						new Double(transitVehicleSpeedCalculatorPanel.dwellTimeTextPane.getText()), 
						new Double(transitVehicleSpeedCalculatorPanel.lineLengthTextPane.getText()), 
						new Double(transitVehicleSpeedCalculatorPanel.topSpeedTextPane.getText()));
					newTrain.determineTrainSpeed();
					userTransitVehicleAttributes.put(transitVehicleSpeedCalculatorPanel.nameTextPane.getText(), newTrain);
					transitVehicleSpeedCalculatorPanel.UpdateScrollPaneButtons(userTransitVehicleAttributes);
				} catch (Exception e) {
					transitVehicleSpeedCalculatorPanel.calculationResultsTextPane.setText(e.toString());
				}
				transitVehicleSpeedCalculatorPanel.vehicleListComboBox.addItem(transitVehicleSpeedCalculatorPanel.nameTextPane.getText());

				for (Component component : transitVehicleSpeedCalculatorPanel.transitVehicleAttributeEntryPanel.getComponents()) {
					JTextPane field = (JTextPane) component;
					field.setText("");
				}
			}
		});
		transitVehicleSpeedCalculatorPanel.newVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component component : transitVehicleSpeedCalculatorPanel.transitVehicleAttributeEntryPanel.getComponents()) {
					JTextPane field = (JTextPane) component;
					field.setText("");
				}
				transitVehicleSpeedCalculatorPanel.calculationResultsTextPane.setText("");
			}
		});
		transitVehicleSpeedCalculatorPanel.saveAttributesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		transitVehicleSpeedCalculatorPanel.vehicleListComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedVehicleName = (String) transitVehicleSpeedCalculatorPanel.vehicleListComboBox.getSelectedItem();
				transitVehicleSpeedCalculatorPanel.DisplayCalculationResults(selectedVehicleName, userTransitVehicleAttributes.get(selectedVehicleName));
			}
		});
		transitVehicleSpeedCalculatorPanel.deleteVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedVehicleName = (String) transitVehicleSpeedCalculatorPanel.vehicleListComboBox.getSelectedItem();
				userTransitVehicleAttributes.remove(selectedVehicleName);
				transitVehicleSpeedCalculatorPanel.vehicleListComboBox.removeItem(selectedVehicleName);
			}
		});
	}
}