package com.vogella.android.minim2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    APIInterface ApiInterface;
    MyRecyclerViewAdapter adapter;

    private String username;
    private GithubUser user;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView usernametext = findViewById(R.id.UserTextView);
        TextView followers = findViewById(R.id.FollowersTextView);
        TextView following = findViewById(R.id.FollowingTextView);

        RecyclerView repositories = findViewById(R.id.RepositoriesRecyclerView);


        String firstline = "Username:" + user.getName();
        String secondline = "Followers:  " + user.getFollowers();
        String thirdline = "Following:  " + user.getFollowing();

        usernametext.setText(firstline);
        followers.setText(secondline);
        following.setText(thirdline);

        final Intent getUser_Intent = getIntent();
        username = getUser_Intent.getStringExtra("username");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);




        ApiInterface = APIClient.getClient().create(APIInterface.class);

    }
}