
-- CSCE 314 [Sections 598, 599] Programming Languages Fall 2024
-- Hyunyoung Lee
-- Homework Assignment 3 (Total 100 points) Due on Monday 9/23/24 at 11:59 p.m.

-- Problem 1 (5 points)
-- Student Name: Shouro Shuvit
-- UIN: 231007248
-- Resources: lecture notes, Haskell documentation, and Stack Overflow

-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit
import System.Exit
import Data.List
import Data.Char
import qualified Control.Applicative as list

-- *** Read textbook Chapters 5, 6, and 7, and the problem specifications
-- *** and requirements in hw3.pdf carefully!

-- Problem 2 (Chapter 6, Exercise 7) (10 points)
merge :: Ord a => [a] -> [a] -> [a]    -- Define a function merge that merges two sorted lists into a single sorted list.
merge [] ys = ys                       -- If the first list is empty, return the second list.
merge xs [] = xs                       -- If the second list is empty, return the first list.
merge (x:xs) (y:ys)                    -- If both lists are non-empty, compare the heads of the lists.
    | x <= y    = x : merge xs (y:ys)  -- If the head of the first list is smaller, add it to the result.
    | otherwise = y : merge (x:xs) ys  -- Otherwise, add the head of the second list.
{-
Explanation:
The merge function takes two sorted lists as input and merges them into a single sorted list. The base cases are when either of the 
lists is empty. If the first list is empty, the function returns the second list. If the second list is empty, the function returns the first list.
If both lists are non-empty, the function compares the heads of the lists. If the head of the first list is smaller than or equal to the head of 
the second list, the function adds the head of the first list to the result and recursively calls merge with the rest of the first list 
and the second list. Otherwise, the function adds the head of the second list to the result and recursively calls merge with the first list and the rest of the second list.
-}


-- Problem 3 (Chapter 6, Exercise 8) (5+10=15 points)
---- Question 3.1 (5 points)    
halve :: [a] -> ([a], [a])                  -- Define a function halve that splits an even-length list into two halves.
halve xs = splitAt (length xs `div` 2) xs   -- Use the splitAt function to split the list at the middle index.
{-
Explanation:
The halve function takes a list as input and splits it into two halves. The splitAt function is used to split the list at the middle index
which is calculated as the length of the list divided by 2. The function returns a tuple containing the two halves of the list.
-}


---- Question 3.2 (10 points)
msort :: Ord a => [a] -> [a]
msort [] = []
msort [x] = [x]
msort xs = merge (msort left) (msort right)
  where
    (left, right) = halve xs
{-
Explanation:
The msort function implements the merge sort algorithm to sort a list of elements. The base cases are when the list is empty or contains only one element.
-}


-- Problem 4 (10+10+10=30 points)
---- Question 4.1 (10 points) 
mergeBy :: (a -> a -> Bool) -> [a] -> [a] -> [a]
mergeBy _ [] ys = ys                        -- If the first list is empty, return the second list
mergeBy _ xs [] = xs                        -- If the second list is empty, return the first list
mergeBy cmp (x:xs) (y:ys)
  | cmp x y    = x : mergeBy cmp xs (y:ys)  -- If comparison is true, take x and merge the rest
  | otherwise  = y : mergeBy cmp (x:xs) ys  -- Otherwise, take y and merge the rest
{-
Explanation:
The mergeBy function takes a comparison function and two lists as input and merges them into a single sorted list based on the comparison function.
The base cases are when either of the lists is empty. If the first list is empty, the function returns the second list.
If the second list is empty, the function returns the first list. If both lists are non-empty, the function compares the heads of the lists 
using the comparison function. If the comparison function returns true for the two elements, the function adds the element from the first list.
Otherwise, it adds the element from the second list. The function then recursively calls mergeBy with the rest of the lists.
-}

---- Question 4.2 (10 points) 
msortBy :: (a -> a -> Bool) -> [a] -> [a]                   -- Define a function msortBy that sorts a list using the merge sort algorithm with a comparison function.
msortBy _ []  = []                                          -- Base case: an empty list is already sorted
msortBy _ [x] = [x]                                         -- Base case: a list with one or zero elements is already sorted
msortBy cmp xs =                                            -- Recursive case: split the list into two halves, sort each half, and merge the sorted halves
  let (left, right) = halve xs                              -- Split the list into two halves
  in mergeBy cmp (msortBy cmp left) (msortBy cmp right)     -- Sort each half recursively and merge the sorted halves using the comparison function
{-
Explanation:
The msortBy function takes a comparison function and a list as input and sorts the list using the merge sort algorithm with the given comparison function.
The base cases are when the list is empty or contains only one element, in which case the list is already sorted. In the recursive case, the function splits the list into two halves,
sorts each half recursively using msortBy, and merges the sorted halves using the comparison function mergeBy. The function finally returns the sorted list.
-}

---- Question 4.3 (10 points)
{- Write your answer for Question 4.3 within this block comment.
-- Should be detailed step-by-step.
The initial call is msortBy (>) [7, 5, 1, 4, 2]
1. Split the list into two halves: [7, 5] and [1, 4, 2]
2. Sort the left half: msortBy (>) [7, 5] = mergeBy (>) (msortBy (>) [7]) (msortBy (>) [5]) because we call halve on [7, 5] which yields [7] and [5] to then merge them into [7, 5].
3. Sort the right half: msortBy (>) [1, 4, 2] = mergeBy (>) (msortBy (>) [1]) (msortBy (>) [4, 2]) because we call halve on [1, 4, 2] which yields [1] and [4, 2] to then merge them into [4, 2, 1].
4. We finally merge the two sorted halves: mergeBy (>) [7, 5] [4, 2, 1] = [7, 5, 4, 2, 1]. 
-}


-- Problem 5 (10+5+10=25 points)
---- Question 5.1 (10 points)
myInsert :: Ord a => a -> [a] -> [a]  -- Define a function myInsert that inserts an element into a sorted list while maintaining the sorted order.
myInsert x [] = [x]                   -- If the list is empty, insert x
myInsert x (y:ys)                     -- If the list is non-empty, compare x and y
  | x <= y    = x : y : ys            -- If x is less than or equal to y, insert x before y
  | otherwise = y : myInsert x ys     -- Otherwise, recursively insert x into the rest of the list
{-
Explanation:
The myInsert function takes an element and a sorted list as input and inserts the element into the list while maintaining the sorted order.
The base case is when the list is empty, in which case the function inserts the element into the list. If the list is non-empty, the function 
compares the element to the head of the list. If the element is less than or equal to the head, the function inserts the element before the head.
Otherwise, the function recursively inserts the element into the rest of the list. The function returns the sorted list with the element inserted.
-}

---- Question 5.2 (5 points)
mySort :: Ord a => [a] -> [a]    -- Define a function mySort that sorts a list using the myInsert function.
mySort = foldr myInsert []       -- Use the foldr function to apply myInsert to each element of the list
{-
Explanation:
The mySort function sorts a list using the myInsert function. The function uses the foldr function 
to apply myInsert to each element of the list.The foldr function starts with an empty list and inserts 
each element of the input list into the sorted list using myInsert. The function returns the sorted list.
-}

---- Question 5.3 (10 points)
{- Write your answer for Question 5.3 within this block comment.
-- Should be detailed step-by-step.
The first call is of mySort is [7, 5, 1, 4, 2]. 
1. Insert 2 into the empty list: [2] since foldr takes the rightmost element of the list and inserts it into the empty list.
2. Insert 4 into the list [2]: [2, 4] since 4 is greater than 2.
3. Insert 1 into the list [2, 4]: [1, 2, 4] since 1 is less than 2.
4. Insert 5 into the list [1, 2, 4]: [1, 2, 4, 5] since 5 is greater than 4.
5. Insert 7 into the list [1, 2, 4, 5]: [1, 2, 4, 5, 7] since 7 is greater than 5.
The final sorted list is [1, 2, 4, 5, 7].
-}



-- Problem 6 (Chapter 7, Exercise 9) (10+5=15 points)
---- Question 6.1 (10 points)
altMap :: (a -> b) -> (a -> b) -> [a] -> [b]    -- Define a function altMap that alternately applies two functions to elements of a list.
altMap _ _ [] = []                              -- Base case: an empty list
altMap f g (x:xs) = f x : altMap g f xs         -- Apply f to x, then swap f and g for the rest
{-
Explanation:
The altMap function takes two functions and a list as input and alternately applies the two functions to the elements of the list.
The base case is when the list is empty, in which case the function returns an empty list. If the list is non-empty, the function applies
the first function f to the head of the list, then swaps the functions f and g for the rest of the list. The function recursively applies the
functions alternately to the elements of the list and returns the resulting list. 
-}

---- Question 6.2 (5 points)
{- Write your answer for Question 6.2 within this block comment.
-- Should be detailed step-by-step.
Starting with the initial call altMap ('div' 3) (*5) [1..9]
1. Apply the first function to the first element: ('div' 3) 1 = 0
2. Apply the second function to the second element: (*5) 2 = 10
3. Apply the first function to the third element: ('div' 3) 3 = 1
4. Apply the second function to the fourth element: (*5) 4 = 20
5. Apply the first function to the fifth element: ('div' 3) 5 = 1
6. Apply the second function to the sixth element: (*5) 6 = 30
7. Apply the first function to the seventh element: ('div' 3) 7 = 2
8. Apply the second function to the eighth element: (*5) 8 = 40
9. Apply the first function to the ninth element: ('div' 3) 9 = 3
The final list is [0, 10, 1, 20, 1, 30, 2, 40, 3].
-}




    
myTestList =
  TestList [

      "merge 1" ~: merge "EGG" "ABCDEFGH" ~=? "ABCDEEFGGGH" 
    , "merge 2" ~: merge "Hello" "e" ~=? "Heello"
    , "merge 3" ~: merge [1,3,5,7,9] [2,4,6] ~=? [1,2,3,4,5,6,7,9]

    , "halve 1" ~: halve "" ~=? ("","")
    , "halve 2" ~: halve "halves" ~=? ("hal","ves")
    , "halve 3" ~: halve "halve" ~=? ("ha","lve")

    , "msort 1" ~: msort "Howdy all!" ~=? " !Hadllowy"
    , "msort 2" ~: msort "" ~=? ""
    , "msort 3" ~: msort "Mississippi" ~=? "Miiiippssss"
    , "msort 4" ~: msort [3,2,1,5,4] ~=? [1,2,3,4,5]

    , "mergeBy 1" ~: mergeBy (>) "FED" "GBA" ~=? "GFEDBA"
    , "mergeBy 2" ~: mergeBy (<) "Howdy" "Maui" ~=? "HMaouiwdy"
    , "mergeBy 3" ~: mergeBy (>) [5,1] [6,4,3] ~=? [6,5,4,3,1]
      
    , "msortBy 1" ~: msortBy (<) "gig 'em" ~=? " 'eggim" 
    , "msortBy 2" ~: msortBy (>) "Jack be nimble" ~=? "nmlkieecbbaJ  "
    , "msortBy 3" ~: msortBy (<) "" ~=? ""
    , "msortBy 4" ~: msortBy (>) [3,2,1,5,4] ~=? [5,4,3,2,1]

    , "myInsert 1" ~: myInsert 'o' "Hw are you?" ~=? "How are you?"
    , "myInsert 2" ~: myInsert 'c' "abdefg" ~=? "abcdefg"
    , "myInsert 3" ~: myInsert 3 [2,4,6] ~=? [2,3,4,6]

    , "mySort 1" ~: mySort "Jack be quick" ~=? "  Jabcceikkqu"
    , "mySort 2" ~: mySort "Howdy all!" ~=? " !Hadllowy"

    , "altMap 1" ~: altMap (* 10) (* 100) [1,2,3,4,5] ~=? [10,200,30,400,50]
    , "altMap 2" ~: and (altMap even odd [1..10]) ~=? False
    , "altMap 3" ~: altMap toLower toUpper "Haskell IS fun!" ~=? "hAsKeLl iS FuN!"
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
