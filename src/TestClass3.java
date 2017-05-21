
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    /* IMPORTANT: Multiple classes and nested static classes are supported */

    /*
     * uncomment this if you want to read input.
    //imports for BufferedReader
    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    //import for Scanner and other utility  classes
    import java.util.*;
    */
    
    //line:
    //AWGrOwUcFWnghtAyvxSb
    //correction:
    //CYGqOqSaGYmggqCqqqSa
    //my magical alphabet
    //ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
    //CCCCCGIIIOOSSSYaaeggkmmqqqqqqqqqqqqqqqqqqqqqqqqqqqqq



    class TestClass3 {

        static String alphabet =        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //static String magicalAlphabet = "CCCCCCGGIIIIIIOOOOSSSSSSYYaaaaeeggggkkmmmmqqqqqqqqqq";
        static String magicalAlphabet =  "CCCCCGIIIOOSSSYaaeggkmmqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
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
        
        static void init_magical_alphabet()
        {
            int dx, min, min_index;
            char char_magic, char_normal;
            for(int i=0; i< alphabet.length();i++)
            {
                min = matrix_distance_magical_alphabet_to_alphabet[i][0];
                min_index = 0;
                for(int j=0; j < set_magical_alphabet.length();j++)
                {
                    if(matrix_distance_magical_alphabet_to_alphabet[i][j] < min)
                    {
                        min = matrix_distance_magical_alphabet_to_alphabet[i][j];
                        min_index = j;
                    }
                }
                magicalAlphabet += set_magical_alphabet.charAt(min_index)+"";
            }
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
                    magical = replace_line_to_magical(line);
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

        static String replace_line_to_magical(String line){
            StringBuilder sb = new StringBuilder(line.length());
            int index;
            char char_line;
            char char_magic, char_magic_right, char_magic_left;
            int char_number, char_magic_right_number, char_magic_left_number;
            int dx_left, dx_right;
            for(int i = 0; i < line.length(); i++){
                char_line = line.charAt(i);
                char_number = Integer.valueOf(char_line);
                index = alphabet.indexOf(char_line);
                //print_info(index+"", "INDEX");
                char_magic = magicalAlphabet.charAt(index);
                char_magic_right = index < (alphabet.length() - 1)? magicalAlphabet.charAt((index+1)): char_magic;          
                print_info(char_magic_right+"", "CHAR_MAGIC_RIGHT");
                char_magic_left = index > 0 ? magicalAlphabet.charAt(index-1) : char_magic;
                print_info(char_magic_left+"", "CHAR_MAGIC_LEFT");
                char_magic_right_number = alphabet.indexOf(char_magic_right) ;
                char_magic_left_number = alphabet.indexOf(char_magic_left) ;
                dx_left = Math.abs(index - char_magic_left_number);
                print_info(dx_left+"", "DX_LEFT");
                dx_right = Math.abs(index - char_magic_right_number);
                print_info(dx_right+"", "DX_RIGHT");

                if(dx_left < dx_right)
                {
                    print_info(char_magic_left+"", "NEAR TO LEFT");
                    sb.append(char_magic_left);
                }
                else if(dx_left > dx_right)
                {
                    print_info(char_magic_right+"", "NEAR TO RIGHT");
                    sb.append(char_magic_right);
                }
                else
                {
                    print_info(char_magic+"", "MIDDLE");
                    print_info(char_magic+"", "MIDDLE");
                    sb.append(char_magic);
                }

            }
            print_info(sb.toString(), "line is " + line+"| magic line is ");
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

    }

