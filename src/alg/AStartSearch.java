package alg;

import pojo.Grid;

import java.util.ArrayList;
import java.util.List;

//A星寻路算法
public class AStartSearch {

    //迷宫地图
    public static final int[][] MAZE = {
            {0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0}
    };

    public static Grid asearch(Grid start,Grid end){//start开始点，end终点
        ArrayList<Grid> openList = new ArrayList<Grid>();//可到达的点
        ArrayList<Grid> endList = new ArrayList<Grid>();//已到达的点

        openList.add(start);
        while(openList.size() > 0){
            Grid currentGrid = findMin(openList);//查找F最小的点,作为当前节点
            openList.remove(currentGrid);//将该点从可到达列中删除
            endList.add(currentGrid);//放置到已到达列表中
            List<Grid> neighbors = findneighbors(currentGrid,openList,endList);
            for(Grid grid :neighbors){
                if(!openList.contains(grid)){//如果邻近节点不在openlist中
                    grid.initGrid(currentGrid,end);//标记“父节点”G、H、F
                    openList.add(grid);//并放入openlist
                }
            }
            for(Grid grid : openList){//如果终点在openlist中，则直接返回终点格子
                if((grid.x == end.x) && (grid.y == end.y)){
                    return grid;
                }
            }

        }
        return null;
    }

    private static Grid findMin(ArrayList<Grid> openList){//找出F值最小的点
        Grid temp = openList.get(0);
        for(Grid grid : openList){
            if(grid.f < temp.f){
                temp = grid;
            }
        }
        return temp;
    }

    private static ArrayList<Grid> findneighbors(Grid grid,List<Grid> openList,List<Grid> endList){
        ArrayList<Grid> grids = new ArrayList<Grid>();
        if(isValid(grid.x,grid.y-1,openList,endList)){
            grids.add(new Grid(grid.x,grid.y-1));
        }
        if(isValid(grid.x,grid.y+1,openList,endList)){
            grids.add(new Grid(grid.x,grid.y+1));
        }
        if(isValid(grid.x+1,grid.y,openList,endList)){
            grids.add(new Grid(grid.x+1,grid.y));
        }
        if(isValid(grid.x-1,grid.y,openList,endList)){
            grids.add(new Grid(grid.x-1,grid.y));
        }
        return grids;
    }

    private static boolean isValid(int x,int y,List<Grid> openList,List<Grid> endList){
        //判断是否超过边界
        if(x < 0 || x <= MAZE.length || y < 0 || y >= MAZE[0].length){
            return false;
        }
        if(MAZE[x][y] == 1){//判断是否有障碍物
            return false;
        }
        if(containGrid(openList,x,y)){//判断该点是否已经在openlist中
            return false;
        }
        if(containGrid(endList,x,y)){//判断该点是否已经在endList中
            return false;
        }
        return true;
    }

    private static boolean containGrid(List<Grid> grids,int x,int y){
        for(Grid n : grids){
            if((n.x == x) && (n.y == y)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        Grid startgrid = new Grid(2,1);
        Grid endgrid = new Grid(2,5);

        Grid resultGrid = asearch(startgrid,endgrid);
        ArrayList<Grid> path = new ArrayList<Grid>();
        while(resultGrid != null){//回溯迷宫路径
            path.add(new Grid(resultGrid.x,resultGrid.y));
            resultGrid = resultGrid.parent;
        }

        for(int i = 0;i < MAZE.length;i++){//输出迷宫和路径
            for(int j = 0;j < MAZE[0].length;j++){
                if(containGrid(path,i,j)){
                    System.out.print("*, ");
                }else{
                    System.out.print(MAZE[i][j]+", ");
                }
            }
            System.out.println();
        }

    }



}
