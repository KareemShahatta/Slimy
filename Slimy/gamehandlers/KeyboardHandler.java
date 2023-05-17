/*    */ package gamehandlers;
/*    */ 
/*    */ import gameentities.EntityDirection;
/*    */ import javafx.event.Event;
/*    */ import javafx.event.EventHandler;
/*    */ import javafx.scene.input.KeyCode;
/*    */ import javafx.scene.input.KeyEvent;
/*    */ import start.StartUp;
/*    */ 
/*    */ public class KeyboardHandler implements EventHandler<KeyEvent> {
/*    */   private final StartUp startUp;
/*    */   
/*    */   public KeyboardHandler(StartUp startUp) {
/* 14 */     this.startUp = startUp;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(KeyEvent event) {
/* 20 */     switch (event.getCode()) {
/*    */       case W:
/* 22 */         this.startUp.getPlayer().move(EntityDirection.NORTH); break;
/* 23 */       case S: this.startUp.getPlayer().move(EntityDirection.SOUTH); break;
/* 24 */       case D: this.startUp.getPlayer().move(EntityDirection.EAST); break;
/* 25 */       case A: this.startUp.getPlayer().move(EntityDirection.WEST); break;
/* 26 */       case X: this.startUp.getPlayer().shoot(); this.startUp.getSoundHandler().playPlayerShootingSound();
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\KeyboardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */