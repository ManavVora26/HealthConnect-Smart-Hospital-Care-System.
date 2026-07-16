import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DoctorFinder {

    public void searchBySpecialization() throws Exception {
        Scanner sc = new Scanner(System.in);

        String spec = "";
        while (true) {
            System.out.print("👉 Enter Specialization (e.g. Cardiologist, Dentist, Orthopedic, Pediatrician): ");
            spec = sc.nextLine().trim();
            boolean isValid = true;
            if (spec.isEmpty()) {
                isValid = false;
            } else {
                for (int i = 0; i < spec.length(); i++) {
                    char ch = spec.charAt(i);
                    if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ')) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                break;
            }
            System.out.println("⚠️ Error: Specialization must contain letters and spaces only.");
        }

        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        PreparedStatement ps = DBConnection.conn.prepareStatement("SELECT * FROM doctors WHERE specialization LIKE ?");
        ps.setString(1, "%" + spec + "%");
        ResultSet rs = ps.executeQuery();
        System.out.println("\n🔍 --- Search Results ---");
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("👨‍⚕️ Doctor ID: " + rs.getInt("doctor_id"));
            System.out.println("👤 Name     : " + rs.getString("name"));
            System.out.println("🩺 Specialty: " + rs.getString("specialization"));
            System.out.println("🏢 Room No  : " + rs.getString("room_no"));
            System.out.println("⏰ Schedule : " + rs.getString("availability"));
            System.out.println("🎓 Experience: " + rs.getInt("experience") + " years");
            System.out.println("💰 Consultation Fee: Rs. " + rs.getDouble("consultation_fee"));
            System.out.println("⭐ Average Rating: " + rs.getDouble("average_rating") + " stars");
            System.out.println("----------------------------------------");
        }
        if (!found) {
            System.out.println("📭 No doctors found with that specialization.");
        }
        rs.close();
        ps.close();
    }

    public void searchAvailableDoctors() throws Exception {
        if (DBConnection.conn == null || DBConnection.conn.isClosed()) {
            DBConnection.initialize();
        }
        PreparedStatement ps = DBConnection.conn.prepareStatement("SELECT * FROM doctors WHERE availability IS NOT NULL AND availability <> ''");
        ResultSet rs = ps.executeQuery();
        System.out.println("\n👨‍⚕️ --- Active/Available Doctors Today ---");
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.printf("👨‍⚕️ ID: %-3d | Name: %-22s | Specialty: %-15s | Room: %-5s | Hours: %-10s | Fee: Rs. %-5.2f | Rating: ⭐ %.2f\n",
                    rs.getInt("doctor_id"),
                    rs.getString("name"),
                    rs.getString("specialization"),
                    rs.getString("room_no"),
                    rs.getString("availability"),
                    rs.getDouble("consultation_fee"),
                    rs.getDouble("average_rating")
            );
        }
        if (!found) {
            System.out.println("📭 No available doctors found.");
        }
        rs.close();
        ps.close();
    }

    public void bookDoctor() throws Exception {
        System.out.println("\n📅 Redirecting you to booking menu...");
        Patient p = (Patient) Main.loggedInUser;
        p.bookAppointment();
    }
}