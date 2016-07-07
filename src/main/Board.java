package main;

import java.util.ArrayList;

public interface Board {

	/**
	 * Create one copy of the board. It is important that the copies do
	 * not store references to objects shared by other boards unless
	 * those objects are immutable.
	 * 
	 * @return
	 */
	public Board duplicate();

	/**
	 * Get a list of all available moves for the current state. MCTS
	 * calls this to know what actions are possible at that point.
	 * 
	 * @return
	 */
	public ArrayList<Move> getMoves();

	/**
	 * Apply the move m to the current state of the board.
	 * 
	 * @param m
	 */
	public void makeMove(Move m);

	/**
	 * Returns true if the game is over.
	 * 
	 * @return
	 */
	public boolean gameOver();	
		
	/**
	 * Returns the player ID for the player whose turn is active. This method is
	 * called by the MCTS.
	 * 
	 * @return
	 */
	public int getCurrentPlayer();
	
	/**
	 * Returns the number of players.
	 * 
	 * @return
	 */
	public int getQuantityOfPlayers();
	
	/**
	 * Return the pessimistic/optimistic bounds for the 
	 * current state of the game. Note that you will 
	 * only need to actually implement these if you are 
	 * running MCTS with bounds enabled. 
	 * 
	 * @return
	 */
	public double[] pessimisticBounds();
	public double[] optimisticBounds();
	
	/**
	 * Returns a score vector. 
	 * [1.0, 0.0] indicates a win for player 0.
	 * [0.0, 1.0] indicates a win for player 1
	 * [0.5, 0.5] indicates a draw
	 * @return score array
	 */
	public double[] getScore();

	/**
	 * Returns an array of probability weights
	 * for each move possible on this board. This
	 * is only relevant in board states where
	 * the choice to make is a random choice.
	 * @return array of weights
	 */
	public double[] getMoveWeights();
	
	public void bPrint();
}