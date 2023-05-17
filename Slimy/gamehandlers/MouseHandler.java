/*    */ package gamehandlers;
/*    */ import javafx.event.Event;
/*    */ import javafx.event.EventHandler;
import javafx.scene.Parent;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
/*    */ import javafx.scene.input.MouseEvent;
/*    */ import javafx.scene.layout.*;
/*    */
/*    */
/*    */
/*    */
/*    */ import javafx.scene.text.Text;
/*    */ import javafx.stage.Stage;
/*    */ import start.GameWindows;
/*    */ import start.StartUp;
/*    */ 
/*    */ public class MouseHandler implements EventHandler<MouseEvent> {
/* 18 */   private final Glow glowEffect = new Glow(); private final StartUp startUp;
/* 19 */   private final Stage informationStage = new Stage();
/*    */   
/*    */   public MouseHandler(StartUp startUp) {
/* 22 */     this.startUp = startUp;
/* 23 */     this.glowEffect.setLevel(0.5D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(MouseEvent event) {
/* 29 */     if (event.getSource() instanceof Text)
/*    */     {
/* 31 */       if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 40 */         if (event.getSource().equals(this.startUp.getPaneHandler().getStartGameLabel()))
/*    */         {
/* 42 */           this.startUp.getGraphicHandler().setCurrentDisplayedWindow(GameWindows.GAME);
/*    */         }
/* 44 */         else if (event.getSource().equals(this.startUp.getPaneHandler().getGameVersionText()))
/*    */         {
/* 46 */           if (!this.informationStage.isShowing())
/*    */           {
/* 48 */             Pane informationPane = new Pane();
/* 49 */             Scene informationScene = new Scene((Parent)informationPane, 400.0D, 500.0D);
/*    */             
/* 51 */             informationPane.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHandler.INFORMATION_BACKGROUND, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT) }));
/* 52 */             this.informationStage.setTitle("How To Play");
/* 53 */             this.informationStage.getIcons().add(ImageHandler.EXPLANATION_MARK);
/* 54 */             this.informationStage.setScene(informationScene);
/* 55 */             this.informationStage.setResizable(false);
/* 56 */             this.informationStage.centerOnScreen();
/* 57 */             this.informationStage.sizeToScene();
/* 58 */             this.informationStage.show();
/*    */           }
/*    */         
/*    */         }
/*    */       
/* 63 */       } else if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
/*    */         
/* 65 */         this.startUp.getSoundHandler().playMouseHoverSound();
/* 66 */         ((Text)event.getSource()).setEffect((Effect)this.glowEffect);
/*    */       }
/* 68 */       else if (event.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
/*    */         
/* 70 */         ((Text)event.getSource()).setEffect(null);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\MouseHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */