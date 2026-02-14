# MySQL Schema Design – Smart Clinic Management System

## Doctor Table
- doctor_id (INT, PRIMARY KEY, AUTO_INCREMENT)
- name (VARCHAR(100))
- speciality (VARCHAR(100))
- email (VARCHAR(100))
- phone (VARCHAR(15))

## Patient Table
- patient_id (INT, PRIMARY KEY, AUTO_INCREMENT)
- name (VARCHAR(100))
- email (VARCHAR(100))
- phone (VARCHAR(15))

## Appointment Table
- appointment_id (INT, PRIMARY KEY, AUTO_INCREMENT)
- appointment_time (DATETIME)
- doctor_id (INT, FOREIGN KEY REFERENCES Doctor(doctor_id))
- patient_id (INT, FOREIGN KEY REFERENCES Patient(patient_id))

## Prescription Table
- prescription_id (INT, PRIMARY KEY, AUTO_INCREMENT)
- details (TEXT)
- appointment_id (INT, FOREIGN KEY REFERENCES Appointment(appointment_id))
