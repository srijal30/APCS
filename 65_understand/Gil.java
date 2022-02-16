// Flying Spanish Actors: Faiyaz Rafee, Salaj Rijal, Alif Rahman
// APCS
// HW 65 -- Explain DA Code -- explain the Code

public class Gil{

    private int[][] _board;

    public void QueenBoard( int size ) {
         _board = new int[size][size];
        }
    
    /*
    Adds a Queen to the board at position row, col. Also subtracts 1 from squares that the Queen can attack.
    returns false if position is not available for a Queen.
    returns true if it is.
    */
    private boolean foo(int row, int col)
    {
        //if position row, col is not empty, then return false
        if(_board[row][col]  != 0){
            return false;
        }
        
        _board[row][col] = 1; // adds Queen
        int offset = 1; // increment variable initialized
        
        //while col+offset is within the limit of board length
        while(col+offset < _board[row].length){
            
            //subtract one from positon row, col+offset (elimenates horizontal postion)
            _board[row][col+offset]--;
        
            //check if row is within limit of board height
            if(row - offset >= 0){
                //subtract one from position row-offset,col+offset (eliminates diagnol)
                _board[row-offset][col+offset]--;
            }
        
            if(row+offset < _board.length){
                //subtract one from position row-offset,col+offset (eliminates diagnol other side)
                _board[row+offset][col+offset]--;
            }

            //add 1 to offset
            offset++;
        }    

        //return true when done
        return true;
    }
    
    /*
    Removes a Queen to the board at position row, col. Also adds 1 from squares that the Queen previously could attack.
    returns false if no queen in position.
    returns true if it is.
    */
    private boolean whutItDoo(int row, int col) {

        //check if queen is in position row,col, if not return false
        if ( _board[row][col] != 1 ) {
            return false;
        }
        
        _board[row][col] = 0; // removes queen
        int offset = 1; // increment variable initialized
    
        // while col+offset is within limit of board length
        while ( col+offset < _board[row].length ) {

            // add one from positon row, col+offset (resets horizontal postion)
            _board[row][col+offset]++;

            //check if row is within limit of board height
            if ( row - offset >= 0 ) {
                //add one from position row-offset,col+offset (resets diagnol)
                _board[row-offset][col+offset]++;
            }

            if ( row + offset < _board.length ) {
                //add one from position row-offset,col+offset (resets diagnol other side)
                _board[row+offset][col+offset]++;
            }

            //add 1 to offset
            offset++;
        }
        
        //return true when done
        return true;
    }


} // end of class Gil