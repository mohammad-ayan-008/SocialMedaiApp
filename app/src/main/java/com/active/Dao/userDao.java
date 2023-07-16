package com.active.Dao;
import com.active.Models.UserModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class userDao {
    FirebaseFirestore fs=FirebaseFirestore.getInstance();
    CollectionReference reff = fs.collection("users");
    
    
    public Task<Void> addUser(UserModel m){
       return reff.document(m.getUid()).set(m);
    }
    public Task<DocumentSnapshot> getUser(String Uid){
        return reff.document(Uid).get();
    }
    
}
