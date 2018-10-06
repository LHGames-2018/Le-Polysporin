package io.polyhx.lhgames.game.bot;

import io.polyhx.lhgames.game.GameInfo;
import io.polyhx.lhgames.game.Map;
import io.polyhx.lhgames.game.Player;
import io.polyhx.lhgames.game.action.IAction;
import io.polyhx.lhgames.game.point.Point;
import io.polyhx.lhgames.game.tile.ResourceTile;
import io.polyhx.lhgames.game.tile.Tile;
import io.polyhx.lhgames.game.tile.TileContent;

import java.util.List;

public class Bot extends BaseBot {
    
    public IAction getAction(Map map, Player player, List<Player> others, GameInfo info) {
        map.print();
        IAction aReturn = null;
        System.out.println(player.getCarriedResource() + " " + player.getCapacityLevel());
        if (player.getCarriedResource() == player.getResourceCapacity()){
            aReturn = bouger(map, player, map.getTile(player.getHousePosition().getX(), player.getHousePosition().getY()));
        } else {
            ResourceTile resource = map.getResources().get(0);
            for (int i = 1 ; i < map.getResources().size(); i++){
                if ((map.getResources().get(i).getX() + map.getResources().get(i).getY()) < (resource.getX() + resource.getY())){
                    resource = map.getResources().get(i);
                }
            }
            aReturn = bouger(map, player, map.getTile(resource.getX(), resource.getY()));
        }
        
        return aReturn;

    }

    private IAction bouger(Map map, Player player, Tile destination) {
        IAction aReturn = null;
        if (player.getX() > destination.getX()) {
            if (map.getTile(player.getX() - 1, player.getY()).isEmpty()) {
                aReturn = createMoveAction(Point.LEFT);
            } else {
                System.out.println(map.getTile(player.getX() - 1, player.getY()).getContent());
                aReturn = interact(map, player, map.getTile(player.getX() - 1, player.getY()).getContent(), Point.LEFT);
            }
        } else if (player.getX() < destination.getX()) {
            if (map.getTile(player.getX() + 1, player.getY()).isEmpty()) {
                aReturn = createMoveAction(Point.RIGHT);
            } else {
                System.out.println(map.getTile(player.getX() - 1, player.getY()).getContent());
                aReturn = interact(map, player, map.getTile(player.getX() - 1, player.getY()).getContent(), Point.RIGHT);
            }
        } else if (player.getY() > destination.getY()) {
            if (map.getTile(player.getX(), player.getY() - 1).isEmpty()) {
                aReturn = createMoveAction(Point.UP);
            } else {
                System.out.println(map.getTile(player.getX() - 1, player.getY()).getContent());
                aReturn = interact(map, player, map.getTile(player.getX() - 1, player.getY()).getContent(), Point.UP);
            }
        } else if (player.getY() < destination.getY()) {
            if (map.getTile(player.getX(), player.getY() + 1).isEmpty()) {
                aReturn = createMoveAction(Point.DOWN);
            } else {
                System.out.println(map.getTile(player.getX() - 1, player.getY()).getContent());
                aReturn = interact(map, player, map.getTile(player.getX() - 1, player.getY()).getContent(), Point.DOWN);
            }
        }
        return aReturn;
    }

    private IAction interact(Map map, Player player, TileContent content, Point direction) {
        IAction aReturn = null;

        switch (content) {
            case WALL:
                aReturn = createMeleeAttackAction(direction);
                break;
            case RESOURCE:
                aReturn = createCollectAction(direction);
                break;
            case HOUSE:
                aReturn = createStealAction(direction);
                break;
            case PLAYER:
                aReturn = createMeleeAttackAction(direction);
                break;
                
            
                       
        }

        return aReturn;
    }
}
