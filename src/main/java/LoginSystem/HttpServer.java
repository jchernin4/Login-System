package LoginSystem;

import io.javalin.Javalin;

import java.io.ObjectInputFilter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class HttpServer {
    private static HttpServer instance;
    public MongoManager mongoManager;
    private final Javalin app;
    
    public static HttpServer getInstance() {
        if (instance == null) {
            instance = new HttpServer();
        }
        return instance;
    }
    
    private HttpServer() {
        mongoManager = MongoManager.getInstance();
        app = Javalin.create(config -> {
            config.requestLogger((ctx, ms) -> {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now(ZoneId.of("US/Eastern"));
                System.out.println("[LOG] " + dtf.format(now) + " | " + ctx.method() + " request to " + ctx.fullUrl()
                        + " from userAgent: " + ctx.userAgent() + " and IP: " + ctx.ip());
            });

            config.enableCorsForAllOrigins();

        }).start(Settings.HTTP_SERVER_PORT);
    }
    
    public void start() {
        System.out.println("Starting...");
        
        app.post("/signup", ctx -> {
            
        });
    }
}
