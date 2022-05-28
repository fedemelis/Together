package view;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarLoginView extends JFrame{
    private JPanel loginCalendarPanel;
    private JTable table1;
    private JButton btnAccedi;

    public CalendarLoginView(){
        setContentPane(loginCalendarPanel);
        setSize(500, 500);
        setVisible(true);

        TableColumn t = new TableColumn();

        table1.addColumn(t);

        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalendarLoginView::new);

    }
}



