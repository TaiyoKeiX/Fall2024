df <- armspan_alldata_1

# Filter data for males (gender == 0)
males_data <- subset(df, gender == 'male')

# View first few rows of data
head(males_data)

# Run the paired t-test
t_test_result <- t.test(males_data$height, males_data$armspan, paired = TRUE)

# Print the results
print(t_test_result)

# Run the Wilcoxon signed-rank test
wilcox_result <- wilcox.test(males_data$height, males_data$armspan, paired = TRUE)

# Print the results
print(wilcox_result)

alpha <- 0.10

# Check the parametric test result
if (t_test_result$p.value < alpha) {
  print("Reject the null hypothesis for the parametric test (paired t-test) at 90% confidence.")
} else {
  print("Fail to reject the null hypothesis for the parametric test (paired t-test) at 90% confidence.")
}

# Check the non-parametric test result
if (wilcox_result$p.value < alpha) {
  print("Reject the null hypothesis for the Wilcoxon signed-rank test at 90% confidence.")
} else {
  print("Fail to reject the null hypothesis for the Wilcoxon signed-rank test at 90% confidence.")
}
