Flying Sullen Actors :: Faiyaz Rafee, Alif Rahman, Salaj Rijal
APCS pd8s
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 1 hrs


DISCO
------------------------------------------------
Pre order:
SELF                  ROOT Left Right
left
right

In order:
left                 Left ROOT Right
SELF
right

POST order:
left
right                Left Right ROOT
SELF

================================================


QCC
------------------------------------------------
* What do Tall Men have to do with trees?
* Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
- a tree shall grow downward

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
- tree, open graph that splits into two, cycles

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
- that is the definition, also cuz when you are filling out a tree as long as the lastest row is the one w/o a complete row,

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
- the left and right subtrees are the same height or 1 away from the same height

Is a perfect tree complete? 
- yes

Is a complete tree balanced? 
- yes

Is the Man Who Is Tall Happy?
- yes, but not for long because tall people die earlier

What must be true of perfect trees but not others?
- all levels must be filled
- cuz it must be balanced AND complete AND have all the bottom nodes filled out

C'EST POSSIBLE?
------------------------------------------------
Yes, it is possible because we know that in a Pre order traversal, the root node is always at the beginning (the left and right follow) and in the in order traversal 
we know that the root node is always at the middle (between the left and right subtrees). We can use this pattern to deduce each root of the tree and then find each 
left and right subtree. Doing this multiple times results in the completed tree.
=============================================================================
        E
       / \ 
          G
         / \
        D
       / \
      K   I
         / \
        N   L
           / \
          O   W
           
Pre Order- EGDKINLOW
In Order-  EKDNIOLW 