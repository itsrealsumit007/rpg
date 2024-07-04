import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatUI extends JPanel {
    private CombatManager combatManager;
    private JButton attackButton;
    private JLabel combatLog;

    public CombatUI(Hero hero, Enemy enemy) {
        combatManager = new CombatManager(hero, enemy);
        attackButton = new JButton("Attack");
        combatLog = new JLabel("<html><body>");

        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                combatManager.startCombat();
                updateCombatLog();
            }
        });

        setLayout(new BorderLayout());
        add(attackButton, BorderLayout.NORTH);
        add(new JScrollPane(combatLog), BorderLayout.CENTER);
    }

    private void updateCombatLog() {
        StringBuilder log = new StringBuilder("<html><body>");
        log.append("Combat started!<br>");
        log.append("Hero HP: ").append(combatManager.getHero().health).append("<br>");
        log.append("Enemy HP: ").append(combatManager.getEnemy().getHealth()).append("<br>");
        combatLog.setText(log.toString());
    }
}
