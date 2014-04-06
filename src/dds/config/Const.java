package dds.config;

/**
 * Author: Hao Zhou
 * Date: 04-02-2014
 */
public class Const {

    public static String TIMESTAMP = System.currentTimeMillis() + "";
    
    // MySQL Source Configuration DEV
    public static final String DEV_JDBC_URL = "jdbc:mysql://cs509.wpilife.org:3306/dds_cs509?useUnicode=yes&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
    public static final String DEV_USER = "cs509";
    public static final String DEV_PASSWORD = "CS5092014";

    // Security
    public static final String SALT_FOR_MD5 = "7F4C02829DC3B105E3B88CE948A66947";

}
