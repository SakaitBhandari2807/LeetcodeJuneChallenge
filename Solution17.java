import java.util.ArrayList;
import java.util.Iterator;

class Solution17 {
    ArrayList<Integer> adj[];
    boolean visited[];
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int rows = board.length,cols=board[0].length;
//        System.out.println(rows+" "+cols);
        adj = new ArrayList[rows*cols];
        visited = new boolean[rows*cols];
        for (int i = 0; i < rows*cols; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                if(board[i][j] == 'O'){
                    if(validateCell(i+1,j,rows,cols) && board[i+1][j] =='O'){
                        adj[cols*i+j].add(cols*(i+1) + j);
                    }
                    if(validateCell(i-1,j,rows,cols) && board[i-1][j] == 'O'){
                        adj[cols*i+j].add(cols*(i-1)+j);
                    }
                    if(validateCell(i,j-1,rows,cols) && board[i][j-1] == 'O'){
                        adj[cols*i+j].add(cols*i+(j-1));
                    }
                    if(validateCell(i,j+1,rows,cols) && board[i][j+1] == 'O'){
                        adj[cols*i+j].add(cols*i+(j+1));
                    }
                }
//                if(board[i][j] == 'X'){
//                    if(validateCell(i+1,j,rows,cols) && board[i+1][j] == 'X'){
//                        adj[]
//                    }
//                }
            }
        }

        for (int i = 0; i < cols ; i++) {
            if(validateCell(0,i,rows,cols) && board[0][i] == 'O'){
                dfs(cols*0+i);
            }
            if(validateCell(rows-1,i,rows,cols) && board[rows-1][i] =='O'){
                dfs(cols*(rows-1)+i);
            }
        }
        for (int i = 0; i <rows ; i++) {
            if(validateCell(i,cols-1,rows,cols) && board[i][cols-1] == 'O'){
                dfs(cols*i+cols-1);
            }
            if(validateCell(i,0,rows,cols) && board[i][0] == 'O'){
                dfs(cols*i);
            }
        }
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(!visited[cols*i+j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
//                System.out.print(board[i][j]+" ");
            }
//            System.out.println();
        }
    }
    public boolean validateCell(int r,int c,int rows,int cols){
        if(( r>-1 && r<rows) && (c<cols && c>-1)) return true;
        return false;
    }
    public void dfs(int node){
      if(!visited[node]){
          visited[node] = true;
          Iterator<Integer>iterator = adj[node].iterator();
          while(iterator.hasNext()){
              int processNode = iterator.next();
              dfs(processNode);
          }
      }
    }
    public static void main(String args[]){
        char [][] board = new char[][]{
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//                {'X'},{'X'},{'X'},{'O'}

                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        new Solution17().solve(board);
    }
}
