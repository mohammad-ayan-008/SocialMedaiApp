package com.active.smallmedia;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.active.Dao.postDao;
import com.active.Models.postModel;
import com.active.recyclerAdapters.FAdapter;
import com.active.smallmedia.commentsActivity;
import com.active.smallmedia.databinding.ActivityMainBinding;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.itsaky.androidide.logsender.LogSender;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    GoogleSignInClient client;
    RecyclerView recycler;
    FAdapter adapter;
    GoogleSignInAccount account;
    public static int liked = R.drawable.liked;
    public static int unliked = R.drawable.unliked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Remove this line if you don't want AndroidIDE to show this app's logs
        LogSender.startLogging(this);
        super.onCreate(savedInstanceState);
        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());
        recycler = binding.recycler;
        recycler.setLayoutManager(new LinearLayoutManager(this));

        account = GoogleSignIn.getLastSignedInAccount(this);
        binding.Post.setOnClickListener(
                V -> {
                    Intent move = new Intent(MainActivity.this, PostMain.class);
                    startActivity(move);
                });

        GoogleSignInOptions gso =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();

        // initializing login Client
        client = GoogleSignIn.getClient(this, gso);
        postDao dao = new postDao();
        Query q = dao.reff.orderBy("createdAt", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions options =
                new FirestoreRecyclerOptions.Builder<postModel>()
                        .setQuery(q, postModel.class)
                        .build();

        Drawable liked = getResources().getDrawable(R.drawable.liked);
        Drawable unliked = getResources().getDrawable(R.drawable.unliked);
        adapter = new FAdapter(options, MainActivity.this, unliked, liked);
        recycler.setAdapter(adapter);
        adapter.setOnLiked(
                new FAdapter.OnLikedListener() {

                    @Override
                    public void onLiked(String id) {
                        postDao dao = new postDao();
                        dao.UpdateLikes(id, account.getId());
                    }
                });
        adapter.setOnMessageShow(
                new FAdapter.onCommentHit() {

                    @Override
                    public void onClick(String id) {
                        Intent move = new Intent(MainActivity.this,commentsActivity.class);
                        move.putExtra("ID",id);
                        move.putExtra("PIC",account.getPhotoUrl().toString());
                        startActivity(move);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu arg0) {
        // TODO: Implement this metho
        getMenuInflater().inflate(R.menu.options, arg0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem arg0) {
        // TODO: Implement this method
        switch (arg0.getItemId()) {
            case R.id.logOut:
                signOut();
                break;
        }
        return super.onOptionsItemSelected(arg0);
    }

    void signOut() {
        client.signOut()
                .addOnCompleteListener(
                        Void -> {
                            Intent move = new Intent(MainActivity.this, GLogin.class);
                            startActivity(move);
                            finish();
                        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
        // TODO: Implement this method
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // TODO: Implement this method
        adapter.stopListening();
    }
}
