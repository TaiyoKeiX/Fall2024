# Load the package
library(binom)

# Define the sample size and the number of successes (students who prefer Pepsi)
successes <- 60
n <- 140

# Calculate the Wilson confidence interval at 90% confidence level
wilson_interval <- binom.confint(successes, n, conf.level = 0.90, methods = "wilson")

# Print the result
print(wilson_interval)
