package PageObjects;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    public static String[] generateNewUserInfo(){

        String emailName = RandomStringUtils.randomAlphanumeric(8);
        String emailTag = "@test.com";
        String randomEmail = emailName.concat(emailTag);

        String randomName = RandomStringUtils.randomAlphabetic(8);
        String randomLastName = RandomStringUtils.randomAlphabetic(8);
        String randomTelephone = RandomStringUtils.randomAlphabetic(8);
        String randomPassword = RandomStringUtils.randomAlphanumeric(8);

        String[] userInfo = new String[] {randomName,randomLastName,randomEmail,randomTelephone,randomPassword};

        return userInfo;
    }
}
