import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public List<PersonInfo> readData(String readFile) {   //returnar en List av objekt läst från filen Customers.txt (anges som parameter)

        List<PersonInfo> people = new ArrayList<>();

        String paymentDate;                                 //variabler
        String temp;
        String [] twoData;

        Path inFilePath = Paths.get(readFile);    //skapar path till parameter (kommer vara src/customers.txt i detta projekt vi har som parameter)
        String filePathString = inFilePath.toString();  //behöver göra detta till string pga fileReader kräver detta, den tar inte en path

        try (BufferedReader bufRead = new BufferedReader(new FileReader(filePathString))) {                    //try with resources, hade problem med fileReader inte tar path, gjorde till string
            while ((temp = bufRead.readLine()) != null) {

                twoData = temp.split(",");                                          //splitras vid ,
                paymentDate = bufRead.readLine();                                           //paymentDate blir nästa rad (datum)

                PersonInfo person = new PersonInfo(twoData[0].trim(), twoData[1].trim(), paymentDate.trim());       //skapar personobjekt med twodata och paymentdate
                people.add(person);                                                            //läggs in i people listan, sedan börjar "while" om igen tills det är slut på rader o läsa från
            }

        }catch (FileNotFoundException e) {                              //file not found exception
            System.out.println("hittade inte filen");
            e.printStackTrace();
            System.exit(0);

        } catch (Exception e) {                                                              //fångar exceptions och printarstacktrace
            System.out.println("något gick fel");
            e.printStackTrace();
            System.exit(0);
        }

      return people;                         //returnar people

    }

    public String sendData(PersonInfo temp, boolean isTest) {       //skickar data till en PT fil, om kunden är betalande

        Path p;
        if (isTest) {

            p = Paths.get("test/testPTFil");                         //olika paths beroende på om det är test eller inte
        }
        else {
            p = Paths.get("src/PTfil");
        }

        try {
        if (!Files.exists(p)) {                                                             //skapar upp filen ifall den inte finns
            Files.createFile(p);
        }
    }catch (IOException e) {
            System.out.println("du har fått IOexception");
            e.printStackTrace();
        }
        try(BufferedWriter bw = Files.newBufferedWriter(p, StandardOpenOption.APPEND)){         //Appendar, verkade fungera bra så inte gammalt content försvinner


            LocalDate actualDate = LocalDate.now();                   //variabler actualdate blir dagen sedan skrivs namn,personnummer, och dagen (nu) de tränade till PTfil
            bw.write("\n");                                             //empty line, lättare o läsa då
            bw.write(temp.getName());
            bw.write("\n");
            bw.write((temp.getSecurityNumber()));
            bw.write("\n");
            bw.write(actualDate.toString());
            bw.write("\n");



        } catch (IOException e) {                                                         //exceptionhantering
            System.out.println("du har fått IOexception");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("har du lagt in null i parametern?");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("det blev okänt fel");
            e.printStackTrace();
        }

        return null;
    }

    public boolean fileContainsContent(String filePath, String testword) {         //metod som hjälper till att testa ifall en fil innehåller ett ord (testword), för att se att vårt test gick igenom

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String temp;
            while((temp = reader.readLine()) != null) {
                if (temp.contains(testword)) {
                    return true;
                }
            }

        } catch (IOException e) {                      //exceptionhantering
            e.printStackTrace();
        }
        return false;

    }
}

//egna lärdommar
//  temp.splitline();
//tror jag hade src innan jag förstod att det var fel att filereader inte kunde läsa från path, funkade senare när jag ändra till src