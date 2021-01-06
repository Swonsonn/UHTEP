//Made by Swonsonn
//31.12.2020
package Scramblers.Combined;
import Raw.*;
import java.util.Arrays;
import java.util.Random;

public class APE extends producer{
    String[] russian=new String[AlphabetRussianL.length()];
    String[] english=new String[AlphabetEnglishL.length()];
    String[] numerics=new String[Numerics.length()];
    
    String VowR="AO";
    String VowE="EY";
    String VowN="UI";
    String ConR="BCHG";
    String ConE="DTPR";
    String ConN="KJ";
    
    String Vow="aeoiuy";//гласная
    String Con="bcdpgrthjk";//согласная
    int Key;
    int TempKey;
    
    public APE(){}
    
    private int LanDef(char a){
        if(VowR.contains(Character.toString(a))||ConR.contains(Character.toString(a)))return 1;
        if(VowE.contains(Character.toString(a))||ConE.contains(Character.toString(a)))return 2;
        if(VowN.contains(Character.toString(a))||ConN.contains(Character.toString(a)))return 3;
        return 0;
    }
    
    private String WordForm(int Language){//1-rus, 2-eng, 5-nums
        Random r = new Random(TempKey);
        TempKey=r.nextInt(9999)+1;
        char v='1',v1='1',v2='1',c='1',c1='1',c2='1',v3='1';
        String V,V1,V2,V3,C,C1,C2;
        switch(Language){
            case 1:{
                v=VowR.charAt(r.nextInt(2));
                c=ConR.charAt(r.nextInt(3));break;
            }
            case 2 : {
                v=VowE.charAt(r.nextInt(2));
                c=ConE.charAt(r.nextInt(2));break;
            }
            case 5 : {
                c=ConN.charAt(r.nextInt(2));
                v=VowN.charAt(r.nextInt(2));break;
            }
        }
        v1=Vow.charAt(r.nextInt(6));
        v2=Vow.charAt(r.nextInt(6));
        v3=Vow.charAt(r.nextInt(6));
        c1=Con.charAt(r.nextInt(10));
        c2=Con.charAt(r.nextInt(10));
        V=Character.toString(v);
        V1=Character.toString(v1);
        V2=Character.toString(v2);
        V3=Character.toString(v3);
        C=Character.toString(c);
        C1=Character.toString(c1);
        C2=Character.toString(c2);
        int R=r.nextInt(6)+1;
        String VeryTemp="";
        switch(R){
            case 1 : {
                //c+v
                VeryTemp+=C+V1;break;
            }
            case 2 : {
                //v+c
                VeryTemp+=V+C1;break;
            }
            case 3 : {
                //c+v+v+c+v
                VeryTemp+=C+V1+V2+C1+V3;break;
            }
            case 4 : {
                //v+c+v+c
                VeryTemp+=V+C1+V1+C2;break;
            }
            case 5 : {
                //c+v+c+v
                VeryTemp+=C+V1+C1+V2;break;
            }
            case 6 : {
                //v+c+v+v+c
                VeryTemp+=V+C1+V1+V2+C2;break;
            }
        }
        return VeryTemp;
    }
    
    private void WhatTheNiggaGottaDoToGetSomeEelDicks(){
        int Length=0;
        {
            Length=AlphabetRussianL.length();
            int i=0;
            String[] stash=new String[Length];
            stash[0]="";
            while(i<Length){
                String temp="";
                temp+=WordForm(1);
                if(!Arrays.stream(stash).anyMatch(temp::equals)){
                    stash[i]=temp;
                    russian[i]=temp;
                    ++i;
                }
            }
        }
        {
            Length=AlphabetEnglishL.length();
            int i=0;
            String[] stash=new String[Length];
            stash[0]="";
            while(i<Length){
                String temp="";
                temp+=WordForm(2);
                if(!Arrays.stream(stash).anyMatch(temp::equals)){
                    stash[i]=temp;
                    english[i]=temp;
                    ++i;
                }
            }
        }
        {
            Length=Numerics.length();
            int i=0;
            String[] stash=new String[Length];
            stash[0]="";
            while(i<Length){
                String temp="";
                temp+=WordForm(5);
                if(!Arrays.stream(stash).anyMatch(temp::equals)){
                    stash[i]=temp;
                    numerics[i]=temp;
                    ++i;
                }
            }
        }
    }
    
    public void Set(String Message, int Key){
        this.Key=Key;
        this.TempKey=Key;
        SetMessage(Message);
    }
    
    @Override
    public void MessageCrypt(){
        String MESSAGE="";
        WhatTheNiggaGottaDoToGetSomeEelDicks();
        char Handler[]=new char[MessageToHandle.length()];
        for(int i=0;i<MessageToHandle.length();++i){
            Handler[i]=MessageToHandle.charAt(i);
            if(Handler[i]=='ё') Handler[i]='е';
            if(Handler[i]=='Ё') Handler[i]='Е';
            String temp="";
            temp+=Handler[i];
            int Symbol=SymbolDefiner(temp);
            int junk;
            switch(Symbol){
                case 1 : {
                    junk=AlphabetRussianL.indexOf(Character.toString(Handler[i]));
                    MESSAGE+=russian[junk];break;
                }
                case 2 : {
                    junk=AlphabetEnglishL.indexOf(Character.toString(Handler[i]));
                    MESSAGE+=english[junk];break;
                }
                case 3 : {
                    junk=AlphabetRussianU.indexOf(Character.toString(Handler[i]));
                    MESSAGE+=russian[junk];break;
                }
                case 4 : {
                    junk=AlphabetEnglishU.indexOf(Character.toString(Handler[i]));
                    MESSAGE+=english[junk];break;
                }
                case 5 : {
                    junk=Numerics.indexOf(Character.toString(Handler[i]));
                    MESSAGE+=numerics[junk];break;
                }
                case 0 : {
                    MESSAGE+=Character.toString(Handler[i]);break;
                }
            }
        }
        MessageToReturn=MESSAGE;
    }
    
    private boolean OmegaBump(int i){
        if(i<MessageToHandle.length())
            if(AlphabetEnglishL.contains(Character.toString(MessageToHandle.charAt(i))))
                return true;
        return false;
    }
    
    private boolean SmollBump(int i){
        if(i<MessageToHandle.length()) return true;
        return false;
    }
    
    @Override
    public void MessageDecrypt(){
        String MESSAGE="";
        WhatTheNiggaGottaDoToGetSomeEelDicks();
        //MessageToHandle
        int i=0;
        int junk=0;
        int Indicator;
        while(i<MessageToHandle.length()){
            String temp="";
            temp+=Character.toString(MessageToHandle.charAt(i));
            Indicator=LanDef(MessageToHandle.charAt(i));
            if(Indicator>=1){
                ++i;
                while(OmegaBump(i)){
                    temp+=Character.toString(MessageToHandle.charAt(i));
                    ++i;
                }
                if(OmegaBump(i-1)){
                    switch(Indicator){
                        case 1 : {
                        junk=Arrays.asList(russian).indexOf(temp);
                        MESSAGE+=Character.toString(AlphabetRussianL.charAt(junk));break;
                    }
                        case 2 : {
                        junk=Arrays.asList(english).indexOf(temp);
                        MESSAGE+=Character.toString(AlphabetEnglishL.charAt(junk));break;
                    }
                        case 3 : {
                        junk=Arrays.asList(numerics).indexOf(temp);
                        MESSAGE+=Character.toString(Numerics.charAt(junk));break;
                    }
                }
                }
            }else{if(SmollBump(i))MESSAGE+=Character.toString(MessageToHandle.charAt(i));++i;}
        }
        MessageToReturn="";
        MessageToReturn=MESSAGE;
    }
    
}
    
