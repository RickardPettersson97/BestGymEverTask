import java.util.List;

public class MainProgram {

    PersonInfo p;                                          //skapar upp instanser av klasser
    UserInput u = new UserInput();
    FileIO fileio = new FileIO();
    Eligable elg = new Eligable();


   public MainProgram() {


       p = u.validateInput("temp", false);                                //p blir objekt som står med i listan, om man skriver in en person som inte är med i listan så säger JOptionPane att input är obehörig
       p = elg.currentMember(p, false);                                       //här kollar programmet om p är current member, skivs ut
       fileio.sendData(p,false);                                 //här skickar det datat ifall man är medlem till en fil


   }

    public static void main(String[] args) {

        MainProgram main = new MainProgram();

    }
}

/**problem, egna reflektioner och tankar
 getname, jag jämförde objekten och detta gav fel på testet, var jobbigt men kom på att till slut jämföra namnen istället
 detta problemet var i eligable!

 massor av logiska problem man behövde tänka på när man gör tester

 Logiskt problem, hur ska man testa om användaren lägger in ett felaktigt namn eller felaktigt input?
 Tänk om någon skrev exterminator300, ska detta vara "ogiltigt input" eller bara skriva "kunden har inte varit här tidigare?" väldigt svårt att
 ta hand om det på rätt sätt, någon kanske heter exterminator300.
 Bestämde mig för att allt som inte var del av personnumer eller namn på listan är "inte tidigare kund"

 Gjorde en separatmetod för att testa att data som skickats med senddata faktiskt finns i listan som skickats till... hur testar jag denna metod?
 Jag behöver ha data i en fil för att testa denna metod, men för att ha datat i filen behöver jag använda senddata som jag först vill testa med metoden som behöver senddata för att testas... om detta låter logiskt

 lite svårt med vad som ska vara i vilken klass, fortfarande aningen nybörjare med upplägg, blir svårare med TDD!

 Lite småproblem:

 Fick nullpointerexception pga råkade skicka med null i senddata ifall kunden var tidigare kund men ICKE nuvarande kund, fixade genom system.exit(0) ifall tidigare kund

 en till nullpointerexception vid första JOptionpane, om input var null, lade till ännu en systemexit ifall svaret var null.
 */