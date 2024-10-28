import pandas as pd
from scipy.stats import norm
import math

# Load the dataset from the provided Excel file
file_path = "/mnt/data/social_life_Data_spring10.xlsx"

# Read the Excel data into a DataFrame
data = pd.read_excel(r'c:\Users\ssjed\OneDrive\Documents\GitHub\Fall2024\STAT406\HW10\social_life_Data_spring10.xlsx')


# Display the first few rows to verify the contents
data.head()

# Function to calculate the sample proportion
def calculate_proportion(females_party, total_females):
    return females_party / total_females

# Function to calculate the confidence interval for a proportion
def confidence_interval(pi_hat, n, confidence_level=0.95):
    z_alpha = norm.ppf(1 - (1 - confidence_level) / 2)
    margin_of_error = z_alpha * math.sqrt((pi_hat * (1 - pi_hat)) / n)
    return (pi_hat - margin_of_error, pi_hat + margin_of_error)

# Function to calculate the z-statistic for hypothesis testing
def z_statistic(pi_hat, pi_0, n):
    standard_error = math.sqrt((pi_0 * (1 - pi_0)) / n)
    return (pi_hat - pi_0) / standard_error

# Function to calculate required sample size for given power and effect size
def required_sample_size(pi_1, pi_0, alpha=0.1, power=0.7):
    z_alpha = norm.ppf(1 - alpha / 2)
    z_beta = norm.ppf(power)
    numerator = (z_alpha + z_beta) ** 2 * pi_0 * (1 - pi_0)
    denominator = (pi_1 - pi_0) ** 2
    return math.ceil(numerator / denominator)

# Filter the data to count the number of females and those who go out 3+ times per week ("party")
female_data = data[data['gender'] == 'female']

# Count total number of females
total_females = female_data.shape[0]

# Count number of females who "party" (go out 3+ times per week)
females_party = female_data[female_data['partytim'] == 'party'].shape[0]

# Calculate proportion and run analysis
pi_hat = calculate_proportion(females_party, total_females)
ci_lower, ci_upper = confidence_interval(pi_hat, total_females)
z_value = z_statistic(pi_hat, 0.5, total_females)
h0_rejected = abs(z_value) > norm.ppf(0.975)  # 95% confidence level
required_n = required_sample_size(0.8, 0.5)

pi_hat, (ci_lower, ci_upper), z_value, h0_rejected, required_n
print(pi_hat, (ci_lower, ci_upper), z_value, h0_rejected, required_n)
