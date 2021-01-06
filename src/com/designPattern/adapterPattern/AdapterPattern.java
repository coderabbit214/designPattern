package com.designPattern.adapterPattern;

/**
 * 适配器模式
 * 把一个接口转换成用户希望的另一个接口，使的原本不兼容而不能一起工作的类可以一起工作。
 */
public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new AudioPlayer();
        mediaPlayer.play("mp4","111");
    }
}
//创建播放器接口
interface MediaPlayer{
    void play(String audioType, String fileName);
}
//创建高级播放器接口
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
//实现高级播放器接口
class VlcMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("playVlc"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
class Mp4MediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playMp4"+fileName);
    }
}
//创建实现了 MediaPlayer 接口的适配器类
class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;
    MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMediaPlayer = new VlcMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4MediaPlayer();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
//创建实现了 MediaPlayer 接口的实体类
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}