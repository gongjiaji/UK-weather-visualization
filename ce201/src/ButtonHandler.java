package ce201.src;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.awt.Color.YELLOW;

public class ButtonHandler implements ActionListener {

    private int action;
    public static String filepath;

    ButtonHandler(int action) {
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {
        if (action == 1) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "1"); // displays WelcomeScreen
        }
        if (action == 2) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "2"); // displays FileSelection
        }
        // csv parser
        if (action == 3) {
            // user must select file before entering main frame
            try {
                if (!FileSelection.fileName.getText().equals("Please select file: ")) {
                    MainFrame.cardLayout.show(MainFrame.cardPanel, "3"); // displays MainMenu
                    Csv csv = new Csv();
                    // please apply methods below
                    //csv.getRows(10);
                    csv.rowsForDataSnippet();
                    FileSelection.message.setText("Please select the file you wish to read");
                    FileSelection.message.setHorizontalAlignment(JTextField.CENTER);

                }
                else {
                    FileSelection.message.setText("Please select a file");
                    FileSelection.message.setForeground(Color.RED);
                    FileSelection.message.setHorizontalAlignment(JTextField.CENTER);
                }
            } catch (FileNotFoundException e1) {

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        // File chooser
        if (action == 4) {
            if (FileSelection.selectFile.getText().equals("Browse")) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "csv & excel files", "csv", "xls"); // csv and excel files are accepted.
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) { // true : open file successful
                    filepath = chooser.getSelectedFile().getAbsolutePath();
                    char c = filepath.charAt(filepath.length()-3);
                    char s = filepath.charAt(filepath.length()-2);
                    char v = filepath.charAt(filepath.length()-1);

                    if (c=='c' && s=='s' && v=='v')
                    FileSelection.fileName.setText("File selected: " + filepath);
                    if (MainFrame.nightOn==false)
                        FileSelection.message.setForeground(null);
                    else
                        FileSelection.message.setForeground(YELLOW);
                    FileSelection.selectFile.setText("clear");

                }
            } else if (FileSelection.selectFile.getText().equals("clear")) {
                FileSelection.fileName.setText("Please select file: ");
                FileSelection.selectFile.setText("Browse");
            }
        }

        if (action == 5) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "3"); // displays MainMenu without processing
            DataSnippet.message.setText("Please select two dates to choose data from; data will then follow: ");
            DataSnippet.message.setHorizontalAlignment(JTextField.CENTER);
            DataSnippet.startDate.getJFormattedTextField().setText("");
            DataSnippet.endDate.getJFormattedTextField().setText("");
            Prediction.number.setText("");
            Prediction.message.setText("Select the number of predictions to be displayed:");
            Prediction.numberTyped="";

            RecentSearch.message.setText("Please select one of the saved data");
        }

        if (action == 6) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "6"); // displays Prediction
        }

        if (action == 7) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "7"); // displays RecentSearch
        }

        if (action == 8) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "8"); // displays SearchForData
        }

        if (action == 9) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "9"); // displays DataSnippet
        }

        if (action == 10) {
//            DataSnippet.message.setText("Please select two dates to choose data from; data will then follow: ");
//            DataSnippet.message.setHorizontalAlignment(JTextField.CENTER);
        }

        if (action == 12) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "12");
        }
        if (action == 14) {
            MainFrame.cardLayout.show(MainFrame.cardPanel, "14");
        }

        if (action == 15) {
            Graphs.barGraph = new BarGraph("UK Power Generation Viewer ", "Date", "Power");
            Graphs.barGraph.setVisible(true);
        }

        if(action == 20){
            //line
            Graphs.lineChart = new LineChart("UK Power Generation Viewer", "Date", "Power (GW)", "lineChart.jpg");
            Graphs.lineChart.setVisible(true);
        }
        if(action == 21){

            JDialog instructions = new JDialog();
            instructions.setModal(true);
            instructions.setResizable(false);
            instructions.setTitle("CSV Requirements");
            JPanel main = new JPanel();
            JPanel one = new JPanel();

            JTextField title = new JTextField("CSV Requirements");
            title.setFont(MainFrame.titleFont);
            title.setEditable(false);
            title.setHorizontalAlignment(JTextField.CENTER);
            title.setBorder(BorderFactory.createEmptyBorder());

            JButton close = new JButton("Close dialog");

            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    instructions.dispose();
                }
            });

            JTextField message = new JTextField("For this program to work as intended; the CSV file must have the columns:");
            message.setBorder(BorderFactory.createEmptyBorder());
            message.setEditable(false);

            JTextArea text = new JTextArea("id\n timestamp\n demand\n frequency\n coal\n nuclear\n ccgt\n wind\n french_ict\n dutch_ict\n irish_ict\n ew_ict\n pumped\n hydro\n oil\n ocgt \n other \n solar");
            text.setEditable(false);
            JScrollPane sp = new JScrollPane(text);
            one.add(message);

            main.setLayout(MainFrame.standardLayout);
            main.add(title);
            main.add(one);
            main.add(sp);
            main.add(close);

            instructions.add(main);
            instructions.setSize(500,500);
            instructions.setVisible(true);
        }

        if(action == 22){
            Graphs.pieChart = new PieChart("UK Power Generation Viewer", "pieChart.jpg");
            Graphs.pieChart.setVisible(true);

        }

        if (action == 23) {
            JDialog instructions = new JDialog();
            instructions.setModal(true);
            instructions.setResizable(false);
            instructions.setTitle("Credits");

            JPanel main = new JPanel();
            JPanel one = new JPanel();

            JTextField title = new JTextField("Credits");
            title.setFont(MainFrame.titleFont);
            title.setEditable(false);
            title.setHorizontalAlignment(JTextField.CENTER);
            title.setBorder(BorderFactory.createEmptyBorder());

            JButton close = new JButton("Close dialog");

            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    instructions.dispose();
                }
            });

            JTextField message = new JTextField("Designed, created and implemented by:");
            message.setEditable(false);
            message.setBorder(BorderFactory.createEmptyBorder());
            JTextArea text = new JTextArea("Jiaji Gong\n Ionel Florin Vasile\n Hamza Butt\n Matei Rusu\n Kai Roper-Blackman\n Tinuade Ologbenla\n Dominic Ashton");
            text.setEditable(false);
            JScrollPane sp = new JScrollPane(text);
            one.add(message);

            main.setLayout(MainFrame.standardLayout);
            main.add(title);
            main.add(one);
            main.add(sp);
            main.add(close);

            instructions.add(main);
            instructions.setSize(500,500);
            instructions.setVisible(true);

        }
    }
}
