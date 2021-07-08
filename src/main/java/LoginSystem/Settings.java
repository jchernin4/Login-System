package LoginSystem;

public class Settings {
    public static final int HTTP_SERVER_PORT = 8080;
    
    public static final String SERVER_IP = "localhost";
    public static final int MONGO_PORT = 27017;
    public static final String MONGO_URI = "mongodb://" + SERVER_IP + ":" + MONGO_PORT;
    public static final String MONGO_DATABASE_NAME = "LoginSystem";
}
