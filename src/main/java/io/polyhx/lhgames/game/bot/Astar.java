/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.polyhx.lhgames.game.bot;

import io.polyhx.lhgames.game.Map;
import io.polyhx.lhgames.game.Player;
import io.polyhx.lhgames.game.tile.Tile;
import io.polyhx.lhgames.game.tile.TileContent;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author Batikan
 */
public class Astar {

    private Map map;
    private Stack<Tile> openList = new Stack<>();
    private Stack<Tile> closedList = new Stack<>();
    
    public Astar(Player player) {
    }

    private void cheminPlusCout(Tile depart, Tile destination) {
        ArrayList<Tile> listeVoisins = new ArrayList<>();
        
        openList.add(depart);
        
        while (!(openList.empty())){
            Tile q = openList.get(0);
            
            for (Tile tile: openList){
                if ((tile.getCout() + tile.getHeuristique()) < (q.getCout() + q.getHeuristique())){
                    q = tile;
                }
            }
            openList.remove(q);
            
            Tile gauche = map.getTile(q.getX() - 1, q.getY());
            Tile droite = map.getTile(q.getX() + 1, q.getY());
            Tile bas = map.getTile(q.getX(), q.getY() + 1);
            Tile haut = map.getTile(q.getX(), q.getY() - 1);
            
            gauche.setParent(q);
            droite.setParent(q);
            bas.setParent(q);
            haut.setParent(q);
            
            listeVoisins.add(gauche);
            listeVoisins.add(droite);
            listeVoisins.add(bas);
            listeVoisins.add(haut);
            
            for (Tile voisin: listeVoisins){
                if (voisin.getX() == destination.getX() && voisin.getY() == destination.getY()){
                    voisin.setCout(q.getCout() + voisin.getDistance(q));
                    voisin.setHeuristique((Math.abs(voisin.getX() - destination.getX())) + (Math.abs(voisin.getY() - destination.getY())));
                    break;
                } else if (openList.contains(voisin)){
                    
                } else if (closedList.contains(voisin)){
                    for (Tile closedListTile: closedList){
                        if ((closedListTile.getCout() + closedListTile.getHeuristique()) > (voisin.getCout() + voisin.getHeuristique())){
                            openList.add(closedListTile);
                        }
                    }
                }
            }
            closedList.push(q);
        }
    }
}
