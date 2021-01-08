//Made by Swonsonn
//01.01.2021
package AccessPoint;
import Scramblers.Roll.*;
import Scramblers.Replace.*;
import Scramblers.Combined.*;

public class GlobalCryptoModule {
    private Caesar caesar=new Caesar();             //1
    private Diogenes diogenes=new Diogenes();       //2
    private Socrates socrates=new Socrates();       //3
    private ID id=new ID();                         //4
    private Itajara itajara=new Itajara();          //5
    private SuperID superid=new SuperID();          //6
    private Heraklesz heraklesz=new Heraklesz();    //7
    private APE ape=new APE();                      //8
    
    private String InputMessage;
    private String OutputMessage;
    private String KeyString1;
    private String KeyString2;

    private int parse(String Key){
        boolean CorrectString=true;
        for(int i=0;i<Key.length();++i)
            if(Key.charAt(i)<48 || Key.charAt(i)>57){CorrectString=false;i+=Key.length();}
        if(CorrectString)return Integer.parseInt(Key);
        int temp=0;
        for(int i=0;i<Key.length();++i) {
            temp+=Key.charAt(i);
        }
        return temp;
    }

    public String crypt(String InputMessage, int method, String KeyString1, String KeyString2){
        this.InputMessage=InputMessage;
        this.KeyString1=KeyString1;
        this.KeyString2=KeyString2;
        
        switch(method){
            case 1:{
                caesar.Set(InputMessage, parse(KeyString1));
                caesar.MessageCrypt();
                OutputMessage=caesar.GetMessage();
                break;
            }
            case 2:{
                diogenes.Set(InputMessage, KeyString1);
                diogenes.MessageCrypt();
                OutputMessage=diogenes.GetMessage();
                break;
            }
            case 3:{
                socrates.Set(InputMessage, parse(KeyString1));
                socrates.MessageCrypt();
                OutputMessage=socrates.GetMessage();
                break;
            }
            case 4:{
                id.Set(InputMessage, parse(KeyString1));
                id.MessageCrypt();
                OutputMessage=id.GetMessage();break;
            }
            case 5:{
                itajara.Set(InputMessage, parse(KeyString1));
                itajara.MessageCrypt();
                OutputMessage=itajara.GetMessage();break;
            }
            case 6:{
                superid.Set(InputMessage, KeyString1);
                superid.MessageCrypt();
                OutputMessage=superid.GetMessage();break;
            }
            case 7:{
                heraklesz.Set(InputMessage, parse(KeyString1), parse(KeyString2));
                heraklesz.MessageCrypt();
                OutputMessage=heraklesz.GetMessage();break;
            }
            case 8:{
                ape.Set(InputMessage, parse(KeyString1));
                ape.MessageCrypt();
                OutputMessage=ape.GetMessage();break;
            }
        }
        return OutputMessage;
    }
    
    public String decrypt(String InputMessage, int method, String KeyString1, String KeyString2){
        this.InputMessage=InputMessage;
        this.KeyString1=KeyString1;
        this.KeyString2=KeyString2;
        
        switch(method){
            case 1:{
                caesar.Set(InputMessage, parse(KeyString1));
                caesar.MessageDecrypt();
                OutputMessage=caesar.GetMessage();break;
            }
            case 2:{
                diogenes.Set(InputMessage, KeyString1);
                diogenes.MessageDecrypt();
                OutputMessage=diogenes.GetMessage();break;
            }
            case 3:{
                socrates.Set(InputMessage, parse(KeyString1));
                socrates.MessageDecrypt();
                OutputMessage=socrates.GetMessage();break;
            }
            case 4:{
                id.Set(InputMessage, parse(KeyString1));
                id.MessageDecrypt();
                OutputMessage=id.GetMessage();break;
            }
            case 5:{
                itajara.Set(InputMessage, parse(KeyString1));
                itajara.MessageDecrypt();
                OutputMessage=itajara.GetMessage();break;
            }
            case 6:{
                superid.Set(InputMessage, KeyString1);
                superid.MessageDecrypt();
                OutputMessage=superid.GetMessage();break;
            }
            case 7:{
                heraklesz.Set(InputMessage, parse(KeyString1), parse(KeyString2));
                heraklesz.MessageDecrypt();
                OutputMessage=heraklesz.GetMessage();break;
            }
            case 8:{
                ape.Set(InputMessage, parse(KeyString1));
                ape.MessageDecrypt();
                OutputMessage=ape.GetMessage();break;
            }
        }
        return OutputMessage;
    }
}
