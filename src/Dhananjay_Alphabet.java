/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nemesis
 */
public class Dhananjay_Alphabet {
    public static void main(String[] args)
    {
        StringBuilder magical_alphabet =new StringBuilder("");
        StringBuilder alphabet=new StringBuilder("");
        int ASCII_TABLE = 128;
        boolean found = false;
        boolean found_top, found_bot;
        char magi_bot;
        char magi_top;
        for(int i = 0; i < ASCII_TABLE; i++)
        {
            magi_bot = (char) i;
            magi_top = (char) i;
            found = false;
            found_bot = false;
            found_top = false;
            if(is_printable(i))
            {
               char alpha = (char) i;
               alphabet.append(alpha) ;
               //test lower path
               for(int j = i; j >= 0; j-- )
               {
                   if(is_printable(j))
                   {
                       if(is_prime(j))
                       {
                           magi_bot = (char) j;
//                         magical_alphabet.append(magi);
                           found=true;
                           found_bot = true;
                           break;
                       }
                   }
               }
               //test upper path
               //if(!found)
               //{
                   for(int j = i; j < ASCII_TABLE; j++ )
                    {
                        if(is_printable(j))
                        {
                            if(is_prime(j))
                            {
                                magi_top = (char) j;
//                              magical_alphabet.append(magi);
                                found=true;
                                found_top = true;
                                break;
                            }
                        }
                    }
                   if(found_bot && found_top)
                   {
                       magical_alphabet.append(magi_bot);
                   }
                   else if(found_top)
                   {
                       magical_alphabet.append(magi_top);
                   }
                   else
                   {
                       magical_alphabet.append(magi_bot);
                   }
               //}
               //test if still not found
//               if(!found)
//               {
//                   
//               }
               
            }
        }
        printAsciiMagicalTable(magical_alphabet);
        printAsciiTable(alphabet);
        
        for(int i = 0; i < magical_alphabet.length(); i++)
        {
            int left_magic;
            int right_magic;
            
            
        }
        
    }
    static void printAsciiMagicalTable(StringBuilder sb)
    {
        System.out.println(sb.toString());
    }
    static void printAsciiTable(StringBuilder sb)
    {
        System.out.println(sb.toString());
    }
    
    static boolean is_printable(int charPositionAscii)
    {
        if((charPositionAscii >= 65 && charPositionAscii <= 90)
                || 
                (charPositionAscii >= 97 && charPositionAscii <= 122))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    static boolean is_prime(int n){
        if(n > 0)
        {
            for(int i = 2; i < n; i++){
                if((n%i) == 0){
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
        
        //print_info(n+"", "this is prime ");
        
    }
    
}
