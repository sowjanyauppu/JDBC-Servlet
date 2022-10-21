package com.bitlabs.JDBCConnectivityExample;

public interface DaoInterface {
	//project  (abstract methods)
	public void patientRegistration(Patient p);
	public void viewAllPatients();
	public void updatePatient(Patient p);
	public void getPatientInfo(int pid);

}
