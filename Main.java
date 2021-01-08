import AccessPoint.GlobalCryptoModule;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName=args[0];
        File file=new File(fileName);
        Scanner inPut=new Scanner(file);
        GlobalCryptoModule module=new GlobalCryptoModule();

        String MESSAGE="pepega",KEY1="1",KEY2="2",METHOD="1",WAY="crypt";
        WAY=args[1];
        METHOD=args[2];
        MESSAGE=inPut.nextLine();
        KEY1=inPut.nextLine();
        KEY2=inPut.nextLine();
        inPut.close();

        if(WAY.equals("crypt"))MESSAGE=module.crypt(MESSAGE,Integer.parseInt(METHOD),KEY1,KEY2);
        else MESSAGE=module.decrypt(MESSAGE,Integer.parseInt(METHOD),KEY1,KEY2);

        FileWriter outPut=new FileWriter(fileName);
        outPut.write(MESSAGE);
        outPut.close();
    }
}
