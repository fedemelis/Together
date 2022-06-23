package res;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;


public class FirebaseInitialize {
    @PostConstruct
    @SneakyThrows
    public void initialize(){

        FileInputStream serviceAccount =
                new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://together-ed667-default-rtdb.europe-west1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

    }

}
