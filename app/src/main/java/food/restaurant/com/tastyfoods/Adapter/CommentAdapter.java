package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import food.restaurant.com.tastyfoods.Model.Comment;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/10/2018.
 */

public class CommentAdapter   extends RecyclerView.Adapter<CommentAdapter.ViewHolder>  {
    private List<Comment> mModelList;
    private Context mContext;

    public CommentAdapter(Context context, List<Comment> list) {
        mModelList = list;
        mContext = context;
    }
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.comment_list_item, parent, false);

        // Return a new holder instance
        CommentAdapter.ViewHolder viewHolder = new CommentAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Comment list = mModelList.get(position);

        // Set item views based on your views and data model
        viewHolder.mUser.setText(list.getUserName());
        viewHolder.mComment.setText(list.getUserComment());
        viewHolder.mImg.setImageResource(list.getUserImg());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mUser;
        private TextView mComment;
        private ImageView mImg;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mUser = (TextView) itemView.findViewById(R.id.textViewUser);
            mComment = (TextView) itemView.findViewById(R.id.textViewComment);
            mImg = (ImageView) itemView.findViewById(R.id.profile_image);
        }
    }
}
