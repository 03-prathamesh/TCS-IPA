import java.util.*;

class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;
    private List<Patient> p;

    // constructor
    public Doctor(int doctorId, String doctorName, String specialization, List<Patient> p) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.p = p;
    }

    // getters
    public int getdoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Patient> getPatients() {
        return p;
    }

    // methods in doctor Class
    public static TreeSet<String> getUniqueIllness(List<Doctor> d, int dId) {
        TreeSet<String> ans = new TreeSet<>();
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getdoctorId() == dId) {
                for (int j = 0; j < d.get(i).p.size(); j++) {
                    ans.add(d.get(i).p.get(j).getIllness());
                }
            }
        }
        if (ans.isEmpty()) {
            System.out.println("Doctor Not Found");
        }
        return ans;
    }

    public static List<String> getDoctorsBySpecialization(List<Doctor> d, String specialization) {

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getSpecialization().equalsIgnoreCase(specialization)) {
                ans.add(d.get(i).getDoctorName());
            }
        }
        if (ans.isEmpty()) {
            System.out.println("No Doctor Found");
        }
        return ans;
    }
}

class Patient {

    private int patientId;
    private String patientName;
    private String illness;

    // parameterised constructors
    public Patient(int patientId, String patientName, String illness) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.illness = illness;
    }

    // getters
    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getIllness() {
        return illness;
    }

}

public class HostpitalManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Patient patie[]=new Patient[n];
        // Doctor d[]=new Doctor[n]; following is equivalent tthis
        List<Doctor> d = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            sc.nextLine();
            String q = sc.nextLine();
            String r = sc.nextLine();

            int m = sc.nextInt();
            sc.nextLine();
            List<Patient> pat = new ArrayList<>(); // object of patient class
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                sc.nextLine();
                String y = sc.nextLine();
                String z = sc.nextLine();
                pat.add(new Patient(x, y, z));
            }

            // d[i]=new Doctor(p,q,r,pat);
            d.add(new Doctor(p, q, r, pat));

        }

        int id = sc.nextInt();
        sc.nextLine();
        String specialization = sc.nextLine();

        TreeSet<String> h1 = Doctor.getUniqueIllness(d, id);
        for(String elem:h1){
            System.out.println(elem);
        }

        List<String>newDoc=Doctor.getDoctorsBySpecialization(d,specialization);
        //for calling the static methods, you need to use Doctor class with . operator(without creating the instance of that class)
        for(String s:newDoc){
            System.out.println(s);
        }
    }
}