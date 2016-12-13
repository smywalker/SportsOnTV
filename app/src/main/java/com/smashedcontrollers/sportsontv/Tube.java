package com.smashedcontrollers.sportsontv;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Tube extends YouTubeBaseActivity {
    //Created variables
    Button play;
    private YouTubePlayerView tubePlayerView;
    private YouTubePlayer.OnInitializedListener newInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tube);
        Toast newToast = Toast.makeText(Tube.this ,"Highlights", Toast.LENGTH_SHORT);
        newToast.show();
        //Reference the youtube view
        tubePlayerView = (YouTubePlayerView) findViewById(R.id.ytView);
        //Initialise youtube listener
        newInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override//called when initialised e.g when we play vid
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("IWsEWC5P-EY");//vido link
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        //set the button to play vid when pressed
        play = (Button) findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tubePlayerView.initialize("AIzaSyAMAG_4m_o11jnsgBhe2mJ8TEtbwx7d3vo", newInitializedListener);//Youtube api key
            }
        });

    }


}
