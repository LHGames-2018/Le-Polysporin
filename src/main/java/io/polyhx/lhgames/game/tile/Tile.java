package io.polyhx.lhgames.game.tile;

import io.polyhx.lhgames.game.point.IPoint;
import io.polyhx.lhgames.game.point.Point;

/**
 * This class represents a tile on the map.
 */
public class Tile implements IPoint {
    /**
     * This global position of t*/

    public double getHeuristique() {
        return heuristique;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setHeuristique(double heuristique) {
        this.heuristique = heuristique;
    }
    
    public double getDistance(Tile tile1){
        return Math.sqrt(Math.pow(tile1.getY() - this.getY(), 2) + Math.pow(tile1.getX() - this.getX(), 2));
    }
    
    /**
     * The type of this tile.
     */
    private Point fPosition;
    private final TileContent fContent;

    /**
     * Constructor.
     *
     * @param position The global position of the tile.
     * @param content  The type of the tile.
     */
    
    private double cout;
    private double heuristique;
    private Tile parent = null;
    
    public Tile(Point position, TileContent content) {
        fPosition = position;
        fContent = content;
    }

    /**
     * This method returns the position of the tile in the global coordinate frame.
     *
     * @return The position of the tile.
     */
    public Point getPosition() {
        return fPosition;
    }

    /**
     * This method returns the type of the tile.
     *
     * @return The type of the tile.
     */
    public TileContent getContent() {
        return fContent;
    }

    public void setCout(double cout){
        this.cout = cout;
    }

    public void setParent(Tile parent){
        this.parent = parent;
    }

    /**
     * This method returns whether this tile is empty.
     *
     * @return {@code true} if it is empty, else {@false}.
     */
    public boolean isEmpty() {
        return (fContent == TileContent.EMPTY);
    }

    /**
     * This method returns whether this tile is a wall.
     *
     * @return {@code true} if it is a wall, else {@false}.
     */
    public boolean isWall() {
        return (fContent == TileContent.WALL);
    }

    /**
     * This method returns whether this tile is a house.
     *
     * @return {@code true} if it is a house, else {@false}.
     */
    public boolean isHouse() {
        return (fContent == TileContent.HOUSE);
    }

    /**
     * This method returns whether this tile is lava.
     *
     * @return {@code true} if it is lava, else {@false}.
     */
    public boolean isLava() {
        return (fContent == TileContent.LAVA);
    }

    /**
     * This method returns whether this tile is a resource.
     *
     * @return {@code true} if it is a resource, else {@false}.
     */
    public boolean isResource() {
        return (fContent == TileContent.RESOURCE);
    }

    /**
     * This method returns whether this tile is a shop.
     *
     * @return {@code true} if it is a shop, else {@false}.
     */
    public boolean isShop() {
        return (fContent == TileContent.SHOP);
    }

    /**
     * This method returns whether this tile is a player.
     *
     * @return {@code true} if it is a player, else {@false}.
     */
    public boolean isPlayer() {
        return (fContent == TileContent.PLAYER);
    }
    
    @Override
    public int getX() {
        return fPosition.getX();
    }

    @Override
    public int getY() {
        return fPosition.getY();
    }
}
