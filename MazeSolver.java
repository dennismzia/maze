import java.util.ArrayList;

public class MazeSolver{
    char OPEN = '.';
    char blocked = '#';
    char START = 'S';
    char GOAL = 'G';
    char MARKED = '+';
    char UNMARKED = 'X';
    char[][] maze;
    ArrayList<String> mazePath = new ArrayList<>();
    int numCellsVisited;
    int mazesSolved = 0;
    int mazesTried= 0;
    boolean completed = false;

    public  boolean solveMaze(char[][] maze){
        // System.out.println("iifpf");
        boolean result = false;
        int[] startCordinates = {0,0};
        int r = this.getStartcordinates(maze)[0];
        int c  = this.getStartcordinates(maze)[1];
        System.out.println(maze[r][c]); // should always retur 'S'

        if (maze[r][c] == this.START){
            // System.out.println(maze[i][j]);
            if (!this.findPath(maze , r, c)) {
                result = false;
                
            } else {
                this.mazesTried++;
                this.mazesSolved++;
                result = true;
                System.out.println("SOLVED maze");
            }
    
        }else if (maze[r][c] == this.OPEN){
            System.out.println(maze[r][c]);
            if(!this.findPath(maze,r, c)){
                // result = 
            }

        }
        return result;

}

    // custom method that checks whether if the next cell is valid(being inside maze or containing an open character) 
    // doesnt affect code output. helper method to reduce code repetiton and complexity
    // doesnt affect code output or final grading system without it theree would be no solutin whatsoever.
    // used to check if north east south west are within bounds of the maze and if the path is open or not
    private  boolean isValidSpot(char[][] maze,int r, int c) {
        // checks to see if the location is valid  or not 
        boolean value =  false;
        if(r >= 0 && r < maze.length && c >= 0 && c < maze[r].length) {
            if (maze[r][c] == '.'){
                value = true;
            }else if (maze[r][c] == this.START){
                value = true;

            }else if (maze[r][c] == this.GOAL){
                // System.out.println("Goal reached");
                this.completed = maze[r][c] == this.GOAL;
                value = true;

            }else{
                value = false;
            }
        }
        return value;

    }

    public int[] getStartcordinates(char[][]maze){
        int[] startCordinates = {0,0};
        for(int i=0; i< maze.length; i++){
            for(int j=0; j< maze[i].length; j++){
                if(maze[i][j] == this.START){
                    startCordinates[0] = i;
                    startCordinates[1] = j;
                }
            }
        }        
        return startCordinates;
    }

    // findpath returns a boolean true if the algortihim was able to find the next path OPEN and
    // returns false if the next path was is
    private  boolean findPath(char[][] maze, int r, int c) {
        boolean value2 = false;

        if(this.isValidSpot(maze,r, c)) {
            //if spot is valid
            System.out.println("never reached");
            if(maze[r][c] == this.GOAL) {
                value2 = true;
            }else{
            // maze[r][c] = this.MARKED;
            // this.maze[r][c] = this.MARKED;

            boolean returnValue = false;
            //North
            if(!returnValue){
            // System.out.println("North: "+findPath(maze , r - 1, c ));

                returnValue = findPath(maze, r - 1, c);
                if(returnValue == true){
                    this.mazePath.add("N");
                }
            }

            //East
            if(!returnValue) {
                // System.out.println("East: "+findPath(maze , r, c + 1));
                if(findPath(maze , r, c + 1) == true){
                    this.mazePath.add("E");
                }
                returnValue = findPath(maze , r, c + 1);
            }

            //South
            if(!returnValue) {
                // System.out.println("south: "+findPath(maze , r + 1 , c));
                if(findPath(maze, r + 1, c) == true){
                    this.mazePath.add("S");
                }
                returnValue = findPath(maze, r + 1, c);
            }

            //west
            if(!returnValue) {
                // System.out.println("west: "+findPath(maze , r, c - 1)); 
                if(findPath(maze , r, c - 1) == true){
                    this.mazePath.add("W");
                }
                returnValue = findPath(maze , r, c - 1);
            }

            if(returnValue) {
                System.out.println(r + ", " + c); // prints out the coordinates the algorithim took to complete the maze
                maze[r][c] = this.MARKED;   
            }
            return returnValue;
        }}
        return value2;
    }

    private  void print(char[][] maze) {
        System.out.println("-----------------------");
        for(int x = 0; x < maze.length; x++) {
            System.out.print("| ");
            for(int y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------");
    }

    public String[] getMoves(){
        return this.mazePath.toArray(new String[this.mazePath.size()]);
    }

    public int getNumCellsVisited(){
        return this.numCellsVisited;
    }

    public int getMazesTried(){
        return this.mazesSolved;
    }
    public int getMazesSolved(){
        return this.mazesTried;
    }
    public int getPerformance(){
        // System.out.println("tried: " +this.getMazesTried() + " solved: "+ this.mazesSolved);
        return mazesTried/mazesSolved;
    }


}
