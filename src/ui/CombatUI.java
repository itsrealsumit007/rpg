import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatUI extends JPanel {
    private CombatManager combatManager;
    private JButton attackButton;

    public CombatUI(Hero hero, Enemy enemy) {
        combatManager = new CombatManager(hero, enemy);
        attackButton = new JButton("Attack");

        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                combatManager.startCombat();
            }
        });

        add(attackButton);
    }
}
