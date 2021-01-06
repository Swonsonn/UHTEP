//Made by Swonsonn
//27.12.2020
package Raw;
//1 Russian lower case: 1072-1104
//2 English lower case: 97-123
//3 Russian upper case: 1040-1072
//4 English upper case: 65-91
//5 Numerics: 48-58
public abstract class producer {
    protected String MessageToHandle;
    protected String MessageToReturn;
    
    protected String AlphabetRussianL="абвгдежзийклмнопрстуфхцчшщъыьэюя";
    protected String AlphabetEnglishL="abcdefghijklmnopqrstuvwxyz";
    protected String AlphabetRussianU="АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    protected String AlphabetEnglishU="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected String Numerics="0123456789";
    public producer(){
    
    }
    
    protected void SetMessage(String MessageToHandle){
        this.MessageToHandle=MessageToHandle;
    }
    
    public String GetMessage(){
        return MessageToReturn;
    }
    
    protected int SymbolDefiner(String a){
        if(AlphabetRussianL.contains(a)){
            return 1;
        }else{
            if(AlphabetEnglishL.contains(a)){
                return 2;
            }else{
                if(AlphabetRussianU.contains(a)){
                    return 3;
                }else{
                    if(AlphabetEnglishU.contains(a)){
                        return 4;
                    }else{
                        if(Numerics.contains(a)){
                            return 5;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        }    
    }
    
    public abstract void MessageCrypt();
    public abstract void MessageDecrypt();
}
