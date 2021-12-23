package software.project.backend.sercuirty;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class passwordOperations {
    private String passwordHashig;
    public String passswordToHash(String pass){
            String salt = getSalt();
            return get_SHA_1_SecurePassword(pass,salt);
    }
    private String getSalt()  {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private String get_SHA_1_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}