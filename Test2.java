public class Test2 {
    public static void main(String[] args) {
        Mazes mz = new Mazes();
        char[][] mz1 = mz.oneStepN;
        char[][] mz2 = mz.oneStepS;
        char[][] maze = mz.twoStepSW;

        // char[][] maze = mz.noSolution10;

        MazeSolver2 solver = new MazeSolver2();
        // System.out.println("y : "+solver.getStartcordinates(maze)[0] + " X:" + solver.getStartcordinates(maze)[1]);
        // System.out.println("below goal coordinates");
        // System.out.println("y : "+solver.findgoalcoordinates(maze)[0] + " X:" + solver.findgoalcoordinates(maze)[1]);
        solver.solveMaze(maze);
        // print(solver.getMoves())
        for (String y : solver.getMoves()){
            System.out.println(y);
        }
    }
}
