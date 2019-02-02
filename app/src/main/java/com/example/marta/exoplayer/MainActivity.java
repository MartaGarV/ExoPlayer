package com.example.marta.exoplayer;

import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    TextInputEditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.playerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //creamos el reproductor
        player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        //lo asociamos a la view
        playerView.setPlayer(player);

        String campo = getIntent().getExtras().getString("parametro");
        //origen de datos
        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this,"ExoPlayer");

        //archivo multimedia a partir de una url
        ExtractorMediaSource archivoMultimedia = new ExtractorMediaSource.Factory(dataSourceFactory).
                createMediaSource(Uri.parse(campo));


        //preparar el reproductor con el archivo
        player.prepare(archivoMultimedia);

        //lo ponemos en marcha
        player.setPlayWhenReady(true);

    }

    protected void onStop(){
        super.onStop();

        playerView.setPlayer(null);
        player.release();
        player = null;

    }
}
