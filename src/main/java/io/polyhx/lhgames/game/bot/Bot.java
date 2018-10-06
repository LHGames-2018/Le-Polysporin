package io.polyhx.lhgames.game.bot;

import io.polyhx.lhgames.game.GameInfo;
import io.polyhx.lhgames.game.Map;
import io.polyhx.lhgames.game.Player;
import io.polyhx.lhgames.game.action.IAction;
import io.polyhx.lhgames.game.point.Point;
import io.polyhx.lhgames.game.tile.ResourceTile;

import java.util.List;

public class Bot extends BaseBot {
    public IAction getAction(Map map, Player player, List<Player> others, GameInfo info) {
        map.print();
        
        
//        for (ResourceTile ressource : map.getResources()) {
//            Point coor = ressource.getPosition();
//        }
        
        
        
        
        for (Player other : others) {
            Point coor = other.getPosition();
            if(player.getDistanceTo(coor)==1)
                return createMeleeAttackAction(coor);
        }
        
        
        
        return createMoveAction(Point.LEFT);
        
    }
}
