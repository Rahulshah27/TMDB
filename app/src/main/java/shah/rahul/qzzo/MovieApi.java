package shah.rahul.qzzo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import shah.rahul.qzzo.models.PoppularMovies;
import shah.rahul.qzzo.models.Result;

public class MovieApi {

    public static final String KEY= "4e44d9029b1270a757cddc766a1bcb63";
    public static final String url = "https://api.themoviedb.org/3/movie/popular/";

    public static MovieService movieService = null;

    public static MovieService getService() {
        if (movieService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            movieService = retrofit.create(MovieService.class);
        }
        return movieService;
    }


    public interface MovieService {
        @GET("?api_key="+KEY)
        Call<PoppularMovies> getMovieList();

        @GET("?api_key="+KEY)
        Call<Result> getResult();

    }

}


