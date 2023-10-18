import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Eligable {

 //problem med tester pga betalande listan kommer ändras framöver i tiden, får skapa upp listan vid ett visst tillfälle.

   private boolean test = false;  //true vid tester
   PaymentDateHandler pdh = new PaymentDateHandler();
   FileIO fileio = new FileIO();                           //skapar upp instanser av PaymentDateHandler och FileIO

   private String inFile = "src/customers.txt";
   List<PersonInfo> medlemmar = fileio.readData(inFile);            //skapar stora listan med alla som varit medlemmar någongång
   // List<PersonInfo> betalande = pdh.payingCustomers(medlemmar, null);            //skapar upp en lista med betalande medlemmar (inom ett år) denna ska vi jämföra objektet med


    public PersonInfo currentMember (PersonInfo temp) {               //den ska ta in objektet i parameter (som vi fick i UserInput) och nu jämföra med listan på paying members

        List<PersonInfo> betalande;
        if (test) {
            LocalDate currentDate = LocalDate.parse("2023-10-17");                  //gör att betalande listan skapas och jämför med ett visst datum
            betalande = pdh.payingCustomers(medlemmar, currentDate);
        }
        else {
            betalande = pdh.payingCustomers(medlemmar, null);        //annars skapas den i realtid, ska vara null
        }

        boolean found = false;
        for (PersonInfo currentMember : betalande)                  //går igenom betalande listan
            if (currentMember.getName().equals(temp.getName())) {                        //om objektet i parametern har samma namn som något objekt i betalda listan
                if(!test) {                                            //om icke test
                    JOptionPane.showMessageDialog(null, temp.getName() + " är betalande kund!" + "\nInformation har skickats till PT:ns fil");
                }
                found = true;
             return currentMember;                                  //returnar vi objektet, detta kommer användas i fileIO för att skriva till fil

            }


        if (!found && !test) {
            JOptionPane.showMessageDialog(null, temp.getName() + " är före detta kund!");
            System.exit(0);
        }
 return null;
    }
}
/* temp och betalande är icke lika för den ena har parsat datum */
/*funkade ÄNTLIGEN efter att jag jämförde deras namn enbart, tror det var något med datum...*/
/* originelt if (currentMember.equals(temp)) if (currentMember.equals(temp)) { //tror jag hade fel sätt o jämföra */
