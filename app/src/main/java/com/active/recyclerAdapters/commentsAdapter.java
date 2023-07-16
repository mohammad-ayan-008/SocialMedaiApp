package com.active.recyclerAdapters;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.active.Models.CommentModel;
import com.active.recyclerAdapters.commentsAdapter;
import com.active.smallmedia.databinding.CommentsActivityBinding;
import com.active.smallmedia.databinding.CommentsviewBinding;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class commentsAdapter  extends RecyclerView.Adapter<commentsAdapter.Holder>{
    private Context c;
    private ArrayList<CommentModel> list;
    
    public commentsAdapter (Context c,ArrayList<CommentModel> list){
        this.c=c;
        this.list=list;
    }
    
    class Holder extends RecyclerView.ViewHolder{
        CommentsviewBinding bidning;
        Holder (CommentsviewBinding bind){
            super(bind.getRoot());
            this.bidning=bind;
        }
    }
    
    

@Override
public int getItemCount() {
    return list.size();
}

@Override
public void onBindViewHolder(Holder arg0, int arg1) {
     CommentModel model = list.get(arg1);
     arg0.bidning.comment.setText(model.getComment());
     Glide.with(c).load(model.getU_pic()).circleCrop().into(arg0.bidning.userpic);
}

@Override
public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
    return new commentsAdapter.Holder(CommentsviewBinding.inflate(LayoutInflater.from(c),arg0,false));
}
}

