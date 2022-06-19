package res;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;

public class DatePick extends JDatePickerImpl {
    /**
     * You are able to set the format of the date being displayed on the label.
     * Formatting is described at:
     * <p>
     * http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html
     *
     * @param datePanel
     * @param formatter
     */
    public DatePick(JDatePanelImpl datePanel, JFormattedTextField.AbstractFormatter formatter) {
        super(datePanel, formatter);
    }
}
