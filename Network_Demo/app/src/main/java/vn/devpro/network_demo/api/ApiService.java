package vn.devpro.network_demo.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import vn.devpro.network_demo.model.Post;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @POST("posts")
    Call<Post> createPost(@Body Post Post);

    @PUT("posts/{id}")
    Call<Post> updatePost(@Path("id") int id, @Body Post Post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
