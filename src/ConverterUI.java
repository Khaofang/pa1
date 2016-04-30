import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Make GUI of Unit converter. Unit converter convert the first unit to the
 * second. Converting can convert from left to right and from right to left.
 * Show result of converting by clicking button "Convert!" and clear result by
 * clicking button "Clear".
 * 
 * @author Chayanin Punjakunaporn
 */
public class ConverterUI extends JFrame {
	/** Attribute */
	private ButtonGroup modeSelection;
	private JButton convertButton, clearButton;
	private JComboBox<Unit> unit1ComboBox, unit2ComboBox;
	private JMenu menuUnitType;
	private JMenuBar menuBar;
	private JMenuItem menuLength, menuArea, menuWeight;
	private JLabel equalLabel;
	private JPanel contents, changeModeContents;
	private JRadioButton select1;
	private JRadioButton select2;
	private JTextField inputField1, inputField2;
	private UnitConverter unitconverter;

	/** Constructor */
	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	/** Set initial components */
	private void initComponents() {
		/** Set layout in GUI */
		this.setLayout(new BorderLayout());
		contents = new JPanel(new FlowLayout());
		changeModeContents = new JPanel(new FlowLayout());
		this.add(contents);
		this.add(changeModeContents, BorderLayout.SOUTH);

		/** Set menu bar */
		menuBar = new JMenuBar();
		menuUnitType = new JMenu("Unit Type");
		menuUnitType.setMnemonic(KeyEvent.VK_F);
		menuLength = new JMenuItem("Length", KeyEvent.VK_N);
		menuLength.addActionListener(new SwitchUnitTypeListener("Length"));
		menuArea = new JMenuItem("Area", KeyEvent.VK_N);
		menuArea.addActionListener(new SwitchUnitTypeListener("Area"));
		menuWeight = new JMenuItem("Weight", KeyEvent.VK_N);
		menuWeight.addActionListener(new SwitchUnitTypeListener("Weight"));
		menuBar.add(menuUnitType);
		menuUnitType.add(menuLength);
		menuUnitType.add(menuArea);
		menuUnitType.add(menuWeight);
		menuUnitType.add(new ExitAction());
		this.setJMenuBar(menuBar);
		
		/** Create all components */
		convertButton = new JButton("Convert!");
		clearButton = new JButton("Clear");
		unit1ComboBox = new JComboBox<Unit>(unitconverter.getUnits(UnitType.Length));
		unit1ComboBox.setPreferredSize(new Dimension(125,25));
		unit2ComboBox = new JComboBox<Unit>(unitconverter.getUnits(UnitType.Length));
		unit2ComboBox.setPreferredSize(new Dimension(125,25));
		equalLabel = new JLabel("=");
		inputField1 = new JTextField("", 10);
		inputField2 = new JTextField("", 10);
		inputField2.setEditable(false);
		modeSelection = new ButtonGroup();
		select1 = new JRadioButton("Left->Right");
		select2 = new JRadioButton("Right->Left");
		modeSelection.add(select1);
		modeSelection.add(select2);

		/** Add all components to layouts */
		contents.add(inputField1);
		contents.add(unit1ComboBox);
		contents.add(equalLabel);
		contents.add(inputField2);
		contents.add(unit2ComboBox);
		contents.add(convertButton);
		contents.add(clearButton);
		changeModeContents.add(select1);
		changeModeContents.add(select2);

		/** Make ActionListener to all components that must be used */
		inputField1.addActionListener(new ConvertButtonListener());
		inputField2.addActionListener(new ConvertButtonListener());
		convertButton.addActionListener(new ConvertButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		select1.addActionListener(new SelectedRadioButtonListener());
		select2.addActionListener(new SelectedRadioButtonListener());

		this.pack();
	}

	/** Run this GUI (Set window for seeing) */
	public void run() {
		this.setVisible(true);
	}

	/** ActionListener of convertButton */
	class ConvertButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String s = "";
			if (select2.isSelected())
				s = inputField2.getText().trim();
			else
				s = inputField1.getText().trim();
			System.out.println("actionPerformed: input=" + s);
			if (s.length() > 0) {
				try {
					double value = Double.valueOf(s);

					if (select2.isSelected()) {
						double result = unitconverter.convert(value, (Unit) unit2ComboBox.getSelectedItem(),
								(Unit) unit1ComboBox.getSelectedItem());
						inputField1.setText(String.format("%.2f", result));
					} else {
						double result = unitconverter.convert(value, (Unit) unit1ComboBox.getSelectedItem(),
								(Unit) unit2ComboBox.getSelectedItem());
						inputField2.setText(String.format("%.2f", result));
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid number!!", "Warning!", JOptionPane.PLAIN_MESSAGE);
				}
			} else
				JOptionPane.showMessageDialog(null, "Please input a number!", "Warning!", JOptionPane.PLAIN_MESSAGE);
		}
	}

	/** ActionListener of clearButton */
	class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			inputField1.setText("");
			inputField2.setText("");
		}
	}

	/** ActionListener of select1 and select2 JRadioButton */
	class SelectedRadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (select2.isSelected()) {
				inputField2.setEditable(true);
				inputField1.setEditable(false);
			} else {
				inputField1.setEditable(true);
				inputField2.setEditable(false);
			}
		}
	}

	class SwitchUnitTypeListener implements ActionListener {
		UnitType utype;
		
		public SwitchUnitTypeListener(String type) {
			UnitType[] allUnitType = UnitFactory.getInstance().getUnitTypes();
			for(UnitType thisUnitType : allUnitType) {
				if(thisUnitType.getType().equals(type))
					utype = thisUnitType;
			}
		}
		
		public void actionPerformed(ActionEvent evt) {
			// get all the Length units from the UnitConverter
			Unit [] units = unitconverter.getUnits(utype);  // converter calls UnitFactory
			// remove the old units.
			while(unit1ComboBox.getItemCount() > 0 && unit2ComboBox.getItemCount() > 0) {
				unit1ComboBox.removeItemAt(0);
				unit2ComboBox.removeItemAt(0);
			}
			// add units to combo boxes in UI.
			for(Unit u : units) {
				unit1ComboBox.addItem(u);;
				unit2ComboBox.addItem(u);
			}
			
		}
	}
	
	class ExitAction extends AbstractAction {
		public ExitAction() {
			super("Exit");
		}
		public void actionPerformed(ActionEvent evt) {
			System.exit(0);
		}
	}

}
