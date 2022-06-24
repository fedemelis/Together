package res;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FirebaseInitialize {
    @SneakyThrows
    public static void initFirebase() {
        FileInputStream serviceAccount = null;
        try {
            //serviceAccount = new FileInputStream("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\together-ed667-firebase-adminsdk-cmk07-323cdd6de4.json");
            serviceAccount = new FileInputStream("C:\\Users\\fedem\\IdeaProjects\\togetherUltimate\\src\\main\\java\\res\\serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    //.setDatabaseUrl("https://meuprojeto-63644.firebaseio.com")
                    .setDatabaseUrl("https://together-ed667-default-rtdb.europe-west1.firebasedatabase.app/")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FirebaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(FirebaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serviceAccount.close();
            } catch (IOException ex) {
                //Logger.getLogger(FirebaseConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
