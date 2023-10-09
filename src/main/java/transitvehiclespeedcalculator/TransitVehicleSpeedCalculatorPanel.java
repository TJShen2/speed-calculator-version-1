package transitvehiclespeedcalculator;

import java.util.HashMap;
import java.util.Map;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class TransitVehicleSpeedCalculatorPanel extends JPanel {

	private HashMap<String,TransitVehicle> userTransitVehicleAttributes;

	private GridBagLayout contentPaneLayout;
	
	//Swing/AWT components
	//Panels
	private JPanel transitVehicleAttributeLabelPanel;
	private JPanel calculateAverageSpeedPanel;
	private JPanel calculationResultsPanel;
	private JPanel transitVehicleListPanel;
	private JPanel transitVehicleAttributeEntryPanel;
	private JPanel transitVehicleAttributePanel;
	private JPanel editVehicleListPanel;

	//Labels
	private JLabel nameLabel;
	private JLabel stationCountLabel;
	private JLabel accelerationRateLabel;
	private JLabel decelerationRateLabel;
	private JLabel dwellTimeLabel;
	private JLabel lineLengthLabel;
	private JLabel topSpeedLabel;
	private JLabel selectedVehicleLabel;
	
	//Text panes
	private JTextPane nameTextPane;
	private JTextPane stationCountTextPane;
	private JTextPane accelerationRateTextPane;
	private JTextPane decelerationRateTextPane;
	private JTextPane dwellTimeTextPane;
	private JTextPane lineLengthTextPane;
	private JTextPane topSpeedTextPane;
	private JTextPane calculationResultsTextPane;
	
	//Buttons
	private JButton calculateAverageSpeedButton;
	private JButton newVehicleButton;
	private JButton deleteVehicleButton;
	private JButton saveAttributesButton;
	
	//Scroll panes
	private JScrollPane transitVehicleListScrollPane;
	
	//Combo boxes
	private JComboBox<String> vehicleListComboBox;

	/**
	 * Create the frame.
	 */
	public TransitVehicleSpeedCalculatorPanel(App parent) {
		userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();

		setBounds(100, 100, 1152, 745);
		new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneLayout = new GridBagLayout();
		contentPaneLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		contentPaneLayout.columnWeights = new double[]{1.0, 0.0};
		setLayout(contentPaneLayout);
		
		//Initialize top-level containers (scroll panes and panels)
		transitVehicleListScrollPane = new JScrollPane();
		transitVehicleListScrollPane.setPreferredSize(new Dimension(100, 540));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;

		editVehicleListPanel = new JPanel();
		GridBagConstraints gbc_editVehicleListPanel = new GridBagConstraints();
		gbc_editVehicleListPanel.insets = new Insets(0, 0, 5, 5);
		gbc_editVehicleListPanel.fill = GridBagConstraints.BOTH;
		gbc_editVehicleListPanel.gridx = 0;
		gbc_editVehicleListPanel.gridy = 2;
		
		transitVehicleAttributePanel = new JPanel();
		transitVehicleAttributePanel.setLayout(new BoxLayout(transitVehicleAttributePanel, BoxLayout.Y_AXIS));
		GridBagConstraints gbc_transitVehicleAttributePanel = new GridBagConstraints();
		gbc_transitVehicleAttributePanel.insets = new Insets(0, 0, 5, 5);
		gbc_transitVehicleAttributePanel.fill = GridBagConstraints.BOTH;
		gbc_transitVehicleAttributePanel.gridx = 0;
		gbc_transitVehicleAttributePanel.gridy = 3;

		calculateAverageSpeedPanel = new JPanel();
		GridBagConstraints gbc_calculateAverageSpeedPanel = new GridBagConstraints();
		gbc_calculateAverageSpeedPanel.weightx = 1.0;
		gbc_calculateAverageSpeedPanel.insets = new Insets(0, 0, 5, 5);
		gbc_calculateAverageSpeedPanel.fill = GridBagConstraints.BOTH;
		gbc_calculateAverageSpeedPanel.gridx = 0;
		gbc_calculateAverageSpeedPanel.gridy = 6;

		calculationResultsPanel = new JPanel();
		calculationResultsPanel.setLayout(new CardLayout(0, 0));
		GridBagConstraints gbc_calculationResultsPanel = new GridBagConstraints();
		gbc_calculationResultsPanel.weightx = 1.0;
		gbc_calculationResultsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_calculationResultsPanel.weighty = 1.0;
		gbc_calculationResultsPanel.fill = GridBagConstraints.BOTH;
		gbc_calculationResultsPanel.gridx = 0;
		gbc_calculationResultsPanel.gridy = 8;
		
		transitVehicleListPanel = new JPanel();
		transitVehicleListPanel.setLayout(new BoxLayout(transitVehicleListPanel, BoxLayout.Y_AXIS));

		transitVehicleAttributeLabelPanel = new JPanel();
		transitVehicleAttributeLabelPanel.setLayout(new GridLayout(0, 7, 20, 0));
		
		transitVehicleAttributeEntryPanel = new JPanel();
		transitVehicleAttributeEntryPanel.setLayout(new GridLayout(0, 7, 20, 0));

		//Initialize labels
		JLabel titleLabel = new JLabel("Input Data");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		
		selectedVehicleLabel = new JLabel("Selected Vehicle:");
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		stationCountLabel = new JLabel("Station Count");
		stationCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stationCountLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		accelerationRateLabel = new JLabel("Acceleration Rate");
		accelerationRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accelerationRateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		decelerationRateLabel = new JLabel("Deceleration Rate");
		decelerationRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		decelerationRateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		dwellTimeLabel = new JLabel("Dwell Time per Station");
		dwellTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dwellTimeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lineLengthLabel = new JLabel("Length of Line");
		lineLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lineLengthLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		topSpeedLabel = new JLabel("Top Speed");
		topSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topSpeedLabel.setFont(new Font("Arial", Font.PLAIN, 13));

		//Initialize buttons
		newVehicleButton = new JButton("New Vehicle");
		newVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component component : transitVehicleAttributeEntryPanel.getComponents()) {
					JTextPane field = (JTextPane) component;
					field.setText("");
				}
				calculationResultsTextPane.setText("");
			}
		});
		deleteVehicleButton = new JButton("Delete Selected Vehicle");
		deleteVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedVehicleName = (String) vehicleListComboBox.getSelectedItem();
				userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
				userTransitVehicleAttributes.remove(selectedVehicleName);
				parent.setUserTransitVehicleAttributes(userTransitVehicleAttributes);
				vehicleListComboBox.removeItem(selectedVehicleName);
			}
		});
		calculateAverageSpeedButton = new JButton("Calculate Average Speed");
		calculateAverageSpeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TransitVehicle newTrain = new TransitVehicle(new Double(stationCountTextPane.getText()), 
						new Double(accelerationRateTextPane.getText()), 
						new Double(decelerationRateTextPane.getText()), 
						new Double(dwellTimeTextPane.getText()), 
						new Double(lineLengthTextPane.getText()), 
						new Double(topSpeedTextPane.getText()));
					newTrain.determineTrainSpeed();
					userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
					userTransitVehicleAttributes.put(nameTextPane.getText(), newTrain);
					parent.setUserTransitVehicleAttributes(userTransitVehicleAttributes);
					updateScrollPaneButtons(userTransitVehicleAttributes);
				} catch (Exception e) {
					e.printStackTrace();
				}
				vehicleListComboBox.addItem(nameTextPane.getText());

				for (Component component : transitVehicleAttributeEntryPanel.getComponents()) {
					JTextPane field = (JTextPane) component;
					field.setText("");
				}
			}
		});
		saveAttributesButton = new JButton("Save Attributes");
		saveAttributesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.saveChanges();
			}
		});
		
		//Initialize combo boxes
		vehicleListComboBox = new JComboBox<String>();
		vehicleListComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedVehicleName = (String) vehicleListComboBox.getSelectedItem();
				userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
				displayCalculationResults(selectedVehicleName, userTransitVehicleAttributes.get(selectedVehicleName));
			}
		});
		
		//Initialize text panes
		nameTextPane = new JTextPane();
		nameTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		stationCountTextPane = new JTextPane();
		stationCountTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		accelerationRateTextPane = new JTextPane();
		accelerationRateTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		decelerationRateTextPane = new JTextPane();
		decelerationRateTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		dwellTimeTextPane = new JTextPane();
		dwellTimeTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lineLengthTextPane = new JTextPane();
		lineLengthTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		topSpeedTextPane = new JTextPane();
		topSpeedTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		calculationResultsTextPane = new JTextPane();

		//Add labels to panels
		transitVehicleAttributeLabelPanel.add(nameLabel);
		transitVehicleAttributeLabelPanel.add(stationCountLabel);
		transitVehicleAttributeLabelPanel.add(accelerationRateLabel);
		transitVehicleAttributeLabelPanel.add(decelerationRateLabel);
		transitVehicleAttributeLabelPanel.add(dwellTimeLabel);
		transitVehicleAttributeLabelPanel.add(lineLengthLabel);
		transitVehicleAttributeLabelPanel.add(topSpeedLabel);

		editVehicleListPanel.add(selectedVehicleLabel);

		//Add label to main panel
		add(titleLabel, gbc_titleLabel);

		//Add buttons to panels
		editVehicleListPanel.add(newVehicleButton);
		editVehicleListPanel.add(deleteVehicleButton);

		calculateAverageSpeedPanel.add(calculateAverageSpeedButton);
		calculateAverageSpeedPanel.add(saveAttributesButton);
		
		//Add combo boxes to panels
		editVehicleListPanel.add(vehicleListComboBox);

		//Add text panes to panels
		transitVehicleAttributeEntryPanel.add(nameTextPane);
		transitVehicleAttributeEntryPanel.add(stationCountTextPane);
		transitVehicleAttributeEntryPanel.add(accelerationRateTextPane);
		transitVehicleAttributeEntryPanel.add(decelerationRateTextPane);
		transitVehicleAttributeEntryPanel.add(dwellTimeTextPane);
		transitVehicleAttributeEntryPanel.add(lineLengthTextPane);
		transitVehicleAttributeEntryPanel.add(topSpeedTextPane);

		//Add panels to other top-level containers
		transitVehicleListScrollPane.setViewportView(transitVehicleListPanel);
		transitVehicleAttributePanel.add(transitVehicleAttributeLabelPanel);
		transitVehicleAttributePanel.add(transitVehicleAttributeEntryPanel);

		calculationResultsPanel.add(calculationResultsTextPane, "name_3141119477751");

		//Add panels and scroll panes to main panel
		add(transitVehicleListScrollPane, gbc_scrollPane);
		add(editVehicleListPanel, gbc_editVehicleListPanel);
		add(transitVehicleAttributePanel, gbc_transitVehicleAttributePanel);
		add(calculateAverageSpeedPanel, gbc_calculateAverageSpeedPanel);
		add(calculationResultsPanel, gbc_calculationResultsPanel);

		updateScrollPaneButtons(userTransitVehicleAttributes);
	}
	private void updateScrollPaneButtons(HashMap<String,TransitVehicle> attributes) {
		transitVehicleListPanel.removeAll();
		for (Map.Entry<String,TransitVehicle> name : attributes.entrySet()) {
			JButton scrollPaneButton = new JButton(name.getKey());
			scrollPaneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayCalculationResults(name.getKey(), name.getValue());
				}
			});
			transitVehicleListPanel.add(scrollPaneButton);
			transitVehicleListPanel.validate();
		}
	}
	private void displayCalculationResults(String name, TransitVehicle transitVehicle) {
		nameTextPane.setText(name);
		Component[] fields = transitVehicleAttributeEntryPanel.getComponents();

		for (int i = 1; i < fields.length; i++) {
			JTextPane field = (JTextPane) fields[i];
			field.setText(String.valueOf(transitVehicle.getAttributes()[i - 1]));
		}
		calculationResultsTextPane.setText("Average speed is: " + transitVehicle.getAverageSpeed() + " km/h\nLine stop spacing is: " + transitVehicle.getStationSpacing() + " m");
	}
}