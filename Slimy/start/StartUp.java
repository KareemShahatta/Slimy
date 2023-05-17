/*    */ package start;
/*    */ import gameentities.entities.LivingEntity;
/*    */ import gameentities.entities.Player;
/*    */ import gamehandlers.*;
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ import javafx.application.Application;
/*    */ import javafx.event.EventHandler;
/*    */ import javafx.scene.Parent;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/*    */ import javafx.stage.WindowEvent;
/*    */ 
/*    */ public class StartUp extends Application {
/* 18 */   private Player player = null;
/*    */   
/* 20 */   private Scene gameScene = new Scene((Parent)new Pane(), 1550.0D, 950.0D);
/* 21 */   private final GraphicHandler graphicHandler = new GraphicHandler(this);
/* 22 */   private final MouseHandler mouseHandler = new MouseHandler(this);
/* 23 */   private final PaneHandler paneHandler = new PaneHandler(this);
/* 24 */   private final SpawnHandler spawnHandler = new SpawnHandler(this);
/* 25 */   private final SoundHandler soundHandler = new SoundHandler();
/*    */ 
/*    */ 
/*    */   
/*    */   public void start(Stage gameStage) {
/* 30 */     this.graphicHandler.setCurrentDisplayedWindow(GameWindows.START);
/*    */     
/* 32 */     gameStage.setOnCloseRequest(event -> {
/*    */           for (LivingEntity entity : LivingEntity.entities) {
/*    */             entity.deSpawn(false);
/*    */           }
/*    */         });
/*    */ 
/*    */ 
/*    */     
/* 40 */     gameStage.getIcons().add(ImageHandler.SLIMY_NORMAL);
/* 41 */     gameStage.setScene(this.gameScene);
/* 42 */     gameStage.setResizable(false);
/* 43 */     gameStage.setTitle("Slimy 1.0");
/* 44 */     gameStage.centerOnScreen();
/* 45 */     gameStage.sizeToScene();
/* 46 */     gameStage.show();
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 50 */     launch(args);
/*    */   }
/*    */   
/*    */   public void setPlayer(Player player) {
/* 54 */     this.player = player; } public Player getPlayer() {
/* 55 */     return this.player;
/*    */   }
/*    */   
/*    */   public Scene getGameScene() {
/* 59 */     return this.gameScene;
/*    */   }
/* 61 */   public GraphicHandler getGraphicHandler() { return this.graphicHandler; }
/* 62 */   public MouseHandler getMouseHandler() { return this.mouseHandler; } public PaneHandler getPaneHandler() {
/* 63 */     return this.paneHandler;
/*    */   }
/*    */   public SoundHandler getSoundHandler() {
/* 66 */     return this.soundHandler;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void finishGame() {
/* 72 */     this.soundHandler.playGameEndSound();
/* 73 */     this.spawnHandler.stopSpawner();
/* 74 */     this.graphicHandler.updatePlayerGraphicalScore();
/* 75 */     this.gameScene.setOnKeyReleased(null);
/* 76 */     for (LivingEntity entity : LivingEntity.entities)
/*    */     {
/* 78 */       entity.deSpawn(false); } 
/*    */   }
/*    */   
/*    */   public void startGame() {
/* 82 */     this.soundHandler.playGameStartSound();
/* 83 */     this.gameScene.setOnKeyReleased((EventHandler)new KeyboardHandler(this));
/* 84 */     this.graphicHandler.setCurrentDisplayedWindow(GameWindows.START);
/* 85 */     this.spawnHandler.startSpawner();
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\start\StartUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */