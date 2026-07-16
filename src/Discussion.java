
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

// Class to manage communication between patient and doctor
public class Discussion {

    Appointment appointment = new Appointment();
    String message = "";
    Date time = new Date();

    // Method to send a message
    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n💬 --- Send Message ---");
        System.out.print("👉 Enter Patient ID: ");
        int patientId = Integer.parseInt(sc.nextLine());
        System.out.print("👉 Enter Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());
        System.out.print("💬 Enter Message Content: ");
        String msg = sc.nextLine();

        DBConnection db = new DBConnection();
        try (Connection conn = db.getConnection();
             CallableStatement stmt = conn.prepareCall("{call SendMessage(?, ?, ?)}")) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setString(3, msg);
            stmt.execute();
            System.out.println("🎉 Message sent successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error sending message: " + e.getMessage());
        }
    }

    // Method to view conversation history
    public void viewConversation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("👉 Enter Patient ID: ");
        int patientId = Integer.parseInt(sc.nextLine());
        System.out.print("👉 Enter Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());

        DBConnection db = new DBConnection();
        try (Connection conn = db.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ViewConversation(?, ?)}")) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n💬 --- Chat History ---");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("💬 Message: " + rs.getString("remarks"));
                }
                if (!found) {
                    System.out.println("📭 No conversation history found.");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error viewing conversation: " + e.getMessage());
        }
    }

    // Method to upload and share a report
    public void uploadReport() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n⚙️ --- Upload Report File to Discussion ---");
        System.out.print("👉 Enter Patient ID: ");
        int patientId = Integer.parseInt(sc.nextLine());
        System.out.print("👉 Enter Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());
        System.out.print("📁 Enter Report File Path (e.g. report.pdf): ");
        String filePath = sc.nextLine();

        DBConnection db = new DBConnection();
        try (Connection conn = db.getConnection();
             CallableStatement stmt = conn.prepareCall("{call SendMessage(?, ?, ?)}")) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setString(3, "📎 Attached Report File: " + filePath);
            stmt.execute();
            System.out.println("✅ File uploaded and shared in conversation successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error sharing uploaded report: " + e.getMessage());
        }
    }

    // Method to share a PDF document
    public void sharePDF() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n⚙️ --- Share PDF Document ---");
        System.out.print("👉 Enter Patient ID: ");
        int patientId = Integer.parseInt(sc.nextLine());
        System.out.print("👉 Enter Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());
        System.out.print("📄 Enter PDF File Path (e.g. invoice.pdf): ");
        String pdfPath = sc.nextLine();

        DBConnection db = new DBConnection();
        try (Connection conn = db.getConnection();
             CallableStatement stmt = conn.prepareCall("{call SendMessage(?, ?, ?)}")) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setString(3, "📄 Shared PDF Document: " + pdfPath);
            stmt.execute();
            System.out.println("✅ PDF document shared in conversation successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error sharing PDF: " + e.getMessage());
        }
    }
}