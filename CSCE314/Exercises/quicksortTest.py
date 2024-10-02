def quicksort(arr, low, high):
    if low < high:
        pivot_index = partition(arr, low, high)
        print(f"Array at call: {arr}")
        quicksort(arr, low, pivot_index - 1)
        quicksort(arr, pivot_index + 1, high)

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

# Example usage
arr = [15, 8, 11, 6, 10]
quicksort(arr, 0, len(arr) - 1)