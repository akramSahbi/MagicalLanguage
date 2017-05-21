    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
 
 
 
    class TestClass {
 
        static String alphabet =        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //static String magicalAlphabet = "CCCCCCGGIIIIIIOOOOSSSSSSYYaaaaeeggggkkmmmmqqqqqqqqqq";
        //static String magicalAlphabet = "CCCCCGIIIOOSSSYaaeggkmmqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        static String magicalAlphabet = "CCCCCGGGIIIIOOOOOSSSSSYYYYaaaeeegggkkkmmmqqqqqqqqqqq";
        static String set_magical_alphabet = "CGIOSYaegkmq";
        static int [][] matrix_distance_magical_alphabet_to_alphabet;
        
        static void init_matrix_distance()
        {
            matrix_distance_magical_alphabet_to_alphabet = new int[alphabet.length()][set_magical_alphabet.length()];
            for(int i = 0; i < alphabet.length(); i++)
            {
                for(int j = 0; j < set_magical_alphabet.length(); j++)
                {
                    matrix_distance_magical_alphabet_to_alphabet[i][j] =
                            distance_from_2_alphabets(alphabet.charAt(i), set_magical_alphabet.charAt(j));
                }
            }
        }
        
        static void print_distance_matrix()
        {
            System.out.println(set_magical_alphabet+"");
            System.out.print("\t");
            
            for(int k = 0; k < set_magical_alphabet.length(); k++)
            {
                System.out.print(set_magical_alphabet.charAt(k)+"\t");
            }
            System.out.println();
            for(int i = 0; i < alphabet.length(); i++)
            {
                System.out.print(alphabet.charAt(i)+"\t");
                for(int j = 0; j < set_magical_alphabet.length(); j++)
                {
                    System.out.print(matrix_distance_magical_alphabet_to_alphabet[i][j] +"\t");
                }
                System.out.println();
            }
            
        }
        
        static void init_magical_alphabet()
        {
            int dx, min, min_index;
            char char_magic, char_normal;
            for(int i=0; i< alphabet.length();i++)
            {
                min = matrix_distance_magical_alphabet_to_alphabet[i][0];
                min_index = 0;
                for(int j=1; j < set_magical_alphabet.length();j++)
                {
                    if(matrix_distance_magical_alphabet_to_alphabet[i][j] < min)
                    {
                        min = matrix_distance_magical_alphabet_to_alphabet[i][j];
                        min_index = j;
                    }
                }
                magicalAlphabet += set_magical_alphabet.charAt(min_index);
            }
            print_info(magicalAlphabet, "MAGICAL_ALPHABET");
        }
        
        
        static int distance_from_2_alphabets(char alphabet1, char alphabet2)
        {
            int index1, index2;
            int dx;
            
            index1 = alphabet.indexOf(alphabet1);
            index2 = alphabet.indexOf(alphabet2);
            dx = Math.abs(index2 - index1);
            return dx;
        }
        
        static String magical = "";
        static String line = "";
        public static void main(String args[] ) throws Exception {
            /*
             * Read input from stdin and provide input before running
             * Use either of these methods for input
    */
 
 
            //Scanner
            //Scanner s = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            1
            int S = 0;
 
            
            
            try
            {
 
                int T = Integer.parseInt(br.readLine());
 
                for (int i = 0; i < T; i++){
                    //BufferedReader
                    S = Integer.parseInt(br.readLine());
 
                    line = br.readLine();
                    replace_line_to_magical();
                    print(magical);
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
 
        static String replace_line_to_magical(){
            StringBuilder sb = new StringBuilder(line.length());
            int index = 0;
//            
            for(int i = 0; i < line.length(); i++){
                index = alphabet.indexOf(line.charAt(i));
                sb.append(magicalAlphabet.charAt(index));
            }
//            print_info(sb.toString(), "line is " + line+"| magic line is ");
            magical = sb.toString();
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

    private static void print(String magical) {
        int i;
        i = -1;
        do
        {
            i++;
            if(magical.length() > i)
            {
                System.out.print(magical.charAt(i));
            }
            
            
        } while((magical.length() > i));
        System.out.println();
    }
 
    }