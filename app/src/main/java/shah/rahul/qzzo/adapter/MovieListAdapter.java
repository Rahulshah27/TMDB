package shah.rahul.qzzo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import shah.rahul.qzzo.R;
import shah.rahul.qzzo.models.PoppularMovies;
import shah.rahul.qzzo.models.Result;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<Result> mResult;
    private LayoutInflater mInflater;
    Context context;

    public MovieListAdapter(Context context, List<Result> mResult) {
        this.context = context;
        this.mResult = mResult;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_movie_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(mResult.get(position));
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle, mOverView;
        ImageView mImage;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tv_title);
            mOverView = itemView.findViewById(R.id.tv_overview);
            mImage = itemView.findViewById(R.id.iv_image);
        }


        public void bind(Result result) {
            mTitle.setText(result.getTitle());
            mOverView.setText(result.getOverview());

            Glide.with(context).load(result.getBackdropPath()).into(mImage);
        }
    }
}
