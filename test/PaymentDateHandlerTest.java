import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDateHandlerTest {
    //planerar o använda denna klass för att göra en ny lista som jämfördatum på payment, alltså få en lista på nuvarande medlemmar, funderade på att ha detta i PersonInfo först...

    FileIO fileIo = new FileIO();
    PaymentDateHandler payment = new PaymentDateHandler();
    String inFile = "src/customers.txt";
    List<PersonInfo> people = fileIo.readData(inFile);         //kallar på readData metoden för att skapa upp listan
    List<PersonInfo> payingCustomer = new ArrayList<>();
    List<PersonInfo> payingCustomer2 = new ArrayList<>();

    @Test
    public final void PayingCustomerListTest() {    //här ska jag testa om en metod som jämför datum och skapar en lista av betalande kunder verkligen fungerar

        LocalDate currentDate = LocalDate.parse("2023-10-17");
        payingCustomer = payment.payingCustomers(people, currentDate);
        assert (payingCustomer.size() == 5);                                 //det ska vara 5 betalande kunder, som betalade avgiften efter 2022-10-17
        assert (payingCustomer.size() != 3);
        //assert (payingCustomer.size() == 4);                               //detta blir fel! bra


        currentDate = LocalDate.parse("2024-02-05");
        payingCustomer2 = payment.payingCustomers(people, currentDate);
        assert (payingCustomer2.size() == 3);                                 //det ska vara 3 betalande kunder, som betalade avgiften efter 2023-02-05
        assert (payingCustomer.size() != 2);
        //assert (payingCustomer.size() == 4);                          //detta blir fel! bra


    }
}









//tidiga planer var att skapa upp listan people genom metoden readData i FiloIO, och sedan assert att (genom att räkna manuellt) X mängd person är betalande kunder... Men detta funkar INTE
//pga att kraven för testerna är att de inte är bundna till ett visst datum, vilket de hade varit annars...

/*
  String inFile = "src/customers.txt";
    List<PersonInfo> people = FileIO.readData(inFile);         //kallar på readData metoden för att skapa upp listan
    List<PersonInfo> payingCustomer = new ArrayList<>();

   @Test
   public final void PayingCustomerListTest() {    //här ska jag testa om en metod som jämför datum och skapar en lista av betalande kunder verkligen fungerar
         payingCustomer = payment.payingCustomers(people);          //blir fel innan skapande av metod, ropar på metod payingCustomers anger people, ska ge oss PayingCustomer listan

       assert(payingCustomer.size() ==)
 */