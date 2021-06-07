package array;

// 프로그래머스
// 방문 길이

public class array10 {
    static int answer = 0;
    public static void main(String[] args){
        String dirs = "LULLLLLLU";

        boolean[][][] visitedX = new boolean[11][11][11];
        boolean[][][] visitedY = new boolean[11][11][11];

        Location location = new Location(5,5);
        for(int i=0; i<dirs.length(); i++){
            location = move(dirs.charAt(i), visitedX, visitedY, location.getCurrentX(), location.getCurrentY());
        }

        System.out.println(answer);
    }

    static Location move(char dir, boolean[][][] visitedX, boolean[][][] visitedY, int currentX, int currentY){
        int preX = currentX;
        int preY = currentY;
        
        switch(dir){
            case 'U':
                currentY = currentY + 1;
                break;
            case 'D':
                currentY = currentY - 1;
                break;
            case 'R':
                currentX = currentX + 1;
                break;
            default:
                currentX = currentX - 1;
                break;
        }

        if(currentX >= visitedX.length || currentY >= visitedY.length || currentX < 0 || currentY < 0){
            return new Location(preX, preY);
        }

        if(currentX - preX == 0){
            if(!visitedY[currentY][preY][preX]){
                visitedY[currentY][preY][preX] = true;
                visitedY[preY][currentY][preX] = true;
                answer = answer + 1;
            }
        } else{
            if(!visitedX[currentX][preX][preY]){
                visitedX[currentX][preX][preY] = true;
                visitedX[preX][currentX][preY] = true;
                answer = answer + 1;
            }
        }

        return new Location(currentX, currentY);
    }
}

class Location{
    private int currentX;
    private int currentY;

    public Location(int currentX, int currentY){
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public int getCurrentX(){
        return this.currentX;
    }

    public int getCurrentY(){
        return this.currentY;
    }
}