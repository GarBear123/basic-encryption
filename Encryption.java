/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Gary Deng
 */
public class Encryption {
        static char[] alphabet ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
        public static String a1z26(char character){
        int num = 0;
        String g = "";
        for(int i = 0;i < alphabet.length;i++){
            if(character == alphabet[i]){
                num = i + 1;
            }
            
        }
        if(num != 0){
        g += num;
        }
        else{
            g += character;
        }
        return g;
}
        public static char Caesar(char character,int key){
        char g = character;
        for(int i = 0 ;i < alphabet.length;i++){
        if(character == alphabet[i]){
            g = alphabet[(i + key) % 26];
        }
        
        
    }
        return g;
    }
    
    public static char Atbash(char character){
        char g = character;
        for(int i = 0; i < alphabet.length;i++){
            if(character == alphabet[i]){
                g = alphabet[25 - i];
            }
            
        }
            return g;

        
    }

}


