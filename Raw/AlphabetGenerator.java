//Made by Swonsonn
//29.12.2020
package Raw;
import java.util.Random;

public class AlphabetGenerator{
    protected String AlphabetRussianL="абвгдежзийклмнопрстуфхцчшщъыьэюя";
    protected String AlphabetEnglishL="abcdefghijklmnopqrstuvwxyz";
    protected String AlphabetRussianU="АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    protected String AlphabetEnglishU="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected String Numerics="0123456789";
    private int Key;
    
    public AlphabetGenerator(int Key){
        this.Key=Key;
    }
    
    public char[] RussianLower(){
        String Alphabet=AlphabetRussianL;
        int CurrentLength=Alphabet.length();
        Random rand = new Random(Key);
        char ToReturn[]=new char[CurrentLength];
        int J=0;
        String Stash="";
        while(Stash.length()<CurrentLength){
            int i=rand.nextInt(CurrentLength);
            if(!Stash.contains(Character.toString(Alphabet.charAt(i)))){
                Stash+=Character.toString(Alphabet.charAt(i));
                ToReturn[J]=Alphabet.charAt(i);
                ++J;
            }
        }
        return ToReturn;
    }
    
    public char[] RussianUpper(){
        String Alphabet=AlphabetRussianU;
        int CurrentLength=Alphabet.length();
        Random rand = new Random(Key);
        char ToReturn[]=new char[CurrentLength];
        int J=0;
        String Stash="";
        while(Stash.length()<CurrentLength){
            int i=rand.nextInt(CurrentLength);
            if(!Stash.contains(Character.toString(Alphabet.charAt(i)))){
                Stash+=Character.toString(Alphabet.charAt(i));
                ToReturn[J]=Alphabet.charAt(i);
                ++J;
            }
        }
        return ToReturn;
    }
    
    public char[] EnglishLower(){
        String Alphabet=AlphabetEnglishL;
        int CurrentLength=Alphabet.length();
        Random rand = new Random(Key);
        char ToReturn[]=new char[CurrentLength];
        int J=0;
        String Stash="";
        while(Stash.length()<CurrentLength){
            int i=rand.nextInt(CurrentLength);
            if(!Stash.contains(Character.toString(Alphabet.charAt(i)))){
                Stash+=Character.toString(Alphabet.charAt(i));
                ToReturn[J]=Alphabet.charAt(i);
                ++J;
            }
        }
        return ToReturn;
    }
    
    public char[] EnglishUpper(){
        String Alphabet=AlphabetEnglishU;
        int CurrentLength=Alphabet.length();
        Random rand = new Random(Key);
        char ToReturn[]=new char[CurrentLength];
        int J=0;
        String Stash="";
        while(Stash.length()<CurrentLength){
            int i=rand.nextInt(CurrentLength);
            if(!Stash.contains(Character.toString(Alphabet.charAt(i)))){
                Stash+=Character.toString(Alphabet.charAt(i));
                ToReturn[J]=Alphabet.charAt(i);
                ++J;
            }
        }
        return ToReturn;
    }
    
    public char[] Numerics(){
        String Alphabet=Numerics;
        int CurrentLength=Alphabet.length();
        Random rand = new Random(Key);
        char ToReturn[]=new char[CurrentLength];
        int J=0;
        String Stash="";
        while(Stash.length()<CurrentLength){
            int i=rand.nextInt(CurrentLength);
            if(!Stash.contains(Character.toString(Alphabet.charAt(i)))){
                Stash+=Character.toString(Alphabet.charAt(i));
                ToReturn[J]=Alphabet.charAt(i);
                ++J;
            }
        }
        return ToReturn;
    }
}
