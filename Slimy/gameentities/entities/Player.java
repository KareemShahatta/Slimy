/*    */ package gameentities.entities;
/*    */ 
/*    */ import gameentities.EntityDirection;
/*    */ import gameentities.EntityType;
/*    */ import gamehandlers.ImageHandler;
/*    */ import javafx.animation.KeyFrame;
/*    */ import javafx.animation.Timeline;
/*    */ import javafx.animation.TranslateTransition;
/*    */ import javafx.event.ActionEvent;
/*    */ import javafx.scene.Node;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.layout.Pane;
/*    */ import javafx.util.Duration;
/*    */ import start.StartUp;
/*    */ 
/*    */ 
/*    */ public class Player
/*    */   extends LivingEntity
/*    */ {
/*    */   private int entityScore;
/*    */   private boolean isShooting = false;
/*    */   
/*    */   public Player(StartUp startup, Pane pane, EntityType type, Image skin, EntityDirection direction, int X, int Y) {
/* 24 */     super(startup, pane, type, skin, direction, X, Y);
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 28 */     return this.entityScore;
/*    */   } void increaseScore() {
/* 30 */     this.startUp.getSoundHandler().playPlayerScoringSound();
/* 31 */     this.entityScore++;
/* 32 */     this.startUp.getGraphicHandler().updatePlayerGraphicalScore();
/*    */   }
/*    */ 
/*    */   
/*    */   public void move(EntityDirection direction) {
/* 37 */     if (canMove(direction))
/*    */     {
/* 39 */       if (!isSpawnerOnTheWay(direction))
/*    */       {
/* 41 */         if (!isEntityOnTheWay(direction))
/*    */         {
/* 43 */           if (isSteady()) {
/*    */             
/* 45 */             setStead(false);
/*    */             
/* 47 */             TranslateTransition mover = new TranslateTransition();
/* 48 */             mover.setNode((Node)getSkin());
/* 49 */             mover.setDuration(Duration.seconds(0.1D));
/*    */             
/* 51 */             switch (direction) {
/*    */               
/*    */               case EAST:
/* 54 */                 setDirection(EntityDirection.EAST);
/* 55 */                 mover.setByX(50.0D);
/* 56 */                 setLocationX(getLocationX() + 50);
/*    */                 break;
/*    */               
/*    */               case WEST:
/* 60 */                 setDirection(EntityDirection.WEST);
/* 61 */                 mover.setByX(-50.0D);
/* 62 */                 setLocationX(getLocationX() - 50);
/*    */                 break;
/*    */               
/*    */               case NORTH:
/* 66 */                 setDirection(EntityDirection.NORTH);
/* 67 */                 mover.setByY(-50.0D);
/* 68 */                 setLocationY(getLocationY() - 50);
/*    */                 break;
/*    */               
/*    */               case SOUTH:
/* 72 */                 setDirection(EntityDirection.SOUTH);
/* 73 */                 mover.setByY(50.0D);
/* 74 */                 setLocationY(getLocationY() + 50);
/*    */                 break;
/*    */             } 
/*    */             
/* 78 */             Timeline movingDelay = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.1D), event -> setStead(true), new javafx.animation.KeyValue[0]) });
/* 79 */             movingDelay.play();
/*    */             
/* 81 */             mover.play();
/*    */           } 
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void shoot() {
/* 89 */     if (!this.isShooting) {
/*    */       
/* 91 */       this.isShooting = true;
/* 92 */       getSkin().setImage(ImageHandler.SLIMY_SHOOT);
/* 93 */       new SlimeBall(this.startUp, getPane(), EntityType.SLIME_BALL, ImageHandler.SLIMY_BALL, getDirection(), getLocationX(), getLocationY());
/* 94 */       Timeline movingDelay = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(1.0D), event -> { this.isShooting = false; getSkin().setImage(ImageHandler.SLIMY_NORMAL); })});
/* 95 */       movingDelay.play();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gameentities\entities\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */