package com.lsjwzh.media.exoplayercompat;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * interface for MediaPlayerCompat
 * Created by panwenye on 14-8-19.
 */
public abstract class MediaPlayerCompat {
    public interface EventListener{
        void onPrepared();
        void onStart();
        void onPlayComplete();
        void onSeekComplete(long positionAfterSeek);
        void onPause();
        void onStop();
        void onReset();
        void onRelease();
        void onPositionUpdate(long position,long duration);
        void onVolumeChanged(float v1,float v2,float newV1,float newV2);
        void onBuffering(long loaded,long all);
        void onError(Exception e);
    }
    final LinkedList<EventListener> mListeners = new LinkedList<EventListener>();


    /**
     * @param context only needed in ExoPlayer,SysMediaPlayer will ignore this arg
     * @param path data source uri
     */
    public abstract void setDataSource(Context context,String path);
    /**
     * prepare the media.
     */
    public abstract void prepare();
    public abstract void prepareAsync(Runnable onPreparedComplete);
    public abstract void start();
    public abstract void seekTo(long position);
//    public abstract void seekTo(long position,Runnable seekCompleteCallback);
    public abstract void pause();
    public abstract void stop();
    public abstract void reset();
    public abstract void release();
    public abstract long getCurrentPosition();
    public abstract long getDuration();
    public abstract boolean isPlaying();
    public abstract boolean isPrepared();
    public abstract boolean isReleased();

    public abstract void setDisplay(SurfaceHolder holder);
    public abstract void setVolume(float v1, float v2);
    public abstract void setAudioStreamType(int streamMusic);

    public void addListener(EventListener listener){
        mListeners.add(listener);
    }
    public void removeListener(EventListener listener){
        mListeners.remove(listener);
    }
    public List<EventListener> getListeners(){
        return mListeners;
    }
}
