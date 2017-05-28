package kyrsovaya;

import java.util.ArrayList;
import java.util.List;

public class Atbash {

    static List<Character> alphabet = new ArrayList<>();
    private final static char[] PUNCTUATION = {'.', ',', ';', ':', '!', '?', '-', ' '};

    public Atbash() {
        for (char c = 'а'; c <= 'я'; c++) {
            alphabet.add(c);
        }
//        for (char c = 'А'; c <= 'Я'; c++) {
//            alphabet.add(c);
//        }        
        for (char c : PUNCTUATION) {
            alphabet.add(c);
        }
    }

    public String encrypt(String text) {
        int n = alphabet.size();
        StringBuilder cryptogram = new StringBuilder();
        //блок шифрования данных
        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.indexOf(text.charAt(i));
            int a = (n - 1) - index;
            cryptogram.append(alphabet.get(a));
        }
        return cryptogram.toString();
    }

    public String decrypt(String text) {
        int n = alphabet.size();
        StringBuilder newText = new StringBuilder();
        //блок дешифрования данных
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alphabet.indexOf(c);
            int a = (n - 1) - index;
            newText.append(alphabet.get(a));
        }
        return newText.toString();
    }
}
