package ayyash.app.seamolec_udj;

/**
 * Created by Ayyash on 9/15/2016.
 */
public class Config {

    public static final String LOGIN_URL = "http://192.168.50.37/new_udj/login.php";

    public static final String KEY_NIS = "nis";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String NIS_SHARED_PREF = "nis";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}