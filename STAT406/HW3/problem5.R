# Data input
women_preferring_light <- 75  # Women preferring light beer
men_preferring_light <- 40    # Men preferring light beer

total_women <- 130  # Total women surveyed
total_men <- 70     # Total men surveyed

# Combine data for proportions test
x <- c(women_preferring_light, men_preferring_light)  # successes
n <- c(total_women, total_men)  # sample sizes

# Perform the two-proportion z-test
prop_test <- prop.test(x, n, conf.level = 0.90, correct = FALSE)

# View the result
prop_test

# The confidence interval is in the "conf.int" attribute of the result
conf_interval <- prop_test$conf.int
print(conf_interval)

