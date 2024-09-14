public class leetcode_79_word_search {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                visited[i][j]= true;
                if(board[i][j] == word.charAt(0)){
                    boolean ans = solve(0,i,j,board,word,visited);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
    private boolean solve(int curr, int i, int j, char[][] board, String word, boolean visited[][]){
        if(curr == word.length()-1) return true;
        //check the left
        if((i-1)>=0 && board[i-1][j] == word.charAt(curr+1) && !visited[i-1][j]){
            visited[i][j] = true;
            //keep on exploring the left till you find the word or hit the base cases
            boolean ans = solve(curr+1, i-1, j,board,word,visited);
            if(ans) return true;
            visited[i][j] = false;
        }

        //check right from current point you're at
        if((i+1)<board.length && board[i+1][j] == word.charAt(curr+1) && !visited[i+1][j]){
            visited[i][j] = true;
            //keep on exploring the left till you find the word or hit the base cases
            boolean ans = solve(curr+1, i+1, j,board,word,visited);
            if(ans) return true;
            visited[i][j] = false;
        }

        //check the top
        if((j-1)>=0 && board[i][j-1] == word.charAt(curr+1) && !visited[i][j-1]){
            visited[i][j] = true;
            //keep on exploring the left till you find the word or hit the base cases
            boolean ans = solve(curr+1, i, j-1,board,word,visited);
            if(ans) return true;
            visited[i][j] = false;
        }

        //check bottom
        if((j+1)<board[0].length && board[i][j+1] == word.charAt(curr+1) && !visited[i][j+1]){
            visited[i][j] = true;
            //keep on exploring the left till you find the word or hit the base cases
            boolean ans = solve(curr+1, i, j+1,board,word,visited);
            if(ans) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
