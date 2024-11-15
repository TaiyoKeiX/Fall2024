library(readr)
library(writexl)

# Load the CSV data
data <- LCK_SummerPlayoffs_2024

# Save as Excel file
write_xlsx(data, "LCK_SummerPlayoffs_2024.xlsx")

