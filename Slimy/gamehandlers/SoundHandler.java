/*    */ package gamehandlers;
/*    */ 
/*    */ import javafx.scene.media.AudioClip;
/*    */ 
/*    */ public class SoundHandler
/*    */ {
/*    */   void playMouseHoverSound() {
/*  8 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/mouse_hover.wav").toExternalForm());
/*  9 */     audioPlayer.setVolume(0.4D);
/* 10 */     audioPlayer.play();
/*    */   }
/*    */   public void playGameStartSound() {
/* 13 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/game_start.wav").toExternalForm());
/* 14 */     audioPlayer.setVolume(0.4D);
/* 15 */     audioPlayer.play();
/*    */   }
/*    */   public void playGameEndSound() {
/* 18 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/game_end.wav").toExternalForm());
/* 19 */     audioPlayer.setVolume(0.4D);
/* 20 */     audioPlayer.play();
/*    */   }
/*    */   void playPlayerShootingSound() {
/* 23 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/player_shoot.wav").toExternalForm());
/* 24 */     audioPlayer.setVolume(0.4D);
/* 25 */     audioPlayer.play();
/*    */   }
/*    */   public void playPlayerScoringSound() {
/* 28 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/player_score.wav").toExternalForm());
/* 29 */     audioPlayer.setVolume(0.4D);
/* 30 */     audioPlayer.play();
/*    */   }
/*    */   public void playPlayerDamageSound() {
/* 33 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/player_damage.wav").toExternalForm());
/* 34 */     audioPlayer.setVolume(0.4D);
/* 35 */     audioPlayer.play();
/*    */   }
/*    */   public void playSlimeBallHitSound() {
/* 38 */     AudioClip audioPlayer = new AudioClip(ClassLoader.getSystemResource("sounds/slime_ball_hit.wav").toExternalForm());
/* 39 */     audioPlayer.setVolume(0.2D);
/* 40 */     audioPlayer.play();
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\SoundHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */