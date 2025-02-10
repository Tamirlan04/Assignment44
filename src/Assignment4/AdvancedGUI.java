package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedGUI {
    private Bank bank;

    public AdvancedGUI(Bank bank) {
        this.bank = bank;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Bank Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton addUserButton = new JButton("Add User");
        JButton removeUserButton = new JButton("Remove User");
        JButton addContributionButton = new JButton("Add Contribution");
        JButton removeContributionButton = new JButton("Remove Contribution");
        JButton showDepositsButton = new JButton("Show Deposits");
        JButton replenishAccountButton = new JButton("Replenish Account");
        JButton showTotalDepositAmountButton = new JButton("Show Total Deposit Amount");

        panel.add(addUserButton);
        panel.add(removeUserButton);
        panel.add(addContributionButton);
        panel.add(removeContributionButton);
        panel.add(showDepositsButton);
        panel.add(replenishAccountButton);
        panel.add(showTotalDepositAmountButton);

        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeUser();
            }
        });

        addContributionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContribution();
            }
        });

        removeContributionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeContribution();
            }
        });

        showDepositsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDeposits();
            }
        });

        replenishAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                replenishAccount();
            }
        });

        showTotalDepositAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTotalDepositAmount();
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void addUser() {
        String branchName = JOptionPane.showInputDialog("Enter the branch name (Main or Secondary):");
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getName().equalsIgnoreCase(branchName)) {
                branch = b;
                break;
            }
        }
        if (branch == null) {
            JOptionPane.showMessageDialog(null, "Branch not found.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the depositor's ID:"));
        String depositorName = JOptionPane.showInputDialog("Enter the depositor's name:");
        double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the deposit amount:"));

        Contribution newDeposit = new Contribution(id, depositorName, depositAmount, branch);
        branch.addDeposit(newDeposit);
        JOptionPane.showMessageDialog(null, "User added successfully.");
    }

    private void removeUser() {
        String branchName = JOptionPane.showInputDialog("Enter the branch name (Main or Secondary):");
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getName().equalsIgnoreCase(branchName)) {
                branch = b;
                break;
            }
        }
        if (branch == null) {
            JOptionPane.showMessageDialog(null, "Branch not found.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the depositor's ID:"));
        Contribution depositToRemove = null;
        for (Contribution deposit : branch.getDeposits()) {
            if (deposit.getId() == id) {
                depositToRemove = deposit;
                break;
            }
        }
        if (depositToRemove == null) {
            JOptionPane.showMessageDialog(null, "User not found.");
        } else {
            branch.removeDeposit(depositToRemove);
            JOptionPane.showMessageDialog(null, "User removed successfully.");
        }
    }

    private void addContribution() {
        String branchName = JOptionPane.showInputDialog("Enter the branch name (Main or Secondary):");
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getName().equalsIgnoreCase(branchName)) {
                branch = b;
                break;
            }
        }
        if (branch == null) {
            JOptionPane.showMessageDialog(null, "Branch not found.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the depositor's ID:"));
        String depositorName = JOptionPane.showInputDialog("Enter the depositor's name:");
        double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the deposit amount:"));

        Contribution newDeposit = new Contribution(id, depositorName, depositAmount, branch);
        branch.addDeposit(newDeposit);
        JOptionPane.showMessageDialog(null, "Contribution added successfully.");
    }

    private void removeContribution() {
        String branchName = JOptionPane.showInputDialog("Enter the branch name (Main or Secondary):");
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getName().equalsIgnoreCase(branchName)) {
                branch = b;
                break;
            }
        }
        if (branch == null) {
            JOptionPane.showMessageDialog(null, "Branch not found.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the depositor's ID:"));
        Contribution depositToRemove = null;
        for (Contribution deposit : branch.getDeposits()) {
            if (deposit.getId() == id) {
                depositToRemove = deposit;
                break;
            }
        }
        if (depositToRemove == null) {
            JOptionPane.showMessageDialog(null, "Contribution not found.");
        } else {
            branch.removeDeposit(depositToRemove);
            JOptionPane.showMessageDialog(null, "Contribution removed successfully.");
        }
    }

    private void showDeposits() {
        StringBuilder message = new StringBuilder("Showing all deposits in the bank:\n");
        for (Branch branch : bank.getBranches()) {
            message.append("Branch: ").append(branch.getName()).append("\n");
            for (Contribution deposit : branch.getDeposits()) {
                message.append("ID: ").append(deposit.getId()).append(", Depositor: ").append(deposit.getDepositorsName()).append(", Amount: ").append(deposit.getAmount()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private void replenishAccount() {
        String branchName = JOptionPane.showInputDialog("Enter the branch name (Main or Secondary):");
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getName().equalsIgnoreCase(branchName)) {
                branch = b;
                break;
            }
        }
        if (branch == null) {
            JOptionPane.showMessageDialog(null, "Branch not found.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the depositor's ID:"));
        Contribution depositToReplenish = null;
        for (Contribution deposit : branch.getDeposits()) {
            if (deposit.getId() == id) {
                depositToReplenish = deposit;
                break;
            }
        }
        if (depositToReplenish == null) {
            JOptionPane.showMessageDialog(null, "Depositor not found.");
        } else {
            String action = JOptionPane.showInputDialog("Do you want to add or subtract from the deposit? (Enter 'add' or 'subtract'):");
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount:"));

            if (action.equalsIgnoreCase("add")) {
                depositToReplenish.replenishAmount(amount);
                JOptionPane.showMessageDialog(null, "Amount added successfully.");
            } else if (action.equalsIgnoreCase("subtract")) {
                depositToReplenish.replenishAmount(-amount);
                JOptionPane.showMessageDialog(null, "Amount subtracted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid action. Please enter 'add' or 'subtract'.");
            }
        }
    }

    private void showTotalDepositAmount() {
        double totalAmount = 0;
        for (Branch branch : bank.getBranches()) {
            totalAmount += branch.getTotalDepositAmount();
        }
        JOptionPane.showMessageDialog(null, "Total deposit amount in the bank: " + totalAmount);
    }

    public static void main(String[] args) {
        Bank bank = new Bank("National");
        Branch branch1 = new Branch("Main", bank);
        Branch branch2 = new Branch("Secondary", bank);
        bank.addBranch(branch1);
        bank.addBranch(branch2);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdvancedGUI(bank);
            }
        });
    }
}