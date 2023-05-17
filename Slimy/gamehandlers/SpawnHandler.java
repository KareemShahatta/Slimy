/*    */ package gamehandlers;
/*    */ 
/*    */ import gameentities.EntityDirection;
/*    */ import gameentities.EntityType;
/*    */ import gameentities.entities.enemies.Enemy_A;
/*    */ import gameentities.entities.enemies.Enemy_B;
/*    */ import gameentities.entities.enemies.Enemy_C;
/*    */ import java.util.concurrent.ThreadLocalRandom;
/*    */ import javafx.animation.KeyFrame;
/*    */ import javafx.animation.Timeline;
/*    */ import javafx.event.ActionEvent;
/*    */ import javafx.util.Duration;
/*    */ import start.StartUp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpawnHandler
/*    */ {
/*    */   private StartUp startUp;
/* 22 */   private Timeline spawnerTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(3.0D), event -> spawnEnemy(), new javafx.animation.KeyValue[0]) });
/*    */   
/*    */   public SpawnHandler(StartUp startUp) {
/* 25 */     this.startUp = startUp;
/*    */     
/* 27 */     this.spawnerTimer.setCycleCount(-1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void startSpawner() {
/* 32 */     this.spawnerTimer.play();
/*    */   }
/*    */   
/*    */   public void stopSpawner() {
/* 36 */     this.spawnerTimer.stop();
/*    */   }
/*    */   
/*    */   private void spawnEnemy() {
/* 40 */     int specificX = 0;
/* 41 */     int specificY = 0;
/*    */     
/* 43 */     int value = ThreadLocalRandom.current().nextInt(0, 4);
/* 44 */     switch (value) {
/*    */ 
/*    */       
/*    */       case 0:
/* 48 */         specificX = 50;
/* 49 */         specificY = 150;
/*    */         break;
/*    */ 
/*    */ 
/*    */       
/*    */       case 1:
/* 55 */         specificX = 1450;
/* 56 */         specificY = 150;
/*    */         break;
/*    */ 
/*    */ 
/*    */       
/*    */       case 2:
/* 62 */         specificX = 1450;
/* 63 */         specificY = 850;
/*    */         break;
/*    */ 
/*    */ 
/*    */       
/*    */       case 3:
/* 69 */         specificX = 50;
/* 70 */         specificY = 850;
/*    */         break;
/*    */     } 
/*    */ 
/*    */     
/* 75 */     determineEnemyype(specificX, specificY);
/*    */   }
/*    */   private void determineEnemyype(int X, int Y) {
/* 78 */     int value = ThreadLocalRandom.current().nextInt(0, 3);
/* 79 */     switch (value) {
/*    */ 
/*    */       
/*    */       case 0:
/* 83 */         new Enemy_A(this.startUp, this.startUp.getPaneHandler().getGamePane(), EntityType.ENEMY_A, ImageHandler.ENEMY_A, EntityDirection.NORTH, X, Y);
/*    */         break;
/*    */ 
/*    */ 
/*    */       
/*    */       case 1:
/* 89 */         new Enemy_B(this.startUp, this.startUp.getPaneHandler().getGamePane(), EntityType.ENEMY_B, ImageHandler.ENEMY_B, EntityDirection.NORTH, X, Y);
/*    */         break;
/*    */ 
/*    */ 
/*    */       
/*    */       case 2:
/* 95 */         new Enemy_C(this.startUp, this.startUp.getPaneHandler().getGamePane(), EntityType.ENEMY_C, ImageHandler.ENEMY_C, EntityDirection.NORTH, X, Y);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\SpawnHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */