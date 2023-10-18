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

    String outFile = "test/testPTFil";                  //används senare vid skrivning till fil
     private String inFile = "src/customers.txt";
     List<PersonInfo> people;

    @Test
    public final void ReadfromFileTest() {                         //final går inte o ändra metoden

        List<PersonInfo> people = fileIo.readData(inFile);      //anropar metoden readData, parameter "inFile" som är vägen till "customers.txt"
        String SSNTest = "7703021234";
        PersonInfo firstPerson = people.get(0);

        assert(people.size() == 14);           //kollar att listan blev 14 personer som det skulle vara
        //assertFalse(people.size() == 14);                    //detta ger error! bra
        assert(people.size() != 13);                       //kollar att listan inte blev 13 personer
        //Assertions.assertEquals("770302123", firstPerson.getSecurityNumber());   //detta blev fel, bra
        Assertions.assertEquals(SSNTest, firstPerson.getSecurityNumber());     //fungerar! nu vet vi första objektet är rätt

        System.out.println(firstPerson.getSecurityNumber());                  //vill se utskrift
        System.out.println(firstPerson.getName());
        System.out.println(firstPerson.getGymPaymentDate());

    }


    @Test
    public final void SendtoFileTest() {
        //vill testa att skicka med ett objekt i parameter, och då ska namnet printas ut först (för att se att objektet verkligen skrevs ut), blev fel innan man starta bra

        PersonInfo p = new PersonInfo("3", "Albert", "2002-02-02"); //test objekt, vill se att albert kommer ut

        fileIo.sendData(p, true); //ska skicka namn och securitynumber från albert och aktuellt datum! istest för att inte skriva till samma fil som riktiga programmet
        //List<PersonInfo> outFileList = FileIO.readData(outFile);           //nu gör jag en lista på alla objekt som jag skrivit till outfile, detta för att leta efter p (den kan ju hamna senare)
                                                                                      //gav out of bounds exception, metoden är inte gjord för detta test
        boolean y = fileIo.fileContainsContent("test/testPTFil", "Albert");
        assert(y);                                                                                    //fick problem vid 50, var liten bokstav på albert som var problemet...

    }

    /*tanke, hur fungerar det o testa en metod som behöver en annan metod o testa fast den metoden behöver första metoden o test?*/

  /* @Test
           public final void testafilescontaincontent() {    //inte klart

        String a = "hellothere";




        }






    }





       /*
    @Test
    public void FileExistanceTest() {            //testade om  inFile existerar, hade problem med detta tidigt i arbetet, fungerade bara för absolute path, anropar dock javametod files.exist
      Path filePath = Paths.get(inFile);
      boolean fileExists = Files.exists(filePath);
      assertTrue(fileExists);

    } */
}
