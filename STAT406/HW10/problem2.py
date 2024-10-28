from statsmodels.stats.power import FTestAnovaPower

# Parameters
mean_diff = 8 - 4  # Difference in means
std_dev = 2  # Standard deviation
effect_size = mean_diff / std_dev  # Cohen's f effect size

alpha = 0.01  # Significance level

# Calculate sample sizes for different power requirements
power_80 = 0.80
power_85 = 0.85
power_95 = 0.95

# Initialize the power analysis object
anova_power = FTestAnovaPower()

# Calculate required sample sizes for each group
n_80 = anova_power.solve_power(effect_size=effect_size, power=power_80, alpha=alpha, k_groups=2)
n_85 = anova_power.solve_power(effect_size=effect_size, power=power_85, alpha=alpha, k_groups=2)
n_95 = anova_power.solve_power(effect_size=effect_size, power=power_95, alpha=alpha, k_groups=2)

print(f"Required sample size per group (80% power): {n_80:.2f}")
print(f"Required sample size per group (85% power): {n_85:.2f}")
print(f"Required sample size per group (95% power): {n_95:.2f}")

import pandas as pd
from scipy import stats

# Assume the dataset looks similar to the structure provided
data = pd.read_excel(r'c:\Users\ssjed\OneDrive\Documents\GitHub\Fall2024\STAT406\HW10\hw2_drug.xlsx')

# Perform ANOVA
f_value, p_value = stats.f_oneway(data['Group1'], data['Group2'], data['Group3'], data['Group4'])

print(f"ANOVA F-value: {f_value}")
print(f"P-value: {p_value}")

# Reshape data for easier comparison
data_long = data.melt(var_name='Group', value_name='Score')

# Perform ANOVA test
f_value, p_value = stats.f_oneway(
    data['Group1'], data['Group2'], data['Group3'], data['Group4']
)

print(f"ANOVA F-value: {f_value}")
print(f"P-value: {p_value}")

# Compare Group 4 (both drugs) with Groups 2 and 3
t_stat, p_value = stats.ttest_ind(data['Group4'], pd.concat([data['Group2'], data['Group3']]))
print(f"T-statistic: {t_stat}")
print(f"P-value: {p_value}")

# Compare Group 2 and Group 3
t_stat, p_value = stats.ttest_ind(data['Group2'], data['Group3'])
print(f"T-statistic: {t_stat}")
print(f"P-value: {p_value}")
