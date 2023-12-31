import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserInput {    //tar userinput och jämför med en lista av customers, listan skapas av FileIO
                            //returnar objekt, om inte finns så skrivs icke behörig
    FileIO fileIo = new FileIO();

    String inFile = "src/customers.txt";
    List<PersonInfo> giltigaObjekt = fileIo.readData(inFile);       //skapar upp listan av personerna i customers.txt, använder metoden readData i FileIO, dessa ska jämföras med input


    public PersonInfo validateInput(String test, boolean testEnvironment) {               //den kommer returna objekt av PersonInfo, test parameter är onödig i riktiga programmet, spelar bara roll för tester
        String s = null;

        if (testEnvironment) {
            s = test;        //s blir det vi ger in under testning istället för att få input

        } else {
            try {
                s = JOptionPane.showInputDialog(null, "Vad är personens namn eller personnummer?");
                if (s == null){                                                                                               //lade till detta pga fick exceptionerror om man tryckte på cancel... ops
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("något gick fel!");
                System.exit(0);
                e.printStackTrace();
            }
        }
        boolean found = false;
        for (PersonInfo temp : giltigaObjekt) {
            if (temp.getSecurityNumber().equalsIgnoreCase(s.trim()) || temp.getName().equalsIgnoreCase(s.trim())) {
                found = true;
                return temp;                   //returnar objektet i fråga / alltså personen med matchande personnummer eller namn
            }
        }
        if (!found) {
            if (testEnvironment) {                          //om test, pga annars stoppar JOptionPane testerna
                return null;
            } else {
                JOptionPane.showMessageDialog(null, s + " finns inte i filen, är därmed obehörig");
                System.exit(0);
            }
        }
        return null;
    }
}


//tidigare problem och tankar
/*  for (PersonInfo temp : giltigaObjekt) { tidiga problem, gick inte igenom loopen korrekt
               if (temp.getSecurityNumber().equals(s.trim()) || temp.getName().equals(s.trim())) {

                   return temp;
               }
                   else {
                       JOptionPane.showMessageDialog(null,s + "finns inte i filen, är därmed obehörig");
                       System.exit(0);

                   }
               }
 */
/* Testerna fastnar här... disaster lyckades lösa genom att göra en till testenvironment flag i slutet
 if (!found) {
            JOptionPane.showMessageDialog(null, s + "finns inte i filen, är därmed obehörig");
            System.exit(0);
        }
        return null;
 */