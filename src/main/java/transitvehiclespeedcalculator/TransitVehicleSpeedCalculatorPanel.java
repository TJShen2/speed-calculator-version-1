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

	private GridBagLayout contentPaneLayout;
	
	private JPanel transitVehicleAttributeLabelPanel;
	public JPanel calculateAverageSpeedPanel;
	private JPanel calculationResultsPanel;
	private JPanel transitVehicleListPanel;
	public JPanel transitVehicleAttributeEntryPanel;
	private JPanel transitVehicleAttributePanel;
	private JPanel editVehicleListPanel;

	private JLabel nameLabel;
	private JLabel stationCountLabel;
	private JLabel accelerationRateLabel;
	private JLabel decelerationRateLabel;
	private JLabel dwellTimeLabel;
	private JLabel lineLengthLabel;
	private JLabel topSpeedLabel;
	private JLabel selectedVehicleLabel;
	
	public JTextPane nameTextPane;
	public JTextPane stationCountTextPane;
	public JTextPane accelerationRateTextPane;
	public JTextPane decelerationRateTextPane;
	public JTextPane dwellTimeTextPane;
	public JTextPane lineLengthTextPane;
	public JTextPane topSpeedTextPane;
	public JTextPane calculationResultsTextPane;
	
	public JButton calculateAverageSpeedButton;
	public JButton newVehicleButton;
	public JButton deleteVehicleButton;
	public JButton saveAttributesButton;
	
	private JScrollPane transitVehicleListScrollPane;
	
	public JComboBox<String> vehicleListComboBox;

	/**
	 * Create the frame.
	 */
	public TransitVehicleSpeedCalculatorPanel() {
		setBounds(100, 100, 1152, 745);
		new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneLayout = new GridBagLayout();
		contentPaneLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		contentPaneLayout.columnWeights = new double[]{1.0, 0.0};
		setLayout(contentPaneLayout);
		
		transitVehicleListScrollPane = new JScrollPane();
		transitVehicleListScrollPane.setPreferredSize(new Dimension(100, 540));
		transitVehicleListScrollPane.setMinimumSize(new Dimension(100, 540));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		add(transitVehicleListScrollPane, gbc_scrollPane);
		
		transitVehicleListPanel = new JPanel();
		transitVehicleListScrollPane.setViewportView(transitVehicleListPanel);
		transitVehicleListPanel.setLayout(new BoxLayout(transitVehicleListPanel, BoxLayout.Y_AXIS));
		
		JLabel titleLabel = new JLabel("Input Data");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		add(titleLabel, gbc_titleLabel);
		
		editVehicleListPanel = new JPanel();
		GridBagConstraints gbc_editVehicleListPanel = new GridBagConstraints();
		gbc_editVehicleListPanel.insets = new Insets(0, 0, 5, 5);
		gbc_editVehicleListPanel.fill = GridBagConstraints.BOTH;
		gbc_editVehicleListPanel.gridx = 0;
		gbc_editVehicleListPanel.gridy = 2;
		add(editVehicleListPanel, gbc_editVehicleListPanel);
		
		newVehicleButton = new JButton("New Vehicle");
		editVehicleListPanel.add(newVehicleButton);
		
		selectedVehicleLabel = new JLabel("Selected Vehicle:");
		editVehicleListPanel.add(selectedVehicleLabel);
		
		vehicleListComboBox = new JComboBox<String>();
		editVehicleListPanel.add(vehicleListComboBox);
		
		deleteVehicleButton = new JButton("Delete Selected Vehicle");
		editVehicleListPanel.add(deleteVehicleButton);
		
		transitVehicleAttributePanel = new JPanel();
		GridBagConstraints gbc_transitVehicleAttributePanel = new GridBagConstraints();
		gbc_transitVehicleAttributePanel.insets = new Insets(0, 0, 5, 5);
		gbc_transitVehicleAttributePanel.fill = GridBagConstraints.BOTH;
		gbc_transitVehicleAttributePanel.gridx = 0;
		gbc_transitVehicleAttributePanel.gridy = 3;
		add(transitVehicleAttributePanel, gbc_transitVehicleAttributePanel);
		transitVehicleAttributePanel.setLayout(new BoxLayout(transitVehicleAttributePanel, BoxLayout.Y_AXIS));
		
		transitVehicleAttributeLabelPanel = new JPanel();
		transitVehicleAttributePanel.add(transitVehicleAttributeLabelPanel);
		transitVehicleAttributeLabelPanel.setLayout(new GridLayout(0, 7, 20, 0));
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitVehicleAttributeLabelPanel.add(nameLabel);
		
		stationCountLabel = new JLabel("Station Count");
		stationCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stationCountLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(stationCountLabel);
		
		accelerationRateLabel = new JLabel("Acceleration Rate");
		accelerationRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accelerationRateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(accelerationRateLabel);
		
		decelerationRateLabel = new JLabel("Deceleration Rate");
		decelerationRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		decelerationRateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(decelerationRateLabel);
		
		dwellTimeLabel = new JLabel("Dwell Time per Station");
		dwellTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dwellTimeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(dwellTimeLabel);
		
		lineLengthLabel = new JLabel("Length of Line");
		lineLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lineLengthLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(lineLengthLabel);
		
		topSpeedLabel = new JLabel("Top Speed");
		topSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topSpeedLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		transitVehicleAttributeLabelPanel.add(topSpeedLabel);
		
		transitVehicleAttributeEntryPanel = new JPanel();
		transitVehicleAttributePanel.add(transitVehicleAttributeEntryPanel);
		transitVehicleAttributeEntryPanel.setLayout(new GridLayout(0, 7, 20, 0));
		
		nameTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(nameTextPane);
		nameTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		stationCountTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(stationCountTextPane);
		stationCountTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		accelerationRateTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(accelerationRateTextPane);
		accelerationRateTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		decelerationRateTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(decelerationRateTextPane);
		decelerationRateTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		dwellTimeTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(dwellTimeTextPane);
		dwellTimeTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lineLengthTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(lineLengthTextPane);
		lineLengthTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		topSpeedTextPane = new JTextPane();
		transitVehicleAttributeEntryPanel.add(topSpeedTextPane);
		topSpeedTextPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		calculateAverageSpeedPanel = new JPanel();
		GridBagConstraints gbc_calculateAverageSpeedPanel = new GridBagConstraints();
		gbc_calculateAverageSpeedPanel.weightx = 1.0;
		gbc_calculateAverageSpeedPanel.insets = new Insets(0, 0, 5, 5);
		gbc_calculateAverageSpeedPanel.fill = GridBagConstraints.BOTH;
		gbc_calculateAverageSpeedPanel.gridx = 0;
		gbc_calculateAverageSpeedPanel.gridy = 6;
		add(calculateAverageSpeedPanel, gbc_calculateAverageSpeedPanel);
		
		calculateAverageSpeedButton = new JButton("Calculate Average Speed");
		calculateAverageSpeedPanel.add(calculateAverageSpeedButton);
		
		saveAttributesButton = new JButton("Save Attributes");
		calculateAverageSpeedPanel.add(saveAttributesButton);
		
		calculationResultsPanel = new JPanel();
		GridBagConstraints gbc_calculationResultsPanel = new GridBagConstraints();
		gbc_calculationResultsPanel.weightx = 1.0;
		gbc_calculationResultsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_calculationResultsPanel.weighty = 1.0;
		gbc_calculationResultsPanel.fill = GridBagConstraints.BOTH;
		gbc_calculationResultsPanel.gridx = 0;
		gbc_calculationResultsPanel.gridy = 8;
		add(calculationResultsPanel, gbc_calculationResultsPanel);
		calculationResultsPanel.setLayout(new CardLayout(0, 0));
		
		calculationResultsTextPane = new JTextPane();
		calculationResultsPanel.add(calculationResultsTextPane, "name_3141119477751");
	}
	public void UpdateScrollPaneButtons(HashMap<String,TransitVehicle> attributes) {
		transitVehicleListPanel.removeAll();
		for (Map.Entry<String,TransitVehicle> name : attributes.entrySet()) {
			JButton scrollPaneButton = new JButton(name.getKey());
			scrollPaneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DisplayCalculationResults(name.getKey(), name.getValue());
				}
			});
			transitVehicleListPanel.add(scrollPaneButton);
			transitVehicleListPanel.validate();
		}
	}
	public void DisplayCalculationResults(String name, TransitVehicle transitVehicle) {
		nameTextPane.setText(name);
		Component[] fields = transitVehicleAttributeEntryPanel.getComponents();

		for (int i = 1; i < fields.length; i++) {
			JTextPane field = (JTextPane) fields[i];
			field.setText(String.valueOf(transitVehicle.attributes[i - 1]));
		}
		calculationResultsTextPane.setText("Average speed is: " + transitVehicle.averageSpeed + " km/h\nLine stop spacing is: " + transitVehicle.stationSpacing+ " m");
	}
}