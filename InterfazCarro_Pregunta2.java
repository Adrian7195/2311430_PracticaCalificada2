import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private final JDesktopPane desktopPane;
    private DefaultTableModel tableModel;

    public MainForm() {
        desktopPane = new JDesktopPane();
        createMenuBar();
        createCarListForm();

        setContentPane(desktopPane);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menú");

        JMenuItem registrarCarroItem = new JMenuItem("Registrar Carro");
        registrarCarroItem.addActionListener((ActionEvent e) -> {
            openCarForm(new Carro("Corolla", "Rojo", true, "ABC123", "FAMILIAR", 2022, "A TODO RIESGO"));
        });

        JMenuItem listarCarrosItem = new JMenuItem("Listar Carros");
        listarCarrosItem.addActionListener((ActionEvent e) -> {
            openCarListForm();
        });

        menu.add(registrarCarroItem);
        menu.add(listarCarrosItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void createCarListForm() {
        String[] columnNames = {"Placa", "Modelo", "Color", "Tipo", "Año", "Seguro"};
        tableModel = new DefaultTableModel(columnNames, 0);

        JTable carTable = new JTable(tableModel);
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de búsqueda por número de placa
                String placaABuscar = JOptionPane.showInputDialog("Ingrese la placa a buscar:");
                // Lógica para buscar en la tabla y resaltar la fila encontrada
            }
        });

        JButton editarButton = new JButton("Editar");
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = carTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los datos de la fila seleccionada y abrir el formulario de edición
                    String placa = (String) tableModel.getValueAt(selectedRow, 0);
                    String modelo = (String) tableModel.getValueAt(selectedRow, 1);
                    String color = (String) tableModel.getValueAt(selectedRow, 2);
                    Carro carroSeleccionado = new Carro(modelo, color, true, placa, "FAMILIAR", 2022, "A TODO RIESGO");
                    openCarForm(carroSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(desktopPane, "Seleccione un carro para editar.");
                }
            }
        });

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = carTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Eliminar la fila seleccionada de la tabla
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(desktopPane, "Seleccione un carro para eliminar.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buscarButton);
        buttonPanel.add(editarButton);
        buttonPanel.add(eliminarButton);

        JScrollPane scrollPane = new JScrollPane(carTable);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JInternalFrame carListForm = new JInternalFrame("Listar Carros", true, true, true, true);
        carListForm.getContentPane().add(mainPanel);
        carListForm.setSize(600, 400);
        carListForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        desktopPane.add(carListForm);
    }

    private void openCarForm(Carro carro) {
        InterfazCarro interfazCarro = new InterfazCarro(carro);
        desktopPane.add(interfazCarro);
        interfazCarro.setVisible(true);
    }

    private void openCarListForm() {
        ListarCarrosForm listarCarrosForm = new ListarCarrosForm(tableModel);
        desktopPane.add(listarCarrosForm);
        listarCarrosForm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
        });
    }
}
