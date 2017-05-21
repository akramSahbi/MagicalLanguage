
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class TestClass2 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        

        //Scanner
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = 0;
        String line = "";
        String magical = "";
        try
        {
            
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++){
                //BufferedReader
                S = Integer.parseInt(br.readLine());
                
                line = br.readLine();
                magical = replace_line_to_magical(line,S);
                System.out.println(magical);

            }
            
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
            
        }
        finally
        {
            //s.close();
            br.close();
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
    static String replace_line_to_magical(String line, int length){
        StringBuilder sb = new StringBuilder(line.length());
        char c = 'c';
        int numb = 0;
        int prime = 0;
        char mag = 'a';
        for(int i = 0; i < line.length(); i++){
            c = line.charAt(i);
            numb = char_to_int(c);
            prime = find_nearest_prime(numb);
            mag = int_to_char(prime);
            sb.append(mag);
        }
        //print_info(sb.toString(), "line is " + line+"| magic line is ");
        return sb.toString();
    }
    static int char_to_int(char asciiChar){
        //print_info(Integer.valueOf((Character)asciiChar)+"", "char = "+ asciiChar+ " integer is ");
        return Integer.valueOf((Character)asciiChar);
    }
    
    static char int_to_char(int intValue){
        //print_info((char)(intValue)+"", "integer = "+ intValue+ " character is ");
        return (char)(intValue);
    }
    
    static int find_nearest_prime(int number){
        int j_bot, j_top;
        final int ASCII_SIZE = 128;
        boolean found_bot;
        boolean found_top;
        int dx_bot, dx_top;
//        if(is_prime(number)){
//            //print_info(number+"", "prime number is ");
//            return number;
//        }
        
        dx_bot = dx_top = 500;
        j_bot = j_top = number;
        
        found_top = false;
        found_bot = false;
        
        int max_iteration_top = ASCII_SIZE-number;
        int max_iteration_bot = number;
        int max_iteration = Math.max(max_iteration_bot, max_iteration_top);
        
        for(int i = 0; i < max_iteration /*&& (j_top < ASCII_SIZE || j_bot >= 0 )*/; i++){
            j_bot  -=  i;
            //j_bot %= (ASCII_SIZE+1);
            if(!found_bot && i < number && is_printable(j_bot))
            {
                if(is_prime(j_bot)){
                    found_bot = true;
                    dx_bot = i;
                print_info(j_bot+"", "J_BOT prime number is ");
                return j_bot;
                }
            }
            
            j_top += i;
            //j_top %= (ASCII_SIZE+1);
            if(!found_top && i < max_iteration_top && is_printable(j_top))
            {
                if(is_prime(j_top)){
                    //print_info(j_top+"", "prime number is ");
                    found_top = true;
                    dx_top = i;
                    print_info(j_top+"", "J_TOP prime number is ");
                    return j_top;
                }
            }
            
        }
        
        if(found_bot && !found_top)
        {
            print_info((char)j_bot+"", "FOUND_BOT prime number is ");
            return j_bot;
        }
        else if (!found_bot && found_top)
        {
            print_info((char)j_top+"", "FOUND_TOP prime number is ");
            return j_top;
        }
        else if(!found_bot && !found_top)
        {
            print_info((char)number+"", "NOT_FOUND_J_BOT_NOT_FOUND_J_TOP prime number is ");
            return number;
        }
        
        if(dx_bot < dx_top)
        {
            print_info((char)j_bot+"", "NEARER_J_BOT prime number is ");
            return j_bot;
        }
        else if ( dx_top < dx_bot)
        {
            print_info((char)j_top+"", "NEARER_J_TOP prime number is ");
            return j_top;
        }
        else
        {
            print_info((char)j_bot+"", "SAME_J_BOT_J_TOP_CHOSE_J_BOT prime number is ");
            return j_bot;
        }
        
        
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
    static void print_info(String o, String info){
        System.out.println(info+" : "+ o);
    }
    
}

