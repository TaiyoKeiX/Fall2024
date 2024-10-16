

-- CSCE 314 [Sections 598, 599] Programming Languages Fall 2024
-- Homework Assignment 4 (Total 100 points)
-- Due on Friday, October 4, 2024

-- Problem 1 (5 points)
-- Student Name: Shouro Shuvit
-- UIN: 231007248
-- StackOverflow, Class Notes, Haskell Documentation
-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit
import System.Exit

-- *** Read Chapters 8 and 16 ***

data Tree a b = Leaf a | Branch b (Tree a b) (Tree a b)

---- Tree objects to be used to test your functions in Problems 2 and 3
-- Use tree1 to show the step-by-step of your function in Problem 3.2
tree1 :: Tree Int String
tree1 = Branch "*" 
            (Branch "+"
               (Branch "*" (Leaf 5) (Leaf 1))
               (Branch "+" (Leaf 2) (Leaf 6)))
            (Branch "*"
               (Branch "+"
                  (Branch "*" (Leaf 8) (Leaf 4))
                  (Leaf 9))
               (Branch "+" (Leaf 7) (Leaf 3)))

-- Another example Tree object
tree2 :: Tree Int String 
tree2 = Branch "+"  
            (Leaf 1)
            (Branch "*" (Leaf 2) (Leaf 3))

-- Yet another Tree object
tree3 :: Tree Int String
tree3 = Branch "+" 
            (Branch "*" 
               (Leaf 3)
               (Leaf 4))
            (Branch "+"
               (Branch "*" (Leaf 5) (Leaf 2))
               (Leaf 1))

-- Yet another...
tree4 :: Tree Int String
tree4 = Branch "A" 
            (Branch "B" 
               (Leaf 1) 
               (Leaf 2)) 
            (Leaf 3)
---------------

-- Problem 2 (15 points)
instance (Show a, Show b) => Show (Tree a b) where                                                  -- Declare the instance of Show for Tree a b
   show :: (Show a, Show b) => Tree a b -> String                                                   -- Define the show function for Tree a b
   show tree = showHelper tree 0                                                                    -- Call the showHelper function with the tree object and 0 as arguments
      where                                                                                         -- Define the showHelper function
        showHelper :: (Show a, Show b) => Tree a b -> Int -> String                                 -- Define the showHelper function with a Tree object and an integer as arguments
        showHelper (Leaf x) indent = replicate indent ' ' ++ "Leaf " ++ show x                      -- If the current node is a Leaf node, return the string "Leaf " followed by the value of the Leaf node
        showHelper (Branch y left right) indent =                                                   -- If the current node is a Branch node
            replicate indent ' ' ++ "Branch " ++ show y ++ "\n" ++                                  -- Return the string "Branch " followed by the value of the Branch node
            showHelper left (indent + 2) ++ "\n" ++                                                 -- Recursively call the showHelper function on the left subtree of the current node, incrementing the indent by 2
            showHelper right (indent + 2)                                                           -- Recursively call the showHelper function on the right subtree of the current node, incrementing the indent by 2
{--
Explanation:
The show function is defined for the Tree data type. The showHelper function is a helper function 
that takes a Tree object and an integer as arguments. The integer represents the number of spaces to 
indent the current line. The showHelper function is a recursive function that traverses the Tree object
and builds a string representation of the Tree object. If the current node is a Leaf node, the function 
returns the string "Leaf " followed by the value of the Leaf node. If the current node is a Branch node, the 
function returns the string "Branch " followed by the value of the Branch node. The function then recursively calls 
itself on the left and right subtrees of the current node, incrementing the indent by 2 for each recursive call. The
function concatenates the string representations of the left and right subtrees with the current node's string 
representation and returns the result.
--}

-- Problem 3 (15 + 10 = 25 points)
---- Problem 3.1 (5 + 5 + 5 = 15 points)
preorder  :: (a -> c) -> (b -> c) -> Tree a b -> [c]                           -- Define the preorder function
preorder fLeaf fBranch (Leaf x) = [fLeaf x]                                    -- Base case: If the current node is a Leaf node, return a list containing the value of the Leaf node
preorder fLeaf fBranch (Branch y left right) =                                 -- Recursive case: If the current node is a Branch node
    [fBranch y] ++ preorder fLeaf fBranch left ++ preorder fLeaf fBranch right -- Return a list containing the value of the Branch node followed by the results of recursively calling the preorder function on the left and right subtrees of the current node


inorder   :: (a -> c) -> (b -> c) -> Tree a b -> [c]                            -- Define the inorder function
inorder fLeaf fBranch (Leaf x) = [fLeaf x]                                      -- Base case: If the current node is a Leaf node, return a list containing the value of the Leaf node
inorder fLeaf fBranch (Branch y left right) =                                   -- Recursive case: If the current node is a Branch node
    inorder fLeaf fBranch left ++ [fBranch y] ++ inorder fLeaf fBranch right    -- Return the results of recursively calling the inorder function on the left subtree of the current node, followed by a list containing the value of the Branch node, followed by the results of recursively calling the inorder function on the right subtree of the current node


postorder  :: (a -> c) -> (b -> c) -> Tree a b -> [c]                                 -- Define the postorder function
postorder fLeaf fBranch (Leaf x) = [fLeaf x]                                          -- Base case: If the current node is a Leaf node, return a list containing the value of the Leaf node
postorder fLeaf fBranch (Branch y left right) =                                       -- Recursive case: If the current node is a Branch node
    postorder fLeaf fBranch left ++ postorder fLeaf fBranch right ++ [fBranch y]      -- Return the results of recursively calling the postorder function on the left subtree of the current node, followed by the results of recursively calling the postorder function on the right subtree of the current node, followed by a list containing the value of the Branch node
{--
Explanation:
The preorder, inorder, and postorder functions are defined for the Tree data type. The preorder function
traverses the Tree object in preorder (root, left, right) and returns a list of values. The inorder function
traverses the Tree object in inorder (left, root, right) and returns a list of values. The postorder function
traverses the Tree object in postorder (left, right, root) and returns a list of values. Each function takes
two functions as arguments: fLeaf and fBranch. fLeaf is a function that takes a value of type a and returns a
value of type c. fBranch is a function that takes a value of type b and returns a value of type c.
--}

---- Problem 3.2 (10 points)
{-- Explain the step-by-step of the following expression.
    Your answer must be in detail step-by-step using your definition
    for inorder.

> inorder show id tree1
1. We start at the branch with the left subtree.
2. In the leftsubtree, the root is Branch "+".
3. The left subtree of the left subtree is Branch "*".
    This reaches leaf 5 where we visit the root of the Branch to go to the right subtree on Leaf 1. 
4. If we go back to the Branch "+".
    Visit the root of the Branch to go to the right subtree to lead us to the leftsubtree on that branch which leads us to Leaf 2.
    Visit the root of the branch which is "+
    Visit the right subtree which is Leaf 6.
5. If we go back to the root of the tree, we visit the right subtree which is Branch "*".
    The left subtree of the right subtree is Leaf8.
    The root of this branch is "+".
    The right subtree of this branch is Leaf 4.
    The root of the original branch is "*" which has a right subtree of Leaf9. 
6. The root of the right subtree is "+".
    The left subtree is leaf7.
    THe root of the branch is "+".
    The right subtree is leaf3. 
The final answer is 5 * 1 + 2 + 6 * 8 + 4 * 9 + 7 + 3.
--}
                          

-- Problem 4 (40 points) Chapter 8, Exercise 9 Modified
data Expr = Val Int | Add Expr Expr | Subt Expr Expr | Mult Expr Expr

type Cont = [Op]

data Op = EVALA Expr | ADD Int | EVALS Expr | SUBT Int | EVALM Expr | MULT Int

eval :: Expr -> Cont -> Int
-- Give four definitions for eval.
-- First two definitions,
-- 1) for (Val n) and c as arguments and
-- 2) for (Add x y) and c as arguments
-- are already given in the text Section 8.7, but
-- you need to modify the second definition slightly
-- and give the third and fourth definitions for
-- (Subt x y) and (Mult x y)
eval (Val n) c = exec c n                   -- If the current node is a value, execute the continuation with the value
eval (Add x y) c = eval x (EVALA y : c)     -- If the current node is an addition, evaluate the left subtree and add the right subtree to the continuation
eval (Subt x y) c = eval x (EVALS y : c)    -- If the current node is a subtraction, evaluate the left subtree and subtract the right subtree from the continuation
eval (Mult x y) c = eval x (EVALM y : c)    -- If the current node is a multiplication, evaluate the left subtree and multiply the right subtree with the continuation
{--Explanation:
The eval function takes an Expr object and a continuation as arguments. The function evaluates the Expr object and the continuation
and returns an integer value. The function has four definitions: one for a value, one for an addition, one for a subtraction,
 and one for a multiplication.
--}


exec :: Cont -> Int -> Int
-- Give seven definitions for exec, one for an empty list and
-- one for each of the six constructors of the data type Op
-- Some of these are already given in the text Section 8.7.
exec [] n = n
exec (EVALA y : c) n = eval y (ADD n : c)   -- If the current node is an addition, evaluate the right subtree and add the value to the continuation
exec (ADD n' : c) n = exec c (n' + n)       -- If the current node is an addition, execute the continuation by adding the value to the current value
exec (EVALS y : c) n = eval y (SUBT n : c)  -- If the current node is a subtraction, evaluate the right subtree and subtract the value from the continuation
exec (SUBT n' : c) n = exec c (n' - n)      -- If the current node is a subtraction, execute the continuation by subtracting the value from the current value
exec (EVALM y : c) n = eval y (MULT n : c)  -- If the current node is a multiplication, evaluate the right subtree and multiply the value with the continuation
exec (MULT n' : c) n = exec c (n' * n)      -- If the current node is a multiplication, execute the continuation by multiplying the value with the current value
{--
Explanation:
The exec function takes a continuation and an integer as arguments. The function executes the continuation
and returns an integer value. The function has seven definitions: one for an empty list and one for each of 
the six constructors of the Op data type. The function evaluates the continuation and the integer value and returns
the result. 
--}


value :: Expr -> Int
value e = eval e []

-- Following expressions are to test your eval and exec definitions
-- (2 + 3) + 4 = 9
e1 = (Val 3)    -- 3
e2 = (Add (Val 4) (Val 2))  -- 4 + 2 = 6
e3 = (Mult (Val 4) (Val 3))  -- 4 * 3 = 12
e4 = (Add (Subt (Val 5) (Val 3)) (Val 4))  -- (5 - 3) + 4 = 6
e5 = (Mult (Mult (Val 2) (Val 3)) (Val 4))  -- (2 * 3) * 4 = 24
e6 = (Mult (Add (Val 2) (Val 3)) (Val 4))  -- (2 + 3) * 4 = 20
e7 = (Mult (Subt (Val 3) (Val 1)) (Val 4))  -- (3 - 1) * 4 = 8
e8 = (Add (Mult (Val 2) (Val 3)) (Val 4))  -- (2 * 3) + 4 = 10
e9 = (Subt (Mult (Val 4) (Val 5)) (Add (Val 2) (Val 3))) -- (4 * 5) - (2 + 3) = 15
e10 = (Mult (Subt (Val 10) (Val 3)) (Add (Val 4) (Val 5))) -- (10 - 3) * (4 + 5) = 63
e11 = (Add (Mult (Add (Val 2) (Val 3)) (Mult (Val 4) (Val 5))) (Mult (Val 3) (Subt (Val 4) (Val 7)))) -- ((2 + 3) * (4 * 5)) + (3 * (4 - 7)) = 91


-- Problem 5 (15 points)
-- Show the step-by-step of the following application of value.
-- > value e9
{-- Your answer goes here. Your answer must be in detail step-by-step showing
    every function call according to your implementation.
The expression is e9 = Subt (Mult (Val 4) (Val 5)) (Add (Val 2) (Val 3))
1. The value function is called with the expression e9 as an argument.
2. The Subt constructor is evaluated with the expression (Mult (Val 4) (Val 5)) as the left subtree 
and (Add (Val 2) (Val 3)) as the right subtree. Since the left subtree is a multiplication, the eval function 
is called with the left subtree and yields 20. 
3. The eval function is called with the right subtree of (Add (Val 2) (Val 3) which yields 5.
4. We then use the Subt constructor to subtract the right subtree from the left subtree which yields 15.
--}



myTestList = 
  TestList [
  
    "preorder 1"  ~: (concat (preorder show id tree1)) ~=? "*+*51+26*+*849+73"
  , "inorder 1"   ~: (concat (inorder show id tree1))  ~=? "5*1+2+6*8*4+9*7+3"
  , "postorder 1" ~: (concat (postorder show id tree1)) ~=? "51*26++84*9+73+**"
  , "preorder 2"  ~: (concat (preorder show id tree2)) ~=? "+1*23"
  , "inorder 2"   ~: (concat (inorder show id tree2))  ~=? "1+2*3"
  , "postorder 2" ~: (concat (postorder show id tree2))  ~=? "123*+"
  , "preorder 3"  ~: (concat (preorder show id tree3)) ~=? "+*34+*521"
  , "inorder 3"   ~: (concat (inorder show id tree3))  ~=? "3*4+5*2+1"
  , "postorder 3" ~: (concat (postorder show id tree3))  ~=? "34*52*1++"

  , "value 1"  ~: value e1 ~=? 3
  , "value 2"  ~: value e2 ~=? 6
  , "value 3"  ~: value e3 ~=? 12
  , "value 4"  ~: value e4 ~=? 6
  , "value 5"  ~: value e5 ~=? 24
  , "value 6"  ~: value e6 ~=? 20
  , "value 7"  ~: value e7 ~=? 8
  , "value 8"  ~: value e8 ~=? 10
  , "value 9"  ~: value e9 ~=? 15
  , "value 10" ~: value e10 ~=? 63
  , "value 11" ~: value e11 ~=? 91
  
    ]

main = do c <- runTestTT myTestList
          putStrLn $ show c
          let errs = errors c
              fails = failures c
          exitWith (codeGet errs fails)
          
codeGet errs fails
 | fails > 0       = ExitFailure 2
 | errs > 0        = ExitFailure 1
 | otherwise       = ExitSuccess

