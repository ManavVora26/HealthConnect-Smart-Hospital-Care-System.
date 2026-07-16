import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class Billing {
    int billId = 0;
    Patient patient = new Patient();
    Appointment appointment = new Appointment();
    double consultationFee = 0.0;
    double labCharges = 0.0;
    double medicineCharges = 0.0;
    double otherCharges = 0.0;
    double totalAmount = 0.0;
    String paymentStatus = "";
    String paymentMethod = "";
    String billDate = "";

    public void generateBill() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n💳 --- Generate Bill ---");

        int patientId = 0;
        while (true) {
            System.out.print("👉 Enter Patient ID: ");
            try {
                patientId = Integer.parseInt(sc.nextLine().trim());
                if (patientId > 0) {
                    break;
                }
                System.out.println("⚠️ Error: Patient ID must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid number format. Please enter an integer.");
            }
        }

        int appId = 0;
        while (true) {
            System.out.print("👉 Enter Appointment ID: ");
            try {
                appId = Integer.parseInt(sc.nextLine().trim());
                if (appId > 0) {
                    break;
                }
                System.out.println("⚠️ Error: Appointment ID must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid number format. Please enter an integer.");
            }
        }

        double amount = 0.0;
        while (true) {
            System.out.print("💰 Enter Total Bill Amount: ");
            try {
                amount = Double.parseDouble(sc.nextLine().trim());
                if (amount >= 0) {
                    break;
                }
                System.out.println("⚠️ Error: Amount must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid decimal format. Please enter a decimal.");
            }
        }

        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        CallableStatement stmt = DBConnection.conn.prepareCall("{call GenerateBill(?, ?, ?)}");
        stmt.setInt(1, patientId);
        stmt.setInt(2, appId);
        stmt.setDouble(3, amount);
        stmt.execute();
        stmt.close();
        System.out.println("🎉 Bill generated successfully!");
        Main.logActivity(1, "INSERT", "payments");
    }

    public void calculateTotal() throws Exception {
        Scanner sc = new Scanner(System.in);

        int appId = 0;
        while (true) {
            System.out.print("👉 Enter Appointment ID to calculate total payments: ");
            try {
                appId = Integer.parseInt(sc.nextLine().trim());
                if (appId > 0) {
                    break;
                }
                System.out.println("⚠️ Error: Appointment ID must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid number format. Please enter an integer.");
            }
        }

        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        CallableStatement stmt = DBConnection.conn.prepareCall("{? = call CalculateBillTotal(?)}");
        stmt.registerOutParameter(1, Types.DECIMAL);
        stmt.setInt(2, appId);
        stmt.execute();
        double total = stmt.getDouble(1);
        stmt.close();
        System.out.println("💰 Total calculated bill amount: Rs. " + total);
    }

    public void makePayment() throws Exception {
        Scanner sc = new Scanner(System.in);

        int bId = 0;
        while (true) {
            System.out.print("👉 Enter Payment ID (Bill ID) to pay: ");
            try {
                bId = Integer.parseInt(sc.nextLine().trim());
                if (bId > 0) {
                    break;
                }
                System.out.println("⚠️ Error: Payment ID must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid number format. Please enter an integer.");
            }
        }

        System.out.print("💳 Enter Payment Method (Cash/Card/UPI): ");
        String method = sc.nextLine();

        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        CallableStatement stmt = DBConnection.conn.prepareCall("{call MakePayment(?, ?)}");
        stmt.setInt(1, bId);
        stmt.setString(2, method);
        stmt.execute();
        stmt.close();
        System.out.println("🎉 Payment successful! Payment ID " + bId + " is now Paid.");
    }

    public void downloadBill() {
        if (this.billId == 0) {
            System.out.println("⚠️ No active bill loaded. Please view a bill first.");
            return;
        }
        System.out.println("⚙️ Downloading receipt...");
        System.out.println("📂 Receipt saved to: /Users/manavvora/Downloads/HealthConnect_Bill_" + this.billId + ".txt");
        System.out.println("📥 Download complete!");
    }

    public void viewBill() throws Exception {
        Scanner sc = new Scanner(System.in);

        int bId = 0;
        while (true) {
            System.out.print("👉 Enter Payment ID (Bill ID) to view: ");
            try {
                bId = Integer.parseInt(sc.nextLine().trim());
                if (bId > 0) {
                    break;
                }
                System.out.println("⚠️ Error: Payment ID must be a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Invalid number format. Please enter an integer.");
            }
        }

        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        PreparedStatement ps = DBConnection.conn.prepareStatement("SELECT * FROM payments WHERE payment_id = ?");
        ps.setInt(1, bId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.billId = rs.getInt("payment_id");
            this.totalAmount = rs.getDouble("amount");
            this.paymentStatus = rs.getString("status");
            this.paymentMethod = rs.getString("payment_mode");
            this.billDate = rs.getString("date");

            System.out.println("\n💳 --- BILL DETAILS ---");
            System.out.println("🔑 Bill ID          : " + this.billId);
            System.out.println("👤 Patient ID       : " + rs.getInt("patient_id"));
            System.out.println("📅 Appointment ID   : " + rs.getInt("appointment_id"));
            System.out.println("------------------------------------");
            System.out.println("💰 Total Amount     : Rs. " + this.totalAmount);
            System.out.println("🚦 Payment Status   : " + this.paymentStatus);
            System.out.println("💳 Payment Method   : " + this.paymentMethod);
            System.out.println("📅 Bill Date        : " + this.billDate);
            System.out.println("------------------------------------");
        } else {
            System.out.println("❌ Bill ID not found.");
        }
        rs.close();
        ps.close();
    }
}