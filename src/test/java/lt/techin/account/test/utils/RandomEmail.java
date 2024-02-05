package lt.techin.account.test.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmail {

    public static String getRandomEmail() {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
//        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "0123456789";
       String randomString= RandomStringUtils.random(4, lowercase)
//                + RandomStringUtils.random(4, uppercase)
                + RandomStringUtils.random(2, number)
//                + System.currentTimeMillis()
                + "@one.lt";
        return randomString;
    }

}


