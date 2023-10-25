package transitvehiclespeedcalculator;

import java.util.List;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class TransitVehicleSpeedCalculatorPanel extends JPanel {

	private App parent;

	private List<TransitVehicle> userTransitVehicleAttributes;
	private ListSelectionModel vehicleListSelectionModel;

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
	private JList<String> vehicleList;

	/**
	 * Create the frame.
	 */
	public TransitVehicleSpeedCalculatorPanel(App parent) {
		this.parent = parent;
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
				int[] selectedIndices = vehicleList.getSelectedIndices();
				userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
				for (int selectedVehicle : selectedIndices) {
					userTransitVehicleAttributes.remove(selectedVehicle);
				}
				parent.setUserTransitVehicleAttributes(userTransitVehicleAttributes);
				updateVehicleList();
			}
		});
		calculateAverageSpeedButton = new JButton("Calculate Average Speed");
		calculateAverageSpeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TransitVehicle newTrain = new TransitVehicle(
						new String(nameTextPane.getText()),
						new Double(stationCountTextPane.getText()), 
						new Double(accelerationRateTextPane.getText()), 
						new Double(decelerationRateTextPane.getText()), 
						new Double(dwellTimeTextPane.getText()), 
						new Double(lineLengthTextPane.getText()), 
						new Double(topSpeedTextPane.getText())
					);
					newTrain.determineTrainSpeed();
					userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
					userTransitVehicleAttributes.add(newTrain);
					parent.setUserTransitVehicleAttributes(userTransitVehicleAttributes);
					updateVehicleList();
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (Component component : transitVehicleAttributeEntryPanel.getComponents()) {
					JTextPane field = (JTextPane) component;
					field.setText("");
				}
				updateVehicleList();
			}
		});
		saveAttributesButton = new JButton("Save Attributes");
		saveAttributesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.saveChanges();
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

		//Add label to main panel
		add(titleLabel, gbc_titleLabel);

		//Add buttons to panels
		editVehicleListPanel.add(newVehicleButton);
		editVehicleListPanel.add(deleteVehicleButton);

		calculateAverageSpeedPanel.add(calculateAverageSpeedButton);
		calculateAverageSpeedPanel.add(saveAttributesButton);

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
		
		vehicleList = new JList<String>();
		transitVehicleListPanel.add(vehicleList);
		transitVehicleAttributePanel.add(transitVehicleAttributeLabelPanel);
		transitVehicleAttributePanel.add(transitVehicleAttributeEntryPanel);

		calculationResultsPanel.add(calculationResultsTextPane, "name_3141119477751");

		//Add panels and scroll panes to main panel
		add(transitVehicleListScrollPane, gbc_scrollPane);
		add(editVehicleListPanel, gbc_editVehicleListPanel);
		add(transitVehicleAttributePanel, gbc_transitVehicleAttributePanel);
		add(calculateAverageSpeedPanel, gbc_calculateAverageSpeedPanel);
		add(calculationResultsPanel, gbc_calculationResultsPanel);

		updateVehicleList();
	}
	private void updateVehicleList() {
		transitVehicleListPanel.removeAll();
		userTransitVehicleAttributes = parent.getUserTransitVehicleAttributes();
		
		DefaultListModel<String> vehicleListModel = new DefaultListModel<String>();

		for (TransitVehicle vehicle : userTransitVehicleAttributes) {
			String vehicleText = vehicle.getName();
			vehicleListModel.addElement(vehicleText);
		}
		vehicleList = new JList<String>(vehicleListModel);
		vehicleListSelectionModel = vehicleList.getSelectionModel();
		vehicleListSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				displayCalculationResults(vehicleList.getSelectedIndex());
			}
		});
		
		transitVehicleListPanel.add(vehicleList);
		transitVehicleListPanel.validate();
	}
	private void displayCalculationResults(int selectedIndex) {
		TransitVehicle transitVehicle = userTransitVehicleAttributes.get(selectedIndex);
		nameTextPane.setText(transitVehicle.getName());
		Component[] fields = transitVehicleAttributeEntryPanel.getComponents();

		for (int i = 1; i < fields.length; i++) {
			JTextPane field = (JTextPane) fields[i];
			field.setText(String.valueOf(transitVehicle.getAttributes()[i - 1]));
		}
		calculationResultsTextPane.setText("Average speed is: " + transitVehicle.getAverageSpeed() + " km/h\nLine stop spacing is: " + transitVehicle.getStationSpacing() + " m\n" + "% top speed is: " + transitVehicle.getPercentTopSpeed());
	}
}