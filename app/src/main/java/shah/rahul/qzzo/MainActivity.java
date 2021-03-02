package shah.rahul.qzzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shah.rahul.qzzo.adapter.MovieListAdapter;
import shah.rahul.qzzo.models.PoppularMovies;
import shah.rahul.qzzo.models.Result;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Result> ProductsList;
    private RecyclerView cartRecyclerView;
    private MovieListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getData();
        getData2();
    }

    private void getData() {
        Call<PoppularMovies> poppularMoviesCall = MovieApi.getService().getMovieList();
        poppularMoviesCall.enqueue(new Callback<PoppularMovies>() {
            @Override
            public void onResponse(Call<PoppularMovies> call, Response<PoppularMovies> response) {
                PoppularMovies list = response.body();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PoppularMovies> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error!"+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getData2() {
        Call<Result> resultCall = MovieApi.getService().getResult();
        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                Toast.makeText(MainActivity.this, "Result Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error!"+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}