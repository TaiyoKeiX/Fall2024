df <- armspan_alldatagendernames

# Load the package
library(onewaytests)

# Perform the Brown-Forsythe test (for example, comparing height and armspan variances)
bf_test1 <- bf.test(differen ~ gender, data = df,alpha = 0.05)
bf_test2 <- bf.test(differen ~ gender, data = df,alpha = 0.1)

# Output the results
print(bf_test1)

# Run the Wilcoxon rank sum test (Mann Whitney U test) to compare the means of two groups
male_data <- subset(df, gender == "male")$differen
female_data <- subset(df, gender == "female")$differen

wilcox_test <- wilcox.test(male_data, female_data, alternative = "two.sided")
print(wilcox_test$p.value)

shapiro.test(male_data)
shapiro.test(female_data)
