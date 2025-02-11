package Assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contribution {
    private int id;
    private String depositorsName;
    private double amount;
    private Branch branch;

    public Contribution(int id, String depositorsName, double amount, Branch branch) {
        this.id = id;
        this.depositorsName = depositorsName;
        this.amount = amount;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public String getDepositorsName() {
        return depositorsName;
    }

    public double getAmount() {
        return amount;
    }

    public Branch getBranch() {
        return branch;
    }

    public void replenishAmount(double amount) {
        this.amount += amount;
        updateAmountInDatabase();
    }

    private void updateAmountInDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE contributions SET amount = ? WHERE id = ? AND branch_id = ?")) {
            stmt.setDouble(1, this.amount);
            stmt.setInt(2, this.id);
            stmt.setInt(3, this.branch.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}