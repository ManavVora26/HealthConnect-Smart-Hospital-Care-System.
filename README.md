# HealthConnect-Smart-Hospital-Care-System.
MY BTECH SEM-II Project
---

### **Project Title:**

**HealthConnect – Smart Hospital & Healthcare  System**

### **Project Overview:**

The objective of this project is to develop a healthcare management system for government hospitals that solves real-life problems such as long waiting queues, manual patient records, inefficient appointment management, and lack of centralized medical history.

Instead of creating a simple hospital management system, the project focuses on improving the complete patient journey—from booking an appointment to follow-up care—while utilizing concepts from all three subjects: **Computer Programming using Java-II, Data Structures using Java, and DBMS**.

### **Proposed Features**

- Smart appointment booking and digital token generation
- Live queue management with priority for emergency cases, senior citizens, children, and pregnant women
- Digital Health ID for maintaining complete patient medical history
- Digital patient records (reports, prescriptions, allergies, vaccination history, lab reports)
- Doctor dashboard and patient dashboard
- Secure doctor-patient follow-up communication
- Digital prescriptions with medicine schedule
- Personalized diet recommendations based on diagnosis
- Medicine reminders and follow-up reminders
- Doctor search and appointment scheduling
- Analytics dashboard for doctors
- Scope for future AI-based features such as symptom triage, waiting-time prediction, and report summarization

### **Use of Semester-2 Syllabus**

**Computer Programming using Java-II**

- OOP concepts (Abstraction, Inheritance, Interfaces, Polymorphism)
- Exception Handling
- Collections Framework
- Multithreading
- File Handling
- JDBC Connectivity

**Data Structures using Java**

- Queue & Priority Queue for patient queue management
- Stack for Undo operations
- Linked Lists for dynamic records
- Trees for hospital/department hierarchy
- Hashing for fast Health ID and patient lookup

**DBMS**

- Database design and normalization
- SQL queries, joins, subqueries
- Constraints
- Transactions (Commit/Rollback)
- Stored Procedures
- Stored Functions
- Triggers
- Cursors
- Query Optimization

### **Future Scope**

The system can later be integrated with government healthcare initiatives such as **ABHA (Ayushman Bharat Health Account)**, telemedicine services, and referral management between PHCs, CHCs, and district hospitals.

This project aims to solve a real-world healthcare problem while demonstrating the practical application of the concepts covered in our Semester-2 syllabus.

### **Code For ER-Diagram**


     digraph HMS_Table_Schema_Compact {
    // Layout settings for maximum compactness (no forced stretching)
    graph [
        rankdir=TB, 
        splines=ortho, 
        nodesep=0.1,   // Extremely tight horizontal spacing
        ranksep=0.2,   // Extremely tight vertical spacing
        fontname="Arial",
        margin=0
    ];
    node [shape=none, fontname="Arial", fontsize=9];
    edge [fontname="Arial", fontsize=9, color="#555555"];

    
    USERS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>USERS</B></TD></TR>
      <TR><TD ALIGN="LEFT">user_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">username</TD></TR>
      <TR><TD ALIGN="LEFT">password</TD></TR>
      <TR><TD ALIGN="LEFT">role</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
      <TR><TD ALIGN="LEFT">created_at</TD></TR>
    </TABLE>>];

    DEPARTMENTS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>DEPARTMENTS</B></TD></TR>
      <TR><TD ALIGN="LEFT">department_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">department_name</TD></TR>
      <TR><TD ALIGN="LEFT">floor</TD></TR>
      <TR><TD ALIGN="LEFT">description</TD></TR>
    </TABLE>>];

    DOCTORS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>DOCTORS</B></TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">name</TD></TR>
      <TR><TD ALIGN="LEFT">specialization</TD></TR>
      <TR><TD ALIGN="LEFT">department_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">qualification</TD></TR>
      <TR><TD ALIGN="LEFT">experience</TD></TR>
      <TR><TD ALIGN="LEFT">phone</TD></TR>
      <TR><TD ALIGN="LEFT">email</TD></TR>
      <TR><TD ALIGN="LEFT">room_no</TD></TR>
      <TR><TD ALIGN="LEFT">availability</TD></TR>
      <TR><TD ALIGN="LEFT">consultation_fee</TD></TR>
    </TABLE>>];

    PATIENTS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>PATIENTS</B></TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">health_id</TD></TR>
      <TR><TD ALIGN="LEFT">first_name</TD></TR>
      <TR><TD ALIGN="LEFT">last_name</TD></TR>
      <TR><TD ALIGN="LEFT">gender</TD></TR>
      <TR><TD ALIGN="LEFT">dob</TD></TR>
      <TR><TD ALIGN="LEFT">blood_group</TD></TR>
      <TR><TD ALIGN="LEFT">phone</TD></TR>
      <TR><TD ALIGN="LEFT">email</TD></TR>
      <TR><TD ALIGN="LEFT">address</TD></TR>
      <TR><TD ALIGN="LEFT">city</TD></TR>
      <TR><TD ALIGN="LEFT">state</TD></TR>
      <TR><TD ALIGN="LEFT">pincode</TD></TR>
      <TR><TD ALIGN="LEFT">aadhaar</TD></TR>
      <TR><TD ALIGN="LEFT">abha_id</TD></TR>
      <TR><TD ALIGN="LEFT">height</TD></TR>
      <TR><TD ALIGN="LEFT">weight</TD></TR>
      <TR><TD ALIGN="LEFT">emergency_contact</TD></TR>
      <TR><TD ALIGN="LEFT">registration_date</TD></TR>
    </TABLE>>];

    APPOINTMENTS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>APPOINTMENTS</B></TD></TR>
      <TR><TD ALIGN="LEFT">appointment_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">appointment_date</TD></TR>
      <TR><TD ALIGN="LEFT">appointment_time</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
      <TR><TD ALIGN="LEFT">token_number</TD></TR>
      <TR><TD ALIGN="LEFT">priority</TD></TR>
      <TR><TD ALIGN="LEFT">booking_type</TD></TR>
      <TR><TD ALIGN="LEFT">remarks</TD></TR>
    </TABLE>>];

    TOKENS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>TOKENS</B></TD></TR>
      <TR><TD ALIGN="LEFT">token_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">appointment_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">token_number</TD></TR>
      <TR><TD ALIGN="LEFT">queue_position</TD></TR>
      <TR><TD ALIGN="LEFT">estimated_wait_time</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
    </TABLE>>];

    QUEUE [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>QUEUE</B></TD></TR>
      <TR><TD ALIGN="LEFT">queue_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">priority_level</TD></TR>
      <TR><TD ALIGN="LEFT">queue_number</TD></TR>
      <TR><TD ALIGN="LEFT">arrival_time</TD></TR>
      <TR><TD ALIGN="LEFT">served_time</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
    </TABLE>>];

    PRESCRIPTIONS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>PRESCRIPTIONS</B></TD></TR>
      <TR><TD ALIGN="LEFT">prescription_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">visit_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">diagnosis</TD></TR>
      <TR><TD ALIGN="LEFT">notes</TD></TR>
      <TR><TD ALIGN="LEFT">created_date</TD></TR>
    </TABLE>>];

    PRESCRIPTION_MEDICINES [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>PRESCRIPTION_MEDICINES</B></TD></TR>
      <TR><TD ALIGN="LEFT">id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">prescription_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">medicine_name</TD></TR>
      <TR><TD ALIGN="LEFT">dosage</TD></TR>
      <TR><TD ALIGN="LEFT">morning</TD></TR>
      <TR><TD ALIGN="LEFT">afternoon</TD></TR>
      <TR><TD ALIGN="LEFT">night</TD></TR>
      <TR><TD ALIGN="LEFT">days</TD></TR>
    </TABLE>>];

    MEDICAL_HISTORY [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>MEDICAL_HISTORY</B></TD></TR>
      <TR><TD ALIGN="LEFT">history_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">disease</TD></TR>
      <TR><TD ALIGN="LEFT">allergy</TD></TR>
      <TR><TD ALIGN="LEFT">surgery</TD></TR>
      <TR><TD ALIGN="LEFT">family_history</TD></TR>
      <TR><TD ALIGN="LEFT">description</TD></TR>
    </TABLE>>];

    LAB_TESTS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>LAB_TESTS</B></TD></TR>
      <TR><TD ALIGN="LEFT">test_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">test_name</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
      <TR><TD ALIGN="LEFT">test_date</TD></TR>
      <TR><TD ALIGN="LEFT">report_file</TD></TR>
    </TABLE>>];

    VACCINATIONS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>VACCINATIONS</B></TD></TR>
      <TR><TD ALIGN="LEFT">vaccination_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">vaccine_name</TD></TR>
      <TR><TD ALIGN="LEFT">date</TD></TR>
      <TR><TD ALIGN="LEFT">next_due</TD></TR>
    </TABLE>>];

    FOLLOW_UP [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>FOLLOW_UP</B></TD></TR>
      <TR><TD ALIGN="LEFT">followup_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">next_visit</TD></TR>
      <TR><TD ALIGN="LEFT">remarks</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
    </TABLE>>];

    REMINDERS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>REMINDERS</B></TD></TR>
      <TR><TD ALIGN="LEFT">reminder_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">type</TD></TR>
      <TR><TD ALIGN="LEFT">date</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
    </TABLE>>];

    DIET_PLAN [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>DIET_PLAN</B></TD></TR>
      <TR><TD ALIGN="LEFT">diet_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">breakfast</TD></TR>
      <TR><TD ALIGN="LEFT">lunch</TD></TR>
      <TR><TD ALIGN="LEFT">snacks</TD></TR>
      <TR><TD ALIGN="LEFT">dinner</TD></TR>
      <TR><TD ALIGN="LEFT">water</TD></TR>
      <TR><TD ALIGN="LEFT">instructions</TD></TR>
    </TABLE>>];

    PHARMACY [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>PHARMACY</B></TD></TR>
      <TR><TD ALIGN="LEFT">medicine_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">medicine_name</TD></TR>
      <TR><TD ALIGN="LEFT">stock</TD></TR>
      <TR><TD ALIGN="LEFT">expiry</TD></TR>
      <TR><TD ALIGN="LEFT">price</TD></TR>
      <TR><TD ALIGN="LEFT">manufacturer</TD></TR>
    </TABLE>>];

    MEDICINE_ISSUE [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>MEDICINE_ISSUE</B></TD></TR>
      <TR><TD ALIGN="LEFT">issue_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">medicine_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">quantity</TD></TR>
      <TR><TD ALIGN="LEFT">issue_date</TD></TR>
    </TABLE>>];

    PAYMENTS [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>PAYMENTS</B></TD></TR>
      <TR><TD ALIGN="LEFT">payment_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">appointment_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">amount</TD></TR>
      <TR><TD ALIGN="LEFT">payment_mode</TD></TR>
      <TR><TD ALIGN="LEFT">status</TD></TR>
      <TR><TD ALIGN="LEFT">date</TD></TR>
    </TABLE>>];

    FEEDBACK [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>FEEDBACK</B></TD></TR>
      <TR><TD ALIGN="LEFT">feedback_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">patient_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">doctor_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">rating</TD></TR>
      <TR><TD ALIGN="LEFT">comments</TD></TR>
      <TR><TD ALIGN="LEFT">date</TD></TR>
    </TABLE>>];

    LOGIN_HISTORY [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>LOGIN_HISTORY</B></TD></TR>
      <TR><TD ALIGN="LEFT">login_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">user_id (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">login_time</TD></TR>
      <TR><TD ALIGN="LEFT">logout_time</TD></TR>
      <TR><TD ALIGN="LEFT">ip_address</TD></TR>
    </TABLE>>];

    AUDIT_LOG [label=<
    <TABLE BORDER="0" CELLBORDER="1" CELLSPACING="0">
      <TR><TD BGCOLOR="#DAE8FC"><B>AUDIT_LOG</B></TD></TR>
      <TR><TD ALIGN="LEFT">log_id (PK)</TD></TR>
      <TR><TD ALIGN="LEFT">user (FK)</TD></TR>
      <TR><TD ALIGN="LEFT">operation</TD></TR>
      <TR><TD ALIGN="LEFT">table_name</TD></TR>
      <TR><TD ALIGN="LEFT">timestamp</TD></TR>
    </TABLE>>];

// ==========================================
// 2. ALL RELATIONSHIPS (Without Cardinality)
// ==========================================

DEPARTMENTS -> DOCTORS;
PATIENTS -> APPOINTMENTS;
DOCTORS -> APPOINTMENTS;
APPOINTMENTS -> TOKENS;
PATIENTS -> QUEUE;
DOCTORS -> QUEUE;
USERS -> LOGIN_HISTORY;
USERS -> AUDIT_LOG;
PATIENTS -> PRESCRIPTIONS;
DOCTORS -> PRESCRIPTIONS;
APPOINTMENTS -> PRESCRIPTIONS;
PRESCRIPTIONS -> PRESCRIPTION_MEDICINES;
PATIENTS -> MEDICAL_HISTORY;
PATIENTS -> LAB_TESTS;
DOCTORS -> LAB_TESTS;
PATIENTS -> VACCINATIONS;
PATIENTS -> DIET_PLAN;
DOCTORS -> DIET_PLAN;
PATIENTS -> FOLLOW_UP;
DOCTORS -> FOLLOW_UP;
PATIENTS -> REMINDERS;
PHARMACY -> MEDICINE_ISSUE;
PATIENTS -> MEDICINE_ISSUE;
PATIENTS -> PAYMENTS;
APPOINTMENTS -> PAYMENTS;
PATIENTS -> FEEDBACK;
DOCTORS -> FEEDBACK;
}
