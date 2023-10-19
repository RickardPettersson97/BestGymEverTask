import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Eligable {     //i denna klass kollar vi om objektet är betalande eller tidigare betalande! tar hjälp av paymentdatehandler

 //problem med tester pga betalande listan kommer ändras framöver i tiden, får skapa upp listan vid ett visst tillfälle.

   PaymentDateHandler pdh = new PaymentDateHandler();
   FileIO fileio = new FileIO();                           //skapar upp instanser av PaymentDateHandler och FileIO

   private String inFile = "src/customers.txt";
   List<PersonInfo> medlemmar = fileio.readData(inFile);            //skapar stora listan med alla som varit medlemmar någongång

    public PersonInfo currentMember (PersonInfo temp, boolean test) {               //den ska ta in objektet i parameter (som vi fick i UserInput) och nu jämföra med listan på paying members

        List<PersonInfo> betalande;
        if (test) {
            LocalDate currentDate = LocalDate.parse("2023-10-17");                  //jämför ett specifikt datum för tester, pga tiden går framåt och utan detta så kommer testerna mislyckats så småningom (fryser tided vid 2023-10-17)
            betalande = pdh.payingCustomers(medlemmar, currentDate);
        }
        else {
            betalande = pdh.payingCustomers(medlemmar, null);        //annars skapas den i realtid, currentdate ska vara null för detta
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


        if (!found && !test) {                                                                                           //om det inte är test, och icke hittad så kommer dialogrutan visa att det är före detta kund
            JOptionPane.showMessageDialog(null, temp.getName() + " är före detta kund!");
            System.exit(0);
        }
 return null;
    }
}

// egna tankar här nere och tidigare misslyckanden
/* temp och betalande är icke lika för den ena har parsat datum */
/*funkade ÄNTLIGEN efter att jag jämförde deras namn enbart, tror det var något med datum...*/
/* originelt if (currentMember.equals(temp)) if (currentMember.equals(temp)) { //tror jag hade fel sätt o jämföra */
