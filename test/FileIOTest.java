import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {


    FileIO fileIo = new FileIO();

    private String inFile = "src/customers.txt";
    List<PersonInfo> people;

    @Test
    public final void ReadfromFileTest() {                         //testa readData metoden

        List<PersonInfo> people = fileIo.readData(inFile);      //anropar metoden readData, parameter "inFile" som är vägen till "customers.txt" gör listan people
        String SSNTest = "7703021234";
        PersonInfo firstPerson = people.get(0);                       //firstPerson är första index i people

        assert (people.size() == 14);           //kollar att listan blev 14 personer som det skulle vara
        //assertFalse(people.size() == 14);                    //detta ger error! bra
        assert (people.size() != 13);                       //kollar att listan inte blev 13 personer
        //Assertions.assertEquals("770302123", firstPerson.getSecurityNumber());   //detta blev fel, bra
        Assertions.assertEquals(SSNTest, firstPerson.getSecurityNumber());     //fungerar! nu vet vi första objektet är rätt, alltså index 0 har samma securitynumber som den ska ha

        System.out.println(firstPerson.getSecurityNumber());                  //vill se utskrift av första index, blev rätt
        System.out.println(firstPerson.getName());
        System.out.println(firstPerson.getGymPaymentDate());

    }

    @Test
    public final void SendtoFileTest() {
        //vill testa att skicka med ett objekt i parameter, och då ska namnet printas ut först (för att se att objektet verkligen skrevs ut), blev fel innan man starta bra

        PersonInfo p = new PersonInfo("3", "Albert", "2002-02-02");             //test objekt, vill se att albert kommer ut

        fileIo.sendData(p, true);               //ska skicka namn och securitynumber från albert och aktuellt datum! istest för att inte skriva till samma fil som riktiga programmet

        boolean y = fileIo.fileContainsContent("test/testPTFil", "Albert");             //använder metoden fileContainsContent för att ta reda på att albert verkligen skrevs ut
        assert (y);                                                                                      //det stämmer! perfekt
    }
}

    //egna tankar, tidigare kod och bloopers

    //List<PersonInfo> outFileList = FileIO.readData(outFile);           //nu gör jag en lista på alla objekt som jag skrivit till outfile, detta för att leta efter p (den kan ju hamna senare)
    //gav out of bounds exception, metoden är inte gjord för detta test
    /*tanke, hur fungerar det o testa en metod som behöver en annan metod o testa fast den metoden behöver första metoden o test?*/

  /* @Test
           public final void testafilescontaincontent() {    //inte klart

        String a = "hellothere";
//fick problem vid 50, var liten bokstav på albert som var problemet...
        }

    }

     // String outFile = "test/testPTFil";                  //används senare vid skrivning till fil SPOILERS, användes aldrig



       /*
    @Test
    public void FileExistanceTest() {            //testade om  inFile existerar, hade problem med detta tidigt i arbetet, fungerade bara för absolute path, anropar dock javametod files.exist
      Path filePath = Paths.get(inFile);
      boolean fileExists = Files.exists(filePath);
      assertTrue(fileExists);
    } */

