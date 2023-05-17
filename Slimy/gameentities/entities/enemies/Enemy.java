/*     */ package gameentities.entities.enemies;
/*     */ 
/*     */ import gameentities.EntityDirection;
/*     */ import gameentities.EntityType;
/*     */ import gameentities.entities.LivingEntity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ThreadLocalRandom;
/*     */ import javafx.animation.KeyFrame;
/*     */ import javafx.animation.Timeline;
/*     */ import javafx.animation.TranslateTransition;
/*     */ import javafx.event.ActionEvent;
/*     */ import javafx.scene.Node;
/*     */ import javafx.scene.image.Image;
/*     */ import javafx.scene.layout.Pane;
/*     */ import javafx.util.Duration;
/*     */ import start.StartUp;

import static gameentities.EntityDirection.*;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Enemy
/*     */   extends LivingEntity
/*     */ {
/*     */   public static int enemiesCount;
/*  27 */   public static final Map<Enemy, Timeline> enemiesMovementTimersMap = new HashMap<>();
/*     */   
/*     */   Enemy(StartUp startUp, Pane pane, EntityType type, Image skin, EntityDirection direction, int X, int Y) {
/*  30 */     super(startUp, pane, type, skin, direction, X, Y); Timeline enemiesMovementTimer;
/*  31 */     enemiesCount++;
/*     */     
/*  33 */     startUp.getGraphicHandler().updateEnemiesGraphicalCount();
/*     */ 
/*     */ 
/*     */     
/*  37 */     switch (direction) { case EAST:
/*  38 */         enemiesMovementTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.5D), event -> moveEnemy(), new javafx.animation.KeyValue[0]) }); break;
/*  39 */       case WEST: enemiesMovementTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.8D), event -> moveEnemy(), new javafx.animation.KeyValue[0]) }); break;
/*  40 */       case NORTH: enemiesMovementTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(1.6D), event -> moveEnemy(), new javafx.animation.KeyValue[0]) }); break;
/*  41 */       default: enemiesMovementTimer = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(1.0D), event -> moveEnemy(), new javafx.animation.KeyValue[0]) });
/*     */         break; }
/*     */     
/*  44 */     enemiesMovementTimer.setCycleCount(-1);
/*  45 */     enemiesMovementTimer.play();
/*     */     
/*  47 */     enemiesMovementTimersMap.put(this, enemiesMovementTimer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void move(EntityDirection direction) {
/*  52 */     if (canMove(direction))
/*     */     {
/*  54 */       if (!isSpawnerOnTheWay(direction))
/*     */       {
/*  56 */         if (!isEntityOnTheWay(direction)) {
/*     */           
/*  58 */           if (isSteady())
/*     */           {
/*  60 */             setStead(false);
/*     */             
/*  62 */             TranslateTransition mover = new TranslateTransition();
/*  63 */             mover.setNode((Node)getSkin());
/*  64 */             mover.setDuration(Duration.seconds(0.1D));
/*     */             
/*  66 */             switch (direction) {
/*     */               
/*     */               case EAST:
/*  69 */                 setDirection(EAST);
/*  70 */                 mover.setByX(50.0D);
/*  71 */                 setLocationX(getLocationX() + 50);
/*     */                 break;
/*     */               
/*     */               case WEST:
/*  75 */                 setDirection(WEST);
/*  76 */                 mover.setByX(-50.0D);
/*  77 */                 setLocationX(getLocationX() - 50);
/*     */                 break;
/*     */               
/*     */               case NORTH:
/*  81 */                 setDirection(NORTH);
/*  82 */                 mover.setByY(-50.0D);
/*  83 */                 setLocationY(getLocationY() - 50);
/*     */                 break;
/*     */               
/*     */               case SOUTH:
/*  87 */                 setDirection(EntityDirection.SOUTH);
/*  88 */                 mover.setByY(50.0D);
/*  89 */                 setLocationY(getLocationY() + 50);
/*     */                 break;
/*     */             } 
/*     */             
/*  93 */             Timeline movingDelay = new Timeline(new KeyFrame[] { new KeyFrame(Duration.seconds(0.1D), event -> setStead(true), new javafx.animation.KeyValue[0]) });
/*  94 */             movingDelay.play();
/*     */             
/*  96 */             mover.play();
/*     */           }
/*     */         
/*     */         }
/* 100 */         else if (getEntityInDirection(direction) instanceof gameentities.entities.Player) {
/*     */           
/* 102 */           if (isSteady()) {
/*     */             
/* 104 */             this.startUp.getSoundHandler().playPlayerDamageSound();
/*     */             
/* 106 */             if (getType().equals(EntityType.ENEMY_C)) {
/*     */               
/* 108 */               this.startUp.getPlayer().damage(2);
/*     */             }
/* 110 */             else if (getType().equals(EntityType.ENEMY_A) || getType().equals(EntityType.ENEMY_B)) {
/*     */               
/* 112 */               this.startUp.getPlayer().damage(1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void moveEnemy() {
/* 121 */     int value = ThreadLocalRandom.current().nextInt(0, 2);
/* 122 */     switch (value) {
/*     */ 
/*     */       
/*     */       case 0:
/* 126 */         moveByX();
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 132 */         moveByY();
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void moveByX() {
/* 138 */     int targetX = this.startUp.getPlayer().getLocationX();
/*     */     
/* 140 */     if (getLocationX() > targetX) {
/*     */       
/* 142 */       move(WEST);
/*     */     }
/* 144 */     else if (getLocationX() < targetX) {
/*     */       
/* 146 */       move(EAST);
/*     */     }
/* 148 */     else if (getLocationX() == targetX && getLocationY() != this.startUp.getPlayer().getLocationY()) {
/*     */       
/* 150 */       moveByY();
/*     */     } 
/*     */   }
/*     */   private void moveByY() {
/* 154 */     int targetY = this.startUp.getPlayer().getLocationY();
/*     */     
/* 156 */     if (getLocationY() > targetY) {
/*     */       
/* 158 */       move(NORTH);
/*     */     }
/* 160 */     else if (getLocationY() < targetY) {
/*     */       
/* 162 */       move(EntityDirection.SOUTH);
/*     */     }
/* 164 */     else if (getLocationY() == targetY && getLocationX() != this.startUp.getPlayer().getLocationX()) {
/*     */       
/* 166 */       moveByX();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gameentities\entities\enemies\Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */