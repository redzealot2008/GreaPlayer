package me.jeff.greaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    MediaPlayer mediaPlayer;
    IjkMediaPlayer ijkMediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        surfaceHolder.setFixedSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
//        surfaceView.setMinimumWidth(displayMetrics.widthPixels);
//        surfaceView.setMinimumHeight(displayMetrics.heightPixels);
        Log.i("Test=======", surfaceView.getWidth() + ",,," + surfaceView.getHeight());

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
//            ijkMediaPlayer = new IjkMediaPlayer();
//            ijkMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/WeiXin/1476591325604.mp4");
//            ijkMediaPlayer.setScreenOnWhilePlaying(true);
//            ijkMediaPlayer.setDisplay(surfaceHolder);
//            ijkMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            ijkMediaPlayer.prepareAsync();
//            ijkMediaPlayer.start();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            holder.setFixedSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
            surfaceView.invalidate();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/WeiXin/1476591325604.mp4");
            mediaPlayer.setScreenOnWhilePlaying(true);
            mediaPlayer.setDisplay(holder);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
