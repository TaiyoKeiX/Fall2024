# Load necessary packages
if(!require(readr)) install.packages("readr")
if(!require(car)) install.packages("car")

# Load data
data <- problem4HW4_src

# Check the first few rows of the data
head(data)

# Perform ANOVA using the 'aov' function
anova_model <- aov(Broadcast ~ factor(Row) + factor(Column) + factor(Treatment), data = data)

# Display the ANOVA table
summary(anova_model)

# Extract MSE for Latin Square Design (Residuals of the model)
mse_ls <- summary(anova_model)[[1]]["Residuals", "Mean Sq"]

# In a CRD, the MSE is calculated by ignoring row and column blocking
crd_model <- aov(Broadcast ~ factor(Treatment), data = data)
mse_crd <- summary(crd_model)[[1]]["Residuals", "Mean Sq"]

# Calculate Relative Efficiency (RE)
re <- mse_ls / mse_crd
re

# Check significance of Row and Column in the ANOVA summary
summary(anova_model)

