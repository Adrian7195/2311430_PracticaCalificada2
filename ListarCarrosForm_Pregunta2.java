import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarCarrosForm extends JInternalFrame {
    private DefaultTableModel tableModel;
    private JTextField placaBuscarField;

    public ListarCarrosForm(DefaultTableModel tableModel) {
        this.tableModel = tableModel;

        setTitle("Listar Carros");
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTable tablaCarros = new JTable(tableModel);
        panel.add(new JScrollPane(tablaCarros), BorderLayout.CENTER);

        placaBuscarField = new JTextField();
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de búsqueda por número de placa
                String placaBuscar = placaBuscarField.getText();

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).equals(placaBuscar)) {
                        // Seleccionar la fila encontrada
                        tablaCarros.setRowSelectionInterval(i, i);
                        // Desplazarse a la fila seleccionada
                        tablaCarros.scrollRectToVisible(new Rectangle(tablaCarros.getCellRect(i, 0, true)));
                        return;
                    }
                }

                JOptionPane.showMessageDialog(panel, "No se encontró ningún carro con la placa especificada.");
            }
        });

        panel.add(placaBuscarField, BorderLayout.NORTH);
        panel.add(buscarButton, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}
