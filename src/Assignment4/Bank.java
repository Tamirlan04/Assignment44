package Assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int id;
    private String name;
    private List<Branch> branches;

    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
        this.branches = new ArrayList<>();
        loadBranchesFromDatabase();
    }

    public int getId() {
        return id;
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
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM branches WHERE bank_id = ?")) {
            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Branch branch = new Branch(rs.getInt("id"), rs.getString("name"), this);
                branches.add(branch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveBranchToDatabase(Branch branch) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO branches (name, bank_id) VALUES (?, ?)")) {
            stmt.setString(1, branch.getName());
            stmt.setInt(2, this.id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}