package Assignment4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        createTables();
        Bank bank = new Bank("National");
        Branch branch1 = new Branch("Main", bank);
        Branch branch2 = new Branch("Secondary", bank);
        bank.addBranch(branch1);
        bank.addBranch(branch2);

        new AdvancedGUI(bank);
    }

    private static void createTables() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String createBranchesTable = "CREATE TABLE IF NOT EXISTS branches (" +
                    "name VARCHAR(255) PRIMARY KEY," +
                    "bank_name VARCHAR(255)" +
                    ")";
            stmt.execute(createBranchesTable);

            String createContributionsTable = "CREATE TABLE IF NOT EXISTS contributions (" +
                    "id SERIAL PRIMARY KEY," +
                    "depositors_name VARCHAR(255)," +
                    "amount DOUBLE PRECISION," +
                    "branch_name VARCHAR(255)" +
                    ")";
            stmt.execute(createContributionsTable);
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}