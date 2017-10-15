package com.codegodfather.minesweeper.Model;

import java.util.Random;

/**
 * Created by godfather on 2017-10-14.
 */

public class GameGenerator {
    private int grid[][];
    private int bombs;
    private int gridSize;

    public GameGenerator(int gridSize,int bombs){
        this.bombs=bombs;
        this.gridSize=gridSize;
    }
    public int[][] createGame() {
        grid = new int[gridSize][gridSize];
        RandomBombAssigner();
        calculateNeighbours();
        printGrid();
        return grid;
    }
//Randomly Assigning bomb as -1
    private void RandomBombAssigner() {
        int numberOfBomb = 0 ;
        int xCoordinate;
        int yCoordinate;
        for(int k = numberOfBomb;numberOfBomb<bombs;k++)
        {
            Random random = new Random();
            xCoordinate = random.nextInt((gridSize - 1) + 1);
            yCoordinate = random.nextInt((gridSize - 1) + 1);
            if(grid[xCoordinate][yCoordinate]!= -1)
            {
                grid[xCoordinate][yCoordinate] = -1 ;
                numberOfBomb++;
            }
        }

    }
    //calculating weight for each cell in grid
    public int[][] calculateNeighbours() {
        for(int i=0;i<gridSize-1;i++)
        {
            for(int j=0;j<gridSize-1;j++)
            {
                grid[i][j]=calculateHints(grid,i,j);
            }
        }
        return grid;
    }

    private int calculateHints(int[][] grid, int i, int j) {
        if (grid[i][j]==-1)
        {
            return -1;
        }
        else
        {
            int count =0;
            topLeft(count,grid,i,j);
            top(count,grid,i,j);
            return count;
        }

    }

    private int top(int count, int[][] grid, int i, int j) {
        int xCoordinate = i;
        int yCoordinate = j+1;
        if(xCoordinate>=0  && xCoordinate<gridSize  && yCoordinate>=0 && yCoordinate<gridSize)
        {
            if(grid[xCoordinate][yCoordinate]==-1)
            {
                count++;
            }
        }

        return count;
    }

    private int topLeft(int count,final int[][] grid,int i, int j) {
        int xCoordinate = i-1;
        int yCoordinate = j+1;
        if(xCoordinate>=0  && xCoordinate<gridSize  && yCoordinate>=0 && yCoordinate<gridSize)
        {
            if(grid[xCoordinate][yCoordinate]==-1)
            {
                count++;
            }
        }

        return count;
    }


    public void printGrid() {
        for (int i = 0;i<gridSize;i++)
        {
            for(int j=0;j<gridSize;j++)
            {
             System.out.print(grid[i][j]);
             System.out.println();
            }
        }
    }


}
