import java.util.List;

public class MainProgram {

    PersonInfo p;                                          //skapar upp instanser av klasser
    UserInput u = new UserInput();
    List<PersonInfo> theList;
    List<PersonInfo> thePayingList;
    FileIO fileio = new FileIO();
    Eligable elg = new Eligable();

    PaymentDateHandler pdh = new PaymentDateHandler();            //paymentdatehandler är klassen som jämför betalande kunder, och icke betalande kunder i filen

    private String inFile = "src/customers.txt";


   public MainProgram() {


      theList = fileio.readData(inFile);                           //här läser den in hela filen "Customers.txt sparas i en PersonInfo lista theList
       thePayingList = pdh.payingCustomers(theList, null);                //här jämförs alla personer som en gång varit kunder, om de är med i "theActiveList" allså betalande

       p = u.validateInput("temp");                                //p är objekt som står med i listan, om man skriver in en person som inte är med i listan så säger JOptionPane att input är obehörig
       p = elg.currentMember(p);                                       //här kollar programmet om p är current member, skivs ut
       fileio.sendData(p,false);                                 //här skickar det datat ifall man är medlem till en fil



   }




    public static void main(String[] args) {

        MainProgram main = new MainProgram();

    }
}