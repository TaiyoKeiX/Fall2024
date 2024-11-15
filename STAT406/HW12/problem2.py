import math

# Data for calculation
high_bp_high_cholesterol = 159
low_bp_high_cholesterol = 91
high_bp_low_cholesterol = 78
low_bp_low_cholesterol = 172

# Calculate the odds ratio (OR)
odds_high_cholesterol = low_bp_high_cholesterol / high_bp_high_cholesterol
odds_low_cholesterol = low_bp_low_cholesterol / high_bp_low_cholesterol
odds_ratio = odds_high_cholesterol / odds_low_cholesterol

# Calculate the 95% confidence interval for the odds ratio
# Standard error for log(OR)
se_log_or = math.sqrt(
    (1 / high_bp_high_cholesterol) + (1 / low_bp_high_cholesterol) +
    (1 / high_bp_low_cholesterol) + (1 / low_bp_low_cholesterol)
)

# Log of odds ratio
log_or = math.log(odds_ratio)

# Confidence interval for OR
ci_lower = math.exp(log_or - 1.96 * se_log_or)
ci_upper = math.exp(log_or + 1.96 * se_log_or)

print("Odds Ratio (OR):", odds_ratio)
print("95% CI for OR:", (ci_lower, ci_upper))
{
    "Odds Ratio (OR)": odds_ratio,
    "95% CI for OR": (ci_lower, ci_upper)
}
