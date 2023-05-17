/*     */ package gamehandlers;
/*     */ import gameentities.EntityType;
/*     */ import gameentities.entities.Player;
/*     */ import gameentities.entities.enemies.Enemy;
/*     */ import javafx.geometry.Pos;
/*     */ import javafx.scene.Node;
/*     */ import javafx.scene.image.ImageView;
/*     */ import javafx.scene.layout.Background;
/*     */ import javafx.scene.layout.BackgroundImage;
/*     */ import javafx.scene.layout.BackgroundPosition;
/*     */ import javafx.scene.layout.BackgroundRepeat;
/*     */ import javafx.scene.layout.BackgroundSize;
/*     */ import javafx.scene.layout.HBox;
/*     */ import javafx.scene.layout.Pane;
/*     */ import javafx.scene.layout.VBox;
/*     */ import javafx.scene.paint.Color;
/*     */ import javafx.scene.paint.Paint;
/*     */ import javafx.scene.shape.Rectangle;
/*     */ import javafx.scene.text.Font;
/*     */ import javafx.scene.text.Text;
/*     */ import start.StartUp;

import static gameentities.EntityDirection.EAST;

/*     */
/*     */ public class PaneHandler {
/*  24 */   private final Pane startPane = new Pane(); private final StartUp startUp;
/*  25 */   private final Pane gamePane = new Pane();
/*  26 */   private final Pane finishPane = new Pane();
/*     */   
/*  28 */   private final Text startGameText = new Text();
/*  29 */   private final Text playerScoreText = new Text();
/*  30 */   private final Text gameInformationText = new Text();
/*  31 */   private final Text enemiesCountText = new Text();
/*  32 */   private final Text playerHealthText = new Text();
/*  33 */   private final Text playerFinalScoreText = new Text();
/*     */ 
/*     */   
/*     */   public PaneHandler(StartUp startUp) {
/*  37 */     this.startUp = startUp;
/*  38 */     initializeStartWindow();
/*  39 */     initializeGameWindow();
/*  40 */     initializeFinishWindow();
/*     */   }
/*     */   
/*     */   private void initializeStartWindow() {
/*  44 */     this.startPane.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHandler.GAME_BACKGROUND, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT) }));
/*     */     
/*  46 */     ImageView screenTitle = new ImageView(ImageHandler.GAME_START_TITLE);
/*  47 */     screenTitle.setFitWidth(1550.0D);
/*  48 */     screenTitle.setTranslateY(150.0D);
/*     */     
/*  50 */     this.gameInformationText.setText("How To Play");
/*  51 */     this.gameInformationText.setFont(new Font("IMPACT", 50.0D));
/*  52 */     this.gameInformationText.setFill((Paint)Color.DARKGREEN);
/*  53 */     this.gameInformationText.setOnMouseClicked(this.startUp.getMouseHandler());
/*  54 */     this.gameInformationText.setOnMouseEntered(this.startUp.getMouseHandler());
/*  55 */     this.gameInformationText.setOnMouseExited(this.startUp.getMouseHandler());
/*     */     
/*  57 */     this.startGameText.setText("CLICK HERE TO START");
/*  58 */     this.startGameText.setFont(new Font("IMPACT", 50.0D));
/*  59 */     this.startGameText.setFill((Paint)Color.DARKGREEN);
/*  60 */     this.startGameText.setOnMouseClicked(this.startUp.getMouseHandler());
/*  61 */     this.startGameText.setOnMouseEntered(this.startUp.getMouseHandler());
/*  62 */     this.startGameText.setOnMouseExited(this.startUp.getMouseHandler());
/*     */ 
/*     */     
/*  65 */     VBox VB = new VBox();
/*  66 */     VB.setPrefHeight(950.0D);
/*  67 */     VB.setAlignment(Pos.BOTTOM_CENTER);
/*  68 */     VB.getChildren().addAll(startGameText , gameInformationText);
/*     */ 
/*     */     
/*  71 */     HBox HB = new HBox();
/*  72 */     HB.setPrefWidth(1550.0D);
/*  73 */     HB.setAlignment(Pos.TOP_CENTER);
/*  74 */     HB.getChildren().add(VB);
/*     */     
/*  76 */     this.startPane.getChildren().addAll(screenTitle , HB);
/*     */   }
/*     */   private void initializeGameWindow() {
/*  79 */     this.startUp.setPlayer(new Player(this.startUp, this.gamePane, EntityType.PLAYER, ImageHandler.SLIMY_NORMAL, EAST, 100, 200));
/*     */     
/*  81 */     this.gamePane.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHandler.GAME_BACKGROUND, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT) }));
/*     */     
/*  83 */     generateGameWindowBarriers(this.gamePane);
/*  84 */     generateGameWindowTexts(this.gamePane);
/*  85 */     generateGameSpawners(this.gamePane);
/*     */   }
/*     */   private void initializeFinishWindow() {
/*  88 */     this.finishPane.setBackground(new Background(new BackgroundImage[] { new BackgroundImage(ImageHandler.GAME_BACKGROUND, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT) }));
/*     */ 
/*     */     
/*  91 */     ImageView screenTitle = new ImageView(ImageHandler.GAME_OVER_TITLE);
/*  92 */     screenTitle.setFitWidth(1550.0D);
/*  93 */     screenTitle.setTranslateY(150.0D);
/*     */     
/*  95 */     this.playerFinalScoreText.setText("YOUR FINAL SCORE: " + this.startUp.getPlayer().getScore());
/*  96 */     this.playerFinalScoreText.setFont(new Font("IMPACT", 50.0D));
/*  97 */     this.playerFinalScoreText.setFill((Paint)Color.DARKGREEN);
/*     */     
/*  99 */     VBox VB = new VBox();
/* 100 */     VB.setPrefHeight(950.0D);
/* 101 */     VB.setAlignment(Pos.BOTTOM_CENTER);
/* 102 */     VB.getChildren().addAll(screenTitle, playerFinalScoreText);
/*     */ 
/*     */     
/* 105 */     HBox HB = new HBox();
/* 106 */     HB.setPrefWidth(1550.0D);
/* 107 */     HB.setAlignment(Pos.TOP_CENTER);
/* 108 */     HB.getChildren().add(VB);
/*     */     
/* 110 */     this.finishPane.getChildren().addAll(screenTitle,HB);
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateGameWindowTexts(Pane givePane) {
/* 115 */     this.playerHealthText.setText("HEALTH: " + this.startUp.getPlayer().getHealth() + "  || ");
/* 116 */     this.playerHealthText.setFont(new Font("IMPACT", 40.0D));
/* 117 */     this.playerHealthText.setFill((Paint)Color.DARKRED);
/*     */     
/* 119 */     this.playerScoreText.setText("<<<< SCORE " + this.startUp.getPlayer().getScore() + " >>>> || ");
/* 120 */     this.playerScoreText.setFont(new Font("IMPACT", 50.0D));
/* 121 */     this.playerScoreText.setFill((Paint)Color.DARKRED);
/*     */     
/* 123 */     this.enemiesCountText.setText("ENEMIES: " + Enemy.enemiesCount);
/* 124 */     this.enemiesCountText.setFont(new Font("IMPACT", 40.0D));
/* 125 */     this.enemiesCountText.setFill((Paint)Color.DARKRED);
/*     */ 
/*     */     
/* 128 */     HBox HB = new HBox();
/* 129 */     HB.setLayoutX(50.0D);
/* 130 */     HB.setLayoutY(50.0D);
/* 131 */     HB.setAlignment(Pos.CENTER);
/* 132 */     HB.setSpacing(25.0D);
/* 133 */     HB.setPrefHeight(50.0D);
/* 134 */     HB.setPrefWidth(1450.0D);
/* 135 */     HB.getChildren().addAll(playerHealthText, playerScoreText, enemiesCountText);
/*     */     
/* 137 */     givePane.getChildren().add(HB);
/*     */   }
/*     */   private void generateGameWindowBarriers(Pane givenPane) {
/*     */     int j;
/* 141 */     for (j = 50; j != 1500; j += 50) {
/*     */ 
/*     */       
/* 144 */       ImageView barrier = new ImageView(ImageHandler.BARRIER_1);
/* 145 */       barrier.setTranslateX(j);
/* 146 */       givenPane.getChildren().add(barrier);
/*     */     } 
/*     */ 
/*     */     
/* 150 */     for (j = 50; j != 1500; j += 50) {
/*     */ 
/*     */       
/* 153 */       ImageView barrier = new ImageView(ImageHandler.BARRIER_1);
/* 154 */       barrier.setTranslateX(j);
/* 155 */       barrier.setTranslateY(100.0D);
/* 156 */       givenPane.getChildren().add(barrier);
/*     */     } 
/*     */ 
/*     */     
/* 160 */     for (int i = 50; i != 900; i += 50) {
/*     */ 
/*     */       
/* 163 */       ImageView barrier = new ImageView(ImageHandler.BARRIER_1);
/* 164 */       barrier.setTranslateX(1500.0D);
/* 165 */       barrier.setTranslateY(i);
/* 166 */       givenPane.getChildren().add(barrier);
/*     */     } 
/*     */ 
/*     */     
/* 170 */     for (int X = 1450; X != 0; X -= 50) {
/*     */ 
/*     */       
/* 173 */       ImageView barrier = new ImageView(ImageHandler.BARRIER_1);
/* 174 */       barrier.setTranslateX(X);
/* 175 */       barrier.setTranslateY(900.0D);
/* 176 */       givenPane.getChildren().add(barrier);
/*     */     } 
/*     */ 
/*     */     
/* 180 */     for (int Y = 850; Y != 0; Y -= 50) {
/*     */       
/* 182 */       ImageView barrier = new ImageView(ImageHandler.BARRIER_1);
/* 183 */       barrier.setTranslateY(Y);
/* 184 */       givenPane.getChildren().add(barrier);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 189 */     ImageView barrierEdge1 = new ImageView(ImageHandler.BARRIER_2);
/* 190 */     barrierEdge1.setTranslateX(0.0D);
/* 191 */     barrierEdge1.setTranslateY(0.0D);
/*     */     
/* 193 */     ImageView barrierEdge2 = new ImageView(ImageHandler.BARRIER_2);
/* 194 */     barrierEdge2.setTranslateX(1500.0D);
/* 195 */     barrierEdge2.setTranslateY(0.0D);
/*     */     
/* 197 */     ImageView barrierEdge3 = new ImageView(ImageHandler.BARRIER_2);
/* 198 */     barrierEdge3.setTranslateX(0.0D);
/* 199 */     barrierEdge3.setTranslateY(900.0D);
/*     */     
/* 201 */     ImageView barrierEdge4 = new ImageView(ImageHandler.BARRIER_2);
/* 202 */     barrierEdge4.setTranslateX(1500.0D);
/* 203 */     barrierEdge4.setTranslateY(900.0D);
/*     */     
/* 205 */     ImageView barrierEdge5 = new ImageView(ImageHandler.BARRIER_2);
/* 206 */     barrierEdge5.setTranslateX(0.0D);
/* 207 */     barrierEdge5.setTranslateY(100.0D);
/*     */     
/* 209 */     ImageView barrierEdge6 = new ImageView(ImageHandler.BARRIER_2);
/* 210 */     barrierEdge6.setTranslateX(1500.0D);
/* 211 */     barrierEdge6.setTranslateY(100.0D);
/*     */ 
/*     */ 
/*     */     
/* 215 */     Rectangle middle_Layer = new Rectangle();
/* 216 */     middle_Layer.setFill((Paint)Color.DARKGREY);
/* 217 */     middle_Layer.setTranslateX(50.0D);
/* 218 */     middle_Layer.setTranslateY(50.0D);
/* 219 */     middle_Layer.setWidth(1450.0D);
/* 220 */     middle_Layer.setHeight(50.0D);
/*     */     
/* 222 */     givenPane.getChildren().addAll(barrierEdge1, barrierEdge2, barrierEdge3, barrierEdge4, barrierEdge5, barrierEdge6, middle_Layer);
/*     */   }
/*     */   private void generateGameSpawners(Pane givenPane) {
/* 225 */     ImageView cornerSpawner1 = new ImageView(ImageHandler.SPAWNER);
/* 226 */     cornerSpawner1.setTranslateX(50.0D);
/* 227 */     cornerSpawner1.setTranslateY(150.0D);
/*     */     
/* 229 */     ImageView cornerSpawner2 = new ImageView(ImageHandler.SPAWNER);
/* 230 */     cornerSpawner2.setTranslateX(1450.0D);
/* 231 */     cornerSpawner2.setTranslateY(150.0D);
/*     */     
/* 233 */     ImageView cornerSpawner3 = new ImageView(ImageHandler.SPAWNER);
/* 234 */     cornerSpawner3.setTranslateX(1450.0D);
/* 235 */     cornerSpawner3.setTranslateY(850.0D);
/*     */     
/* 237 */     ImageView cornerSpawner4 = new ImageView(ImageHandler.SPAWNER);
/* 238 */     cornerSpawner4.setTranslateX(50.0D);
/* 239 */     cornerSpawner4.setTranslateY(850.0D);
/*     */     
/* 241 */     givenPane.getChildren().addAll(cornerSpawner1, cornerSpawner2, cornerSpawner3, cornerSpawner4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Pane getStartPane() {
/* 248 */     return this.startPane;
/*     */   }
/*     */   
/*     */   Pane getGamePane() {
/* 252 */     return this.gamePane;
/*     */   }
/*     */   
/*     */   Pane getFinishPane() {
/* 256 */     return this.finishPane;
/*     */   }
/*     */ 
/*     */   
/*     */   Text getStartGameLabel() {
/* 261 */     return this.startGameText;
/*     */   }
/*     */   
/*     */   Text getGameVersionText() {
/* 265 */     return this.gameInformationText;
/*     */   }
/*     */   
/*     */   Text getPlayerScoreText() {
/* 269 */     return this.playerScoreText;
/*     */   }
/*     */   
/*     */   Text getEnemiesCountText() {
/* 273 */     return this.enemiesCountText;
/*     */   }
/*     */   
/*     */   Text getPlayerHealthText() {
/* 277 */     return this.playerHealthText;
/*     */   }
/*     */   
/*     */   Text getPlayerFinalScoreText() {
/* 281 */     return this.playerFinalScoreText;
/*     */   }
/*     */ }


/* Location:              C:\Users\Kareem\Downloads\Slimy\!\gamehandlers\PaneHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */