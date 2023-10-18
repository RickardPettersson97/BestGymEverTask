import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public boolean testEnvironment = false;     //sätt true om det är test pågång
    FileIO fileIo = new FileIO();

    String inFile = "src/customers.txt";
    List<PersonInfo> giltigaObjekt = fileIo.readData(inFile);       //skapar upp listan av 14 personinfo som vi testade förut, dessa ska jämföras


    public PersonInfo validateInput(String test) {               //den kommer returna objekt av PersonInfo
        String s = null;

        if (testEnvironment) {
            s = test;        //s blir det vi ger in under testning istället för att få input

        } else {
            try {
                s = JOptionPane.showInputDialog(null, "Vad är personens namn eller personnummer?");
                if (s == null){                                                                                               //lade till detta pga fick exceptionerror om man tryckte på cancel
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
                found = true;                                                                           //den är väl visst använd?
                return temp;                   //returnar objektet i fråga / personen med personnummer eller namnet
            }
        }
        if (!found) {
            if (testEnvironment) {
                return null;
            } else {
                JOptionPane.showMessageDialog(null, s + " finns inte i filen, är därmed obehörig");
                System.exit(0);
            }

        }
        return null;
    }
}





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