package hello;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameListController {
    //private String nameTemp = getNameTemp();
    private String nameTemp = "%d. %s, %s, %s";
    private String gender = null;
    private String firstName = null;
    private String lastName = null;
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/entername")
    public void nameList(@RequestParam(value = "gender", defaultValue = "") String gender,
                         @RequestParam(value = "lastName", defaultValue = "Doe") String lastName,
                         @RequestParam(value = "firstName",defaultValue = "") String firstName) throws Exception {
        gender = gender.toUpperCase();
        if(gender.equals("F")) {
            if(firstName == null || firstName.isEmpty()) {
                firstName = "Jane";
            }
        }
        if(gender.equals("M")) {
            if(firstName == null || firstName.isEmpty()) {
                firstName = "John";

            }
        }
        if(!gender.equals("F") && !gender.equals("M")) {
            //System.out.println(gender);
            gender = "Tree";
            if(firstName == null || firstName.isEmpty()){
                firstName = "Popcorn";
            }

        }


        printNameToFile(counter, gender, lastName, firstName, nameTemp);

    }
    //extending a controller class from a non controller class creates a conflict atomiclong.
    public static void printNameToFile(AtomicLong counter, String gender, String lastName, String firstName, String nameTemp) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);
        File file = new File("namelist "+ timeStamp +".txt");
        if(!file.exists()){
            file.createNewFile();
            counter.set(0);
        }

        //Using FileWriter to write to the file
        //BufferWriter tells file writer how to write to the file.
        //True lets us change without overwriting.
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format(nameTemp, (counter.incrementAndGet()), gender, lastName, firstName));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
