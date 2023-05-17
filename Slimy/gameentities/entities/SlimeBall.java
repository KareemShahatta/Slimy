/*    */ package gameentities.entities;
/*    */ 
/*    */ import gameentities.EntityDirection;
/*    */ import gameentities.EntityType;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javafx.animation.KeyFrame;
/*    */ import javafx.animation.Timeline;
/*    */ import javafx.event.ActionEvent;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.layout.Pane;
/*    */ import javafx.util.Duration;
/*    */ import start.StartUp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlimeBall
/*    */   extends LivingEntity
/*    */ {
/* 23 */   static final Map<SlimeBall, Timeline> slimeBallMovementTimerMap = new HashMap<>();
/*    */   
/*    */   SlimeBall(StartUp startUp, Pane pane, EntityType type, Image skin, EntityDirection direction, int X, int Y) {
/* 26 */     super(startUp, pane, type, skin, direction, X, Y);
/*    */     
/* 28 */     Timeline slimeBallMovementTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.1D), event -> move(direction), new javafx.animation.KeyValue[0]) });
/* 29 */     slimeBallMovementTimer.setCycleCount(-1);
/* 30 */     slimeBallMovementTimer.play();
/*    */     
/* 32 */     slimeBallMovementTimerMap.put(this, slimeBallMovementTimer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void move(EntityDirection direction) {
/* 37 */     if (canMove(direction)) {
/*    */       
/* 39 */       if (!isSpawnerOnTheWay(direction))
/*    */       {
/* 41 */         if (!isEntityOnTheWay(direction)) {
/*    */           
/* 43 */           switch (direction) {
/*    */             
/*    */             case EAST:
/* 46 */               setDirection(EntityDirection.EAST);
/* 47 */               getSkin().setTranslateX(getSkin().getTranslateX() + 50.0D);
/* 48 */               setLocationX(getLocationX() + 50);
/*    */               break;
/*    */             
/*    */             case WEST:
/* 52 */               setDirection(EntityDirection.WEST);
/* 53 */               getSkin().setTranslateX(getSkin().getTranslateX() - 50.0D);
/* 54 */               setLocationX(getLocationX() - 50);
/*    */               break;
/*    */             
/*    */             case NORTH:
/* 58 */               setDirection(EntityDirection.NORTH);
/* 59 */               getSkin().setTranslateY(getSkin().getTranslateY() - 50.0D);
/* 60 */               setLocationY(getLocationY() - 50);
/*    */               break;
/*    */             
/*    */             case SOUTH:
/* 64 */               setDirection(EntityDirection.SOUTH);
/* 65 */               getSkin().setTranslateY(getSkin().getTranslateY() + 50.0D);
/* 66 */               setLocationY(getLocationY() + 50);
/*    */               break;
/*    */           } 
/*    */ 
/*    */         
/* 71 */         } else if (getEntityInDirection(direction) instanceof gameentities.entities.enemies.Enemy) {
/*    */           
/* 73 */           if ((getEntityInDirection(direction)).isAlive)
/*    */           {
/* 75 */             getEntityInDirection(direction).damage(1);
/* 76 */             deSpawn(true);
/*    */           }
/*    */         
/*    */         }
/*    */       
/*    */       }
/*    */     } else {
/*    */       
/* 84 */       deSpawn(true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gameentities\entities\SlimeBall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */