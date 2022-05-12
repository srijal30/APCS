public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;
  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    //create the new node
    TreeNode newNode = new TreeNode( newVal );   
    
    if( _root == null){
      _root = newNode;
      return;
    }
    
    else{
      //call the helper method
      insert( _root, newNode );
    }

  }

  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    
    //if goes left
    if( newNode.getValue() < stRoot.getValue() ){
      //check if empty
      if( stRoot.getLeft() == null ) stRoot.setLeft( newNode );
      //else go deeper
      else insert( stRoot.getLeft(), newNode );
    }

    //if goes right
    else if ( newNode.getValue() > stRoot.getValue() ){
      //check if empty
      if( stRoot.getRight() == null ) stRoot.setRight( newNode );
      //else go deeper
      else insert( stRoot.getRight(), newNode );
    }
    
    else {
      System.out.println("There is something wrong with the input provided!");
    }
    
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root ); 
  }

  public void preOrderTrav( TreeNode currNode )
  {
    if( currNode == null ) return;
    //process root
    System.out.println( currNode.getValue() );
    //process left subtree
    preOrderTrav( currNode.getLeft() );  
    //process right subtree
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {  
    inOrderTrav( _root );
  }
  
  public void inOrderTrav( TreeNode currNode )
  {
    if( currNode == null ) return;
    //process left
    inOrderTrav( currNode.getLeft() );
    //process root
    System.out.println( currNode.getValue() );
    //process right subtree
    inOrderTrav( currNode.getRight() );
    
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }

  public void postOrderTrav( TreeNode currNode )
  {
    if( currNode == null ) return;
    //process left
    postOrderTrav( currNode.getLeft() );
    //process right
    postOrderTrav( currNode.getRight() );
    //process root
    System.out.println( currNode.getValue() );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //MODIFICATIONS

    TreeNode search( int target )
    {
        return search( target, _root );
    }
    
    TreeNode search( int target, TreeNode root )
    {
      if (root == null) return null;
      else if ( target == root.getValue() ) return root;
      else if ( target < root.getValue() ) return search( target, root.getLeft() );
      else return search( target, root.getRight() );
    }

    public int height()
    {
      return height(_root);
    }
    
    public int height(TreeNode root)
    {
      if ( root == null ) return -1;
      return 1 + Math.max( height(root.getLeft()), height(root.getRight()) );
    }

    public int numNodes()
    {
      return numNodes( _root );
    }

    public int numNodes( TreeNode root ){
        if ( root == null ) return 0;
        return 1 + numNodes( root.getLeft() ) + numNodes( root.getRight() );
    }

    public int numLeaves()
    {
      return numLeaves( _root );
    }

    public int numLeaves( TreeNode root){
      if ( root == null ) return 0;
      if ( root.getLeft() == null && root.getRight() == null) return 1;
      return numLeaves( root.getLeft() ) + numLeaves ( root.getRight() );
    }

  //main method for testing
  public static void main( String[] args )
  {

    BST arbol = new BST();

    arbol.insert( 4 );      
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( arbol.search( 4 ) ) ;
    System.out.println( arbol.search( 5 ) ) ;
    System.out.println( arbol.search( 10 ) ) ;




    System.out.println( arbol.height() );
    System.out.println( arbol.numNodes()  );
    System.out.println( arbol.numLeaves() );

/*
EXPECTING
height: 2
nodes: 6
leaves: 3
            4
           / \
          2    5
         / \    \
        1   3    6
*/
}

}//end class
