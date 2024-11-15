import numpy as np

# Function to calculate odds ratio and 95% CI
def odds_ratio_and_ci(a, b, c, d):
    # Calculate the odds ratio
    or_value = (a * d) / (b * c)
    
    # Calculate the log odds ratio and standard error
    log_or = np.log(or_value)
    se_log_or = np.sqrt(1/a + 1/b + 1/c + 1/d)
    
    # Calculate the 95% confidence interval for the odds ratio
    ci_lower = np.exp(log_or - 1.96 * se_log_or)
    ci_upper = np.exp(log_or + 1.96 * se_log_or)
    
    return or_value, ci_lower, ci_upper

# Given data for each region (a, b, c, d)
# East: 220 (a), 125 (b), 38 (c), 67 (d)
# South: 120 (a), 77 (b), 25 (c), 78 (d)
# West: 95 (a), 103 (b), 36 (c), 66 (d)

east_data = (220, 125, 38, 67)
south_data = (120, 77, 25, 78)
west_data = (95, 103, 36, 66)

# Calculate for each region
east_or, east_ci_lower, east_ci_upper = odds_ratio_and_ci(*east_data)
south_or, south_ci_lower, south_ci_upper = odds_ratio_and_ci(*south_data)
west_or, west_ci_lower, west_ci_upper = odds_ratio_and_ci(*west_data)

print(f"East Region - Odds Ratio: {east_or}, 95% CI: ({east_ci_lower}, {east_ci_upper})")
print(f"South Region - Odds Ratio: {south_or}, 95% CI: ({south_ci_lower}, {south_ci_upper})")
print(f"West Region - Odds Ratio: {west_or}, 95% CI: ({west_ci_lower}, {west_ci_upper})")
