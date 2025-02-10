package Assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
        loadBranchesFromDatabase();
    }

    public String getName() {
        return name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
        saveBranchToDatabase(branch);
    }

    private void loadBranchesFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM branches WHERE bank_name = ?")) {
            stmt.setString(1, this.name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Branch branch = new Branch(rs.getString("name"), this);
                branches.add(branch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveBranchToDatabase(Branch branch) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO branches (name, bank_name) VALUES (?, ?)")) {
            stmt.setString(1, branch.getName());
            stmt.setString(2, this.name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}