import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCarro extends JInternalFrame {
    private Carro carro;

    private JTextField modeloField;
    private JTextField colorField;
    private JTextField placaField;
    // Otros campos según los atributos de la clase Carro

    public InterfazCarro(Carro carro) {
        this.carro = carro;

        setTitle("Editar Carro");
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        modeloField = new JTextField(carro.getModelo());
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);

        colorField = new JTextField(carro.getColor());
        panel.add(new JLabel("Color:"));
        panel.add(colorField);

        placaField = new JTextField(carro.getPlaca());
        panel.add(new JLabel("Placa:"));
        panel.add(placaField);

        // Agregar otros campos según los atributos de la clase Carro

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar los cambios en el objeto Carro
                carro.setModelo(modeloField.getText());
                carro.setColor(colorField.getText());
                carro.setPlaca(placaField.getText());
                // Actualizar otros atributos según los campos de la interfaz

                JOptionPane.showMessageDialog(null, "Cambios guardados correctamente");

                // Cerrar la interfaz de edición
                setVisible(false);
            }
        });
        panel.add(guardarButton);

        setContentPane(panel);
    }
}
