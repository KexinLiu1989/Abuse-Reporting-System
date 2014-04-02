package dds.config;

/**
 * Author: Hao Zhou
 * Date: 04-02-2014
 */
public class Const {

    public static String TIMESTAMP = System.currentTimeMillis() + "";
    
    // MySQL Source Configuration DEV
    public static String DEV_JDBC_URL = "jdbc:mysql://cs509.wpilife.org:3306/dds_cs509";
    public static String DEV_USER = "cs509";
    public static String DEV_PASSWORD = "CS5092014";

    // beetl
    public static String BEETL_ROOT_DIR = "/WEB-INF/beetl";

}
