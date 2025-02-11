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

        JButton showBankInfoButton = new JButton("Show Bank Information");
        JButton addUserButton = new JButton("Add User");
        JButton removeUserButton = new JButton("Remove User");
        JButton replenishAccountButton = new JButton("Replenish Account");
        JButton showTotalDepositAmountButton = new JButton("Show Total Deposit Amount");

        panel.add(showBankInfoButton);
        panel.add(addUserButton);
        panel.add(removeUserButton);
        panel.add(replenishAccountButton);
        panel.add(showTotalDepositAmountButton);

        showBankInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBankInformation();
            }
        });

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

    private void showBankInformation() {
        StringBuilder message = new StringBuilder("Bank Name: " + bank.getName() + "\n");
        message.append("Bank ID: ").append(bank.getId()).append("\n");
        message.append("Number of Branches: ").append(bank.getBranches().size()).append("\n\n");

        message.append("Branches:\n");
        for (Branch branch : bank.getBranches()) {
            message.append("Branch ID: ").append(branch.getId()).append(", Branch Name: ").append(branch.getName()).append("\n");
        }

        String branchIdStr = JOptionPane.showInputDialog(message.toString() + "\nEnter the Branch ID to view details:");
        int branchId = Integer.parseInt(branchIdStr);

        Branch selectedBranch = null;
        for (Branch branch : bank.getBranches()) {
            if (branch.getId() == branchId) {
                selectedBranch = branch;
                break;
            }
        }

        if (selectedBranch != null) {
            showBranchInformation(selectedBranch);
        } else {
            JOptionPane.showMessageDialog(null, "Branch not found.");
        }
    }

    private void showBranchInformation(Branch branch) {
        StringBuilder message = new StringBuilder("Branch Name: " + branch.getName() + "\n");
        message.append("Branch ID: ").append(branch.getId()).append("\n\n");

        message.append("Deposits:\n");
        for (Contribution deposit : branch.getDeposits()) {
            message.append("ID: ").append(deposit.getId()).append(", Depositor: ").append(deposit.getDepositorsName()).append(", Amount: ").append(deposit.getAmount()).append("\n");
        }

        JOptionPane.showMessageDialog(null, message.toString());
    }

    private void addUser() {
        int branchId = Integer.parseInt(JOptionPane.showInputDialog("Enter the branch ID:"));
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getId() == branchId) {
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
        int branchId = Integer.parseInt(JOptionPane.showInputDialog("Enter the branch ID:"));
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getId() == branchId) {
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
        int branchId = Integer.parseInt(JOptionPane.showInputDialog("Enter the branch ID:"));
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getId() == branchId) {
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
        int branchId = Integer.parseInt(JOptionPane.showInputDialog("Enter the branch ID:"));
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getId() == branchId) {
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

    private void replenishAccount() {
        int branchId = Integer.parseInt(JOptionPane.showInputDialog("Enter the branch ID:"));
        Branch branch = null;
        for (Branch b : bank.getBranches()) {
            if (b.getId() == branchId) {
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
        Bank bank = new Bank(1, "National");
        Branch branch1 = new Branch(1, "Main", bank);
        Branch branch2 = new Branch(2, "Secondary", bank);
        bank.addBranch(branch1);
        bank.addBranch(branch2);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdvancedGUI(bank);
            }
        });
    }
}