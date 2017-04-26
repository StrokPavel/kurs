package Kyrsovaya;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import kyrsovaya.Cesar;
import kyrsovaya.Atbash;

public class Kyrsovaya {

    public static void main(String[] args) throws FileNotFoundException {
        Cesar b = new Cesar();
        Atbash a = new Atbash();
        Scanner sc = new Scanner(new FileReader("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Kyrsovaya\\src\\kyrsovaya\\text.txt"));
        String Cstring_in = "";
        while (sc.hasNextLine()) {
            Cstring_in += sc.nextLine() + "\n";
        }
        String Cstring_encryptoftext = b.encrypt(Cstring_in, 1, 4);
        String Cstring_decryptoftext = b.decrypt(Cstring_encryptoftext, 1, 4);
        System.out.println("-----Шифр Цезаря-----");
        System.out.println("Слово для шифровки: \n" + Cstring_in + ".\rШифрованное слово: "
                + Cstring_encryptoftext + ".\nРасшифрованное слово: " + Cstring_decryptoftext + ".");
        System.out.println("-----Шифр Атбаш-----");
        String Astring_encryptoftext = a.encrypt(Cstring_encryptoftext);
        String Astring_decryptoftext_atbash = a.decrypt(Astring_encryptoftext);
        String Astring_decryptoftext_cesar = b.decrypt(Astring_decryptoftext_atbash, 1, 4);
        System.out.println("Слово для шифровки: \n" + Cstring_in + ".\rШифрованное слово: "
                + Astring_encryptoftext + ".\nРасшифрованное слово: " + Astring_decryptoftext_cesar + ".");
    }
}
