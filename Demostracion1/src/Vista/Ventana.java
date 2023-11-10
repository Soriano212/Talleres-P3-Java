package Vista;

import javax.swing.*;

public class Ventana extends JFrame {
    private JLabel labelTitle;
    private JLabel labelSep1;
    public JComboBox comboBoxPaises;
    private JLabel labelPais;
    private JLabel labelPaquete;
    private JLabel labelExtras;
    public JRadioButton basicoRadioButton;
    public JRadioButton resortRadioButton;
    public JRadioButton vipRadioButton;
    public JCheckBox autoCheckBox;
    public JCheckBox comidasCheckBox;
    public JCheckBox guíaTuristicoCheckBox;
    public JButton buttonAgregar;
    public JTable table;
    private JPanel panelPrincipal;
    public JButton buttonLimpiar;
    public ButtonGroup buttonGroupPaquetes;

    public Ventana() {
        super("Formulario");
        setContentPane(panelPrincipal);
        buttonGroupPaquetes = new ButtonGroup();
        buttonGroupPaquetes.add(basicoRadioButton);
        buttonGroupPaquetes.add(resortRadioButton);
        buttonGroupPaquetes.add(vipRadioButton);
    }
}
