import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDateHandler {    //returnar lista av BETALANDE medlemmar
//finns ett problem med min logik ifall medarbetare inte förstår att currentdate ska vara "null" för riktiga programmet...


     public List<PersonInfo> payingCustomers(List<PersonInfo> people, LocalDate currentDate) {        //returnar en personinfo lista, har som parameter en personinfo lista och currentdate för test
        if (currentDate == null) {                                                                    //om currendate är null (i riktiga programmet) så är det riktig tid som används, detta pga testning
            currentDate = LocalDate.now();
        }

        List<PersonInfo> payingCustomers = new ArrayList<>();
        LocalDate withinAYear = currentDate.minusYears(1);             //variabel för att checka av folk som betalade inom ett år

        for (PersonInfo temp : people) {                                         //loopar genom parameter listan
            LocalDate paymentDate = LocalDate.parse(temp.getGymPaymentDate());           //parsar gympaymentdate till date

            if (paymentDate.isAfter(withinAYear)) {                               //om detta datum var inom ett år sedan, så läggs dem på nya listan med betalande kunder!
                payingCustomers.add(temp);
            }
        }
        return payingCustomers;                     //returnerar ny lista med payingcustomers, alltså de som betalat inom senaste året,
    }
    }

/*

//egna tankar och tidigare kod som jag ändrat
tidigare försökskod, testade att ha en if else sats och testenvironment för att se ifall tester var igång! problemet är att det bara går att göra tester på ett datum (2023-10-17) så ändrar om till
parameter istället


    public static boolean testEnvironment = false;       //sätt true om test är pågång


    public List<PersonInfo> payingCustomers(List<PersonInfo> people) {                          //returnar en personinfo lista, har som parameter en personinfo lista

        List<PersonInfo> payingCustomers = new ArrayList<>();
        LocalDate currentDate;                                            //variabel currentDate

        if (testEnvironment) {
            currentDate = LocalDate.parse("2023-10-17");              //currentdate är ett specifikt värde om testenvironment är på! pga svårt att göra tester med aktivt ökande tid
        }
        else {
            currentDate = LocalDate.now();                                    //annars är currentDate nutid
        }

        LocalDate withinAYear = currentDate.minusYears(1);             //variabel för att checka av folk som betalade inom ett år

        for (PersonInfo temp : people) {                                         //loopar genom parameter listan
            LocalDate paymentDate = LocalDate.parse(temp.getGymPaymentDate());           //parsar gympaymentdate till date

            if (paymentDate.isAfter(withinAYear)) {                               //om detta datum var inom ett år sedan, så läggs dem på nya listan med betalande kunder!
                payingCustomers.add(temp);
            }
        }
        return payingCustomers;
    }
}
 */