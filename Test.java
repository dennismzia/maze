public class Test{
    public static void main(String[] args) {
        char OPEN = '.';
        char blocked = '#';
        char START = 'S';
        char GOAL = 'G';
        char MARKED = '+';
        char UNMARKED = 'X';
        Mazes mz = new Mazes();
        char[][] mz1 = mz.oneStepN;
        char[][] mz2 = mz.oneStepS;
        char[][] mz3 = mz.oneStepE;
        char[][] maze = mz.noSolution10;
        int y = findcordinate(maze)[0];
        int x = findcordinate(maze)[1];
        System.out.println("y : "+findcordinate(maze)[0] + " X:" + findcordinate(maze)[1]);
        System.out.println("below goal coordinates");
        System.out.println("y : "+findgoalcoordinates(maze)[0] + " X:" + findgoalcoordinates(maze)[1]);
        solveMaze(maze);
    }

    public static int[] findcordinate(char[][] maze){
        int coordinates[] = {0,0}; // (x,y)
        for(int i=0; i< maze.length; i++){
            for(int j=0; j< maze[i].length; j++){
                if (maze[i][j] == 'S'){
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates; 
    }



    public static int[] findgoalcoordinates(char[][] maze){
        int goalcordinates[] = {0,0};
        for(int i=0; i< maze.length; i++){
            for(int j=0; j< maze[i].length; j++){
                if (maze[i][j] == 'G'){
                    goalcordinates[0] = i;
                    goalcordinates[1] = j;
                }
            }

        }
        return goalcordinates;
    }

    // findPath(y-1,x);  north
    // findPath(y, x+1); east
    // findPath(y+1, x); south
    // findPath(y, x-1); west

    public static char findPath(int y , int x){
        Mazes mz = new Mazes();
        char[][] maze = mz.noSolution10;
        return maze[y][x];
    }

    public static void solveMaze(char[][] maze){
        // findpath(); // a recursive function
        int y = findcordinate(maze)[0];
        int x = findcordinate(maze)[1];
        while(true){
            if (findPath(y -1 , x) == '.'){
                if (findPath(y -1 , x) == '#'){
                    if((findPath(y, x + 1 )) == '.'){
                        findPath(y, x);

                    } 
                }
            }else if((findPath(y, x + 1) == '.')){
                if ((findPath(y, x+1)) == '#'){
                    if ((findPath(y+1, x)) == '.'){
                        if((findPath(y+1, x) == '#')){
                            if((findPath(y, x - 1)) == '.'){
                                if((findPath(y, x-1)) == '#'){
                                    if((findPath(y, x)) == '#'){
                                        findPath(y, x);
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
}}