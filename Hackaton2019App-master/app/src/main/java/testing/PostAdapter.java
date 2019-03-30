package testing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hackaton2019.R;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {


    //this context we will use to inflate the layout
    private Context ctx;

    //we are storing all the post in a list
    private List<Post> postList;

    //getting the context and product list with constructor
    public PostAdapter(Context ctx, List<Post> postList) {
        this.ctx = ctx;
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.problem_record_layout, null);
        return new PostViewHolder(view);
}

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        //getting the product of the specified position
        Post post = postList.get(position);
        //binding the data with the viewholder views
        holder.textViewId.setText(String.valueOf(post.getId()));
        holder.textViewUserId.setText(String.valueOf(post.getUserId()));
        holder.textViewTitle.setText(String.valueOf(post.getTitle()));
        holder.textViewText.setText(String.valueOf(post.getText()));


    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewId, textViewUserId, textViewText;

        public PostViewHolder(View itemView) {
            super(itemView);

            textViewUserId = itemView.findViewById(R.id.textViewUserId);
            textViewId= itemView.findViewById(R.id.textViewId);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewText = itemView.findViewById(R.id.textViewText);

        }
    }
}