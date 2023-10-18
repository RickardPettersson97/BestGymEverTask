import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EligableTest {
    /* här planerar jag att jämföra objektet / personen som är eller tidigare varit medlem och ta reda på vilket! sedan skriver jag ut ifall det är tidigare medlem eller inte
    *  om nutida medlem så låter jag fileIO göra skriften till en fil
    * skapa upp några personInfo objekt som jag vet är betalande, sedan jämför dessa med...
    * */

    //skapade upp 2 personInfo objekt. ska testa att första verkligen är med i betalande kunder listan, och andra icke är detta
    PersonInfo p1 = new PersonInfo("7703021234","Alhambra Aromes","2023-07-01");
    PersonInfo p2 = new PersonInfo("8204021234","Bear Belle","2019-12-02");

    Eligable elg = new Eligable();

    @Test
    public final void validateCurrentMemberFunction(){


        PersonInfo result1 = elg.currentMember(p1);
        assert(result1 != null);
        // assert(result1 == null); den blev fel tack och lov

        PersonInfo result2 = elg.currentMember(p2);
        assert(result2 == null);

    }






}
