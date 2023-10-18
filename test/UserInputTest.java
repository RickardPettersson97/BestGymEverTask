import org.junit.jupiter.api.Test;

import java.util.List;

public class UserInputTest {

/*
problem här, är att hur ska man möjligtvis kolla om input man får är "löjligt?" och felaktigt eller bara en person som inte är med i registret? lättaste hade ju varit att göra ifall man
får in ett input som inte matchar listan så är det varken det ena eller andra
t.ex. om någon anger "thathat thathatgbabgabgatgah" är detta en person som inte är med i filen eller ogiltigt input?
 */

    UserInput ji = new UserInput();


 @Test
    public final void validateInputTest () {
     String s = "margareta";                         //testar lägga in margareta
     PersonInfo result = ji.validateInput(s);
     assert(result == null);                          //den ska vara null
     //assert(result != null);                      //detta ger error tack och lov

      s = "    Ida Idylle";
     result = ji.validateInput(s);
     assert (result != null);                     //detta gav originellt error

     s = "        7605021234";
     result = ji.validateInput(s);
     assert (result != null);
     System.out.println(result.getName());   //bra rätt namn också
 }
}
/*  jag fick fel på båda sista testerna, ida idylle och 07050 etc... jag funderar på att problemet är jag råkar exit system efter första varve så loopet inte är jätte lyckat */
