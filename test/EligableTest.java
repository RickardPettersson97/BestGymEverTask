import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EligableTest {


    //skapade upp 2 personInfo objekt. ska testa att p1 verkligen är med i betalande kunder listan, och p2 icke är detta
    PersonInfo p1 = new PersonInfo("7703021234","Alhambra Aromes","2023-07-01");
    PersonInfo p2 = new PersonInfo("8204021234","Bear Belle","2019-12-02");

    Eligable elg = new Eligable();

    @Test
    public final void validateCurrentMemberFunction(){


        PersonInfo result1 = elg.currentMember(p1, true);
        assert(result1 != null);                          //detta, objekt p1 SKA vara en betalande medlem, pga det är Alhambra Aromes
        // assert(result1 == null);                       detta blev fel tack och lov

        PersonInfo result2 = elg.currentMember(p2, true);
        assert(result2 == null);                            //detta objekt är INTE betalande medlem, pga det är Bear Belle

    }


    //planer och fundering tidigt i TDD processen...
    /* här planerar jag att jämföra objektet / personen som är eller tidigare varit medlem och ta reda på vilket! sedan skriver jag ut ifall det är tidigare medlem eller inte
     *jämföra om det är betalande medlem eller inte?
     * om nutida medlem så låter jag fileIO göra skriften till en fil
     * skapa upp några personInfo objekt som jag vet är betalande, sedan jämför dessa med...
     * */


}
