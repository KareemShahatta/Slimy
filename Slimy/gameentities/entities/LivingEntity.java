/*     */ package gameentities.entities;
/*     */ 
/*     */ import gameentities.EntityDirection;
/*     */ import gameentities.EntityType;
/*     */ import gameentities.entities.enemies.Enemy;
/*     */ import gamehandlers.ImageHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javafx.animation.Timeline;
/*     */ import javafx.scene.image.Image;
/*     */ import javafx.scene.image.ImageView;
/*     */ import javafx.scene.layout.Pane;
/*     */ import start.StartUp;

import static gameentities.EntityDirection.*;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LivingEntity
/*     */ {
/*  24 */   public static final List<LivingEntity> entities = new ArrayList<>();
/*     */   
/*     */   protected final StartUp startUp;
/*     */   
/*     */   boolean isAlive = true;
/*     */   
/*     */   private boolean isSteady = true;
/*     */   
/*     */   private int locationX;
/*     */   
/*     */   private int locationY;
/*     */   
/*     */   private Pane entityPane;
/*     */   private int entityHealth;
/*     */   private ImageView entitySkin;
/*     */   private EntityType entityType;
/*     */   private EntityDirection entityDirection;
/*     */   
/*     */   public LivingEntity(StartUp startUp, Pane pane, EntityType type, Image skin, EntityDirection direction, int X, int Y) {
/*  43 */     this.startUp = startUp;
/*  44 */     entities.add(this);
/*     */     
/*  46 */     this.entityPane = pane;
/*  47 */     this.entityType = type;
/*  48 */     this.entityDirection = direction;
/*     */ 
/*     */     
/*  51 */     this.entitySkin = new ImageView(skin);
/*  52 */     this.entitySkin.setTranslateX(X);
/*  53 */     this.entitySkin.setTranslateY(Y);
/*     */     
/*  55 */     this.locationX = X;
/*  56 */     this.locationY = Y;
/*     */     
/*  58 */     switch (this.entityDirection) {
/*     */       case EAST: this.entityHealth = 10; break;
/*  61 */       case WEST: this.entityHealth = 2; break;
/*  62 */       case NORTH: this.entityHealth = 3; break;
/*  63 */       case SOUTH: this.entityHealth = 4;
/*     */         break;
/*     */     } 
/*  66 */     this.entityPane.getChildren().add(this.entitySkin);
/*     */   }
/*     */   
/*     */   protected boolean isSteady() {
/*  70 */     return this.isSteady;
/*     */   }
/*     */   protected void setStead(boolean value) {
/*  73 */     this.isSteady = value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLocationX() {
/*  79 */     return this.locationX;
/*     */   }
/*     */   
/*     */   public int getLocationY() {
/*  83 */     return this.locationY;
/*     */   }
/*     */   
/*     */   protected void setLocationX(int value) {
/*  87 */     this.locationX = value;
/*     */   }
/*     */   
/*     */   protected void setLocationY(int value) {
/*  91 */     this.locationY = value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   EntityDirection getDirection() {
/*  97 */     return this.entityDirection;
/*     */   }
/*     */   
/*     */   protected void setDirection(EntityDirection direction) {
/* 101 */     this.entityDirection = direction;
/*     */   }
/*     */   
/*     */   protected ImageView getSkin() {
/* 105 */     return this.entitySkin;
/*     */   }
/*     */   protected EntityType getType() {
/* 108 */     return this.entityType;
/*     */   }
/*     */   public int getHealth() {
/* 111 */     return this.entityHealth;
/*     */   }
/*     */   
/*     */   Pane getPane() {
/* 115 */     return this.entityPane;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deSpawn(boolean running) {
/* 121 */     this.isAlive = false;
/* 122 */     this.entityPane.getChildren().remove(this.entitySkin);
/*     */     
/* 124 */     if (this instanceof Enemy) {
/*     */       
/* 126 */       Enemy.enemiesCount--;
/* 127 */       if (running)
/*     */       {
/* 129 */         this.startUp.getPlayer().increaseScore();
/*     */       }
/* 131 */       this.startUp.getGraphicHandler().updateEnemiesGraphicalCount();
/*     */       
/* 133 */       if (Enemy.enemiesMovementTimersMap.containsKey(this))
/*     */       {
/* 135 */         ((Timeline)Enemy.enemiesMovementTimersMap.get(this)).stop();
/*     */       }
/*     */     }
/* 138 */     else if (this instanceof SlimeBall) {
/*     */       
/* 140 */       if (SlimeBall.slimeBallMovementTimerMap.containsKey(this))
/*     */       {
/* 142 */         ((Timeline)SlimeBall.slimeBallMovementTimerMap.get(this)).stop(); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void damage(int value) {
/* 147 */     if (this instanceof Enemy) {
/*     */       
/* 149 */       this.startUp.getSoundHandler().playSlimeBallHitSound();
/*     */       
/* 151 */       if (this.entityType == EntityType.ENEMY_A) {
/*     */ 
/*     */         
/* 154 */         if (this.entityHealth == 2)
/*     */         {
/* 156 */           this.entitySkin.setImage(ImageHandler.ENEMY_A_DAMAGED);
/* 157 */           this.entityHealth -= value;
/*     */         }
/* 159 */         else if (this.entityHealth == 1)
/*     */         {
/* 161 */           deSpawn(true);
/*     */         }
/*     */       
/* 164 */       } else if (this.entityType == EntityType.ENEMY_B) {
/*     */         
/* 166 */         if (this.entityHealth == 3)
/*     */         {
/* 168 */           this.entitySkin.setImage(ImageHandler.ENEMY_A);
/* 169 */           this.entityHealth -= value;
/*     */         }
/* 171 */         else if (this.entityHealth == 2)
/*     */         {
/* 173 */           this.entitySkin.setImage(ImageHandler.ENEMY_A_DAMAGED);
/* 174 */           this.entityHealth -= value;
/*     */         }
/* 176 */         else if (this.entityHealth == 1)
/*     */         {
/* 178 */           deSpawn(true);
/*     */         }
/*     */       
/* 181 */       } else if (this.entityType == EntityType.ENEMY_C) {
/*     */         
/* 183 */         if (this.entityHealth == 4)
/*     */         {
/* 185 */           this.entitySkin.setImage(ImageHandler.ENEMY_B);
/* 186 */           this.entityHealth -= value;
/*     */         }
/* 188 */         else if (this.entityHealth == 3)
/*     */         {
/* 190 */           this.entitySkin.setImage(ImageHandler.ENEMY_A);
/* 191 */           this.entityHealth -= value;
/*     */         }
/* 193 */         else if (this.entityHealth == 2)
/*     */         {
/* 195 */           this.entitySkin.setImage(ImageHandler.ENEMY_A_DAMAGED);
/* 196 */           this.entityHealth -= value;
/*     */         }
/* 198 */         else if (this.entityHealth == 1)
/*     */         {
/* 200 */           deSpawn(true);
/*     */         }
/*     */       
/*     */       } 
/* 204 */     } else if (this.entityType == EntityType.PLAYER) {
/*     */       
/* 206 */       this.startUp.getSoundHandler().playPlayerDamageSound();
/* 207 */       this.entityHealth -= value;
/* 208 */       this.startUp.getGraphicHandler().updatePlayerGraphicalHealth();
/*     */     } 
/*     */   }
/*     */   public abstract void move(EntityDirection paramEntityDirection);
/*     */   
/*     */   protected boolean canMove(EntityDirection direction) {
/* 214 */     switch (direction) {
/*     */ 
/*     */       
/*     */       case EAST:
/* 218 */         if (this.locationX + 50 == 1500)
/*     */         {
/* 220 */           return false;
/*     */         }
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case WEST:
/* 227 */         if (this.locationX - 50 == 0)
/*     */         {
/* 229 */           return false;
/*     */         }
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case NORTH:
/* 236 */         if (this.locationY - 50 == 100)
/*     */         {
/* 238 */           return false;
/*     */         }
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case SOUTH:
/* 245 */         if (this.locationY + 50 == 900)
/*     */         {
/* 247 */           return false;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 253 */     return true;
/*     */   }
/*     */   protected boolean isSpawnerOnTheWay(EntityDirection direction) {
/* 256 */     int targetX = this.locationX;
/* 257 */     int targetY = this.locationY;
/*     */     
/* 259 */     switch (direction) {
/*     */       case WEST:
/* 261 */         targetX -= 50; break;
/* 262 */       case EAST: targetX += 50; break;
/* 263 */       case SOUTH: targetY += 50; break;
/* 264 */       case NORTH: targetY -= 50;
/*     */         break;
/*     */     } 
/*     */     
/* 268 */     return ((targetX == 50 && targetY == 150) || (targetX == 1450 && targetY == 150) || (targetX == 1450 && targetY == 850) || (targetX == 50 && targetY == 850));
/*     */   }
/*     */   protected boolean isEntityOnTheWay(EntityDirection direction) {
/* 271 */     int targetX = this.locationX;
/* 272 */     int targetY = this.locationY;
/*     */     
/* 274 */     switch (direction) {
/*     */       case WEST:
/* 276 */         targetX -= 50; break;
/* 277 */       case EAST: targetX += 50; break;
/* 278 */       case SOUTH: targetY += 50; break;
/* 279 */       case NORTH: targetY -= 50;
/*     */         break;
/*     */     } 
/*     */     
/* 283 */     for (LivingEntity entity : entities) {
/*     */       
/* 285 */       if (entity.isAlive)
/*     */       {
/* 287 */         if (!(entity instanceof SlimeBall))
/*     */         {
/* 289 */           if (targetX == entity.getLocationX() && targetY == entity.getLocationY())
/*     */           {
/* 291 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/* 296 */     return false;
/*     */   }
/*     */   protected LivingEntity getEntityInDirection(EntityDirection direction) {
/* 299 */     int targetX = this.locationX;
/* 300 */     int targetY = this.locationY;
/*     */     
/* 302 */     switch (direction) {
/*     */       case WEST:
/* 304 */         targetX -= 50; break;
/* 305 */       case EAST: targetX += 50; break;
/* 306 */       case SOUTH: targetY += 50; break;
/* 307 */       case NORTH: targetY -= 50;
/*     */         break;
/*     */     } 
/*     */     
/* 311 */     for (LivingEntity entity : entities) {
/*     */       
/* 313 */       if (entity.isAlive)
/*     */       {
/* 315 */         if (targetX == entity.getLocationX() && targetY == entity.getLocationY())
/*     */         {
/* 317 */           return entity;
/*     */         }
/*     */       }
/*     */     } 
/* 321 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gameentities\entities\LivingEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */