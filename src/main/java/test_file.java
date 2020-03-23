
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test_file{

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN1 ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,40})";
    private static final String PASSWORD_PATTERN2 ="[^a-z&&[^A-Z]&&[^0-9]]";


    public boolean validate(final String password){

        matcher = Pattern.compile(PASSWORD_PATTERN1).matcher(password);
        System.out.println(matcher.matches());

        if(matcher.matches()){
            matcher = Pattern.compile(PASSWORD_PATTERN2).matcher(password);
            System.out.println(matcher.find());
        }
        return matcher.matches();

    }
    public static void main(String args[]){
        new test_file().validate("mkyong1A..");

    }
}