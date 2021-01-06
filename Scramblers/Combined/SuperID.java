//Made by Swonsonn
//29.12.2020
package Scramblers.Combined;
import Raw.*;
import java.util.Random;

public class SuperID extends producer{
    char RL[]=new char[AlphabetRussianL.length()];
    char RU[]=new char[AlphabetRussianU.length()];
    char EL[]=new char[AlphabetEnglishL.length()];
    char EU[]=new char[AlphabetEnglishU.length()];
    char NM[]=new char[Numerics.length()];
    int GlobalKey=0;
    
    public SuperID(){}
    
    public void Set(String Message, String Key){
        GlobalKey=0;
        for(int i=0;i<Key.length();++i){
            GlobalKey+=(int)Key.charAt(i);
        }
        System.out.println(GlobalKey);
        AlphabetGenerator gen = new AlphabetGenerator(GlobalKey);
        SetMessage(Message);
        RL=gen.RussianLower();
        RU=gen.RussianUpper();
        EL=gen.EnglishLower();
        EU=gen.EnglishUpper();
        NM=gen.Numerics();
    }
    
    @Override
    public void MessageCrypt(){
        char Handler[]=new char[MessageToHandle.length()];
        Random rand = new Random(GlobalKey);
        for(int i=0;i<MessageToHandle.length();++i){
            Handler[i]=MessageToHandle.charAt(i);
            if(Handler[i]=='ё') Handler[i]='е';
            if(Handler[i]=='Ё') Handler[i]='Е';
            String temp="";
            temp+=Handler[i];
            int junk;
            int Symbol=SymbolDefiner(temp);
            int ArSize=0, LowerBorder=0, UpperBorder=0, proc;
            switch(Symbol){
                case 1 : {
                    ArSize=AlphabetRussianL.length();
                    junk=AlphabetRussianL.indexOf(Character.toString(Handler[i]));
                    Handler[i]=RL[junk];
                    LowerBorder=1072;
                    UpperBorder=1103;break;
                }
                case 2 : {
                    ArSize=AlphabetEnglishL.length();
                    junk=AlphabetEnglishL.indexOf(Character.toString(Handler[i]));
                    Handler[i]=EL[junk];
                    LowerBorder=97;
                    UpperBorder=122;break;
                }
                case 3 : {
                    ArSize=AlphabetRussianU.length();
                    junk=AlphabetRussianU.indexOf(Character.toString(Handler[i]));
                    Handler[i]=RU[junk];
                    LowerBorder=1040;
                    UpperBorder=1071;break;
                }
                case 4 : {
                    ArSize=AlphabetEnglishU.length();
                    junk=AlphabetEnglishU.indexOf(Character.toString(Handler[i]));
                    Handler[i]=EU[junk];
                    LowerBorder=65;
                    UpperBorder=90;break;
                }
                case 5 : {
                    ArSize=Numerics.length();
                    junk=Numerics.indexOf(Character.toString(Handler[i]));
                    Handler[i]=NM[junk];
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
                proc=(int)Handler[i]+rand.nextInt(33);
                while(proc>UpperBorder)proc-=ArSize;
                Handler[i]=(char)proc;
            }
        }
        String temp = new String(Handler);
        MessageToReturn=temp;
    }
    
    @Override
    public void MessageDecrypt(){
        char Handler[]=new char[MessageToHandle.length()];
        Random rand = new Random(GlobalKey);
        for(int i=0;i<MessageToHandle.length();++i){
            Handler[i]=MessageToHandle.charAt(i);
            if(Handler[i]=='ё') Handler[i]='е';
            if(Handler[i]=='Ё') Handler[i]='Е';
            String temp="";
            temp+=Handler[i];
            int junk;
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
                proc=(int)Handler[i]-rand.nextInt(33);
                while(proc<LowerBorder)proc+=ArSize;
                Handler[i]=(char)proc;
                switch(Symbol){
                    case 1 : {
                    ArSize=AlphabetRussianL.length();
                    String S = new String(RL);
                    junk=S.indexOf(Character.toString(Handler[i]));
                    Handler[i]=AlphabetRussianL.charAt(junk);
                    LowerBorder=1072;
                    UpperBorder=1103;break;
                }
                    case 2 : {
                    ArSize=AlphabetEnglishL.length();
                    String S = new String(EL);
                    junk=S.indexOf(Character.toString(Handler[i]));
                    Handler[i]=AlphabetEnglishL.charAt(junk);
                    LowerBorder=97;
                    UpperBorder=122;break;
                }
                    case 3 : {
                    ArSize=AlphabetRussianU.length();
                    String S = new String(RU);
                    junk=S.indexOf(Character.toString(Handler[i]));
                    Handler[i]=AlphabetRussianU.charAt(junk);
                    LowerBorder=1040;
                    UpperBorder=1071;break;
                }
                    case 4 : {
                    ArSize=AlphabetEnglishU.length();
                    String S = new String(EU);
                    junk=S.indexOf(Character.toString(Handler[i]));
                    Handler[i]=AlphabetEnglishU.charAt(junk);
                    LowerBorder=65;
                    UpperBorder=90;break;
                }
                    case 5 : {
                    ArSize=Numerics.length();
                    String S = new String(NM);
                    junk=S.indexOf(Character.toString(Handler[i]));
                    Handler[i]=Numerics.charAt(junk);
                    LowerBorder=48;
                    UpperBorder=57;break;
                }
                    case 0 : {
                    ArSize=-1;
                    LowerBorder=-1;
                    UpperBorder=-1;
                        break;
                }
            }
            }
        }
        String temp = new String(Handler);
        MessageToReturn=temp;
    }
}
