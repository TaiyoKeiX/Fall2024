import math

# Given data for seat belt usage analysis
killed_with_seat_belt = 16001
survived_with_seat_belt = 7758634
killed_without_seat_belt = 31199
survived_without_seat_belt = 2791887

# Calculate the odds of being killed with and without seat belt
odds_with_seat_belt = killed_with_seat_belt / survived_with_seat_belt
odds_without_seat_belt = killed_without_seat_belt / survived_without_seat_belt

# Calculate the odds ratio (OR)
odds_ratio_seat_belt = odds_with_seat_belt / odds_without_seat_belt

# Calculate the 95% confidence interval for the odds ratio
# Using the formula for the confidence interval of an OR with exponentiated values
se_log_or_seat_belt = math.sqrt((1 / killed_with_seat_belt) + (1 / survived_with_seat_belt) +
                                (1 / killed_without_seat_belt) + (1 / survived_without_seat_belt))
log_or_seat_belt = math.log(odds_ratio_seat_belt)
ci_lower_seat_belt = math.exp(log_or_seat_belt - 1.96 * se_log_or_seat_belt)
ci_upper_seat_belt = math.exp(log_or_seat_belt + 1.96 * se_log_or_seat_belt)

print("Odds with Seat Belt:", odds_with_seat_belt)
print("Odds without Seat Belt:", odds_without_seat_belt)
print("Odds Ratio for Seat Belt:", odds_ratio_seat_belt)
print("95% CI for Odds Ratio (Seat Belt):", (ci_lower_seat_belt, ci_upper_seat_belt))


