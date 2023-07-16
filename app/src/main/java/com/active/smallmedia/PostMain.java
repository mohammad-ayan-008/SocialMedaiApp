package com.active.smallmedia;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.active.Dao.postDao;
import com.active.smallmedia.databinding.LayoutPostMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class PostMain extends AppCompatActivity{
    LayoutPostMainBinding binding;
    GoogleSignInAccount accounts;
    @Override
        public void onCreate(Bundle arg0) {
            super.onCreate(arg0);
            // TODO: Implement this method
            binding = LayoutPostMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            accounts= GoogleSignIn.getLastSignedInAccount(this);
            binding.uploadpost.setOnClickListener(V->{
                postDao dao = new postDao();
                dao.addpost(PostMain.this,accounts.getId(),binding.postdata.getText().toString());
                   finish();
                
            });
        }
        
}
