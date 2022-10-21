package com.bitlabs.JDBCConnectivityExample;


public class App 
{
    public static void main( String[] args )
    {
        DaoInterface dao=new DaoImpl();
        Patient p=new Patient();
        p.setPid(101);
        p.setPname("Ramesh");
        p.setAge(34);
        p.setMobile(9234567890L);
        dao.patientRegistration(p);
        Patient p1=new Patient();
        p1.setPid(102);
        p1.setPname("suresh");
        p1.setAge(35);
        p1.setMobile(9265394390L);
        Patient p2=new Patient();
        p2.setPid(103);
        p2.setPname("kumar");
        p2.setAge(37);
        p2.setMobile(9876543989L);
       dao.patientRegistration(p);
       dao.patientRegistration(p1);
       dao.patientRegistration(p2);
       dao.viewAllPatients();
       p.setPname("rajesh");
       p.setPid(101);
       dao.updatePatient(p); 
       dao.getPatientInfo(102);
        
               
    }
}
