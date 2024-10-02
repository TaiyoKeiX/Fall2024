# Create the dataset in R
data <- data.frame(
  Day = factor(c(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7)),
  Treatment = factor(c('C', 'E', 'G', 'D', 'F', 'G', 'A', 'E', 'F', 'B', 'D', 'E', 
                       'A', 'C', 'D', 'A', 'B', 'G', 'B', 'C', 'F')),
  Response = c(19.8, 7.8, 13.0, 16.0, 11.0, 5.3, 11.7, 5.3, 12.3, 11.2, 10.0, 16.2,
               13.2, 17.3, 16.2, 16.0, 17.2, 10.8, 15.7, 18.0, 12.7)
)

# View the data structure
head(data)

# Perform ANOVA to test the effect of Treatment and Block (Day)
anova_model <- aov(Response ~ Treatment + Day, data = data)

# Summary of the ANOVA model
summary(anova_model)


