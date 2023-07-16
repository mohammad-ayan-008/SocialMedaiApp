package com.active.smallmedia;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.active.Dao.postDao;
import com.active.Models.CommentModel;
import com.active.Models.postModel;
import com.active.recyclerAdapters.commentsAdapter;
import com.active.smallmedia.commentsActivity;
import com.active.smallmedia.databinding.CommentsActivityBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import java.util.ArrayList;

public class commentsActivity extends AppCompatActivity {
    CommentsActivityBinding binding;
    String Id,PIC;
    public postDao dao = new postDao();
    public postModel P_mdl;
    private ArrayList<CommentModel> model;
    private  RecyclerView Rc_View;
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        // TODO: Implement this method
        binding = CommentsActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Id = getIntent().getExtras().getString("ID");
        PIC = getIntent().getExtras().getString("PIC");
        
        Rc_View = binding.recyc;
        Rc_View.setLayoutManager(new LinearLayoutManager(this));
        dao.reff
                .document(Id)
                .get()
                .addOnCompleteListener(
                        new OnCompleteListener<DocumentSnapshot>() {

                            @Override
                            public void onComplete(Task<DocumentSnapshot> arg0) {
                              if(arg0.isSuccessful()){
                                  P_mdl = arg0.getResult().toObject(postModel.class);
                                  commentsAdapter adapter= new commentsAdapter(commentsActivity.this,P_mdl.getComments());
                                  Rc_View.setAdapter(adapter);
                              }
                            }
                        });
        
        binding.send.setOnClickListener(V->{
           if(!TextUtils.isEmpty(binding.mesaage.getText().toString())){
                if(P_mdl!=null){
                    CommentModel model = new CommentModel(binding.mesaage.getText().toString(),PIC);
                    P_mdl.getComments().add(model);
                    dao.reff.document(Id).set(P_mdl).addOnSuccessListener(Void->{
                       dao.reff
                       .document(Id)
                       .get()
                       .addOnCompleteListener(
                          new OnCompleteListener<DocumentSnapshot>() {

                              @Override
                               public void onComplete(Task<DocumentSnapshot> arg0) {
                                  if(arg0.isSuccessful()){
                                     P_mdl = arg0.getResult().toObject(postModel.class);
                                     commentsAdapter adapter= new commentsAdapter(commentsActivity.this,P_mdl.getComments());
                                     Rc_View.setAdapter(adapter);
                                     binding.mesaage.setText("");        
                                 }
                               }
                          }); 
                      });
                }
           }
        });
    }
}
