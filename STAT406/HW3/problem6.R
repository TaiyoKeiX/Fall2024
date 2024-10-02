# Reading the data from the CSV file
data <- problem6_src # Change this to the actual file path

# Viewing the first few rows of the data
head(data)

# Assuming the column containing the tree count data is named 'count'
tree_counts <- data$Number

# Check the mean of the data (Poisson's lambda is the mean)
mean_tree_count <- mean(tree_counts)
mean_tree_count

# Goodness-of-fit test for Poisson distribution
library(vcd)
goodness_fit <- goodfit(tree_counts, type = "poisson")
summary(goodness_fit)

# Compute 95% Confidence Interval for Poisson mean
lambda <- mean_tree_count  # lambda is the mean in Poisson
n <- length(tree_counts)  # Number of observations

# Calculate the standard error and confidence interval
se <- sqrt(lambda / n)
ci_lower <- lambda - 1.96 * se
ci_upper <- lambda + 1.96 * se

# Print the confidence interval
cat("95% Confidence Interval on the mean is (", ci_lower, ",", ci_upper, ")")

