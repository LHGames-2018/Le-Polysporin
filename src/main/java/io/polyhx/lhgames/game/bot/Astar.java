///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.polyhx.lhgames.game.bot;
//
//import io.polyhx.lhgames.game.Map;
//import io.polyhx.lhgames.game.Player;
//import io.polyhx.lhgames.game.point.IPoint;
//import io.polyhx.lhgames.game.point.Point;
//import io.polyhx.lhgames.game.tile.Tile;
//import io.polyhx.lhgames.game.tile.TileContent;
//import java.util.Stack;
//
///**
// *
// * @author Batikan
// */
//public class Astar {
//
//    private Map map;
//    private Stack openList = new Stack();
//    private Stack closedList = new Stack();
//    
//    
//    public Astar(Player player) {
//        cheminPlusCout(new Tile(player.getPosition(), TileContent.PLAYER), new Tile(new Point(10, 10), TileContent.EMPTY));
//    }
//    
//    private int comparer2noeuds(Tile noeud1, Tile noeud2){
//        if (noeud1.getHeuristique() < noeud2.getHeuristique()){
//            return 1;
//        } else if (noeud1.getHeuristique() == noeud2.getHeuristique()){
//            return 0;    
//        } else {
//            return -1;
//        }
//    }
//    
//    private void cheminPlusCout(IPoint depart, Tile destination){
//        openList.add(depart);
//        while(!openList.empty()){
//            Tile u = (Tile)openList.peek();
//            if ((u.getX() == destination.getX()) && (u.getY() == destination.getY())){
//                //reconstruction
//                //on decriss de la boucle
//            } else {
//                for (int x = 0; x < map.getTiles().size(); x++){
//                    for (int y = 0; y < map.getTiles().size(); y++){
//                        Tile v = new Tile(new Point(x, y), TileContent.EMPTY);
//                        if (!(openList.contains(v) || closedList.contains(v))){
//                           v.setCout(u.getCout() + 1);
//                           v.setHeuristique(v.getCout() + v.getDistance(destination));
//                           openList.add(v);
//                        }
//                        closedList.add(u);
//                    }
//                }
//            }
//        }
//    }
//    
//    private void refresh(){
//        
//    }
//    
//}
