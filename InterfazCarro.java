import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCarro extends JFrame implements ActionListener {
    private Carro carro;

    private JTextField modeloField, colorField, placaField, tipoCarroField, añoField, seguroField;
    private JCheckBox pinturaMetalizadaCheckBox;

    public InterfazCarro(Carro carro) {
        this.carro = carro;

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloField = new JTextField(carro.getModelo());

        JLabel colorLabel = new JLabel("Color:");
        colorField = new JTextField(carro.getColor());

        JLabel placaLabel = new JLabel("Placa:");
        placaField = new JTextField(carro.getPlaca());

        JLabel tipoCarroLabel = new JLabel("Tipo de Carro:");
        tipoCarroField = new JTextField(carro.getTipoCarro());

        JLabel pinturaLabel = new JLabel("Pintura Metalizada:");
        pinturaMetalizadaCheckBox = new JCheckBox("Sí");
        pinturaMetalizadaCheckBox.setSelected(carro.isPinturaMetalizada());

        JLabel añoLabel = new JLabel("Año de Fabricación:");
        añoField = new JTextField(String.valueOf(carro.getAñoFabricacion()));

        JLabel seguroLabel = new JLabel("Modalidad de Seguro:");
        seguroField = new JTextField(carro.getModalidadSeguro());

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(this);

        setLayout(new GridLayout(9, 2));
        add(modeloLabel);
        add(modeloField);
        add(colorLabel);
        add(colorField);
        add(placaLabel);
        add(placaField);
        add(tipoCarroLabel);
        add(tipoCarroField);
        add(pinturaLabel);
        add(pinturaMetalizadaCheckBox);
        add(añoLabel);
        add(añoField);
        add(seguroLabel);
        add(seguroField);
        add(new JLabel()); // Espacio en blanco
        add(new JLabel()); // Espacio en blanco
        add(guardarButton);

        setTitle("Editar Carro");
        setSize(400, 350); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carro.setModelo(modeloField.getText());
        carro.setColor(colorField.getText());
        carro.setPlaca(placaField.getText());
        carro.setTipoCarro(tipoCarroField.getText());
        carro.setPinturaMetalizada(pinturaMetalizadaCheckBox.isSelected());
        carro.setAñoFabricacion(Integer.parseInt(añoField.getText()));
        carro.setModalidadSeguro(seguroField.getText());

        System.out.println("Datos del carro actualizados: " + carro.toString());
    }

    public static void main(String[] args) {
        Carro miCarro = new Carro("Corolla", "Rojo", true, "ABC123", "FAMILIAR", 2022, "A TODO RIESGO");
        InterfazCarro interfaz = new InterfazCarro(miCarro);
    }
}
