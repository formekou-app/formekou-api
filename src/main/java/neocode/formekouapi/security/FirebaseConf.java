package neocode.formekouapi.security;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConf {
    @Bean
    public FirebaseAuth firebaseApp() throws IOException {
        String firebaseConfigPath = System.getenv("FIREBASE_ACCOUNT_PATH");
        FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        return FirebaseAuth.getInstance(firebaseApp);
    }
}
