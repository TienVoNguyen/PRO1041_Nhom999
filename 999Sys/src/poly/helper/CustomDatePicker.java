/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.IconUIResource;
import sun.swing.ImageIconUIResource;

/**
 *
 * @author NTV
 */
public  class CustomDatePicker {
    public static DatePickerSettings customsDatePicker( DatePicker datePicker, ImageIcon icon ) {
        DatePickerSettings dateSettings = new DatePickerSettings();
        JButton datePickerButton = datePicker.getComponentToggleCalendarButton();
        datePickerButton.setText("");
        datePickerButton.setIcon( icon );
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, Color.ORANGE);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, Color.GREEN);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, Color.YELLOW);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundTodayLabel, Color.YELLOW);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundClearLabel, Color.BLACK);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, Color.CYAN);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundTopLeftLabelAboveWeekNumbers, Color.CYAN);
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundSelectedDate, Color.PINK);
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarBorderSelectedDate, Color.WHITE);
        dateSettings.setColorBackgroundWeekdayLabels(Color.ORANGE, true);
        dateSettings.setColorBackgroundWeekNumberLabels(Color.ORANGE, true);

        // Set fonts:
        Font randomFont = new Font("Monospaced", Font.ITALIC | Font.BOLD, 20);
        Font smallerFont = new Font("Serif", Font.BOLD, 18);
        dateSettings.setFontMonthAndYearMenuLabels(randomFont);
        dateSettings.setFontMonthAndYearNavigationButtons(randomFont);
        dateSettings.setFontTodayLabel(randomFont);
        dateSettings.setFontClearLabel(randomFont);
        dateSettings.setFontCalendarDateLabels(randomFont);
        dateSettings.setFontCalendarWeekdayLabels(smallerFont);
        dateSettings.setFontCalendarWeekNumberLabels(smallerFont);
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        dateSettings.setAllowKeyboardEditing(false);
        // Set text colors:
        dateSettings.setColor(DatePickerSettings.DateArea.TextMonthAndYearMenuLabels, Color.BLUE);
        dateSettings.setColor(DatePickerSettings.DateArea.TextMonthAndYearNavigationButtons, Color.BLUE);
        dateSettings.setColor(DatePickerSettings.DateArea.TextTodayLabel, Color.BLUE);
        dateSettings.setColor(DatePickerSettings.DateArea.TextClearLabel, Color.BLUE);
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarTextNormalDates, Color.BLACK);
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarTextWeekdays, Color.BLACK);
        dateSettings.setColor(DatePickerSettings.DateArea.CalendarTextWeekNumbers, Color.RED);
        dateSettings.setColor(DatePickerSettings.DateArea.BackgroundCalendarPanelLabelsOnHover, Color.BLUE);
        dateSettings.setColor(DatePickerSettings.DateArea.TextCalendarPanelLabelsOnHover, Color.YELLOW);

        dateSettings.setAllowEmptyDates(false);
        
        return dateSettings;
    }
}
