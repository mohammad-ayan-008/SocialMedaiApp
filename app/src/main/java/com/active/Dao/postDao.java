package com.active.Dao;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.active.Dao.userDao;
import com.active.Models.UserModel;
import com.active.Models.postModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class postDao {
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    public CollectionReference reff = fs.collection("post");
    public UserModel model;
    private postModel pmodel, P_mdl;

    public void addpost(Context c, String GID, String text) {
        userDao dao = new userDao();

        dao.getUser(GID)
                .addOnCompleteListener(
                        new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(Task<DocumentSnapshot> arg0) {
                                if (arg0.isSuccessful()) {
                                    UserModel m =
                                            (UserModel) arg0.getResult().toObject(UserModel.class);

                                    if (m != null) {
                                        Toast.makeText(c, m.getDisplayName(), 0).show();
                                        pmodel = new postModel(text, m, System.currentTimeMillis());
                                        reff.document().set(pmodel);
                                    } else {
                                        Log.e("Task", "Nullll");
                                    }
                                }
                            }
                        });
    }

    public void UpdateLikes(String id, String sid) {
        reff.document(id)
                .get()
                .addOnCompleteListener(
                        new OnCompleteListener<DocumentSnapshot>() {

                            @Override
                            public void onComplete(Task<DocumentSnapshot> arg0) {
                             if(arg0.isSuccessful()){
                                P_mdl = arg0.getResult().toObject(postModel.class);
                                if(!P_mdl.getLikedby().contains(sid)){
                                    P_mdl.getLikedby().add(sid);
                                }else{
                                    P_mdl.getLikedby().remove(sid);
                                }
                                reff.document(id).set(P_mdl);
                             }
                            }
                        });
    }
}
