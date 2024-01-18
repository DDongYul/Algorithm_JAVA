import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        if(n.equals("1")){
            System.out.println(1);
        }
        else{
            BigInteger bigInteger = new BigInteger(n);
            bigInteger = bigInteger.add(bigInteger).add(new BigInteger("-2"));
            System.out.println(bigInteger);
        }
    }
}
