package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	boolean goNorth, goSouth, goEast, goWest;
	private static final double W = 600, H = 400;
	private static final int KEYBOARD_MOVEMENT_DELTA = 5;
	private Node robotNode;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Image maze = new Image("images/maze.png");
			//Image robot = new Image("images/robot.png");
			
			ImageView mazeView = new ImageView(new Image("images/maze.png"));
			ImageView robotView = new ImageView(new Image("images/robot.png"));
			StackPane sp = new StackPane(mazeView);
			Scene scene = new Scene(sp);
			sp.getChildren().add(robotView);
			StackPane.setAlignment(robotView, Pos.CENTER);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			      @Override 
			      public void handle(KeyEvent event) {
			    	  if (event.getCode() == KeyCode.RIGHT) {
			    	        robotView.setLayoutX(robotView.getLayoutX() + 10);
			    	    } else if (event.getCode() == KeyCode.LEFT) {
			    	    	robotView.setLayoutX(robotView.getLayoutX() - 10);
			    	    }	  
	/*		        switch (event.getCode()) {
			          case UP:    robotView.setLayoutY(robotView.getLayoutY() - KEYBOARD_MOVEMENT_DELTA); break;
			          case RIGHT: robotView.setLayoutX(robotView.getLayoutX() + KEYBOARD_MOVEMENT_DELTA); break;
			          case DOWN:  robotView.setLayoutY(robotView.getLayoutY() + KEYBOARD_MOVEMENT_DELTA); break;
			          case LEFT:  robotView.setLayoutX(robotView.getLayoutX() - KEYBOARD_MOVEMENT_DELTA); break;
			        }
	*/		      }
			    });
			
	/*		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {
	                    case UP:    goNorth = true; break;
	                    case DOWN:  goSouth = true; break;
	                    case LEFT:  goWest  = true; break;
	                    case RIGHT: goEast  = true; break;
					default:
						break;
	                   
	                }
	            }
	        });

	        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {
	                    case UP:    goNorth = false; break;
	                    case DOWN:  goSouth = false; break;
	                    case LEFT:  goWest  = false; break;
	                    case RIGHT: goEast  = false; break;
					default:
						break;
	                    
	                }
	            }
	        });
	*/		
			primaryStage.setTitle("Robot");
			primaryStage.setScene(scene);
			primaryStage.show();
			
	/*		AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	                int dx = 0, dy = 0;

	                if (goNorth) dy -= 1;
	                if (goSouth) dy += 1;
	                if (goEast)  dx += 1;
	                if (goWest)  dx -= 1;
	                

	                moveRobotNodeBy(dx, dy);
	            }
	        };
	        timer.start();
*/	    
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
	/*	private void moveRobotNodeBy(int dx, int dy) {
	        if (dx == 0 && dy == 0) return;

	        final double cx = robotNode.getBoundsInLocal().getWidth()  / 2;
	        final double cy = robotNode.getBoundsInLocal().getHeight() / 2;

	        double x = cx + robotNode.getLayoutX() + dx;
	        double y = cy + robotNode.getLayoutY() + dy;

	        moveRobotNodeTo(x, y);
	    
	}
		private void moveRobotNodeTo(double x, double y) {
	        final double cx = robotNode.getBoundsInLocal().getWidth()  / 2;
	        final double cy = robotNode.getBoundsInLocal().getHeight() / 2;

	        if (x - cx >= 0 &&
	            x + cx <= W &&
	            y - cy >= 0 &&
	            y + cy <= H) {
	            robotNode.relocate(x - cx, y - cy);
	        }
	    }

	
	  private void moveRobotOnKeyPress(Scene scene, final ImageView imgView) {
		    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		      @Override public void handle(KeyEvent event) {
		        switch (event.getCode()) {
		          case UP:    imgView.setLayoutY(imgView.getLayoutY() - KEYBOARD_MOVEMENT_DELTA); break;
		          case RIGHT: imgView.setLayoutX(imgView.getLayoutX() + KEYBOARD_MOVEMENT_DELTA); break;
		          case DOWN:  imgView.setLayoutY(imgView.getLayoutY() + KEYBOARD_MOVEMENT_DELTA); break;
		          case LEFT:  imgView.setLayoutX(imgView.getLayoutX() - KEYBOARD_MOVEMENT_DELTA); break;
		        }
		      }
		    });
		  }
	*/public static void main(String[] args) {
		launch(args);
	}
}
