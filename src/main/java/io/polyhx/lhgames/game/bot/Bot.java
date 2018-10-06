package io.polyhx.lhgames.game.bot;

import io.polyhx.lhgames.game.GameInfo;
import io.polyhx.lhgames.game.Map;
import io.polyhx.lhgames.game.Player;
import io.polyhx.lhgames.game.action.IAction;
import io.polyhx.lhgames.game.point.Point;
import io.polyhx.lhgames.game.tile.ResourceTile;
import io.polyhx.lhgames.game.tile.TileContent;

import java.util.List;

public class Bot extends BaseBot {
    
    boolean compteur=true;
    boolean maisonAVoler=false;
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
        
//        int x = player.getPosition().getX()-1;
//        int y = player.getPosition().getY();
//        System.out.println(x+" "+y);
//        System.out.println(map.getTiles().get(x).get(y).getContent());
//        if(TileContent.WALL==(map.getTiles().get(x).get(y).getContent()))
//            
//            
//           return createMeleeAttackAction(Point.UP);
//        }
//         
//         for (Player other : others) {
//            if(map.getTileLeftOf(player.getPosition())==map.getTile(other.getHousePosition())){
//                 System.out.println("VERY NICE");
//                maisonAVoler=true;
//            }
//            else
//                maisonAVoler=false;
//        }
        if (compteur){
            compteur=false;
            return createCollectAction(Point.UP);
        }
       if(maisonAVoler)
           return createStealAction(Point.UP);
        else{
            compteur=true;
        return createMoveAction(Point.UP);
        }
        
    }
}
