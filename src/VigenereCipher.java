public class VigenereCipher {
    //properties
    private String key;
    private String alphabet;
    //constructors
    public VigenereCipher(String key){
        this.key = key.toLowerCase();
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    //methods

    public String getKey(){
        return this.key.toLowerCase();
    }
    public String getAlphabet(){
        return this.alphabet;
    }
    public void setKey(String newKey){
        this.key = newKey;
    }

    private boolean isItInAlphabet(char c){
        for (int i = 0; i < 52; i++){
            if (c == alphabet.charAt(i)){
                return true;
            }
        }
        return false;
    }

    private String encodeHelper(char originalC, char keyC){
        int char1 = originalC;
        //c1 is original text char
        int char2 = keyC;
        //c2 is key char
        int newCharInt;
        if (char1 + char2 - 97 < 123){
            newCharInt = char1 + char2 - 97;
        }
        else{
            newCharInt = char1 + char2 - 123;
        }
        char newChar = (char)newCharInt;
        return String.valueOf(newChar);
    }
    private String decodeHelper(char originalC, char keyC){
        int char1 = originalC;
        //char1 is ASCII of original text char
        int char2 = keyC;
        //char2 is ASCII of is key char
        int newCharInt;

        if (char1 > char2){
            newCharInt = char1 - char2 + 97;
        }
        else if (char1 == char2){
            newCharInt = 97;
        }
        else{
            newCharInt = char1 - char2 + 123;
        }
        char newChar = (char)newCharInt;
        return String.valueOf(newChar);
    }

    //the encode method
    public String encode(String plainText){
        String keyRepeated = "";
        String keyword = this.key;
        //make same length
        int stringLength = plainText.length();
        int quotient = stringLength / keyword.length();
        int remainder = stringLength % keyword.length();

        //e.g. plaintext = deoxyribonucleicacid, key = genome, repeated key would be genomegenomegenomege
        keyRepeated += keyword.repeat(quotient);   //adds full amount of repeated cycles, e.g. genomegenomegenome
        keyRepeated += keyword.substring(0, remainder);   //adds partially repeated parts, e.g. ge
        //now plainText and keyRepeated should be the same length

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++){
            if (isItInAlphabet(plainText.charAt(i))){
                char char1 = plainText.charAt(i);
                char char2 = keyRepeated.charAt(i);
                cipherText += encodeHelper(char1, char2);
            }
            else{
                cipherText += plainText.charAt(i);
            }
        }

        return cipherText;
    }


    //the decode method
    public String decode(String cipherText){
        String keyRepeated = "";
        String keyword = this.key;
        //make same length
        int stringLength = cipherText.length();
        int quotient = stringLength / keyword.length();
        int remainder = stringLength % keyword.length();

        keyRepeated += keyword.repeat(quotient);
        keyRepeated += keyword.substring(0, remainder);

        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++){
            if (isItInAlphabet(cipherText.charAt(i))){
                char char1 = cipherText.charAt(i);
                char char2 = keyRepeated.charAt(i);
                plainText += decodeHelper(char1, char2);
            }
            else{
                plainText += cipherText.charAt(i);
            }
        }

        return plainText;
    }
}
