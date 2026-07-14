import java.util.Date;

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
    Date billDate = new Date();

    public void generateBill() {
    }

    public void calculateTotal() {
    }

    public void makePayment() {
    }

    public void downloadBill() {
    }

    public void viewBill() {
    }
}