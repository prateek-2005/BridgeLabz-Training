package csv_data_handling;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;
public class EncryptAndDecrypt {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "MySecretKey12345"; 
    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder()
                .encodeToString(cipher.doFinal(data.getBytes()));
    }
    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }

    public static void main(String[] args) {
        String fileName = "employees_secure.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("ID,Name,Email,Salary\n");
            writer.write("101,Amit," +
                    encrypt("amit@gmail.com") + "," +
                    encrypt("50000") + "\n");
            writer.write("102,Rahul," +
                    encrypt("rahul@yahoo.com") + "," +
                    encrypt("45000") + "\n");
            System.out.println(" Encrypted CSV written successfully\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;
            System.out.println("🔓 Decrypted Data:\n");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String email = decrypt(data[2]);
                String salary = decrypt(data[3]);
                System.out.println("ID     : " + id);
                System.out.println("Name   : " + name);
                System.out.println("Email  : " + email);
                System.out.println("Salary : " + salary);
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
