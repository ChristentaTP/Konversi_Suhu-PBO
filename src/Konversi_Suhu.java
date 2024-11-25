import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konversi_Suhu {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Konversi Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(3, 2, 10, 10));


        JLabel labelTitle = new JLabel("Konversi Suhu", JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(labelTitle, BorderLayout.NORTH);


        JLabel labelInput = new JLabel("Masukkan Suhu: ");
        JTextField inputField = new JTextField();
        panelCenter.add(labelInput);
        panelCenter.add(inputField);

        JComboBox<String> conversionOptions = new JComboBox<>(new String[]{
                "Celsius ke Fahrenheit",
                "Fahrenheit ke Celsius"
        });
        panelCenter.add(new JLabel("Pilih Jenis Konversi: "));
        panelCenter.add(conversionOptions);


        JButton convertButton = new JButton("Konversi");
        panelCenter.add(convertButton);
        JLabel resultLabel = new JLabel("Hasil: ", JLabel.CENTER);
        panelCenter.add(resultLabel);


        frame.add(panelCenter, BorderLayout.CENTER);


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double input = Double.parseDouble(inputField.getText());
                    String conversionType = (String) conversionOptions.getSelectedItem();
                    double result;

                    if ("Celsius ke Fahrenheit".equals(conversionType)) {
                        result = (input * 9 / 5) + 32;
                        resultLabel.setText("Hasil: " + result + " °F");
                    } else if ("Fahrenheit ke Celsius".equals(conversionType)) {
                        result = (input - 32) * 5 / 9;
                        resultLabel.setText("Hasil: " + result + " °C");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Masukkan angka yang valid!");
                }
            }
        });


        frame.setVisible(true);
    }
}
