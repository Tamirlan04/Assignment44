package Assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Branch {
    private int id;
    private String name;
    private Bank bank;
    private List<Contribution> deposits;

    public Branch(int id, String name, Bank bank) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.deposits = new ArrayList<>();
        loadDepositsFromDatabase();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public List<Contribution> getDeposits() {
        return deposits;
    }

    public void addDeposit(Contribution deposit) {
        deposits.add(deposit);
        saveDepositToDatabase(deposit);
    }

    public void removeDeposit(Contribution deposit) {
        deposits.remove(deposit);
        removeDepositFromDatabase(deposit);
    }

    public double getTotalDepositAmount() {
        double total = 0;
        for (Contribution deposit : deposits) {
            total += deposit.getAmount();
        }
        return total;
    }

    private void loadDepositsFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contributions WHERE branch_id = ?")) {
            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contribution deposit = new Contribution(rs.getInt("id"), rs.getString("depositors_name"), rs.getDouble("amount"), this);
                deposits.add(deposit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveDepositToDatabase(Contribution deposit) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO contributions (depositors_name, amount, branch_id) VALUES (?, ?, ?)")) {
            stmt.setString(1, deposit.getDepositorsName());
            stmt.setDouble(2, deposit.getAmount());
            stmt.setInt(3, this.id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeDepositFromDatabase(Contribution deposit) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM contributions WHERE id = ? AND branch_id = ?")) {
            stmt.setInt(1, deposit.getId());
            stmt.setInt(2, this.id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}