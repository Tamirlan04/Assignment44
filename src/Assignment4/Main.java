package Assignment4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        createTables();
        Bank bank = new Bank(1, "National");
        Branch branch1 = new Branch(1, "Main", bank);
        Branch branch2 = new Branch(2, "Secondary", bank);
        bank.addBranch(branch1);
        bank.addBranch(branch2);

        new AdvancedGUI(bank);
    }

    private static void createTables() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String createBanksTable = "CREATE TABLE IF NOT EXISTS banks (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(255)" +
                    ")";
            stmt.execute(createBanksTable);

            String createBranchesTable = "CREATE TABLE IF NOT EXISTS branches (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "bank_id INTEGER REFERENCES banks(id)" +
                    ")";
            stmt.execute(createBranchesTable);

            String createContributionsTable = "CREATE TABLE IF NOT EXISTS contributions (" +
                    "id SERIAL PRIMARY KEY," +
                    "depositors_name VARCHAR(255)," +
                    "amount DOUBLE PRECISION," +
                    "branch_id INTEGER REFERENCES branches(id)" +
                    ")";
            stmt.execute(createContributionsTable);
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}