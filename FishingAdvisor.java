import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class FishingAdvisor {

    // Metod för att hämta årstid baserat på månad
    public static String getSeason(String month) {
        Map<String, String> seasonMap = new HashMap<>();
        seasonMap.put("januari", "Vinter");
        seasonMap.put("februari", "Vinter");
        seasonMap.put("december", "Vinter");
        seasonMap.put("mars", "Vår");
        seasonMap.put("april", "Vår");
        seasonMap.put("maj", "Vår");
        seasonMap.put("juni", "Sommar");
        seasonMap.put("juli", "Sommar");
        seasonMap.put("augusti", "Sommar");
        seasonMap.put("september", "Höst");
        seasonMap.put("oktober", "Höst");
        seasonMap.put("november", "Höst");

        return seasonMap.getOrDefault(month.toLowerCase(), null);
    }

    public static String showFishingTips(String season) {
        switch(season.toLowerCase()){
            case "vinter" :
            return "🎣 Vintertips: Prova  "
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Skapa huvudfönster
            JFrame frame = new JFrame("FishingAdvisor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 250);
            frame.setLayout(new BorderLayout(10, 10));

            // Panel för innehåll
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // Rubrik
            JLabel titleLabel = new JLabel("🎣 Välkommen till FishingAdvisor");
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Instruktion
            JLabel instructionLabel = new JLabel("Välj en månad nedan:");
            instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            instructionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

            // Dropdown för månader
            String[] months = {
                "-- Välj månad --", "Januari", "Februari", "Mars", "April", "Maj", "Juni",
                "Juli", "Augusti", "September", "Oktober", "November", "December"
            };
            JComboBox<String> monthComboBox = new JComboBox<>(months);
            monthComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Resultatetikett
            JLabel resultLabel = new JLabel(" ");
            resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            resultLabel.setForeground(Color.BLUE);

            // Knapp för att hämta årstid
            JButton getSeasonButton = new JButton("Hämta Årstid");
            getSeasonButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // ActionListener för knappen
            getSeasonButton.addActionListener(e -> {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                if (selectedMonth.equals("-- Välj månad --")) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("⚠️ Du måste välja en månad för att fortsätta.");
                } else {
                    String season = getSeason(selectedMonth);
                    resultLabel.setForeground(new Color(0, 128, 0)); // Grön färg
                    resultLabel.setText("🗓️ " + selectedMonth + " tillhör årstiden: " + season);
                }
            });

            // Lägg till alla komponenter till panelen
            panel.add(titleLabel);
            panel.add(instructionLabel);
            panel.add(monthComboBox);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(getSeasonButton);
            panel.add(Box.createRigidArea(new Dimension(0, 15)));
            panel.add(resultLabel);

            // Lägg till panel i fönstret
            frame.add(panel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null); // Centrera fönstret
            frame.setVisible(true);
        });
    }
}



