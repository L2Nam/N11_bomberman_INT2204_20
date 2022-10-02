package uet.oop.bomberman.Graphics;

import uet.oop.bomberman.Entity.Entity;
import uet.oop.bomberman.Entity.Entity_map.Brick;
import uet.oop.bomberman.Entity.Entity_map.Grass;
import uet.oop.bomberman.Entity.Entity_map.Portal;
import uet.oop.bomberman.Entity.Entity_map.Wall;
import uet.oop.bomberman.Features.Sprite;
import uet.oop.bomberman.Main.GameRun;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import static uet.oop.bomberman.Main.GameRun.*;

public class MapCreation {

    public MapCreation(String level) {
        System.out.println(System.getProperty("user.dir"));
        final File fileName = new File(level);
        try (FileReader inputFile = new FileReader(fileName)) {
            Scanner ip = new Scanner(inputFile);
            String line = ip.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);

            GameRun.level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            while (ip.hasNextLine()) {
                id_objects = new int[width][height];
                list_kill = new int[width][height];
                for (int i = 0; i < height; ++i) {
                    String lineTile = ip.nextLine();
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);

                    for (int j = 0; j < width; j++) {
                        int token = Integer.parseInt(tokenTile.nextToken());
                        Entity entity;


                        switch (token) {
                            case 1:
                                entity = new Portal(j, i, Sprite.grass.getFxImage());
                                token = 0;
                                break;
                            case 2:
                                entity = new Wall(j, i, Sprite.wall.getFxImage());
                                break;
                            case 3:
                                entity = new Brick(j, i, Sprite.brick.getFxImage());
                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        id_objects[j][i] = token;
                        block.add(entity);
                    }
                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        
        }
    }
}

