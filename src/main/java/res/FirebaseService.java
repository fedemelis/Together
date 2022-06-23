package res;

import base.User.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.SneakyThrows;

public class FirebaseService {
    @SneakyThrows
    public String saveUserDetails(User user){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("user").document(user.getUsername()).set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
