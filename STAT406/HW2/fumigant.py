import numpy as np
from scipy import stats

# Given data
F1 = np.array([79, 40, 11, 31, 28, 50, 53, 26, 33])
F2 = np.array([72, 38, 10, 29, 27, 48, 51, 24, 32])

# Calculate the differences
differences = F1 - F2

# Calculate mean and standard deviation of the differences
mean_diff = np.mean(differences)
std_diff = np.std(differences, ddof=1)  # Sample standard deviation
n = len(differences)

# Calculate the t-statistic
t_statistic = mean_diff / (std_diff / np.sqrt(n))

# Calculate the p-value
p_value = stats.t.sf(np.abs(t_statistic), df=n-1) * 2  # two-tailed test

print(mean_diff, std_diff, t_statistic, p_value)

alpha = 0.1  # significance level (1 - confidence level)
critical_value = stats.t.ppf(1 - alpha / 2, df=n-1)  # two-tailed test

lower_bound = mean_diff - critical_value * (std_diff / np.sqrt(n))
upper_bound = mean_diff + critical_value * (std_diff / np.sqrt(n))

confidence_interval = (lower_bound, upper_bound)

print(confidence_interval)