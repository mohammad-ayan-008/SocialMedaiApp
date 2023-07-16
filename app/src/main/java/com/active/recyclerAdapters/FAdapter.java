package com.active.recyclerAdapters;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.active.Models.UserModel;
import com.active.Models.postModel;
import com.active.smallmedia.MainActivity;
import com.active.smallmedia.databinding.PostslayoutBinding;
import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class FAdapter extends FirestoreRecyclerAdapter<postModel, FAdapter.Holder> {

    private Context c;
    GoogleSignInAccount account;
    private Drawable liked,unliked;
    private OnLikedListener onliked;
    private onCommentHit t;
    public FAdapter(FirestoreRecyclerOptions<postModel> opt,Context c,Drawable linked,Drawable unliked) {
        super(opt);
        this.c=c;
        this.liked=liked;
        this.unliked=unliked;
        account= GoogleSignIn.getLastSignedInAccount(c);
    }
    @Override
    protected void onBindViewHolder(Holder arg1,int pos,postModel m){
        arg1.bind.Text.setText(m.getText());
        Glide.with(c).load(m.getUser().getImageUrl()).circleCrop().into(arg1.bind.Logo);
        arg1.bind.likes.setText(""+m.getLikedby().size());
        arg1.bind.commentsno.setText(""+m.getComments().size());
        if(m.getLikedby().contains(account.getId())){ 
            arg1.bind.liked.setImageResource(MainActivity.liked);
        }else{
            arg1.bind.liked.setImageResource(MainActivity.unliked);
        }
        
    }
    
    @Override 
    public Holder onCreateViewHolder(ViewGroup arg1,int l){
        PostslayoutBinding bind=PostslayoutBinding.inflate(LayoutInflater.from(arg1.getContext()),arg1,false);
        FAdapter.Holder h=new FAdapter.Holder(bind);
        h.bind.liked.setOnClickListener(V->{ 
          onliked.onLiked(getSnapshots().getSnapshot(h.getAdapterPosition()).getId());
        });
        h.bind.comments.setOnClickListener(T->{
            t.onClick(getSnapshots().getSnapshot(h.getAdapterPosition()).getId());
        });
        return h;
        
    }
    class Holder extends RecyclerView.ViewHolder {
        PostslayoutBinding bind;

        public Holder(PostslayoutBinding binding) {
            super(binding.getRoot());
            bind = binding;
        }
    }
    
    public interface OnLikedListener{
        void onLiked(String id);
    }
    public interface onCommentHit{
        void onClick(String id);
    }
    public void setOnLiked(OnLikedListener l){
        this.onliked = l;
    }
    public void setOnMessageShow(onCommentHit l){
        this.t = l;
    }
}
