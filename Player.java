package week5;
/*
-within the GameBoard class i will set an ArrayList<PlayerMoves> to keep track of plays made by any player
 */
public class Player {
	public enum PlayerColor{
		RED, BLACK
	}
	private PlayerColor player;
	
	public Player(PlayerColor player){
		this.player = player;
	}
	public PlayerColor getPlayer() {
		return player;
	}
	public void setPlayer(PlayerColor player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return this.player + " player";
	}
	
}
