/*    */ package gamehandlers;
/*    */ 
/*    */ import gameentities.entities.enemies.Enemy;
/*    */ import javafx.scene.Parent;
/*    */ import start.GameWindows;
/*    */ import start.StartUp;
/*    */ 
/*    */ 
/*    */ public class GraphicHandler
/*    */ {
/*    */   private final StartUp startUp;
/*    */   
/*    */   public GraphicHandler(StartUp startUp) {
/* 14 */     this.startUp = startUp;
/*    */   }
/*    */   
/*    */   public void updateEnemiesGraphicalCount() {
/* 18 */     this.startUp.getPaneHandler().getEnemiesCountText().setText("ENEMIES: " + Enemy.enemiesCount);
/*    */   }
/*    */   public void updatePlayerGraphicalHealth() {
/* 21 */     if (this.startUp.getPlayer().getHealth() >= 1) {
/*    */       
/* 23 */       this.startUp.getPaneHandler().getPlayerHealthText().setText("HEALTH: " + this.startUp.getPlayer().getHealth() + "  || ");
/*    */     }
/*    */     else {
/*    */       
/* 27 */       setCurrentDisplayedWindow(GameWindows.FINISH);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void updatePlayerGraphicalScore() {
/* 32 */     this.startUp.getPaneHandler().getPlayerScoreText().setText("<<<< SCORE " + this.startUp.getPlayer().getScore() + " >>>> || ");
/* 33 */     this.startUp.getPaneHandler().getPlayerFinalScoreText().setText("YOUR FINAL SCORE: " + this.startUp.getPlayer().getScore());
/*    */   }
/*    */   
/*    */   public void setCurrentDisplayedWindow(GameWindows wantedScreen) {
/* 37 */     if (wantedScreen.equals(GameWindows.START)) {
/*    */       
/* 39 */       this.startUp.getGameScene().setRoot((Parent)this.startUp.getPaneHandler().getStartPane());
/* 40 */     } else if (wantedScreen.equals(GameWindows.GAME)) {
/*    */       
/* 42 */       this.startUp.startGame();
/* 43 */       this.startUp.getGameScene().setRoot((Parent)this.startUp.getPaneHandler().getGamePane());
/*    */     }
/* 45 */     else if (wantedScreen.equals(GameWindows.FINISH)) {
/*    */       
/* 47 */       this.startUp.finishGame();
/* 48 */       this.startUp.getGameScene().setRoot((Parent)this.startUp.getPaneHandler().getFinishPane());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\GraphicHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */