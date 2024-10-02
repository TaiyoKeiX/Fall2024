# Create the data as vectors
distance <- factor(rep(c("1KM", "5KM", "10KM", "20KM"), each = 10))


oxygen_content <- c(1, 5, 2, 1, 2, 2, 4, 3, 0, 2,
          4, 8, 2, 3, 8, 5, 6, 4, 3, 3,
          20, 26, 24, 11, 28, 20, 19, 19, 21, 24, 
          37, 30, 26, 24, 41, 25, 36, 31, 31, 33)

# Combine into a dataframe
data <- data.frame(distance, oxygen_content)

# Print the dataframe
print(data)

# Perform ANOVA
anova_model <- aov(oxygen_content ~ distance, data = data)
summary(anova_model)

# Check normality of residuals
shapiro.test(residuals(anova_model))

# Install and load car package for Levene's Test
if (!require(car)) install.packages("car")
library(car)

# Perform Levene's Test
leveneTest(oxygen_content ~ distance, data = data)


# Log10 transformation
data$log_oxygen <- log10(data$oxygen_content+1) # Add 1 to avoid log(0)

# Perform ANOVA on transformed data
anova_log_model <- aov(log_oxygen ~ distance, data = data)
summary(anova_log_model)

# Check assumptions again
shapiro.test(residuals(anova_log_model))  # Normality check
leveneTest(log_oxygen ~ distance, data = data)  # Homogeneity check

# Perform Kruskal-Wallis test
kruskal.test(oxygen_content ~ distance, data = data)
