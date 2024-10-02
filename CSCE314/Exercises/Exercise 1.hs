-- ReverseList.hs

-- Main function that will be executed
main :: IO ()
main = do
    -- Define a list of integers
    let list = [1, 2, 3, 4, 5]
    
    -- Reverse the list using the `reverse` function
    let reversedList = reverse list
    
    -- Print the original and the reversed list
    putStrLn "Original list:"
    print list
    
    putStrLn "Reversed list:"
    print reversedList

-- Function to reverse a list (optional, demonstrating the logic)
reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]
