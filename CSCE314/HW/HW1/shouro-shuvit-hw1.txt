
-- CSCE 314 [Sections 598, 599] Programming Languages, Fall 2024
-- Homework Assignment 1 (Total 105 points)

-- Problem 1 (5 points)
-- This is head comment (single line comment should be preceded by two dashes)
-- Student Name: Shouro Shuvit
-- UIN: 231007248
-- Resources: Lecture notes, Haskell documentation, and Stack Overflow

-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit  -- if this line causes compile error, try the following
                   -- command at the terminal prompt > cabal v1-install HUnit
import System.Exit


-- Example:
-- Write a recursive function mySum that sums all the numbers
-- in a list without using the prelude function sum.
--mySum :: [Int] -> Int  -- type signature of mySum. mySum accepts a list of Ints
                       -- as its argument and returns an Int
--mySum []     = 0  -- def.1
--mySum (x:xs) = x + mySum xs -- def.2

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


-- Problem 2 (5+15 = 20 points)
qsort1 :: Ord a => [a] -> [a] -- Function initialization with Ord type signature for sorting lists
---- Question 2.1 (5 points)
qsort1 [] = [] --Input list is empty, return empty list
qsort1 (x:xs) = qsort1 larger ++ [x] ++ qsort1 smaller -- Recursive Case smaller and larger lists are sorted
    where
        smaller = [a | a <- xs, a < x] -- List comprehension to get elements smaller than x
        larger = [b | b <- xs, b >= x] -- List comprehension to get elements larger than or equal to x


---- Question 2.2 (15 points)
{- Write your answer for Question 2.2 within this block comment.
        1. First Call: qsort1 [15,8,11,6,10]
        - x = 15
        - smaller = [8,11,6,10]  
        - larger = []            
        - qsort1 [8,11,6,10] is called next.

        2. Second Call: qsort1 [8,11,6,10]
        - x = 8
        - smaller = [6]          
        - larger = [11,10]       
        - qsort1 [6] and qsort1 [11,10] are called next.

        3. Third Call: qsort1 [6]
        - x = 6
        - smaller = []           
        - larger = []            
        - qsort1 [] is called twice, both returning empty lists.

        4. Fourth Call: qsort1 [11,10]
        - x = 11
        - smaller = [10]         
        - larger = []           
        - qsort1 [10] and qsort1 [] are called next.

        5. Fifth Call: qsort1 [10]
        - x = 10
        - smaller = []          
        - larger = []            
        - qsort1 [] is called twice, both returning empty lists.

        The recursive calls made by qsort1 are:
        1. qsort1 [8,11,6,10]  -> Second call
        2. qsort1 [6]          -> Third call
        3. qsort1 [11,10]      -> Fourth call
        4. qsort1 [10]         -> Fifth call
        5. qsort1 [] (twice)   -> No further calls (base case)

        Thus, qsort1 is called **4 times recursively** after the initial call to qsort1 [15,8,11,6,10].
-}


-- Problem 3 (10 points)
lucas :: Int -> Int -- Function initialization with integer type signature
lucas 0 = 2 -- Base Case 1 where n = 0 means lucas = 2
lucas 1 = 1 -- Base Case 2 where n = 1 means lucas = 1
lucas n = lucas (n - 1) + lucas (n - 2) -- Recursive Case where n > 1 and lucas is the sum of lucas (n-1) and lucas (n-2)
-- Explanation:
{- 
        The function lucas calculates the nth Lucas number using recursion with the base cases being lucas 0 = 2 and lucas 1 = 1. If the input is greater than 1,
        the function calls itself recursively with the previous two Lucas numbers (n-1 and n-2) and adds them together to get the nth Lucas number.
-}


-- Problem 4 (10 points)
factorial :: Int -> Int -- Function initialization with integer type signature
factorial 0 = 1 -- Base Case where n = 0 means factorial = 1
factorial n = n * factorial (n - 1) -- Recursive Case where n > 0 and n is multiplied by the factorial of (n-1)
-- Explanation:
{- 
        The function factorial calculates the factorial of a number using recursion with the base case being factorial 0 = 1. If the input is greater than 0, 
        the function calls itself recursively with the previous number (n-1) and multiplies it with the current number to get the factorial of the current number.
-}

-- Problem 5 (5+10+10=25 points)
---- Question 5.1 (5 points)
semifactorial :: Int -> Int -- Function initialization with integer type signature
semifactorial 0 = 1 -- Base Case 1 where n = 0 means semifactorial = 1
semifactorial 1 = 1 -- Base Case 2 where n = 1 means semifactorial = 1
semifactorial n = n * semifactorial (n - 2) -- Recursive Case where n > 1 and n is multiplied by the semifactorial of (n-2)

---- Question 5.2 (10 points)
{- Write your answer for Question 5.2 within this block comment.
        The function semifactorial calculates the semifactorial of a number using recursion with the base cases being semifactorial 0 = 1 and semifactorial 1 = 1. 
        If the input is greater than 1, the function calls itself recursively with the previous two numbers (n-2) and multiplies it with 
        the current number to get the semifactorial of the current number.
        So, if the input is 14 then semifactorial will be called with 12, 10, 8, 6, 4, 2, and 0 which is 7 times after the first call.
-}

---- Question 5.3 (10 points)
myfactorial :: Int -> Int -- Function initialization with integer type signature 
myfactorial 0 = 0 -- Base Case where n = 0 means myfactorial = 0
myfactorial n = semifactorial n * myfactorial (n - 1) -- Recursive Case where n > 0 and myfactorial is the semifactorial of n multiplied by the myfactorial of (n-1)
-- Explanation: 
{- 
        The function myfactorial calculates the factorial of a number using the semifactorial function with recursion. The base case is myfactorial 0 = 1. 
        If the input is greater than 0, the function calls itself recursively with the previous number (n-1) and multiplies it with the semifactorial of the current number 
        to get the factorial of the current number. The semifactorial function is used to calculate the factorial of the current number. The base case is myfactorial 0 = 0 because 
        the factorial of 0 is 1 and the semifactorial of 0 is 1 but in order to calculate the factorial of 1, the semifactorial of 1 needs to be subtracted by 1 which is 0.
-}

-- Problem 6 (10+15+10=35 points)
---- Question 6.1 (10 points)
term :: Num a => Int -> a -> a -- Function initialization with Num type signature
term 1 x = x -- Base Case where n = 1 means term = x
term n x = x * term (n - 1) x -- Recursive Case where n > 1 and term is x multiplied by the term of (n-1) x
-- Explanation:
{- 
        The function term calculates the nth term of a polynomial using recursion with the base case being term 1 x = x. If the input is greater than 1, 
        the function calls itself recursively with the previous term (n-1) and multiplies it with the current term x to get the nth term of the polynomial. 
        This is repeated till the whole polynomial is calculated by reaching the base case.
-}
---- Question 6.2 (15 points)
polynaive :: Num a => [a] -> Int -> a -> a -- Function initialization with Num type signature
polynaive [] _ _ = 0 -- Base Case where the polynomial list is empty, return 0
polynaive (a:as) n x = a * term n x + polynaive as (n - 1) x -- Recursive Case where the polynomial list is not empty, the polynomial is calculated by multiplying the coefficient with the nth term 
--and adding it to the polynomial of the rest of the list

-- Explanation:
{- 
        The function polynaive calculates the value of a polynomial using recursion with the base case being an empty polynomial list, in which case the function returns 0. 
        If the polynomial list is not empty, the function calculates the value of the polynomial by multiplying the coefficient with the nth term and adding it to the polynomial 
        of the rest of the list. This is repeated until the whole polynomial is calculated by reaching the base case.
-}
---- Question 6.3 (10 points)
{- Write your answer for Question 6.3 within this block comment.
        The function polynaive calculates the value of a polynomial using recursion with the base case being an empty polynomial list, in which case the function returns 0. 
        If the polynomial list is not empty, the function calculates the value of the polynomial by multiplying the coefficient with the nth term and adding it to the polynomial 
        of the rest of the list. This is repeated until the whole polynomial is calculated by reaching the base case.
        So, if the input is [2,-4,-1,1] then polynaive will be called with 3, 2, 1, and 0 which is 4 times after the first call.

        The recursive calls made by polynaive are:
        1. polynaive [2,-4,-1,1] '3' 2  -> First call
        2. polynaive [-4,-1,1] '2' 2    -> Second call
        3. polynaive [-1,1] '1' 2       -> Third call
        4. polynaive [1] '0' 2          -> Fourth call
        5. polynaive [] '-1' 2          -> No further calls (base case)
-}



myTestList =
  TestList [

      "qsort1 1" ~: qsort1 [3, 2, 5, 1, 8] ~=? [8,5,3,2,1]
    , "qsort1 2" ~: qsort1 "howdy" ~=? "ywohd"
    , "qsort1 3" ~: qsort1 "Oh, happy day!" ~=? "yypphhdaaO,!  "

    , "lucas 1" ~: lucas 0 ~=? 2
    , "lucas 2" ~: lucas 1 ~=? 1
    , "lucas 3" ~: lucas 4 ~=? 7

    , "factorial 1" ~: factorial 3 ~=? 6
    , "factorial 2" ~: factorial 5 ~=? 120
    , "factorial 3" ~: factorial 10 ~=? 3628800

    , "semifactorial 1" ~: semifactorial 3 ~=? 3
    , "semifactorial 2" ~: semifactorial 5 ~=? 15
    , "semifactorial 3" ~: semifactorial 10 ~=? 3840

    , "myfactorial 1" ~: myfactorial 3 ~=? 6
    , "myfactorial 2" ~: myfactorial 5 ~=? 120
    , "myfactorial 3" ~: myfactorial 10 ~=? 3628800

    , "term 1" ~: term 3 2 ~=? 8
    , "term 2" ~: term 4 5 ~=? 625
    , "term 3" ~: term 10 3 ~=? 59049

    , "polynaive 1" ~: polynaive [2,-1,3,5] 3 2 ~=? 23
    , "polynaive 2" ~: polynaive [1,3,0,7,2] 4 5 ~=? 1037
    , "polynaive 3" ~: polynaive [1/3,1,-2,0,2,1,1/2] 6 3 ~=? 345.5
    , "polynaive 4" ~: polynaive [3,-4,2,7] 3 2 ~=? 19

    ]

main = do c <- runTestTT myTestList
          print c
          let errs = errors c
              fails = failures c
          exitWith (codeGet errs fails)

codeGet errs fails
 | fails > 0       = ExitFailure 2
 | errs > 0        = ExitFailure 1
 | otherwise       = ExitSuccess

