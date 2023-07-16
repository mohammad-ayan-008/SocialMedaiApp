package com.active.smallmedia;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.active.Dao.userDao;
import com.active.Models.UserModel;
import com.active.smallmedia.databinding.LayoutGLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class GLogin extends AppCompatActivity {
    LayoutGLoginBinding binding;
    SignInButton login;
    private GoogleSignInClient client;
    @Override
        protected void onCreate(Bundle arg0) {
            super.onCreate(arg0);
            // TODO: Implement this method
            binding= LayoutGLoginBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            login=binding.signIn;
            login.setSize(SignInButton.SIZE_WIDE);
            
            //Options
             GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             .requestEmail()
             .build();
             GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
             if(account!=null){
              Toast.makeText(getApplicationContext(),account.getEmail(),0).show();
              startActivity(new Intent(GLogin.this,MainActivity.class));
              finish();  
             }
             
            //initializing login Client
             client = GoogleSignIn.getClient(this,gso);
             
         
            
        
            login.setOnClickListener(V->{
               login();
            });
        
        }
    
         void login(){
            Intent login_intent= client.getSignInIntent();
            startActivityForResult(login_intent,100);
         }
    
      @Override
        protected void onActivityResult(int arg0, int arg1, Intent arg2) {
            super.onActivityResult(arg0, arg1, arg2);
            // TODO: Implement this method
            if(arg0==100){
              Task<GoogleSignInAccount>  task= GoogleSignIn.getSignedInAccountFromIntent(arg2);
             try{
              GoogleSignInAccount account=task.getResult(ApiException.class);
              Toast.makeText(getApplicationContext(),account.getEmail(),0).show();
              UserModel model= new UserModel(account.getId(),account.getDisplayName(),account.getPhotoUrl().toString());
              userDao dao = new userDao();
                   dao.addUser(model).addOnSuccessListener(Void->{
                   startActivity(new Intent(GLogin.this,MainActivity.class));
                   finish();  
               });          
              }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),0).show();
              }
            }
        }
        
}
