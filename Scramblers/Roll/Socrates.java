//Made by Swonsonn
//29.12.2020
package Scramblers.Roll;
import Raw.producer;
import java.util.Random;

public class Socrates extends producer{
    int Key;
    
    public Socrates(){};
    
    public void Set(String Message,int Key){
        this.Key=Key;
        SetMessage(Message);
    }
    
     @Override
    public void MessageCrypt(){
        Random rand = new Random(Key);
        int Roll;
        char Handler[]=new char[MessageToHandle.length()];
        for(int i=0;i<MessageToHandle.length();++i){
            Roll=rand.nextInt(100);
            Handler[i]=MessageToHandle.charAt(i);
            if(Handler[i]=='ё') Handler[i]='е';
            if(Handler[i]=='Ё') Handler[i]='Е';
            String temp="";
            temp+=Handler[i];
            int Symbol=SymbolDefiner(temp);
            int ArSize=0, LowerBorder=0, UpperBorder=0, proc;
            switch(Symbol){
                case 1 : {
                    ArSize=AlphabetRussianL.length();
                    LowerBorder=1072;
                    UpperBorder=1103;break;
                }
                case 2 : {
                    ArSize=AlphabetEnglishL.length();
                    LowerBorder=97;
                    UpperBorder=122;break;
                }
                case 3 : {
                    ArSize=AlphabetRussianU.length();
                    LowerBorder=1040;
                    UpperBorder=1071;break;
                }
                case 4 : {
                    ArSize=AlphabetEnglishU.length();
                    LowerBorder=65;
                    UpperBorder=90;break;
                }
                case 5 : {
                    ArSize=Numerics.length();
                    LowerBorder=48;
                    UpperBorder=57;break;
                }
                case 0 : {
                    ArSize=-1;
                    LowerBorder=-1;
                    UpperBorder=-1;break;
                }
            }
            if(ArSize!=-1){
                proc=(int)Handler[i]+Roll;
                while(proc>UpperBorder)proc-=ArSize;
                Handler[i]=(char)proc;
            }
        }
        String temp = new String(Handler);
        MessageToReturn=temp;
    }
    
    @Override
    public void MessageDecrypt(){
        Random rand = new Random(Key);
        int Roll;
        char Handler[]=new char[MessageToHandle.length()];
        for(int i=0;i<MessageToHandle.length();++i){
            Roll=rand.nextInt(100);
            Handler[i]=MessageToHandle.charAt(i);
            if(Handler[i]=='ё') Handler[i]='е';
            if(Handler[i]=='Ё') Handler[i]='Е';
            String temp="";
            temp+=Handler[i];
            int Symbol=SymbolDefiner(temp);
            int ArSize=0, LowerBorder=0, UpperBorder=0, proc;
            switch(Symbol){
                case 1 : {
                    ArSize=AlphabetRussianL.length();
                    LowerBorder=1072;
                    UpperBorder=1103;break;
                }
                case 2 : {
                    ArSize=AlphabetEnglishL.length();
                    LowerBorder=97;
                    UpperBorder=122;break;
                }
                case 3 : {
                    ArSize=AlphabetRussianU.length();
                    LowerBorder=1040;
                    UpperBorder=1071;break;
                }
                case 4 : {
                    ArSize=AlphabetEnglishU.length();
                    LowerBorder=65;
                    UpperBorder=90;break;
                }
                case 5 : {
                    ArSize=Numerics.length();
                    LowerBorder=48;
                    UpperBorder=57;break;
                }
                case 0 : {
                    ArSize=-1;
                    LowerBorder=-1;
                    UpperBorder=-1;break;
                }
            }
            if(ArSize!=-1){
                proc=(int)Handler[i]-Roll;
                while(proc<LowerBorder)proc+=ArSize;
                Handler[i]=(char)proc;
            }
        }
        String temp = new String(Handler);
        MessageToReturn=temp;
    }
}

