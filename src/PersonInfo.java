public class PersonInfo {           //personInfo klassen, inkapsling, konstruktor, sparar setters även ifall de inte används just nu

    private String name;

    private String securityNumber;

    private String gymPaymentDate;


    public PersonInfo(String securityNumber, String name, String GymPaymentDate) {
        this.securityNumber = securityNumber;
        this.name = name;
        this.gymPaymentDate = GymPaymentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getGymPaymentDate() {
        return gymPaymentDate;
    }

    public void setGymPaymentDate(String gymPayment) {
        this.gymPaymentDate = gymPayment;
    }
}
