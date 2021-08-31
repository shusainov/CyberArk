import org.jboss.aerogear.security.otp.Totp;

public class OTP {
    private Totp totp;
    private Config conf;

    public OTP(){
        conf = new Config();
        totp = new Totp(conf.getProperty("mfaSecurityKey"));
    }

    public String now(){
        return totp.now();
    }

}