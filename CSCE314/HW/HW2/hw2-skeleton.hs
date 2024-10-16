
-- CSCE 314 [Sections 598, 599] Programming Languages, Fall 2024
-- Homework Assignment 2 (Total 100 points)

-- Problem 1 (5 points)
-- This is head comment (single line comment should be preceded by two dashes)
-- Student Name: Shouro Shuvit
-- UIN: 231007248
-- Resources: lecture notes, Haskell documentation, and Stack Overflow

-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit 

import System.Exit


-- Example:
-- Write a recursive function mySum that sums all the numbers
-- in a list without using the prelude function sum.
mySum :: [Int] -> Int  -- type signature of mySum. mySum accepts a list of Ints
                       -- as its argument and returns an Int
mySum []     = 0  -- def.1
mySum (x:xs) = x + mySum xs -- def.2

{- Block comment over multiple lines is enclosed within {- and -}
Explanation:
The type of mySum tells us that mySum takes a list of Ints as an argument
and returns an Int that is the sum of all the Ints in the argument list.

Def.1 of mySum is the base case of the recursion, that is,
the argument list is empty, for which case the function value is 
defined as zero (summation identity).

Def.2 is when the argument list contains at least one element, 
namely x, in which case the function is defined as the sum of x 
and the result of the recursive call of mySum applied to the rest of 
the argument list, namely xs.
-}


type Set a = [a]

-- Problem 2 (10 points)
isElem :: Eq a => a -> [a] -> Bool     -- Type signature of isElem which takes an element and a list and returns a Bool with a type constraint Eq a
isElem _ [] = False                    -- Base case: If the list is empty, return False
isElem x (y:ys)                        -- Recursive case: Check head of the list
  | x == y    = True                   -- If x matches the head (y), return True
  | otherwise = isElem x ys            -- Otherwise, recursively check the rest of the list
{- 
Explanation:
The type signature of isElem tells us that isElem takes an element of type a and a list of type a as arguments and returns a Bool. 
The type constraint Eq a tells us that the elements of the list must be comparable for equality. The base case of isElem is when the list is empty, 
in which case the function returns False. The recursive case of isElem checks if the head of the list matches the element x. If it does, the function returns True. 
If it doesn't, the function recursively checks the rest of the list.
-}

-- Problem 3 (15 points)
-- Using isElem (from Problem 2) in the definition is required
toSet :: Eq a => [a] -> Set a   -- Type signature of toSet which takes a list and returns a Set (a list with no duplicates) with a type constraint Eq a
toSet [] = []                   -- Base case: Empty list returns an empty list
toSet (x:xs)                    -- Recursive case: Check head of the list
  | isElem x xs = toSet xs      -- If x is already in the list, skip it
  | otherwise   = x : toSet xs  -- Otherwise, include x and continue
{- 
Explanation:
The type signature of toSet tells us that toSet takes a list of type a as an argument and returns a Set of type a. The base case of toSet is when the list is empty,
in which case the function returns an empty list. The recursive case of toSet checks if the head of the list is already in the rest of the list. The 
function then either skips the head of the list or includes it in the result, depending on whether the head is already in the rest of the list.
-}

-- Problem 4 (15 points)
-- Using isElem (from Problem 2) in the definition is required
subset :: Eq a => Set a -> Set a -> Bool -- Type signature of subset which takes two Sets of type a and returns a Bool and has a type constraint Eq a
subset [] _ = True                       -- Base case: An empty set is a subset of any set
subset (x:xs) b                          -- Recursive case: Check head of the first set
  | isElem x b = subset xs b             -- If x is in b, check the rest of the elements
  | otherwise = False                    -- If x is not in b, return False
{- 
Explanation:
The type signature of subset tells us that subset takes two Sets of type a as arguments and returns a Bool. The type constraint Eq a tells us that
the elements of the sets must be comparable for equality. The base case of subset is when the first set is empty, in which case the function returns True.
The recursive case of subset checks if the head of the first set is in the second set. If it is, the function recursively checks the rest of the first set.
-}

-- Problem 5 (10 points)
-- Using subset (from Problem 4) in the definition is required
setEqual :: Eq a => Set a -> Set a -> Bool -- Type signature of setEqual
setEqual a b = subset a b && subset b a    -- Check if both sets are subsets of each other
{- 
Explanation:
The type signature of setEqual tells us that setEqual takes two Sets of type a as arguments and returns a Bool. The type constraint Eq a tells us that
the elements of the sets must be comparable for equality. The function setEqual checks if both sets are subsets of each other by using the subset function.
-}


-- Problem 6 (20+10 = 30 points)
powerset :: Set a -> Set (Set a)       -- Type signature: powerset takes a list and returns a list of lists (the powerset)
---- Question 6.1  (20 points)
---- Using direct recursion and list comprehenson is required
powerset [] = [[]]                     -- Base case: powerset of an empty set is a set containing the empty set
powerset (x:xs) = let ps = powerset xs -- Recursive case: Calculate powerset of the rest of the set
                  in ps ++ map (x:) ps -- Include x in the result and combine with the powerset of the rest of the set
-- powerset [2,3] = [[],[3],[2],[2,3]]
{- 
Explanation:
The base case of powerset is when the set is empty, in which case the function returns a set containing the empty set. 
The recursive case of powerset calculates the powerset of the rest of the set and stores it in the variable ps. The function 
then includes x in the result and combines it with the powerset of the rest of the set.
-}
---- Question 6.2 (10 points)
{- Write your answer for Question 6.2 within this block comment.
When powerset[2,3] is called the following occurs:
1. x = 2, xs = [3] which means powerset[3] is calculated. 
2. x = 3, xs = [] which means powerset[] is calculated.
3. Here we reached the base case which returns [[]].
4. Once we go back to the previous step, we can combine the result of the base case with the element 3 
using map(3:) ps which is [[3]] to yield powerset[3] = [[],[3]].
5. We can then go further back to the first step and combine the result of powerset[3] with the element 2
using map(2:) ps to yield powerset[2,3] = [[],[3],[2],[2,3]] which is the answer. 
-}



-- Problem 7 (10+5 = 15 points)
scalarproduct :: [Int] -> [Int] -> Int                  -- Type signature: scalarproduct takes two lists of Ints and returns an Int
---- Question 7.1  (10 points)
---- Using list comprehenson and the zip prelude function is required
scalarproduct xs ys = sum [x * y | (x, y) <- zip xs ys] -- Calculate the sum of the products of the corresponding elements of the two lists
-- zip xs ys combines the elements of the two lists into pairs. 
-- x * y is the product of the elements of the pairs from the two lists.
-- sum calculates the sum of the products to get the scalar product.
---- Question 7.2 (5 points)
{- Write your answer for Question 7.2 within this block comment.
1. For [4,3,5,2] and [1..] they are zipped to create [(4,1),(3,2),(5,3),(2,4)].
2. Each pair is multiplied to get [4,6,15,8].
3. The sum of the products is calculated to get 33.
-}



myTestList = 
  TestList [

      "isElem 1" ~: (isElem 'h' "happy") ~=? True
    , "isElem 2" ~: (isElem 'o' "happy") ~=? False
    , "isElem 3" ~: (isElem 'p' "happy") ~=? True

    , "toSet 1" ~: length (toSet "aardvark") ~=? 5
    , "toSet 2" ~: length (toSet "BartBart") ~=? 4

    , "subset 1" ~: subset [] [1,2] ~=? True
    , "subset 2" ~: subset [1,2] [] ~=? False
    , "subset 3" ~: subset [2,3] [1,2] ~=? False
    , "subset 4" ~: subset [2,3] [3,1,2] ~=? True
    , "subset 5" ~: subset [2,3] [2,1,4] ~=? False

    , "setEqual 1" ~: setEqual "abc" "bca" ~=? True
    , "setEqual 2" ~: setEqual [1,2] [2,1] ~=? True
    , "setEqual 3" ~: setEqual [1,2,3] [1,2,3,4] ~=? False
    , "setEqual 4" ~: setEqual [2,3,1] [1,2,3] ~=? True
    
    , "powerset 1" ~: length (powerset ([]::[Int])) ~=? 1
    , "powerset 2" ~: length (powerset [5]) ~=? 2
    , "powerset 3" ~: length (powerset [3,2,5,1,4]) ~=? 32
    , "powerset 4" ~: length (powerset "abc") ~=? 8

    , "scalarproduct 1" ~: scalarproduct [4,5,6] [1,2,3] ~=? 32
    , "scalarproduct 2" ~: scalarproduct [2,3] [1,-1] ~=? -1
    , "scalarproduct 3" ~: scalarproduct [1..10] [1..5] ~=? 55

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

